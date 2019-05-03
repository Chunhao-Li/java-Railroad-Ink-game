package comp1110.ass2;

import java.util.*;

import static comp1110.ass2.RailroadInk.*;

public class HelperMethod {
    /**
     * This method is to get the shape of the tile. Shape is a string contains 4 characters.
     * h: represents highway edge
     * r: represents railway edge
     * #: represents blank edge
     * @author Frederick Li
     * @param tilePlacement a char array of tile placement which contains 5 elements.
     * @param orientation a char which is in the range '0'-'7'
     * @return a string which represents the shape of the tile
     */
     static String getShape(char[] tilePlacement, char orientation) {
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
     * This method is to check whether a tile's connection to the exit is invalid
     * @author Frederick Li
     * @param tilePlacement a string contains 5 characters
     * @return boolean
     */
     static boolean isInvalidExitConnection(String tilePlacement) {
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
     * @author Frederick Li
     * @param tilePlacement a string of 5 characters
     * @return boolean
     */
     static boolean isExitConnected(String tilePlacement) {
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
     * Count the total scores of connected exits of all routes
     * @author Frederick Li
     * @param tilePlacements an array of string which contains tile placements
     * @return the score of all routes based on their connected exits
     */
     static int countExitsScore(String[] tilePlacements) {
        // Avoid modifying the original ArrayList
        ArrayList<String> tiles = new ArrayList<>();
        Collections.addAll(tiles, tilePlacements);

        HashMap<String, String> tilesMap = new HashMap<>(); // for quick locating pieces
        for (String tile : tiles) {
            tilesMap.put(tile.substring(2, 4),tile);
        }

        int count = 0;
        int sum = 0;
        boolean flag = true;    // This flag determines whether this route can be expanded

        // Use HashSets to remove duplicates
        HashSet<String> b2Tiles = new HashSet<>();
        HashSet<String> connectedTiles = new HashSet<>();
        HashSet<String> route = new HashSet<>();

        while (!tiles.stream().allMatch(HelperMethod::isB2Tile))
        {
            while (flag) {
                if (route.isEmpty()) {
                    for (String tile : tiles) {
                        if (isExitConnected(tile) && !isB2Tile(tile)) {
                            route.add(tile);
                            connectedTiles.add(tile);
                            break;
                        }
                        else if (isExitConnected(tile) && isB2Tile(tile)) {
                            ArrayList<String> neighbours= getNeighbours(tile,tilesMap);
                            if (neighbours.size() == 1) {
                                route.add(tile);
                                connectedTiles.add(tile);
                                break;
                            }
                        }
                    }

                }
                tiles.removeAll(connectedTiles);
                if (route.isEmpty()) {
                    route.add(tiles.stream().filter(HelperMethod::isExitConnected).findFirst().orElseThrow());
                }
                for (String tile : tiles) {
                    for (String tileCollected : route) {
                        if (!areConnectedNeighbours(tileCollected, tile)) continue;
                        if (!isB2Tile(tile)) {
                            connectedTiles.add(tile);
                            break;
                        }
                        searchSameLine(tileCollected, tile, connectedTiles, b2Tiles, tilesMap);

                    }

                }
                flag = false;

                // Update route and tiles
                route.addAll(connectedTiles);
                tiles.removeAll(connectedTiles);
                for (String tile : connectedTiles) {
                    tilesMap.remove(tile.substring(2, 4));
                }
                connectedTiles.clear();

                // Check whether the current route can be expanded
                outerLoop:
                for (String t : tiles) {
                    for (String placed : route) {
                        if (areConnectedNeighbours(t, placed) && !isB2Tile(t)) {
                            flag = true;
                            break outerLoop;
                        }
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

    /**
     * This method is to get the tiles neighbours if they are existed
     * @author Frederick Li
     * @param tile the target tile
     * @param tilesMap a HashMap whose key is the position, whose value is the tile placement string
     * @return an ArrayList of all neighbours' positions
     */
     static ArrayList<String> getNeighbours(String tile, HashMap<String, String> tilesMap) {
        var position = tile.substring(2, 4);
        ArrayList<String> result = new ArrayList<>();
        var row = position.charAt(0);
        var col = position.charAt(1);
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
                result.add(String.valueOf(i) + String.valueOf(j));
            }
        }
        result.removeIf(t->!tilesMap.containsKey(t));
        return result;
    }

    /**
     * This method is to search for more connected tiles after finding the B2 tile
     * @author Frederick Li
     * @param lastTile the previous tile connected to the B2 tile
     * @param b2Tile the target B2 tile
     * @param connectedTiles a HashSet which contain the tiles of this route
     * @param b2Tiles a HashSet which contain the B2 tiles of the route
     * @param tilesMap a HashMap whose key is the position, whose value is the tile placement string
     */
     static void searchSameLine(String lastTile, String b2Tile, HashSet<String> connectedTiles,
                                       HashSet<String> b2Tiles, HashMap<String, String> tilesMap) {
        b2Tiles.add(b2Tile);
        char row, col;
        if (b2Tile.charAt(2) == lastTile.charAt(2)) {
            row = b2Tile.charAt(2);
            col = b2Tile.charAt(3) > lastTile.charAt(3) ?(char) (b2Tile.charAt(3)+1) :
                    (char) (b2Tile.charAt(3) -1);
        }
        else {
            col = b2Tile.charAt(3);
            row = b2Tile.charAt(2) > lastTile.charAt(2) ? (char) (b2Tile.charAt(2)+1) :
                    (char) (b2Tile.charAt(2)-1);
        }
        String position = String.valueOf(row) + String.valueOf(col);
        String tile = tilesMap.get(position);
        if (null != tile && areConnectedNeighbours(tile, b2Tile)) {
            if (!isB2Tile(tile)) {
                connectedTiles.add(tile);
            } else {
                searchSameLine(b2Tile, tile, connectedTiles, b2Tiles, tilesMap);
            }
        }
    }

    /**
     * This method is to check whether a tile is B2 tile
     * @author Frederick Li
     * @param placement tile placement string
     * @return boolean
     */
     static boolean isB2Tile(String placement) {
        return placement.charAt(0) == 'B' && placement.charAt(1) == '2';
    }


    /**
     * Count all errors: Errors are the edges of routes
     *      that are not connected to an edge of the board.
     * @author Frederick Li
     * @param tilePlacements an array of string which contains tile placements
     * @return the number of errors also regarded as scores.
     */
     static int countErrorsScore(String[] tilePlacements) {
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
}
