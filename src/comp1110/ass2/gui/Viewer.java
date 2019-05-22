package comp1110.ass2.gui;

import static comp1110.ass2.RailroadInk.*;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is a JavaFX application that provides a graphical user interface for the Railroad Ink game.
 * <p>
 *
 * @author Frederick Li (except explicitly commented)
 *
 * The game feature:
 * - It has four modes (Single Mode), (Player to AI mode), (Debug Mode), (AI to AI mode) which correspond to
 * -    the buttons "Single game", "Play with computer", "Debug mode", "AI to AI" in the main page.
 * - In every mode, users can press "ESCAPE" to quit and clear current game state
 * -    and go back to the main page.
 * - In the main page, useres can press "Q" to quit the game.
 *
 * - Single Mode:
 * -    Users can press "Roll a dice" to start a new turn, and press "clear" to end the current game
 * -    Users can rotate the tiles using mouse scroll on tiles, flip the tiles when click twice on
 * -        the tile or flip back with tripple click.
 * -    Users can drag tiles and put them on the board.
 * -    All other rules are in README.md.
 * - Player to AI Mode:
 * -    Most of the features are the same as the Single Mode.
 * -    "Change to AI" button can enable AI to play moves.
 * -    In every turn except turn 7, users need to press "Change to AI" which enables AI to make a move.
 * -    Users can press "New Game" to end the current game and start a new one.
 * -    Users can press "Change to AI" to change the board to AI's, and "Go back to player" to switch back
 * -    All other rules are in README.md.
 * - Debug Mode:
 * -    Users can input any tile placements in the TextField and then press "Refresh" to show them
 * -    When users input any illegal texts in the TextField, "Refresh" can clear the current tiles.
 * -    "Place tiles" does the same thing except that it won't clear TextField.
 * - AI to AI:
 * -    A simple mode for testing different AIs' performance. Simpliy change the "generateMove"
 * -    and "generateBetterMove" in the method playMoveAi for using different AI. (add or remove
 * -    "sTilesAI" or "STileAicomponent" if the methods needs to use special tiles or not).
 */
public class Viewer extends Application {
    private static final double VIEWER_WIDTH = 1024;
    private static final double VIEWER_HEIGHT = 768;
    private static final String URI_BASE = "assets/";
    private static final double Tile_Size = 80;
    private static final int X_Side = 232;   //(VIEWER_WIDTH - Tile_Size * 7)/2
    private static final int Y_Side = 104;   //(VIEWER_HEIGHT - Tile_Size * 7)/2

    final private static MediaPlayer bgMusic        // Bob modified
        = new MediaPlayer(new Media(Viewer.class.getResource(URI_BASE + "BGM.mp3").toString()));
    final private static int MUSIC_MODE = MediaPlayer.INDEFINITE;  // Bob modified

    private final Group mainGroup = new Group();
    private final Group boardSingleMode = new Group(); // board group for single game mode
    private final Group boardAI = new Group(); // AI in "Player to AI" or AI1 in "AI to AI" mode
    private final Group boardPlayer = new Group();
    private final Group boardAIComponent = new Group(); // AI2's board in "AI to AI" mode

    private final Group controls = new Group(); // controls for "Single Mode" and "Debug Mode"
    private final Group controlsPlayer = new Group();
    private final Group controlsAI = new Group();  // AI's controls in "Player to AI"
    private final Group controlsAIMode = new Group();   // AI1 in "AI to AI mode"
    private final Group controlsAiComponent = new Group(); // AI2 in "AI to AI mode"
    private final Group pieces = new Group();
    private final Group placedPieces = new Group();
    private final Group aiPieces = new Group();
    private final Group generatingPieces = new Group();
    private final Group rootSingle = new Group();
    private final Group rootPlayer = new Group();
    private final Group rootAI = new Group();   // main group for AI in "Player to AI" or AI1 in "AI to AI"
    private final Group rootAIComponent = new Group();
    private Scene sceneAIComponent = new Scene(rootAIComponent, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene sceneAI = new Scene(rootAI, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene sceneMain = new Scene(mainGroup, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene sceneSingle = new Scene(rootSingle, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene scenePlayer = new Scene(rootPlayer, VIEWER_WIDTH, VIEWER_HEIGHT);
    private TextField textField;
    private String boardString = "";
    private String boardStringAI = "";
    private int sTileTotal = 0;
    private int sTilePerTurn = 0;
    private List<DraggablePiece> sTilesNotPlaced = new ArrayList<>();
    private String dices = "";
    private String dicesAI = "";
    private int diceRollTimes = 0;
    private Text resultInfo = null;
    private Text resultInfoAI = null;
    private Text turnInfo = null;
    private Text turnInfoAI = null;
    private List<String> sTilesAI = new ArrayList<>();
    private List<String> sTileAIComponent = new ArrayList<>();

    //Bob modified
    private ImageView mainBgImg;
    private ImageView boardBGImg;
    private ImageView aiGroupImg;
    private ImageView aiComponentImg;

    /**
     * Draw a placement in the window, removing any previously drawn one
     * @author Mingchao Sima, Frederick Li (modified)
     * @param placement A valid placement string
     *
     */
    public void makePlacement(String placement, boolean isAIMode, Group group) {
        // FIXME Task 4: implement the simple placement viewer
        group.getChildren().clear();
        for (int i = placement.length() - 5; i >= 0; i -= 5) {
            try {
                ImageView tileImage = new ImageView(new Image(Viewer.class.getResource(
                        URI_BASE + placement.substring(i, i + 2) + ".png").toString()));
                tileImage.setFitWidth(Tile_Size);
                tileImage.setFitHeight(Tile_Size);
                tileImage.setLayoutY(Y_Side + (placement.charAt(i + 2) - 'A') * Tile_Size);
                tileImage.setLayoutX(X_Side + (placement.charAt(i + 3) - '0') * Tile_Size);
                int orientation = placement.charAt(i + 4) - '0';
                if (orientation > 3) tileImage.setScaleX(-1);   // flip tile
                tileImage.setRotate(orientation < 4 ? orientation * 90 : (orientation - 4) * 90);
                group.getChildren().add(tileImage);
            } catch (NullPointerException e) {  // invalid placement input
                return;
            }
        }
        if (isAIMode) {
            dicesAI = "";
        }
    }


    /**
     * This method is used to draw 12 exits
     *
     * @param group a board Group which will add these exits
     * @author Mingchao Sima
     */
    private void drawExits(Group group) {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 7; row++) {
                ImageView exit = new ImageView();
                exit.setFitWidth(Tile_Size);
                exit.setFitHeight(Tile_Size);
                if (col == 1 || col == 3 || col == 5) {
                    exit.setLayoutX(X_Side + col * Tile_Size);
                    if (col == 1 || col == 5) {
                        exit.setImage(new Image(Viewer.class.getResource(
                                URI_BASE + "HighExit.png").toString()));
                    } else {
                        exit.setImage(new Image(Viewer.class.getResource(
                                URI_BASE + "RailExit.png").toString()));
                    }

                    if (row == 0) {
                        exit.setLayoutY(Y_Side - Tile_Size / 2);
                        group.getChildren().add(exit);
                    } else if (row == 6) {
                        exit.setRotate(180);
                        exit.setLayoutY(VIEWER_HEIGHT - Y_Side - Tile_Size / 2);
                        group.getChildren().add(exit);
                    }

                } else if (col == 0 || col == 6) {
                    exit.setLayoutY(Y_Side + row * Tile_Size);
                    if (col == 0) {
                        exit.setRotate(270);
                        exit.setLayoutX(X_Side - Tile_Size / 2);
                    } else {
                        exit.setRotate(90);
                        exit.setLayoutX(VIEWER_WIDTH - X_Side - Tile_Size / 2);
                    }

                    if (row == 1 || row == 5) {
                        exit.setImage(new Image(Viewer.class.getResource(
                                URI_BASE + "RailExit.png").toString()));
                        group.getChildren().add(exit);
                    } else if (row == 3) {
                        exit.setImage(new Image(Viewer.class.getResource(
                                URI_BASE + "HighExit.png").toString()));
                        group.getChildren().add(exit);
                    }
                }
            }
        }
    }


    /* Generate 4 normal tiles with random dice roll and 6 special tiles */
    private void generateDicePieces(Group group) {
        if (!dices.isEmpty() && hasValidPlacement(false)) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "You must place regular tiles as many as you can!");
            alert.showAndWait();
            return;
        }
        diceRollTimes++;
        dices = generateDiceRoll();

        if (diceRollTimes > 1) {
            group.getChildren().remove(turnInfo); // avoid adding the same node twice
        }
        turnInfo = group == rootPlayer ?
                new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes) :
                new Text(X_Side + Tile_Size, 60, "Turn: " + diceRollTimes);
        turnInfo.setFont(Font.font("Verdana", 20));
        group.getChildren().add(turnInfo);

        sTilePerTurn = 0;   // init special tiles used count
        generatingPieces.getChildren().clear();

        if (group == rootPlayer) {  // Player to AI mode
            rootAI.getChildren().remove(turnInfoAI);
            turnInfoAI = new Text(X_Side + Tile_Size, 60, "Turn: " + diceRollTimes);
            turnInfoAI.setFont(Font.font("Verdana", 20));
            rootAI.getChildren().add(turnInfoAI);
            dicesAI = dices;
        }

        String[] tiles = splitString(dices, 2);

        for (int i = 0; i < tiles.length; i++) {
            String dice = tiles[i];
            Image tileImage = new Image(Viewer.class.getResource(
                    URI_BASE + dice + ".png").toString());
            DraggablePiece draggablePiece = new DraggablePiece(tileImage, dice);
            draggablePiece.setFitHeight(Tile_Size);
            draggablePiece.setFitWidth(Tile_Size);
            draggablePiece.homeX = X_Side / 3f;
            draggablePiece.homeY = Y_Side + 20 + 2 * i * Tile_Size;
            draggablePiece.setLayoutX(draggablePiece.homeX);
            draggablePiece.setLayoutY(draggablePiece.homeY);
            generatingPieces.getChildren().add(draggablePiece);
        }

        // draw the six special tiles in the first turn
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

        handlePiece(group);
    }


    /**
     * This class can enable users to drag or rotate tiles
     */
    class DraggablePiece extends ImageView {
        double homeX, homeY;
        int rotation = 0;
        double mouseX, mouseY;  // the last known mouse positions
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
            double newX = Math.round((currX - X_Side) / Tile_Size) * Tile_Size + X_Side;
            double newY = Math.round((currY - Y_Side) / Tile_Size) * Tile_Size + Y_Side;
            this.setLayoutX(newX);
            this.setLayoutY(newY);
            this.setOpacity(1.0);
        }

        private void rotate() {
            rotation = (rotation + 1) % 4;
            this.setRotate(rotation * 90);
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
            return getLayoutX() > X_Side - Tile_Size && getLayoutX() < VIEWER_WIDTH - X_Side
                    && getLayoutY() > Y_Side - Tile_Size && getLayoutY() < VIEWER_HEIGHT - Y_Side;
        }

        void setPosition() {
            Image tileImage = new Image(Viewer.class.getResource(
                    URI_BASE + name + ".png").toString());
            ImageView placedPiece = new ImageView(tileImage);
            placedPiece.setRotate(rotation * 90);
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
                dices = dices.substring(0, i) + dices.substring(i+2, dices.length()); // remove from dices
            }
        }

        boolean isValid() {
            double currX = this.getLayoutX();
            double currY = this.getLayoutY();
            char col = (char) (Math.round((currX - X_Side) / Tile_Size) + '0');
            char row = (char) (Math.round((currY - Y_Side) / Tile_Size) + 'A');
            String orientation = isFlipped ? String.valueOf(rotation + 4) : String.valueOf(rotation);
            String piecePlacement = name + String.valueOf(row) + String.valueOf(col) + orientation;
            if (name.charAt(0) == 'S') {
                if (sTileTotal >= 3) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "You have used 3 special tiles in this game!");
                    alert.showAndWait();
                    return false;
                }
                if (sTilePerTurn == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "You can only use 1 special tile each turn!");
                    alert.showAndWait();
                    return false;
                }
            }
            if (isValidPlacementSequence(boardString + piecePlacement)) {
                boardString += piecePlacement;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * This method is to check whether exists valid moves
     *
     * @param sIncluded including special tiles or not
     * @return boolean
     */
    private boolean hasValidPlacement(boolean sIncluded) {
        HashSet<String> availableGrids = getAvailableGrids(boardString);
        Set<String> tiles = new HashSet<>();
        for (int i = 0; i + 2 <= dices.length(); i += 2) {
            tiles.add(dices.substring(i, i + 2));
        }

        if (sIncluded && sTileTotal < 3 && sTilePerTurn == 0) {
            for (DraggablePiece sTileDraggable : sTilesNotPlaced) {
                tiles.add(sTileDraggable.name);
            }
        }

        for (String tile : tiles) {
            List<Character> orientations = getOrientations(tile);
            for (String grid : availableGrids) {
                for (char o : orientations) {
                    String placement = tile + grid + String.valueOf(o);
                    if (isValidPlacementSequence(boardString + placement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * This method is used to control DraggablePiece
     * - Scroll on the tile: rotates 90 degrees clockwise each time
     * - Double click: flip the tile (if not flipped)
     * - Triple click: flip back (if flipped)
     * - Drag and release the tile on the board to place it
     */
    private void handlePiece(Group group) {
        BooleanProperty isDragging = new ReadOnlyBooleanWrapper(false);

        for (Node node : generatingPieces.getChildren()) {
            DraggablePiece piece = (DraggablePiece) node;

            piece.setOnScroll(e -> {
                if (!isDragging.getValue()) {
                    piece.rotate(); // cannot rotate when dragging
                }
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
                isDragging.setValue(true);
                piece.toFront();
                double moveX = e.getSceneX() - piece.mouseX;
                double moveY = e.getSceneY() - piece.mouseY;
                piece.drag(moveX, moveY);
                piece.mouseX = e.getSceneX();
                piece.mouseY = e.getSceneY();
            });

            piece.setOnMouseReleased(e -> {
                isDragging.setValue(false);
                if (!piece.isOnBoard()) {
                    piece.snapToHome();
                } else if (piece.isValid()) {
                    piece.snapToGrid();
                    piece.setPosition();
                    generatingPieces.getChildren().remove(piece);
                } else {
                    piece.snapToHome();
                }

                // In the last turn, check valid moves and show the information if necessary
                if (diceRollTimes == 7) {
                    if (!hasValidPlacement(true)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                                "No more moves, press OK to get the score", ButtonType.OK);
                        alert.showAndWait();
                        if (group == rootSingle) {
                            int score = getAdvancedScore(boardString);
                            resultInfo = new Text(VIEWER_WIDTH / 2, 60,
                                    "Total Score: " + score);
                            resultInfo.setFont(Font.font("Verdana", 20));
                            generatingPieces.getChildren().clear();
                            group.getChildren().add(resultInfo);
                        } else {
                            if (sTilesAI.size() == 3) {
                                sTilesAI.clear();   // can only use at most 3 special tiles
                            }
                            boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
                            makePlacement(boardStringAI, true, pieces);
                            calculateScore(group);
                        }
                    } else if (!hasValidPlacement(false)
                            && hasValidPlacement(true)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                                "You can still place a special tile, do you want to end the game?",
                                    ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.YES) {
                            if (group == rootSingle) {
                                int score = getAdvancedScore(boardString);
                                resultInfo = new Text(VIEWER_WIDTH / 2, (double) Y_Side / 2,
                                        "Advanced Score: " + score);
                                resultInfo.setFont(Font.font("Verdana", 20));
                                generatingPieces.getChildren().clear();
                                group.getChildren().add(resultInfo);
                            } else {
                                if (sTilesAI.size() == 3) {
                                    sTilesAI.clear();
                                }
                                boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
                                makePlacement(boardStringAI, true, pieces);
                                calculateScore(group);
                            }
                        }
                    }
                }
            });

        }
    }

    /* Get the total result for Player to AI mode */
    private void calculateScore(Group group) {
        int scorePlayer = getAdvancedScore(boardString);
        int scoreAI = getAdvancedScore(boardStringAI);
        int errorPlayer = -countErrorsScore(boardString);
        int errorAI = -countErrorsScore(boardStringAI);

        String winnerInfo = "Winner: ";
        if (scoreAI == scorePlayer) {
            if (errorPlayer < errorAI) {
                winnerInfo += "Player!";
            } else if (errorAI < errorPlayer) {
                winnerInfo += "AI!";
            } else {
                winnerInfo = "Tie!";
            }
        } else if (scoreAI < scorePlayer) {
            winnerInfo += "Player!";
        } else {
            winnerInfo += "AI!";
        }

        resultInfo = new Text(X_Side + 2 * Tile_Size, Y_Side / 3f, winnerInfo);
        resultInfo.setFont(Font.font("Verdana", 30));
        Label scoreP, scoreA;
        if (!winnerInfo.equals("Tie")) {
            scoreP = new Label("Player's Score: " + scorePlayer);
            scoreA = new Label("AI's Score: " + scoreAI);
        } else {
            scoreP = new Label("Player's Score: " + scorePlayer + " Errors: " + errorPlayer);
            scoreA = new Label("AI's Score: " + scoreAI + " Errors: " + errorAI);
        }
        VBox scores = new VBox(scoreP, scoreA);
        scores.setSpacing(10);
        scores.setLayoutX(X_Side + 5 * Tile_Size);
        scores.setLayoutY(Y_Side / 3f);
        group.getChildren().addAll(scores, resultInfo);
        generatingPieces.getChildren().clear();
    }


    /* This method can clear current game state for any modes */
    private void clearAll() {
        if (textField != null) {
            textField.clear();
        }
        initSTiles();
        generatingPieces.getChildren().clear();
        placedPieces.getChildren().clear();
        aiPieces.getChildren().clear();
        sTilesNotPlaced.clear();
        diceRollTimes = sTilePerTurn = sTileTotal = 0;
        dices = dicesAI = boardString = boardStringAI = "";
        resultInfo = resultInfoAI = null;
        pieces.getChildren().clear();

        rootPlayer.getChildren().clear();
        rootPlayer.getChildren().addAll(boardBGImg, boardPlayer, generatingPieces, placedPieces);

        rootAI.getChildren().clear();
        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAI, pieces);

        rootAIComponent.getChildren().clear();
        rootAIComponent.getChildren().addAll(aiComponentImg, boardAIComponent, controlsAiComponent, aiPieces);

        rootSingle.getChildren().clear();

        //Bob modified
        rootSingle.getChildren().addAll(boardBGImg, boardSingleMode, controls, generatingPieces, placedPieces, pieces);
    }


    /**
     * This method controls the main scene where users can switch to different modes
     * modes:
     * - Single mode ("Single game")
     * - Player to AI mode ("Play with computer")
     * - Debug mode ("Debug mode")
     * - AI to AI mode ("AI to AI")
     *
     * @param primaryStage the main stage of the program
     */
    private void mainSceneSetting(Stage primaryStage) {
        initSTiles();
        primaryStage.setScene(sceneMain);

        sceneMain.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm()); // Bob modified

        sceneMain.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
                primaryStage.close();
            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setLayoutX(VIEWER_WIDTH / 2 - Tile_Size);
        vBox.setLayoutY(VIEWER_HEIGHT / 2 - Tile_Size);
        vBox.setSpacing(30);
        Text title = new Text(VIEWER_WIDTH / 3, X_Side, "Railroad Ink");
        title.setFont(Font.font("Verdana", 50));

        Button single = new Button("Single game");
        single.setOnAction(e -> {
            singleOrDebug(primaryStage, true);

        });

        Button debug = new Button("Debug mode");
        debug.setOnAction(e -> {
            singleOrDebug(primaryStage, false);
        });

        Button computerMode = new Button("Play with computer");
        computerMode.setOnAction(e -> {
            playWithAI(primaryStage);
        });

        Button aiComponentMode = new Button("AI to AI");
        aiComponentMode.setOnAction(e -> {
            aiToAiMode(primaryStage);
        });
        // Bob modified
        bgMusic.setCycleCount(Viewer.MUSIC_MODE);
        bgMusic.play(); // play music

        mainBgImg = new ImageView();
        mainBgImg.setImage(new Image(getClass().getResource(URI_BASE + "bg.jpg").toString()));
        mainBgImg.setFitWidth(VIEWER_WIDTH);
        mainBgImg.setFitHeight(VIEWER_HEIGHT);
        mainBgImg.setOpacity(0.8);

        boardBGImg = new ImageView();
        boardBGImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
        boardBGImg.setFitWidth(VIEWER_WIDTH);
        boardBGImg.setFitHeight(VIEWER_HEIGHT);
        boardBGImg.setOpacity(0.45);

        aiGroupImg = new ImageView();
        aiGroupImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
        aiGroupImg.setFitWidth(VIEWER_WIDTH);
        aiGroupImg.setFitHeight(VIEWER_HEIGHT);
        aiGroupImg.setOpacity(0.45);

        aiComponentImg = new ImageView();
        aiComponentImg.setImage(new Image(getClass().getResource(URI_BASE + "boardBG.jpg").toString()));
        aiComponentImg.setFitWidth(VIEWER_WIDTH);
        aiComponentImg.setFitHeight(VIEWER_HEIGHT);
        aiComponentImg.setOpacity(0.45);

        vBox.getChildren().addAll(single, computerMode, debug, aiComponentMode);
        // Bob modified
        mainGroup.getChildren().addAll(mainBgImg, vBox, title);
    }

    /* Method for drawing board */
    private void drawBoard(Group group) {
        for (int i = 0; i < 8; i++) {
            Line row = new Line();
            Line column = new Line();
            row.setStartX(X_Side);
            row.setStartY(Y_Side + i * Tile_Size);
            row.setEndX(X_Side + 7 * Tile_Size);
            row.setEndY(Y_Side + i * Tile_Size);
            column.setStartX(X_Side + i * Tile_Size);
            column.setStartY(Y_Side);
            column.setEndX(X_Side + i * Tile_Size);
            column.setEndY(Y_Side + 7 * Tile_Size);
            group.getChildren().addAll(row, column);
            if (i == 2 || i == 5) {
                Line redRow = new Line();
                Line redCol = new Line();
                redRow.setStartX(X_Side + 2 * Tile_Size);
                redRow.setStartY(Y_Side + i * Tile_Size);
                redRow.setEndX(X_Side + 5 * Tile_Size);
                redRow.setEndY(Y_Side + i * Tile_Size);
                redCol.setStartX(X_Side + i * Tile_Size);
                redCol.setStartY(Y_Side + 2 * Tile_Size);
                redCol.setEndX(X_Side + i * Tile_Size);
                redCol.setEndY(Y_Side + 5 * Tile_Size);
                redRow.setStroke(Color.RED);
                redCol.setStroke(Color.RED);
                group.getChildren().addAll(redRow, redCol);
            }

        }
    }


    /**
     * Making and handle controls for all scenes except the main scene.
     *
     * @param group      the control Group
     * @param isGameMode gameMode is singleOrDebug or Player to AI mode
     * @param stage      primaryStage
     */
    private void makeControls(Group group, boolean isGameMode, Stage stage) {
        Button diceRoll = new Button("Roll a dice");
        Button clear = new Button("Clear");
        Button changeView = new Button("Change to AI");
        Button changeAi = new Button("Change AI");
        Button changeAiBack = new Button("Change to another AI");
        Button newGame = new Button("New Game");
        Button newGameAi = new Button("New Game");
        Button switchBack = new Button("Go back to player");
        Button newMove = new Button("New Turn");

        diceRoll.setOnAction(e -> {
            if (diceRollTimes == 7) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "7 rounds reached");
                alert.showAndWait();
            } else {
                if (group == rootPlayer && !dicesAI.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "You must press 'Change to AI' before the next turn!");
                    alert.showAndWait();
                } else {
                    generateDicePieces(group);
                }
            }

        });

        clear.setOnAction(e -> {
            clearAll();
        });

        // play move of AI and change board to AI (Player to AI mode)
        changeView.setOnAction(e -> {
            if (!dices.isEmpty() && hasValidPlacement(false)) {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "You must place regular tiles as many as you can!");
                alert.showAndWait();
            } else {
                stage.setScene(sceneAI);
                if (!dicesAI.isEmpty()) {
                    if (sTilesAI.size() == 3) {
                        sTilesAI.clear();
                    }
                    boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTilesAI);
                    makePlacement(boardStringAI, true, pieces);
                    if (diceRollTimes == 7) {
                        calculateScore(rootPlayer);
                    }
                }
            }
        });

        newGame.setOnAction(e -> {
            clearAll();
            playWithAI(stage);
        });

        newGameAi.setOnAction(e -> {
            clearAll();
            aiToAiMode(stage);
        });

        switchBack.setOnAction(e -> {
            stage.setScene(scenePlayer);
        });

        changeAi.setOnAction(e -> {
            stage.setScene(sceneAIComponent);
        });

        changeAiBack.setOnAction(e -> {
            stage.setScene(sceneAI);
        });

        newMove.setOnAction(e -> {
            playMoveAi();
        });

        HBox buttonBox = new HBox();
        buttonBox.setLayoutX(40);
        buttonBox.setLayoutY(40);
        buttonBox.setSpacing(13);

        // Player to AI mode
        if (group == rootPlayer) {
            buttonBox.getChildren().addAll(diceRoll, changeView, newGame);
            controlsPlayer.getChildren().add(buttonBox);
            switchBack.setLayoutX(40);
            switchBack.setLayoutY(40);
            controlsAI.getChildren().add(switchBack);
        }

        // AI to AI mode
        if (group == rootAI) {
            buttonBox.getChildren().addAll(newMove, changeAi, newGameAi);
            changeAiBack.setLayoutX(40);
            changeAiBack.setLayoutY(40);
            controlsAIMode.getChildren().add(buttonBox);
            controlsAiComponent.getChildren().add(changeAiBack);
        }

        // Debug or Single mode
        if (group == rootSingle) {
            buttonBox.getChildren().addAll(diceRoll, clear);

            HBox hb = new HBox();   // HBox collections for debug mode
            Label label1 = new Label("Placement:");
            textField = new TextField();
            textField.setPrefWidth(300);
            Button button = new Button("Refresh");
            Button placeTiles = new Button("Place tiles");
            button.setOnAction(e -> {
                makePlacement(textField.getText(), false, pieces);
                textField.clear();
            });
            placeTiles.setOnAction(e -> {
                makePlacement(textField.getText(), false, pieces);
            });
            hb.getChildren().addAll(label1, textField, button, placeTiles);
            hb.setSpacing(20);
            hb.setLayoutX(130);
            hb.setLayoutY(VIEWER_HEIGHT - 50);

            if (isGameMode) {       // single game mode
                controls.getChildren().clear();
                controls.getChildren().add(buttonBox);
            } else {                // debug mode
                controls.getChildren().clear();
                controls.getChildren().add(hb);
            }
        }
    }

    /* Init the special tiles collections (AI to AI mode) */
    private void initSTiles() {
        sTilesAI.clear();
        sTileAIComponent.clear();
        for (int i = 0; i < 6; i++) {
            sTilesAI.add("S" + i);
            sTileAIComponent.add("S" + i);
        }
    }


    /* This method is for ai to ai mode */
    private void playMoveAi() {
        diceRollTimes++;
        if (diceRollTimes > 1 && diceRollTimes < 8) {       // prevent adding the same node twice
            rootAI.getChildren().remove(turnInfo);
            rootAIComponent.getChildren().remove(turnInfoAI);
        }

        if (diceRollTimes < 8) {
            dices = dicesAI = generateDiceRoll();
            if (sTilesAI.size() == 3) {
                sTilesAI.clear();
            }
            if (sTileAIComponent.size() == 3) {
                sTileAIComponent.clear();
            }
            boardString += generateMove(boardString, dices);    // AI 1
            boardStringAI += generateBetterMove(boardStringAI, dicesAI, sTileAIComponent); // AI 2
            makePlacement(boardString, false, pieces);
            makePlacement(boardStringAI, false, aiPieces);

            // update the turn information
            turnInfo = new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes);
            turnInfoAI = new Text(X_Side + 2 * Tile_Size, 60, "Turn: " + diceRollTimes);
            turnInfo.setFont(Font.font("Verdana", 20));
            turnInfoAI.setFont(Font.font("Verdana", 20));
            rootAI.getChildren().add(turnInfo);
            rootAIComponent.getChildren().add(turnInfoAI);
        }

        if (diceRollTimes >= 7) {   // end the game and displays the result
            if (resultInfo == null && resultInfoAI == null) {
                int score1 = getAdvancedScore(boardString);
                int score2 = getAdvancedScore(boardStringAI);
                resultInfo = new Text(X_Side + 4 * Tile_Size, Y_Side / 2f,
                        "AI1 score: " + score1 + "  " + "AI2 score: " + score2);
                resultInfo.setFont(Font.font("Verdana", 27));
                resultInfoAI = new Text(X_Side + 4 * Tile_Size, Y_Side / 2f,
                        "AI1 score: " + score1 + "  " + "AI2 score: " + score2);
                resultInfoAI.setFont(Font.font("Verdana", 27));
                rootAI.getChildren().add(resultInfo);
                rootAIComponent.getChildren().add(resultInfoAI);
            }
        }
    }

    /* Init method for the Player to AI Mode */
    private void playWithAI(Stage stage) {
        stage.setScene(scenePlayer);

        scenePlayer.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm());   // Bob
        sceneAI.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm());   // Bob

        scenePlayer.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(sceneMain);
            }
        });

        sceneAI.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(sceneMain);
            }
        });

        makeControls(rootPlayer, true, stage);
        rootPlayer.getChildren().clear();
        rootPlayer.getChildren().addAll(boardBGImg, boardPlayer, controlsPlayer, generatingPieces, placedPieces);

        rootAI.getChildren().clear();
        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAI, pieces);
    }

    /**
     * Init method for the Single and Debug mode.
     * @param stage the main stage of the game
     * @param isGameMode if true, it is singleOrDebug, otherwise debug mode
     */
    private void singleOrDebug(Stage stage, boolean isGameMode) {
        stage.setScene(sceneSingle);


        sceneSingle.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm()); // Bob modified

        sceneSingle.setOnKeyPressed(e -> {
           if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(sceneMain);
            }
        });

        makeControls(rootSingle, isGameMode, stage);
        rootSingle.getChildren().clear();
        rootSingle.getChildren().addAll(boardBGImg, boardSingleMode, controls, pieces, generatingPieces, placedPieces);
    }

    /* Init method for AI to AI mode */
    private void aiToAiMode(Stage stage) {
        stage.setScene(sceneAI);

        sceneAI.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm());
        sceneAIComponent.getStylesheets().add(this.getClass().getResource(
                "GameBoardBG.css").toExternalForm());

        sceneAI.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(sceneMain);
            }
        });

        sceneAIComponent.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(sceneMain);
            }
        });
        makeControls(rootAI, false, stage);
        rootAI.getChildren().clear();
        rootAI.getChildren().addAll(aiGroupImg, boardAI, controlsAIMode, pieces);

        rootAIComponent.getChildren().clear();
        rootAIComponent.getChildren().addAll(aiComponentImg, boardAIComponent, controlsAiComponent, aiPieces);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railroad Ink V1.0");
        primaryStage.getIcons().add(new Image(getClass().getResource(URI_BASE + "icon.png").toString()));
        drawBoard(boardSingleMode);
        drawExits(boardSingleMode);

        drawBoard(boardPlayer);
        drawExits(boardPlayer);

        drawBoard(boardAI);
        drawExits(boardAI);

        drawBoard(boardAIComponent);
        drawExits(boardAIComponent);

        mainSceneSetting(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
