package comp1110.ass2;

import java.util.*;

import static comp1110.ass2.HelperMethod.*;

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
        if (!isBoardStringWellFormed(boardString)) {
            return false;
        }
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
            sb.append('A').append(String.valueOf((int) (Math.random()*6)));
            count--;
        }
        sb.append('B').append(String.valueOf((int) (Math.random()*3)));
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


        List<String> unUsedGridsBase = getUnusedGrids(boardString); // this List contains the board positions of unused grids

        List<String> validMoves = new ArrayList<>();
        int count = 0;
        while ( count < 4) {

            List<String> unUsedGrids = new ArrayList<>(unUsedGridsBase);

            HashMap<Integer, List<StringBuilder>> movesCollection = new HashMap<>();    // key: the order of the move
            List<StringBuilder> base =  new ArrayList<>();
            base.add(new StringBuilder(""));
            movesCollection.put(-1, base);
            for (int i = 0; i < tiles.size(); i++) {
                String tile = tiles.get(i);
                List<StringBuilder> lastMoves = movesCollection.get(i-1);
                outLoop:
                for (String unUsedGrid : unUsedGrids) {
                    List<Character> orientations = getOrientations(tile);
                    for (char o : orientations) {
                        String aMove = tile + unUsedGrid + o;
                        if (null != lastMoves) {
                            for (StringBuilder lastMove : lastMoves) {
                                if (isValidPlacementSequence(boardString + lastMove.toString() + aMove)) {
                                    movesCollection.computeIfAbsent(i, k -> new ArrayList<>());
                                    List<StringBuilder> currentMoves = movesCollection.get(i);
                                    currentMoves.add(new StringBuilder(lastMove+aMove));
                                    unUsedGrids.remove(unUsedGrid);
                                    break outLoop;

                                }
                            }
                        }
                    }

                }
            }
            tiles.add(tiles.remove(0));
            HashSet<StringBuilder> allMoves = new HashSet<>();
            for (Map.Entry<Integer, List<StringBuilder>> entry : movesCollection.entrySet()) {
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
        String[] tilePlacements = new String[boardString.length()/5];
        for (int i = 0; i+5 <= boardString.length(); i += 5) {
            tilePlacements[i/5] = boardString.substring(i, i+5);
        }

        HashSet<HashSet<String>> railroads = new HashSet<>();
        HashSet<HashSet<String>> highRoads = new HashSet<>();


        for (String tile : tilePlacements) {
            HashSet<String> route = new HashSet<>();
            if (isHighway(tile)) {
                continue;
            } else {
                route.add(tile);
            }
            boolean flag = true;

            while (flag) {
                for (String otherTile : tilePlacements) {

                    if (!isHighway(otherTile)) {
                        for (String routeTile : route) {
                            if (areConnectedNeighbours(otherTile, routeTile)
                                &&  checkEdge(otherTile, routeTile, 'r')) {
                                route.add(otherTile);
                                break;
                            }
                        }
                    }
                }
                flag = false;
                outLoop:
                for (String otherTile : tilePlacements) {
                    for (String routeTile : route) {
                        if (!route.contains(otherTile) && !isHighway(otherTile)
                                && areConnectedNeighbours(otherTile, routeTile) &&
                        checkEdge(otherTile, routeTile, 'r')) {
                            flag = true;
                            break outLoop;
                        }
                    }
                }

            }
            railroads.add(route);
        }



        for (String tile : tilePlacements) {
            HashSet<String> route = new HashSet<>();
            if (isRailway(tile)) {
                continue;
            } else {
                route.add(tile);
            }
            boolean flag = true;

            while (flag) {
                for (String otherTile : tilePlacements) {

                    if (!isRailway(otherTile)) {
                        for (String routeTile : route) {
                            if (areConnectedNeighbours(otherTile, routeTile) &&
                            checkEdge(otherTile, routeTile, 'h')) {
                                route.add(otherTile);
                                break;
                            }
                        }
                    }
                }
                flag = false;
                outLoop:
                for (String otherTile : tilePlacements) {
                    for (String routeTile : route) {
                        if (!route.contains(otherTile) && !isRailway(otherTile)
                                && areConnectedNeighbours(otherTile, routeTile)
                        &&  checkEdge(otherTile, routeTile, 'h')) {
                            flag = true;
                            break outLoop;
                        }
                    }
                }

            }
            highRoads.add(route);
        }

        int longestHighLength = 0;
        for (HashSet<String> route : highRoads) {
            longestHighLength = Math.max(longestHighLength, findLongestRoad(route, 'h'));

        }
        int longestRailLength = 0;
        for (HashSet<String> route : railroads ) {
            longestRailLength = Math.max(longestRailLength, findLongestRoad(route,'r'));
        }

        return longestHighLength + longestRailLength + basicScore;
    }

}

