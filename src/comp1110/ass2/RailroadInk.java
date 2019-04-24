package comp1110.ass2;

import java.util.*;

public class RailroadInk {
    /**
     * Determine whether a tile placement string is well-formed:
     * - it consists of exactly 5 characters;
     * - the first character represents a die A or B, or a special tile S
     * - the second character indicates which tile or face of the die (0-5 for die A and special tiles, or 0-2 for die B)
     * - the third character represents the placement row A-G
     * - the fourth character represents the placement column 0-6
     * - the fifth character represents the orientation 0-7
     *
     * @param tilePlacementString a candidate tile placement string
     * @return true if the tile placement is well formed
     */
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
        // FIXME Task 2: determine whether a tile placement is well-formed
        if (tilePlacementString.length() != 5) {return false;}
        if (!"ABS".contains(""+tilePlacementString.charAt(0))) {return false;}
        if (tilePlacementString.charAt(0) == 'B') {
            if (tilePlacementString.charAt(1) < '0' || tilePlacementString.charAt(1) > '2') {return false;}
        }
        else {
            if (tilePlacementString.charAt(1) < '0' || tilePlacementString.charAt(1) > '5') {return false;}
        }
        if (tilePlacementString.charAt(2) < 'A' || tilePlacementString.charAt(2) > 'G') {return false;}
        if (tilePlacementString.charAt(3) < '0' || tilePlacementString.charAt(3) > '6') {return false;}
        if (tilePlacementString.charAt(4) < '0' || tilePlacementString.charAt(4) > '7') {return false;}

        return true;
    }

    /**
     * Determine whether a board string is well-formed:
     * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
     * - each piece placement is well-formed
     * - no more than three special tiles are included
     *
     * @param boardString a board string describing the placement of one or more pieces
     * @return true if the board string is well-formed
     */
    public static boolean isBoardStringWellFormed(String boardString) {
        // FIXME Task 3: determine whether a board string is well-formed
        if (boardString == null || boardString.length() == 0) {return false;}
        if (boardString.length() % 5 != 0 || boardString.length() > 155) {return false;}
        int count = 0;
        for (int i = 0; i + 5 <= boardString.length(); i = i + 5) {
            String tilePlacement = boardString.substring(i, i+5);
            if (!isTilePlacementWellFormed(tilePlacement)) {return false;}
            if (boardString.charAt(i) == 'S') {count++;}
            if (count > 3) {return false;}
        }
        return true;

    }


    /**
     * Determine whether the provided placements are neighbours connected by at least one validly connecting edge.
     * For example,
     * - areConnectedNeighbours("A3C10", "A3C23") would return true as these tiles are connected by a highway edge;
     * - areConnectedNeighbours("A3C23", "B1B20") would return false as these neighbouring tiles are disconnected;
     * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
     * invalid connection between highway and railway; and
     * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
     *
     * @return true if the placements are connected neighbours
     */

    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        // FIXME Task 5: determine whether neighbouring placements are connected
        if (tilePlacementStringA.length() < 5 || tilePlacementStringB.length() < 5) {return false;}
        char[] a = tilePlacementStringA.toCharArray();
        char[] b = tilePlacementStringB.toCharArray();
        if (Math.abs(a[2] - b[2]) > 1 || Math.abs(a[3] - b[3]) > 1) {return false;}
        if (a[2] == b[2] && a[3] == b[3]) {return false;}
        if (Math.abs(a[2] - b[2]) == 1 && Math.abs(a[3] - b[3]) == 1) {return false;}
        char[] aShape = getShape(a, a[4]).toCharArray();
        char[] bShape = getShape(b, b[4]).toCharArray();

        if (a[2] > b[2]) {
            if (!(aShape[0] == bShape[2] && aShape[0] != '#')) {return false;}
        }
        if (a[2] < b[2]) {
            if (!(aShape[2] == bShape[0] && aShape[2] != '#')) {return false;}
        }
        if (a[3] > b[3]) {
            if (!(aShape[1] == bShape[3] && aShape[1] != '#')) {return false;}
        }
        if (a[3] < b[3]) {
            if (!(aShape[3] == bShape[1] && aShape[3] != '#')) {return false;}
        }
        return true;


    }

    /**
     * This function is to get the shape of the tile. Shape is a string contains 4 characters.
     * h: represents highway edge
     * r: represents railway edge
     * #: represents blank edge
     * @param tilePlacement a char array of tile placement which contains 5 elements.
     * @param orientation a char which is in the range '0'-'7'
     * @return a string which represents the shape of the tile
     */
    private static String getShape(char[] tilePlacement, char orientation) {
        String[] shapeA = {"rr##", "r#r#", "r#rr", "h#hh", "h#h#", "hh##"}; // shapes of A with orientation '0'
        String[] shapeB = {"h#r#", "h##r", "hrhr"};
        String[] shapeS = {"hhrh", "hrrr", "hhhh", "rrrr", "hhrr", "hrhr"};
        char[] shape;
        if (tilePlacement[0] == 'A') {
            shape = shapeA[tilePlacement[1] - '0'].toCharArray();
        }
        else if (tilePlacement[0] == 'B') {
            shape = shapeB[tilePlacement[1] - '0'].toCharArray();
        }
        else {
            shape = shapeS[tilePlacement[1] - '0'].toCharArray();
        }

        if (orientation > '3') {
            char temp = shape[3];
            shape[3] = shape[1];
            shape[1] = temp;
        }
        String flipped = String.valueOf(shape);
        int offset = orientation > '3' ?(int) orientation  - '0' - 4 : (int) orientation - '0';
        return flipped.substring(offset) + flipped.substring(0, offset);
    }

    /**
     * Given a well-formed board string representing an ordered list of placements,
     * determine whether the board string is valid.
     * A board string is valid if each tile placement is legal with respect to all previous tile
     * placements in the string, according to the rules for legal placements:
     * - A tile must be placed such that at least one edge connects to either an exit or a pre-existing route.
     *   Such a connection is called a valid connection.
     * - Tiles may not be placed such that a highway edge connects to a railway edge;
     *   this is referred to as an invalid connection.
     *   Highways and railways may only join at station tiles.
     * - A tile may have one or more edges touching a blank edge of another tile;
     *   this is referred to as disconnected, but the placement is still legal.
     *
     * @param boardString a board string representing some placement sequence
     * @return true if placement sequence is valid
     */
    public static boolean isValidPlacementSequence(String boardString) {
        // FIXME Task 6: determine whether the given placement sequence is valid
        String[] tiles = new String[boardString.length() / 5];
        String[] placed = new String[tiles.length];
        for (int i = 0; i+5 <= boardString.length() ; i += 5) {
            tiles[i/5] = boardString.substring(i, i+5);
            placed[i/5] = i == 0 ? boardString.substring(i, i+5) : "" ;
        }

        if (!(isExitConnected(tiles[0]))) {return false;}
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 0; j < placed.length; j++ ) {
                if (isExitConnected(tiles[i])) {
                    placed[i] = tiles[i];
                    continue;
                }
                if (areConnectedNeighbours(tiles[i], placed[j]) && !isInvalidExitConnection(tiles[i])) {
                    placed[i] = tiles[i];
                }
            }
        }

        return Arrays.equals(tiles, placed);


    }

    /**
     * This method is to check whether a tile's connection to the exit is invalid
     * @param tilePlacement a string contains 5 characters
     * @return boolean
     */
    private static boolean isInvalidExitConnection(String tilePlacement) {
        char[] a = tilePlacement.toCharArray();
        char[] aShape = getShape(a, a[4]).toCharArray();

        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) {
            if (aShape[a[2] == 'A' ? 0 : 2] != '#') {
                return (!isExitConnected(tilePlacement));
            }

        }
        else if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) {
            if (aShape[a[3] == '0' ? 1 : 3] != '#') {
                return (!isExitConnected(tilePlacement));
            }
        }
        return false;


    }

    /**
     * This method is to check whether a tile is legally connected to an exit
     * @param tilePlacement a string of 5 characters
     * @return boolean
     */
    private static boolean isExitConnected(String tilePlacement) {
        char[] a = tilePlacement.toCharArray();
        char[] aShape = getShape(a, a[4]).toCharArray();

        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) {
            if ((a[3] == '1' || a[3] =='5') && aShape[a[2] == 'A' ? 0 : 2] == 'h') {return true;}
            else {return (a[3] == '3' && aShape[a[2] == 'A' ? 0 : 2] == 'r');}
        }

        else if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) {
            if ((a[2] == 'B' || a[2] == 'F') && aShape[a[3] == '0' ? 1 : 3] == 'r') {return true;}
            else {return (a[2] == 'D' && aShape[a[3] == '0' ? 1 : 3] == 'h');}
        }

        return false;
    }




    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Die A has faces numbered 0-5.
     * Die B has faces numbered 0-2.
     * Each die roll is composed of a character 'A' or 'B' representing the dice,
     * followed by a digit character representing the face.
     *
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        // FIXME Task 7: generate a dice roll
        StringBuilder sb = new StringBuilder();
        int count = 3;
        while (count > 0) {
            sb.append('A').append(String.valueOf((int) (Math.random()*5)));
            count--;
        }
        sb.append('B').append(String.valueOf((int) (Math.random()*2)));
        return sb.toString();
    }

    /**
     * Given the current state of a game board, output an integer representing the sum of all the following factors
     * that contribute to the player's final score.
     * <p>
     * * Number of exits mapped
     * * Number of centre tiles used
     * * Number of dead ends in the network
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for score *not* considering longest rail/highway
     */
    public static int getBasicScore(String boardString) {
        // FIXME Task 8: compute the basic score

        String[] tilePlacements = new String[boardString.length()/5];
        for (int i = 0; i+5 <= boardString.length(); i += 5) {
            tilePlacements[i/5] = boardString.substring(i, i+5);
        }

        int exitScore = 0;
        int centerTilesScore = 0;
        int deadEndsScore = 0;
        exitScore = countExitsScore(tilePlacements);
        deadEndsScore = countErrorsScore(tilePlacements);
        for (String placement : tilePlacements) {
            if (placement.charAt(2) >= 'C' && placement.charAt(2) <= 'E'
                && placement.charAt(3) >= '2' && placement.charAt(3) <= '4') {
                centerTilesScore++;
            }
        }
        return exitScore+centerTilesScore-deadEndsScore;

    }

    /**
     * Count the total scores of connected exits of all routes
     * @param tilePlacements an array of string which contains tile placements
     * @return the score of all routes based on their connected exits
     */
    public static int countExitsScore(String[] tilePlacements) {
        // Avoid modifying the original ArrayList
        ArrayList<String> tiles = new ArrayList<>();
        Collections.addAll(tiles, tilePlacements);

        int count = 0;
        int sum = 0;
        boolean flag = true;

        // Use HashSets to remove duplicates
        HashSet<String> b2Tiles = new HashSet<>();
        HashSet<String> connectedTiles = new HashSet<>();
        HashSet<String> route = new HashSet<>();

        while (!tiles.stream().allMatch(RailroadInk::isB2Tile))
        {
        while (flag) {
            for (int i = 0; i < tiles.size(); i++) {
                String tile = tiles.get(i);
                if (route.isEmpty()) {
                    route.add(tile);
                    connectedTiles.add(tile);
                }

                for (String tileCollected : route) {
                    if (!areConnectedNeighbours(tileCollected, tile)) continue;
                    if (!isB2Tile(tile)) {
                        connectedTiles.add(tile);
                        continue;
                    }
                    b2Tiles.add(tile);
                    for (String tile1 : tiles) {
                        if (areConnectedNeighbours(tile1, tile) &&
                            (tile.charAt(2) == tileCollected.charAt(2) ?
                            tile.charAt(2) == tile1.charAt(2) :
                            tile.charAt(3) == tile1.charAt(3)))
                                connectedTiles.add(tile1);
                    }
                }

            }
            flag = false;

            // Update route and tiles
            route.addAll(connectedTiles);
            tiles.removeAll(connectedTiles);
            connectedTiles.clear();

            // Check whether the current route can be expanded
            for (String t : tiles) {
                for (String t1 : route) {
                    if (areConnectedNeighbours(t, t1) && !isB2Tile(t))
                        flag = true;
                }
            }

            // Count exits and start a new route
            if (!flag) {
                route.addAll(b2Tiles);
                b2Tiles.clear();
                for (String t : route) {
                    if (isExitConnected(t))
                        count++;
                }
                route.clear();

                if (count == 12)
                    sum += 45;
                else if (count >= 2)
                    sum += count * 4 - 4;
                count = 0;
            }
        }
        flag = true;
    }
        return sum;

    }

    public static boolean isB2Tile(String placement) {
        return placement.charAt(0) == 'B' && placement.charAt(1) == '2';
    }


    /**
     * Count all errors: Errors are the edges of routes that are not connected to an edge of the board.
     * @param tilePlacements an array of string which contains tile placements
     * @return the number of errors also regarded as scores.
     */
    public static int countErrorsScore(String[] tilePlacements) {
        String[] tiles = Arrays.copyOf(tilePlacements, tilePlacements.length);
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = getShape(tilePlacements[i].toCharArray(), tilePlacements[i].charAt(4))
                            + tilePlacements[i].substring(2, 4);
        }

        // tiles connected to the edge of the board
        for (int i = 0; i < tiles.length; i++) {
            String t = tiles[i];
            if (t.charAt(4) == 'A' && t.charAt(0) != '#') {
                t = "#" + t.substring(1);
            }

            if (t.charAt(4) == 'G' && t.charAt(2) != '#') {
                t = t.substring(0, 2) + "#" +t.substring(3);
            }

            if (t.charAt(5) == '0' && t.charAt(1) != '#') {
                t = t.charAt(0) + "#" + t.substring(2);
            }

            if (t.charAt(5) == '6' && t.charAt(3) != '#') {
                t = t.substring(0, 3) + "#" + t.substring(4);
            }
            tiles[i] = t;
        }

        // tiles connected with neighbours
        for (int i = 0; i < tiles.length; i++) {
            for (int j = tiles.length-1; j > i; j--) {
                if (areConnectedNeighbours(tilePlacements[i], tilePlacements[j])) {
                    String tileI = tiles[i];
                    String tileJ = tiles[j];
                    if (tileI.charAt(4) == tileJ.charAt(4)) {
                        if (tileI.charAt(5) < tileJ.charAt(5)) {
                            tileI = tileI.substring(0, 3) + "#" + tileI.substring(4);
                            tileJ = tileJ.charAt(0) + "#" + tileJ.substring(2);
                        } else {
                            tileI = tileI.charAt(0) + "#" + tileI.substring(2);
                            tileJ = tileJ.substring(0, 3) + "#" + tileJ.substring(4);
                        }
                    }

                    if (tileI.charAt(5) == tileJ.charAt(5)) {
                        if (tileI.charAt(4) < tileJ.charAt(4)) {
                            tileI = tileI.substring(0, 2) + "#" +tileI.substring(3);
                            tileJ = "#" + tileJ.substring(1);
                        } else {
                            tileJ = tileJ.substring(0, 2) + "#" +tileJ.substring(3);
                            tileI = "#" + tileI.substring(1);
                        }
                    }
                    tiles[i] = tileI;
                    tiles[j] = tileJ;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String tile : tiles) {
            sb.append(tile.substring(0, 4));
        }
        int errors = 0;
        for (char c : sb.toString().toCharArray()) {
            if (c != '#') {errors++;}
        }
        return errors;

    }

    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String generateMove(String boardString, String diceRoll) {
        // FIXME Task 10: generate a valid move


        List<String> tiles = new ArrayList<>(4);
        for (int i = 0; i+2 <= diceRoll.length(); i+=2) {
            tiles.add(diceRoll.substring(i, i+2));
        }


        List<String> unUsedGridsBase = getUnusedGrids(boardString);

        List<String> validMoves = new ArrayList<>();
        int count = 0;
        while ( count < 4) {

            List<String> unUsedGrids = new ArrayList<>(unUsedGridsBase);

            HashMap<Integer, List<StringBuilder>> movesDP = new HashMap<>();
            List<StringBuilder> base =  new ArrayList<>();
            base.add(new StringBuilder(""));
            movesDP.put(-1, base);
            for (int t = 0; t < tiles.size(); t++) {
                String tile = tiles.get(t);
                boolean placed = false;
                List<StringBuilder> lastMoves = movesDP.get(t-1);
                for (int i = 0; i < unUsedGrids.size(); i++) {
                    String unUsedGrid = unUsedGrids.get(i);
                    List<Character> orientations = getOrientations(tile);
                    for (char o : orientations) {
                        String aMove = tile + unUsedGrid + o;
                        if (null != lastMoves) {
                            for (StringBuilder lastMove : lastMoves) {
                                if (isValidPlacementSequence(boardString + lastMove.append(aMove).toString())) {
                                    movesDP.computeIfAbsent(t, k -> new ArrayList<>());
                                    List<StringBuilder> currentMoves = movesDP.get(t);
                                    StringBuilder currentMove = new StringBuilder(lastMove.toString());

                                    currentMoves.add(currentMove);
                                    placed = true;

                                }
                                lastMove.delete(lastMove.length() - 5, lastMove.length());
                            }
                        }
                    }
                    if (placed) {
                        unUsedGrids.remove(i);
                        break;
                    }
                }
            }
            String firstTile = tiles.remove(0);
            tiles.add(firstTile);
            HashSet<StringBuilder> allMoves = new HashSet<>();
            for (Map.Entry<Integer, List<StringBuilder>> entry : movesDP.entrySet()) {
                allMoves.addAll(entry.getValue());
            }
            for (StringBuilder m : allMoves) {
                if (areNeighboursValid(boardString, m.toString())) {
                    validMoves.add(m.toString());
                }

            }
            count++;

        }

        return max(validMoves);

    }

    /**
     * Returns the longest string in the list.
     * @param moves a List of String.
     * @return the longest string
     */
    static String max(List<String> moves) {
        String longestMove = "";
        for (String move :moves) {
            if (move.length() > longestMove.length()) {
                longestMove = move;
            }
        }
        return longestMove;
    }


    /**
     * Get all possible orientations for a specific tile after fixing orientations.
     * @param tile a String of two chars which represent a tile
     * @return a List of Characters which contain possible orientations
     */
    static List<Character> getOrientations(String tile) {
            List<Character> orientations = new ArrayList<>();
            if (tile.equals("B1")) {
                for (char i = '0'; i <= '7'; i++) {
                    orientations.add(i);
                }
            }
            else if (tile.equals("A1") || tile.equals("A4") || tile.equals("B2")) {
                orientations.add('0');
                orientations.add('1');
            }
            else {
                for (char i = '0'; i <= '3'; i++) {
                    orientations.add(i);
                }
            }
            return orientations;
    }


    /**
     * This function is to check whether two neighbouring tile are validly connected
     * @param boardString a string represents game state
     * @param newPlacementString a sequence of new placements
     * @return boolean
     */
    static boolean areNeighboursValid(String boardString, String newPlacementString) {
        HashMap<String, String> placed = new HashMap<>();
        for (int i = 0; i+5 <= boardString.length(); i+=5) {
            String grid = boardString.substring(i+2, i+4);
            placed.put(grid, boardString.substring(i, i + 5));
        }

        List<String> newPlacements = new ArrayList<>();
        for (int i = 0; i+5 <= newPlacementString.length(); i += 5) {
            newPlacements.add(newPlacementString.substring(i, i+5));
        }

        for (String placement : newPlacements) {
            char row = placement.charAt(2);
            char col = placement.charAt(3);
            for (char i = row == 'A' ? row : (char) (row - 1); i <= row + 1; i++) {
                for (char j = col == '0' ? col : (char) (col - 1); j <= col + 1; j++) {
                    if (i > 'G' || j > '6') {
                        continue;
                    }
                    if (Math.abs(i - row) == 1 && Math.abs(j - col) == 1) {
                        continue;
                    }
                    if (i == row && j == col) {
                        continue;
                    }
                    String grid = String.valueOf(i) + String.valueOf(j);
                    if (placed.containsKey(grid)) {
                        String neighbour = placed.get(grid);
                        String placementShape = getShape(placement.toCharArray(), placement.charAt(4));
                        String neighbourShape = getShape(neighbour.toCharArray(), neighbour.charAt(4));
                        if (row == i && (col < j
                            ? (placementShape.charAt(3) != '#' && neighbourShape.charAt(1) != '#' &&
                                placementShape.charAt(3) != neighbourShape.charAt(1))
                            : (placementShape.charAt(1) != '#' && neighbourShape.charAt(3) != '#' &&
                                placementShape.charAt(1) != neighbourShape.charAt(3)))) {
                            return false;
                        }

                        if (col == j && (row < i
                            ? (placementShape.charAt(2) != '#' && neighbourShape.charAt(0) != '#' &&
                                placementShape.charAt(2) != neighbourShape.charAt(0))
                            : (placementShape.charAt(0) != '#' && neighbourShape.charAt(2) != '#' &&
                                placementShape.charAt(0) != neighbourShape.charAt(2)))) {
                            return false;
                        }

                    }
                }
            }
            placed.put(placement.substring(2, 4), placement);
        }

        return true;

    }

    /**
     * Get all the unplaced grids.
     * @param boardString a sequence of current game state
     * @return a List of String which contains all available grids
     */
    static List<String> getUnusedGrids(String boardString) {
        List<String> board = new ArrayList<>();
        for (char i = 'A'; i <= 'G'; i++) {
            for (char j = '0'; j <= '6'; j++) {
                String grid = String.valueOf(i) + String.valueOf(j);
                board.add(grid);
            }
        }
        List<String> usedGrids = new ArrayList<>();
        for (int i = 0; i+5 <= boardString.length(); i+=5) {
            String grid = boardString.substring(i+2, i+4);
            usedGrids.add(grid);
        }

        board.removeAll(usedGrids);
        return board;
    }


    /**
     * Given the current state of a game board, output an integer representing the sum of all the factors contributing
     * to `getBasicScore`, as well as those attributed to:
     * <p>
     * * Longest railroad
     * * Longest highway
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for final score (not counting expansion packs)
     */
    public static int getAdvancedScore(String boardString) {
        // FIXME Task 12: compute the total score including bonus points
        int basicScore = getBasicScore(boardString);
        return -1;
    }
}

