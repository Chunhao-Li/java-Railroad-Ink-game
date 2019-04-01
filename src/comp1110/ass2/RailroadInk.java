package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

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

        if ((a[2] == 'A' || a[2] == 'G') && (a[3] == '1' || a[3] == '3' || a[3] == '5')) {
            return (!isExitConnected(tilePlacement));

        }
        else if ((a[2] == 'B' || a[2] == 'D' || a[2] == 'F') && (a[3] == '0' || a[3] == '6')) {
            return (!isExitConnected(tilePlacement));
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
        return "";
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
        return -1;
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
        return null;
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
        return -1;
    }
}

