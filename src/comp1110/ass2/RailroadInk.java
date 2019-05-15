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
     * @author Frederick Li
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
     * @author Frederick Li
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
        List<String> positions = new ArrayList<>();
        for (int i = boardString.length()-5; i >= 0; i -= 5) {
            String position = boardString.substring(i+2, i+4);
            if (positions.contains(position)) {
                return false;
            } else {
                positions.add(position);
            }
        }
        return true;
    }


    /**
     * This method is to get the shape of the tile. Shape is a string contains 4 characters.
     * h: represents highway edge
     * r: represents railway edge
     * #: represents blank edge
     * @author Frederick Li, Haoyan Liu
     * @param tilePlacement a char array of tile placement which contains 5 elements."B0A53"
     * @param orientation a char which is in the range '0'-'7'
     * @return a string which represents the shape of the tile
     */
    static String getShape(char[] tilePlacement, char orientation) {
        String[] shapeA = {"rr##", "r#r#", "r#rr", "h#hh", "h#h#", "hh##"}; // shapes of A with orientation '0'
        String[] shapeB = {"h#r#", "h##r", "hrhr"};//shape of B with orientation 0
        String[] shapeS = {"hhrh", "hrrr", "hhhh", "rrrr", "hhrr", "hrhr"};//shape of S with orientation 0
        char[] shape;
        if (tilePlacement[0] == 'A') {
            shape = shapeA[tilePlacement[1] - '0'].toCharArray();// shape char output
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
            shape[1] = temp;//exchange ( see the shape)
        }
        String flipped = String.valueOf(shape);
        int offset = orientation > '3' ?(int) orientation  - '0' - 4 : (int) orientation - '0';
        return flipped.substring(offset) + flipped.substring(0, offset);
    }


    /**
     * Determine whether the provided placements are neighbours connected by at least one validly connecting edge.
     * For example,
     * - areConnectedNeighbours("A3C10", "A3C23") would return true as these tiles are connected by a highway edge;
     * - areConnectedNeighbours("A3C23", "B1B20") would return false as these neighbouring tiles are disconnected;
     * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
     * invalid connection between highway and railway; and
     * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
     * @author Frederick Li, Haoyan Liu
     * @return true if the placements are connected neighbours
     */

    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        // FIXME Task 5: determine whether neighbouring placements are connected
        if (tilePlacementStringA.length() < 5 || tilePlacementStringB.length() < 5) {return false;}
        char[] a = tilePlacementStringA.toCharArray();
        char[] b = tilePlacementStringB.toCharArray();
        if (Math.abs(a[2] - b[2]) > 1 || Math.abs(a[3] - b[3]) > 1) {return false;}// not connected
        if (a[2] == b[2] && a[3] == b[3]) {return false;}//exactly copy paste in the same box
        if (Math.abs(a[2] - b[2]) == 1 && Math.abs(a[3] - b[3]) == 1) {return false;}// diagonal position
        char[] aShape = getShape(a, a[4]).toCharArray();
        char[] bShape = getShape(b, b[4]).toCharArray();

        if (a[2] > b[2]) {
            if (!(aShape[0] == bShape[2] && aShape[0] != '#')) {return false;} // if up!=down and up is not empty
        }
        if (a[2] < b[2]) {
            if (!(aShape[2] == bShape[0] && aShape[2] != '#')) {return false;}//reverse previous
        }
        if (a[3] > b[3]) {
            if (!(aShape[1] == bShape[3] && aShape[1] != '#')) {return false;}//if left!=right and left is not empty
        }
        if (a[3] < b[3]) {
            if (!(aShape[3] == bShape[1] && aShape[3] != '#')) {return false;}// reverse
        }
        return true;
    }


    /**
     * This method is to check whether a tile is legally connected to an exit
     * @author Frederick Li
     * @param tilePlacement a string of 5 characters
     * @return boolean
     */
    static boolean isExitConnected(String tilePlacement) {
        char[] a = tilePlacement.toCharArray();
        char[] aShape = getShape(a, a[4]).toCharArray();

        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) {// possible exits
            if ((a[3] == '1' || a[3] =='5') && aShape[a[2] == 'A' ? 0 : 2] == 'h') // if fst or last column matches highway
            {return true;}
            else
            {return (a[3] == '3' && aShape[a[2] == 'A' ? 0 : 2] == 'r');} //matches railway
        }
        else
        if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) { // else possible exit
            if ((a[2] == 'B' || a[2] == 'F') && aShape[a[3] == '0' ? 1 : 3] == 'r') // last row<-> down is exit position
            {return true;}
            else
            {return (a[2] == 'D' && aShape[a[3] == '0' ? 1 : 3] == 'h');}
        }

        return false;
    }


    /**
     * This method is to check whether a tile's connection to the exit is invalid
     * @author Frederick Li
     * @param tilePlacement a string contains 5 characters
     * @return boolean
     */
    private static boolean isInvalidExitConnection(String tilePlacement) {
        char[] a = tilePlacement.toCharArray();
        char[] aShape = getShape(a, a[4]).toCharArray();

        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) { // possible exits
            if (aShape[a[2] == 'A' ? 0 : 2] != '#') {  // if tile at the fst row , up is not be vacant / If last, down
                //is not be vacant.
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
     * This method is to check whether all neighbouring tiles
     *      are validly connected for a new placement string
     * @author Frederick Li
     * @param boardString the original game state
     * @param newPlacementString a sequence of new placements
     * @return boolean
     */
    public static boolean areNeighboursValid(String boardString, String newPlacementString) {
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
     * @author Frederick Li
     * @param boardString a board string representing some placement sequence
     * @return true if placement sequence is valid
     */
    public static boolean isValidPlacementSequence(String boardString) {
        // FIXME Task 6: determine whether the given placement sequence is valid
        if (!isBoardStringWellFormed(boardString)) {
            return false;
        }
        String[] tiles = new String[boardString.length() / 5];// 5 letters in a tile representation.
        String[] placed = new String[tiles.length];
        for (int i = 0; i+5 <= boardString.length() ; i += 5) {
            tiles[i/5] = boardString.substring(i, i+5);// representation of  i/5 th tile
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

        if (!areNeighboursValid("",boardString)) {
            return false;
        }
        return Arrays.equals(tiles, placed);
    }


    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Die A has faces numbered 0-5.
     * Die B has faces numbered 0-2.
     * Each die roll is composed of a character 'A' or 'B' representing the dice,
     * followed by a digit character representing the face.
     * @author Haoyan Liu
     * @return a String representing the die roll e.g. A0A4A3B2
     */
    public static String generateDiceRoll() {
        // FIXME Task 7: generate a dice roll
        Random random = new Random();
        String [] rolls={"AAAB","ABAA","AABA","BAAA"};
        String roll = rolls[0];
        String result = "";
        for (int i = 0; i <4; i++) {
            char dice = roll.charAt(i);
            result = result + roll.charAt(i);
            if (dice == 'A') {
                result = result + random.nextInt(6);
            }
            if (dice=='B') {
                result = result + random.nextInt(3);
            }
        }
        return result;
    }


    /**
     * Replace the B2 tile with two single tiles
     * @author Mingchao Sima
     * @param B2 a String of B2 tile placement
     * @return the ArrayList of the replaced tiles
     */
    private static ArrayList<String> replaceB2(String B2) {
        ArrayList<String> replace = new ArrayList<>();
        if (getShape(B2.toCharArray(), B2.charAt(4)).charAt(0) == 'h'){ // top is highway
            replace.add("A1"+B2.substring(2,4)+"1");// rotate A1
            replace.add("A4"+B2.substring(2,4)+"0");// change it to A1 and A4
        }else {
            replace.add("A1"+B2.substring(2,4)+"0");
            replace.add("A4"+B2.substring(2,4)+"1");// rotate A4
        }
        return replace;
    }


    /**
     * This method is to get the neighbouring tiles of a tile from a list tiles
     * @author Mingchao Sima
     * @param tile the target tile
     * @param tiles an ArrayList contains all unconnected tiles
     * @return an ArrayList of all neighbouring tiles
     */
    private static ArrayList<String> getNeighbours(String tile, ArrayList<String> tiles) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < tiles.size(); i++) {
            if (areConnectedNeighbours(tile, tiles.get(i))){ // print all connected neighbours
                result.add(tiles.get(i));
            }
        }
        return result;
    }


    /**
     * This method is to check whether a tile is B2 tile
     * @author Frederick Li
     * @param placement tile placement string
     * @return boolean
     */
    private static boolean isB2Tile(String placement) {
        return placement.charAt(0) == 'B' && placement.charAt(1) == '2';
    }


    /**
     * Count the total scores of connected exits of all routes
     * @author Frederick Li, Mingchao Sima
     * @param boardString a string represents the game state
     * @return the score of all routes based on their connected exits
     */
    public static int countExitsScore(String boardString) {
        ArrayList<String> tiles = new ArrayList<>();
        for (int i = 0; i+5 <= boardString.length(); i += 5) {
            if (!isB2Tile(boardString.substring(i, i+5))){
                tiles.add(boardString.substring(i, i+5));
            }
            else{
                tiles.addAll(replaceB2(boardString.substring(i, i+5)));
            }
        }

        int count = 0;
        int sum = 0;
        boolean flag = true;    // This flag determines whether this route can be expanded

        HashSet<String> connectedTiles = new HashSet<>();
        HashSet<String> route = new HashSet<>();

        while (!tiles.isEmpty()) {
            if (route.isEmpty()) {
                for (String tile : tiles) {
                    if (isExitConnected(tile)) {
                        route.add(tile);
                        connectedTiles.add(tile);
                        break;
                    }
                }
                route.add(tiles.get(0));
                connectedTiles.add(tiles.get(0));
            }

            for (String tileCollected : route) {
                connectedTiles.addAll(getNeighbours(tileCollected, tiles));
            }

            flag = false;

            // Update route and tiles
            route.addAll(connectedTiles);
            tiles.removeAll(connectedTiles);

            // Check whether the current route can be expanded
            outerLoop:
            for (String t : tiles) {
                for (String placed : connectedTiles) {
                    if (areConnectedNeighbours(t, placed)) {
                        flag = true;
                        break outerLoop;
                    }
                }
            }
            connectedTiles.clear();

            // Count exits and start a new route
            if (!flag) {
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
        return sum;
    }


    /**
     * Count all errors: Errors are the edges of routes
     *      that are not connected to an edge of the board.
     * @author Frederick Li
     * @param boardString a string of game state
     * @return the number of errors also regarded as scores.
     */
    public static int countErrorsScore(String boardString) {
        String[] tilePlacements = new String[ boardString.length()/5];
        for (int i = 0; i+5 <= boardString.length(); i += 5) {
            tilePlacements[i/5] = (boardString.substring(i, i+5));
        }
        String[] tiles = new String[tilePlacements.length];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = getShape(tilePlacements[i].toCharArray(), tilePlacements[i].charAt(4))//e.g R#R#
                    + tilePlacements[i].substring(2, 4);// row,column
        }

        // change tiles connected to the edge of the board to # ,and calculate no. of # later
        for (int i = 0; i < tiles.length; i++) {
            String t = tiles[i];
            if (t.charAt(4) == 'A' && t.charAt(0) != '#') { //row1 and up not vacant
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

        //  change tiles connected with neighbours to #
        for (int i = 0; i < tiles.length; i++) {
            for (int j = tiles.length-1; j > i; j--) {
                if (areConnectedNeighbours(tilePlacements[i], tilePlacements[j])) {
                    String tileI = tiles[i];
                    String tileJ = tiles[j];
                    if (tileI.charAt(4) == tileJ.charAt(4)) { // change the row
                        if (tileI.charAt(5) < tileJ.charAt(5)) {
                            tileI = tileI.substring(0, 3) + "#" + tileI.substring(4);
                            tileJ = tileJ.charAt(0) + "#" + tileJ.substring(2);
                        } else {
                            tileI = tileI.charAt(0) + "#" + tileI.substring(2);
                            tileJ = tileJ.substring(0, 3) + "#" + tileJ.substring(4);
                        }
                    }

                    if (tileI.charAt(5) == tileJ.charAt(5)) { // change the column
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
            if (c != '#') {errors++;} // tiles not changed to # are errors
        }
        return -errors;
    }


    /**
     * Given the current state of a game board, output an integer representing the sum of all the following factors
     * that contribute to the player's final score.
     * <p>
     * * Number of exits mapped
     * * Number of centre tiles used
     * * Number of dead ends in the network
     * @author Frederick Li
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
        exitScore = countExitsScore(boardString);
        deadEndsScore = countErrorsScore(boardString);
        for (String placement : tilePlacements) {
            if (placement.charAt(2) >= 'C' && placement.charAt(2) <= 'E'
                && placement.charAt(3) >= '2' && placement.charAt(3) <= '4') {
                centerTilesScore++;
            }
        }
        return exitScore+centerTilesScore+deadEndsScore;

    }


    /**
     * Returns the longest move in the list. A helper method for task 10
     * @author Frederick Li
     * @param moves a List of moves
     * @return the longest move
     */
    static String longestMove(HashSet<String> moves) {
        String longestMove = "";
        for (String move :moves) {
            if (move.length() > longestMove.length()) {
                longestMove = move;
            }
        }
        return longestMove;
    }


    /**
     * Get all unplaced grids.
     * @author Frederick Li
     * @param boardString a sequence of current game state
     * @return a List of String which contains all available grids
     */
    public static List<String> getUnusedGrids(String boardString) {
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
     * Get all possible orientations for a specific tile after fixing orientations.
     * @author Frederick Li
     * @param tile a String of two chars which represent a tile
     * @return a List of Characters which contain possible orientations
     */
    public static List<Character> getOrientations(String tile) {
        List<Character> orientations = new ArrayList<>();
        switch (tile) {
            case "B1":
                for (char i = '0'; i <= '7'; i++) {
                    orientations.add(i);
                }
                break;
            case "A1": case "A4": case "B2":
                orientations.add('0');
                orientations.add('1');
                break;
            default:
                for (char i = '0'; i <= '3'; i++) {
                    orientations.add(i);
                }
        }
        return orientations;
    }


    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     * @author Frederick Li
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

        // this List contains the board positions of unused grids
        List<String> unUsedGridsBase = getUnusedGrids(boardString);

        // this contains all valid moves
        HashSet<String> validMoves = new HashSet<>();

        int count = 0;
        while ( count < 4) {
            List<String> unUsedGrids = new ArrayList<>(unUsedGridsBase);
            HashMap<Integer, List<String>> movesCollection = new HashMap<>();    // key: the order of the move
            List<String> base =  new ArrayList<>();
            base.add("");
            movesCollection.put(-1, base);  // the base move
            for (int i = 0; i < tiles.size(); i++) {
                List<String> lastMoves = movesCollection.get(i-1);
                if (null == lastMoves) {break;}
                String tile = tiles.get(i);
                List<Character> orientations = getOrientations(tile);
                outLoop:
                for (String unUsedGrid : unUsedGrids) {
                    for (char o : orientations) {
                        String aMove = tile + unUsedGrid + o;
                            for (String lastMove : lastMoves) {
                                if (isValidPlacementSequence(boardString + lastMove + aMove)) {
                                    String newMove = lastMove + aMove;

                                    // all 4 normal tiles have been placed
                                    if (i == 3) {
                                        return newMove;
                                    }

                                    movesCollection.computeIfAbsent(i, k -> new ArrayList<>());
                                    List<String> currentMoves = movesCollection.get(i);
                                    currentMoves.add(lastMove + aMove);
                                    unUsedGrids.remove(unUsedGrid);
                                    movesCollection.remove(i-1); // save memory
                                    break outLoop;
                                }
                            }
                        }
                    }
            }

            for (int i = 3; i >= 0 ; i--) {
                if (movesCollection.get(i) != null) {
                    validMoves.addAll(movesCollection.get(i));
                    break;
                }
            }
            tiles.add(tiles.remove(0)); // shift rotate the tiles ordering
            count++;

        }
        return longestMove(validMoves);
    }


    /**
     * This method is to check whether two connected tiles have the same edge c ( r or h)
     * @author Frederick Li
     * @param tileA tilePlacement
     * @param tileB tilePlacement
     * @param c either 'r' or 'h'
     */
    private static boolean checkEdge(String tileA, String tileB, char c) {
        String tileAShape = getShape(tileA.toCharArray(), tileA.charAt(4));
        String tileBShape = getShape(tileB.toCharArray(), tileB.charAt(4));

        if (tileA.charAt(2) == tileB.charAt(2)) {       // the same row
            if (tileA.charAt(3) < tileB.charAt(3)) {
                return tileAShape.charAt(3) == c ;
            } else {
                return tileAShape.charAt(1) == c;
            }
        } else {        // the same column
            if (tileA.charAt(2) < tileB.charAt(2)) {
                return tileAShape.charAt(2) == c;
            } else {
                return tileAShape.charAt(0) == c;
            }
        }
    }


    /**
     * This class represents the connection of a route
     */
    static class TileGraph {
        private HashMap<String, LinkedList<String>> adj; // adjacent tiles collection
        private int vertices;

        public TileGraph(int vertices) {
            this.vertices = vertices;
            adj = new HashMap<>();
        }

        public void addTile(String key, String tile) {
            adj.get(key).add(tile);
        }

        /**
         * This is a recursion util function for findLongestRoad
         * @author Frederick Li
         * @param s a string represents the starting tile
         * @param visited a HashMap which record the tiles that have been visited
         * @param prev previous length
         * @param max an array with 1 element of the length of the longest road
         */
        public void findLongestRoadRec(String s, HashMap<String, Boolean> visited,
                                       int prev, int[] max) {
            visited.put(s, true);

            int curr = prev;

            for (String adjTile : adj.get(s)) {
                if (!visited.get(adjTile)) {
                    curr = prev + 1;
                    findLongestRoadRec(adjTile, visited, curr, max);
                }
                max[0] = Math.max(max[0], curr);
            }
        }
    }


    /**
     * This method is to find the longest road from a route (collection with tiles)
     * @author Frederick Li
     * @param tiles an array of tiles
     * @param k the kind (railway or highway) : either 'r' or 'h'
     * @return the length of the longest road
     */
    public static int findLongestRoad(String[] tiles, char k) {
        HashSet<String> tilePlacements = new HashSet<>();
        Collections.addAll(tilePlacements,tiles);
        TileGraph tileGraph = new TileGraph(tilePlacements.size());

        // initialize tile graph
        for (String tile : tilePlacements) {
            LinkedList<String> neighbours = new LinkedList<>();
            tileGraph.adj.put(tile, neighbours);

        }

        // generate the full graph
        for (String keyTile : tilePlacements) {
            for (String checkingTile: tilePlacements) {
                if (areConnectedNeighbours(keyTile,checkingTile) &&
                        checkEdge(keyTile, checkingTile, k)) {
                    LinkedList<String> neighbours = tileGraph.adj.get(keyTile);
                    neighbours.add(checkingTile);
                }
            }
        }

        ArrayList<Integer> maxCollections = new ArrayList<>();
        for (String startTile : tilePlacements) {
            HashMap<String, Boolean> visited = new HashMap<>();
            for (String key : tilePlacements) {
                visited.put(key, false);
            }
            int[] max = {Integer.MIN_VALUE};
            tileGraph.findLongestRoadRec(startTile,visited ,1 ,max ); // recursively find the longest road
            maxCollections.add(max[0]);

        }

        return maxCollections.stream().max(Comparator.comparingInt(i->i)).orElseThrow();
    }


    /**
     * Given the current state of a game board, output an integer representing the sum of all the factors contributing
     * to `getBasicScore`, as well as those attributed to:
     * <p>
     * * Longest railroad
     * * Longest highway
     * @author Frederick Li
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for final score (not counting expansion packs)
     */
    public static int getAdvancedScore(String boardString) {
        // FIXME Task 12: compute the total score including bonus points
        int basicScore = getBasicScore(boardString);
        String[] tilePlacements = new String[boardString.length()/5];
        for (int i = 0; i+5 <= boardString.length(); i += 5) {
            tilePlacements[i/5] = boardString.substring(i, i+5);
        }

        int longestRailway = findLongestRoad(tilePlacements,'r' );
        int longestHighway = findLongestRoad(tilePlacements, 'h');

        return longestHighway + longestRailway + basicScore;
    }

}

