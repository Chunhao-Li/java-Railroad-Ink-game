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
     * @param boardString a string represents the game state
     * @return the score of all routes based on their connected exits
     */
     public static int countExitsScore(String boardString) {
         ArrayList<String> tiles = new ArrayList<>();
         for (int i = 0; i+5 <= boardString.length(); i += 5) {
             tiles.add(boardString.substring(i, i+5));
         }

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
                if (route.isEmpty()) {
                    route.add(tiles.stream().filter(i -> !isB2Tile(i)).findFirst().orElseThrow());
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
                        if (areConnectedNeighbours(t, placed)  &&
                                (!isB2Tile(t) || !b2Tiles.contains(t))) {
                            flag = true;
                            break outerLoop;
                            }

                    }
                }

                // additional check of B2 tile
                outLoop:
                for (String b2Tile : b2Tiles) {
                    if (flag) {break;}
                    ArrayList<String> neighbourPos =  getNeighbours(b2Tile,tilesMap);
                    if (neighbourPos.isEmpty()) { continue ;}
                    for (String position : neighbourPos) {
                        if (isB2Tile(tilesMap.get(position))) {continue;}
                        char searchRow, searchCol;
                        if (position.charAt(0) == b2Tile.charAt(2)) {
                            searchRow = position.charAt(0);
                            searchCol = (char) (position.charAt(1) < b2Tile.charAt(3) ?
                                    b2Tile.charAt(3)+1 : b2Tile.charAt(3)-1);
                        } else {
                            searchRow = (char) (position.charAt(0) < b2Tile.charAt(2) ?
                                    b2Tile.charAt(2)+1 : b2Tile.charAt(2)-1);
                            searchCol = position.charAt(1);
                        }
                        for (String routeTile : route) {
                            if (routeTile.charAt(2) == searchRow &&
                                    routeTile.charAt(3) == searchCol) {
                                flag = true;
                                String removeTile = tilesMap.remove(position);
                                tiles.remove(removeTile);
                                route.add(removeTile);
                                break outLoop;
                            }
                        }
                    }

                }

                // Count exits and start a new route
                if (!flag) {
                    route.addAll(b2Tiles);
                    for (String b2Tile :b2Tiles) {
                        if (isExitConnected(b2Tile)
                        && isB2TileNeedRemoved(b2Tile, route)) {
                            route.remove(b2Tile);
                        }
                    }
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
     * This is a helper method for countExitsScore, where B2 tile is connected to an exit
     * @author Frederick Li
     * @param b2Tile B2 tile
     * @param route a HashSet of tile placements
     * @return boolean
     */
    static boolean isB2TileNeedRemoved(String b2Tile, HashSet<String> route) {
        HashMap<String, String> tilesMap = new HashMap<>(); // for quick locating pieces
        for (String routeTile : route) {
            tilesMap.put(routeTile.substring(2, 4),routeTile);
        }

        var row = b2Tile.charAt(2);
        var col = b2Tile.charAt(3);
        if (row == 'A' || row == 'G') {
            char findRow = (char) (row == 'A' ? row+1 : row-1);
            while(true) {
                if ((row == 'A' && findRow == 'G') || (row == 'G' && findRow == 'A')) {
                    return false;
                }
                String findPos = String.valueOf(findRow) + String.valueOf(col);
                String routeTile = tilesMap.get(findPos);
                if (routeTile == null) {
                    return true;
                } else if (!isB2Tile(routeTile)) {
                    return false;
                } else {
                    findRow = (char) (row == 'A' ? ++findRow : --findRow);
                }
            }
        } else {
            char findCol = (char) (col == '0' ? col+1 : col-1);
            while(true) {
                if ((col == '0' && findCol == '6') || (col == '6' && findCol == '0')) {
                    return false;
                }
                String findPos = String.valueOf(row) + String.valueOf(findCol);
                String routeTile = tilesMap.get(findPos);
                if (routeTile == null) {
                    return true;
                } else if (!isB2Tile(routeTile)) {
                    return false;
                } else {
                    findCol = (char) (col == '0' ? ++findCol: --findCol);
                }
            }
        }
    }


    /**
     * This method is to get the tiles neighbours from the map if they are existed
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
        return -errors;
    }

    /**
     * Returns the longest string in the list.
     * @author Frederick Li
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
     * This method is to check whether all neighbouring tiles
     *      are validly connected for a new placement string
     * @author Frederick Li
     * @param boardString a string represents game state
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
     * This method is to check whether a tile is a railway (all edges are railway)
     *      B2 is excluded.
     * @author Frederick Li
     * @param tilePlacement a 5 characters string represents a tile
     */
    static boolean isRailway(String tilePlacement) {
        String tileKind = tilePlacement.substring(0, 2);
        return tileKind.equals("S3") || tileKind.equals("A0") ||
                tileKind.equals("A1") || tileKind.equals("A2");
    }


    /**
     * This method is to check whether a tile is a highway (all edges are highway)
     *      B2 is excluded.
     * @author Frederick Li
     * @param tilePlacement a 5 characters string represents a tile
     */
    static boolean isHighway(String tilePlacement){
        String tileKind = tilePlacement.substring(0, 2);
        return tileKind.equals("S2") || tileKind.equals("A3") ||
                tileKind.equals("A4") || tileKind.equals("A5");
    }


    /**
     * This method is to check whether two connected tiles have the same edge c ( r or h)
     * @author Frederick Li
     * @param tileA tilePlacement
     * @param tileB tilePlacement
     * @param c either 'r' or 'h'
     */
    static boolean checkEdge(String tileA, String tileB, char c) {
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
    static class RouteGraph {
        private HashMap<String, LinkedList<String>> adj; // adjacent tiles collection
        private int vertices;

        public RouteGraph(int vertices) {
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
        RouteGraph tileGraph = new RouteGraph(tilePlacements.size());
        for (String tile:
             tilePlacements) {
            LinkedList<String> neighbours = new LinkedList<>();
            tileGraph.adj.put(tile, neighbours);

        }
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
            tileGraph.findLongestRoadRec(startTile,visited ,1 ,max );
            maxCollections.add(max[0]);

        }

        return maxCollections.stream().max(Comparator.comparingInt(i->i)).orElseThrow();
    }

}