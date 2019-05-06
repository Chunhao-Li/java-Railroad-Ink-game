package comp1110.ass2.gui;

import comp1110.ass2.HelperMethod;
import comp1110.ass2.RailroadInk;
import static comp1110.ass2.HelperMethod.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final double VIEWER_WIDTH = 1024;
    private static final double VIEWER_HEIGHT = 768;
    private static final String URI_BASE = "assets/";
    private static final double Tile_Size = 80;
    private static final int X_Side = 232;   //(VIEWER_WIDTH - Tile_Size * 7)/2
    private static final int Y_Side = 104;   //(VIEWER_HEIGHT - Tile_Size * 7)/2

    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group Pieces = new Group();
    private final Group placedPieces = new Group();
    private final Group generatingPieces = new Group();
    private TextField textField;
    private String boardString = "";
    private int sTileTotal = 0;
    private int sTilePerTurn = 0;
    private List<DraggablePiece> sTilesNotPlaced = new ArrayList<>();
    private String dices = "";
    private int diceRollTimes = 0;
    private Text scoreShow = null;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    public void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        Pieces.getChildren().clear();
        for (int i = placement.length() - 5; i >= 0; i -= 5) {
            ImageView tileImage = new ImageView(new Image(
                    Viewer.class.getResource(URI_BASE + placement.substring(i, i + 2) + ".png").toString()));
            tileImage.setFitWidth(Tile_Size);
            tileImage.setFitHeight(Tile_Size);
            tileImage.setLayoutY(Y_Side + (placement.charAt(i + 2) - 'A') * Tile_Size);
            tileImage.setLayoutX(X_Side + (placement.charAt(i + 3) - '0') * Tile_Size);
            int orientation = placement.charAt(i + 4) - '0';
            if (orientation > 3) tileImage.setScaleX(-1);
            tileImage.setRotate(orientation < 4 ? orientation * 90 : (orientation - 4) * 90);
            Pieces.getChildren().add(tileImage);
        }

    }


    private void drawExits() {
        for (int col = 1; col <= 5; col += 2) {
            for (int row = 0; row <= 7; row += 7) {
                ImageView highExit = new ImageView(new Image(
                        Viewer.class.getResource(URI_BASE + "HighExit.png").toString()));
                ImageView railExit = new ImageView(new Image(
                        Viewer.class.getResource(URI_BASE + "RailExit.png").toString()));
                highExit.setFitWidth(Tile_Size);
                highExit.setFitHeight(Tile_Size);
                railExit.setFitWidth(Tile_Size);
                railExit.setFitHeight(Tile_Size);
                if (row == 0) {
                    if (col == 3) {
                        railExit.setLayoutY(Y_Side - Tile_Size/2);
                        railExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(railExit);
                    }else if (col == 1){
                        highExit.setLayoutY(Y_Side - Tile_Size/2);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }else { // col == 5
                        highExit.setLayoutY(Y_Side - Tile_Size/2);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }
                }
                if (row == 7) {
                    highExit.setRotate(180);
                    railExit.setRotate(180);
                    if (col == 3) {
                        railExit.setLayoutY(Y_Side - Tile_Size/2 + 7 * Tile_Size);
                        railExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(railExit);
                    }else if (col == 1){
                        highExit.setLayoutY(Y_Side - Tile_Size/2 + 7 * Tile_Size);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }else { // col == 5
                        highExit.setLayoutY(Y_Side - Tile_Size/2 + 7 * Tile_Size);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }
                }
            }
        }

        for (int row = 1; row <= 5; row += 2) {
            for (int col = 0; col <= 7; col += 7) {
                ImageView highExit = new ImageView(new Image(
                        Viewer.class.getResource(URI_BASE + "HighExit.png").toString()));
                ImageView railExit = new ImageView(new Image(
                        Viewer.class.getResource(URI_BASE + "RailExit.png").toString()));
                highExit.setFitWidth(Tile_Size);
                highExit.setFitHeight(Tile_Size);
                railExit.setFitWidth(Tile_Size);
                railExit.setFitHeight(Tile_Size);
                if (col == 0) {
                    highExit.setRotate(270);
                    railExit.setRotate(270);
                    if (row == 3) {
                        highExit.setLayoutY(Y_Side + row * Tile_Size);
                        highExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(highExit);
                    }else if (row == 1){
                        railExit.setLayoutY(Y_Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(railExit);
                    }else {
                        railExit.setLayoutY(Y_Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(railExit);
                    }
                }
                if (col == 7) {
                    highExit.setRotate(90);
                    railExit.setRotate(90);
                    if (row == 3) {
                        highExit.setLayoutY(Y_Side + row * Tile_Size);
                        highExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(highExit);
                    }else if (row == 1){
                        railExit.setLayoutY(Y_Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(railExit);
                    }else {
                        railExit.setLayoutY(Y_Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(railExit);
                    }
                }
            }
        }
    }

    /**
     * Generate 4 pieces via dice roll and 6 S tiles
     */
    private void generateDicePieces() {
        if (!dices.isEmpty() && hasValidPlacement()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "You must place regular tiles as many as you can!");
            alert.showAndWait();
            return;
        }
        diceRollTimes++;
        sTilePerTurn = 0;
        generatingPieces.getChildren().clear();
        dices = RailroadInk.generateDiceRoll();
        String[] eachDice = new String[4];
        for (int i = 0; i+2 <= dices.length(); i+=2) {
            eachDice[i/2] = dices.substring(i, i+2);
        }
        for (int i = 0; i < eachDice.length; i++) {
            String dice = eachDice[i];
            Image tileImage = new Image(Viewer.class.getResource(URI_BASE + dice + ".png").toString());
            DraggablePiece draggablePiece = new DraggablePiece(tileImage, dice);
            draggablePiece.setFitHeight(Tile_Size);
            draggablePiece.setFitWidth(Tile_Size);
            draggablePiece.homeX = X_Side/3f;
            draggablePiece.homeY = Y_Side + 20 + 2*i * Tile_Size;
            draggablePiece.setLayoutX(draggablePiece.homeX);
            draggablePiece.setLayoutY(draggablePiece.homeY);
            generatingPieces.getChildren().add(draggablePiece);
        }
        if (diceRollTimes == 1) {
            for (int i = 0; i < 6; i++) {
                Image tileImage = new Image(Viewer.class.getResource(
                        URI_BASE + "S" + i + ".png").toString());
                DraggablePiece draggablePiece = new DraggablePiece(tileImage, "S" + i);
                draggablePiece.setFitWidth(Tile_Size);
                draggablePiece.setFitHeight(Tile_Size);
                draggablePiece.homeX = X_Side + 7 * Tile_Size + X_Side / 3f;
                draggablePiece.setLayoutX(draggablePiece.homeX);
                draggablePiece.homeY = 30 + 1.5 * i * Tile_Size;
                draggablePiece.setLayoutY(draggablePiece.homeY);
                sTilesNotPlaced.add(draggablePiece);
                generatingPieces.getChildren().add(draggablePiece);
            }
        } else {
            generatingPieces.getChildren().addAll(sTilesNotPlaced);
        }
        handlePiece();
    }

    /**
     * Construct a draggable piece for play
     */
    class DraggablePiece extends ImageView {
        double homeX, homeY;
        int rotation = 0;
        double mouseX, mouseY; // the last known mouse positions
        boolean isFlipped = false;
        String name;

        DraggablePiece(Image image, String name) {
            super(image);
            this.name = name;

        }

        private void snapToHome() {
            this.setLayoutX(homeX);
            this.setLayoutY(homeY);
            this.setOpacity(1.0);
        }

        private void snapToGrid() {
            double currX = this.getLayoutX();
            double currY = this.getLayoutY();

            double newX = Math.round((currX-X_Side) / Tile_Size) * Tile_Size + X_Side;
            double newY = Math.round((currY-Y_Side) / Tile_Size) * Tile_Size + Y_Side;
            this.setLayoutX(newX);
            this.setLayoutY(newY);
            this.setOpacity(1.0);
        }

        private void rotate() {
            rotation = (rotation+1) % 4;
            this.setRotate(rotation*90);
        }

        private void flipped() {
            this.setScaleX(-1);
            isFlipped = true;

        }
        private void flippedBack() {
            this.setScaleX(1);
            isFlipped = false;
        }
        void drag(double moveX, double moveY) {
            setLayoutX(getLayoutX() + moveX);
            setLayoutY(getLayoutY() + moveY);
            setOpacity(0.5);
            this.toFront();
        }

        boolean isOnBoard() {
            return this.getLayoutX() > X_Side-Tile_Size && this.getLayoutX() < VIEWER_WIDTH-X_Side
                    && this.getLayoutY() > Y_Side-Tile_Size && this.getLayoutY() < VIEWER_HEIGHT-Y_Side;
        }

        void setPosition() {
            Image tileImage = new Image(Viewer.class.getResource(URI_BASE + name + ".png").toString());
            ImageView placedPiece = new ImageView(tileImage);
            placedPiece.setRotate(rotation*90);
            if (isFlipped) {
                placedPiece.setScaleX(-1);
            }
            placedPiece.setFitHeight(Tile_Size);
            placedPiece.setFitWidth(Tile_Size);
            placedPiece.setLayoutX(this.getLayoutX());
            placedPiece.setLayoutY(this.getLayoutY());
            placedPieces.getChildren().add(placedPiece);
            if (name.charAt(0) == 'S') {
                sTilePerTurn++;
                sTileTotal++;
                sTilesNotPlaced.remove(this);
            } else {
                int i = dices.indexOf(name);
                dices = dices.substring(0, i) + dices.substring(i+2, dices.length());
            }
            System.out.println(boardString);

        }

        boolean isValid() {
            double currX = this.getLayoutX();
            double currY = this.getLayoutY();
            char col = (char) ( Math.round((currX-X_Side) / Tile_Size) + '0') ;
            char row = (char) (Math.round((currY-Y_Side) / Tile_Size) + 'A') ;
            String orientation = isFlipped ? String.valueOf(rotation+4) : String.valueOf(rotation);
            String piecePlacement = name + String.valueOf(row) + String.valueOf(col) + orientation;
            if (name.charAt(0) == 'S' ) {
                if (sTileTotal >= 3) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You have used 3 special tiles in this game!");
                alert.showAndWait();
                    return false;}
                if (sTilePerTurn == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "You can only use 1 special tile each turn!");
                    alert.showAndWait();
                    return false;
                }
            }
            if (RailroadInk.isValidPlacementSequence(boardString+piecePlacement)
                && HelperMethod.areNeighboursValid(boardString, piecePlacement)
           ) {
                boardString += piecePlacement;

                return true;
            } else {
                return false;
            }

        }

    }

    private boolean hasValidPlacement() {
        List<String> unUsedGrids = HelperMethod.getUnusedGrids(boardString);
        Set<String> tiles = new HashSet<>();
        for (int i = 0; i+2 <= dices.length(); i+=2) {
            tiles.add(dices.substring(i, i+2));
        }

        for (String tile: tiles) {
            List<Character> orientations = HelperMethod.getOrientations(tile);
            for (String grid : unUsedGrids) {
                for (char o : orientations) {
                    String placement = tile+grid+String.valueOf(o);
                    if (RailroadInk.isValidPlacementSequence(boardString+placement) &&
                        HelperMethod.areNeighboursValid(boardString, placement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method is used to control DraggablePiece :
     * - Scroll on the tile: rotate it 90 degrees clockwise
     * - Double click: flip the tile (if not flipped)
     * - Triple click: flip back (if flipped)
     * - Drag and release the tile on the board to place it
     */
    private void handlePiece() {
        for (Node node : generatingPieces.getChildren()) {
            DraggablePiece piece = (DraggablePiece) node;
            piece.setOnScroll(e -> {
                piece.rotate();
            });

            piece.setOnMouseClicked(e -> {
                switch (e.getClickCount()) {
                    case 2:
                        piece.flipped();
                        break;
                    case 3:
                        piece.flippedBack();
                        break;
                }
            });

            piece.setOnMousePressed(e -> {
                piece.mouseX = e.getSceneX();
                piece.mouseY = e.getSceneY();
            });

            piece.setOnMouseDragged(e -> {
                piece.toFront();
                double moveX = e.getSceneX() - piece.mouseX;
                double moveY = e.getSceneY() - piece.mouseY;
                piece.drag(moveX, moveY);
                piece.mouseX = e.getSceneX();
                piece.mouseY = e.getSceneY();
            });

            piece.setOnMouseReleased(e -> {
                if (!piece.isOnBoard()) {
                    piece.snapToHome();
                } else if (piece.isValid()) {
                    piece.snapToGrid();
                    piece.setPosition();
                    generatingPieces.getChildren().remove(piece);
                } else {
                    piece.snapToHome();
                }

                if (diceRollTimes == 7 && !hasValidPlacement()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "No more placement", ButtonType.OK);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.OK) {
                        int score = RailroadInk.getAdvancedScore(boardString);
                        scoreShow = new Text(VIEWER_WIDTH/2, (double) Y_Side/2, "Advanced Score: "+score);
                        scoreShow.setFont(Font.font("Verdana", 20));
                        root.getChildren().add(scoreShow);
                    }
                }
            });

        }
    }



    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Button diceRoll = new Button("Roll the dice");
        diceRoll.setLayoutX(40);
        diceRoll.setLayoutY(40);
        diceRoll.setOnAction(e -> {
            if (diceRollTimes == 7) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "7 rounds reached");
                alert.showAndWait();
            } else {

                generateDicePieces();
            }

        });

        Button clear = new Button("Clear");
        clear.setLayoutX(diceRoll.getLayoutX()+100);
        clear.setLayoutY(diceRoll.getLayoutY());
        clear.setOnAction(e -> {
            generatingPieces.getChildren().clear();
            placedPieces.getChildren().clear();
            diceRollTimes = 0;
            boardString = "";
            sTileTotal = 0;
            dices = "";
            sTilePerTurn = 0;
            root.getChildren().remove(scoreShow);

        });

        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            placedPieces.getChildren().clear();
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().addAll(hb, diceRoll, clear);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        Rectangle rectangle = new Rectangle(3*Tile_Size, 3*Tile_Size, Color.LIGHTGRAY);
        rectangle.setX(X_Side+2*Tile_Size);
        rectangle.setY(Y_Side +2*Tile_Size);


        root.getChildren().addAll(rectangle, generatingPieces, placedPieces, controls, Pieces);

        makeControls();
//        handlePiece();

        Line[] row = new Line[8];
        Line[] column = new Line[8];
        for (int i = 0; i < 8; i ++){
            row[i] = new Line();
            column[i] = new Line();
            row[i].setStartX(X_Side);
            row[i].setStartY(Y_Side + i * Tile_Size);
            row[i].setEndX(X_Side + 7 * Tile_Size);
            row[i].setEndY(Y_Side + i * Tile_Size);
            column[i].setStartX(X_Side + i * Tile_Size);
            column[i].setStartY(Y_Side);
            column[i].setEndX(X_Side + i * Tile_Size);
            column[i].setEndY(Y_Side + 7 * Tile_Size);
            root.getChildren().add(row[i]);
            root.getChildren().add(column[i]);
        }
        drawExits();

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
