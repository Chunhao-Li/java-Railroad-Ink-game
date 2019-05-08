package comp1110.ass2.gui;

import static comp1110.ass2.HelperMethod.*;
import static comp1110.ass2.RailroadInk.*;
import javafx.application.Application;
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
    private static final double VIEWER_WIDTH = 1024;
    private static final double VIEWER_HEIGHT = 768;
    private static final String URI_BASE = "assets/";
    private static final double Tile_Size = 80;
    private static final int X_Side = 232;   //(VIEWER_WIDTH - Tile_Size * 7)/2
    private static final int Y_Side = 104;   //(VIEWER_HEIGHT - Tile_Size * 7)/2

    private final Group mainGroup = new Group();
    private final Group boardSingleMode = new Group();
    private final Group boardAiModeA = new Group();
    private final Group boardAiModeP = new Group();
    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group controlsAiP = new Group();
    private final Group controlsAiA = new Group();
    private final Group pieces = new Group();
    private final Group placedPieces = new Group();
    private final Group generatingPieces = new Group();
    private final Group rootAIMode = new Group();
    private final Group aiBoardGroup = new Group();
    private Scene aiBoardScene = new Scene(aiBoardGroup, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene mainScene = new Scene(mainGroup, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene singleModeScene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
    private Scene aiModePlayerScene = new Scene(rootAIMode, VIEWER_WIDTH, VIEWER_HEIGHT);
    private TextField textField;
    private String boardString = "";
    private String aiBoardString = "";
    private int sTileTotal = 0;
    private int sTilePerTurn = 0;
    private List<DraggablePiece> sTilesNotPlaced = new ArrayList<>();
    private String dices = "";
    private String dicesAI = "";
    private int diceRollTimes = 0;
    private Text resultInfo = null;
    private Text turnInfo = null;
    private Text turnInfoAi = null;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    public void makePlacement(String placement, boolean isAIMode) {
        // FIXME Task 4: implement the simple placement viewer
        pieces.getChildren().clear();
        for (int i = placement.length() - 5; i >= 0; i -= 5) {
            try {
            ImageView tileImage = new ImageView(new Image(
                    Viewer.class.getResource(URI_BASE + placement.substring(i, i + 2) + ".png").toString()));
                tileImage.setFitWidth(Tile_Size);
                tileImage.setFitHeight(Tile_Size);
                tileImage.setLayoutY(Y_Side + (placement.charAt(i + 2) - 'A') * Tile_Size);
                tileImage.setLayoutX(X_Side + (placement.charAt(i + 3) - '0') * Tile_Size);
                int orientation = placement.charAt(i + 4) - '0';
                if (orientation > 3) tileImage.setScaleX(-1);
                tileImage.setRotate(orientation < 4 ? orientation * 90 : (orientation - 4) * 90);
                pieces.getChildren().add(tileImage);
            } catch (NullPointerException e) {
                return;
            }
        }
        if (isAIMode) {
            dicesAI = "";
        }
    }


    /**
     * This method is help to draw 12 exits
     * @param group a board Group which will add these exits
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


    /**
     * Generate 4 normal tiles with random dice roll and 6 special tiles
     */
    private void generateDicePieces(Group group) {
        if (!dices.isEmpty() && hasValidPlacement(false)) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "You must place regular tiles as many as you can!");
            alert.showAndWait();
            return;
        }
        diceRollTimes++;
        if (diceRollTimes > 1) {
            group.getChildren().remove(turnInfo);
        }
        turnInfo = group == rootAIMode ?
                new Text(X_Side+2*Tile_Size, 60,"Turn: " + diceRollTimes) :
                new Text(X_Side+Tile_Size, 60,"Turn: " + diceRollTimes);

        turnInfo.setFont(Font.font("Verdana", 20));
        group.getChildren().add(turnInfo);
        sTilePerTurn = 0;
        generatingPieces.getChildren().clear();
        dices = generateDiceRoll();
        if (group == rootAIMode) {
            aiBoardGroup.getChildren().remove(turnInfoAi);
            turnInfoAi = new Text(X_Side+Tile_Size, 60,"Turn: " + diceRollTimes);
            turnInfoAi.setFont(Font.font("Verdana", 20));
            aiBoardGroup.getChildren().add(turnInfoAi);
            dicesAI = dices;
        }
        String[] eachDice = new String[4];
        for (int i = 0; i+2 <= dices.length(); i+=2) {
            eachDice[i/2] = dices.substring(i, i+2);
        }
        for (int i = 0; i < eachDice.length; i++) {
            String dice = eachDice[i];
            Image tileImage = new Image(Viewer.class.getResource(
                    URI_BASE + dice + ".png").toString());
            DraggablePiece draggablePiece = new DraggablePiece(tileImage, dice);
            draggablePiece.setFitHeight(Tile_Size);
            draggablePiece.setFitWidth(Tile_Size);
            draggablePiece.homeX = X_Side/3f;
            draggablePiece.homeY = Y_Side + 20 + 2*i * Tile_Size;
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
     * Construct a draggable piece for playing
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
            Image tileImage = new Image(Viewer.class.getResource(
                    URI_BASE + name + ".png").toString());
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
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "You have used 3 special tiles in this game!");
                alert.showAndWait();
                    return false;}
                if (sTilePerTurn == 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "You can only use 1 special tile each turn!");
                    alert.showAndWait();
                    return false;
                }
            }
            if (isValidPlacementSequence(boardString+piecePlacement)
                && areNeighboursValid(boardString, piecePlacement)
           ) {
                boardString += piecePlacement;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * This method is to check whether exists valid moves
     * @param sIncluded including special tiles or not
     * @return boolean
     */
    private boolean hasValidPlacement(boolean sIncluded) {
        List<String> unUsedGrids = getUnusedGrids(boardString);
        Set<String> tiles = new HashSet<>();
        for (int i = 0; i+2 <= dices.length(); i+=2) {
            tiles.add(dices.substring(i, i+2));
        }

        if (sIncluded && sTileTotal < 3 && sTilePerTurn == 0) {
            for (DraggablePiece sTileDraggable : sTilesNotPlaced) {
                tiles.add(sTileDraggable.name);
            }
        }

        for (String tile: tiles) {
            List<Character> orientations = getOrientations(tile);
            for (String grid : unUsedGrids) {
                for (char o : orientations) {
                    String placement = tile + grid + String.valueOf(o);
                    if (isValidPlacementSequence(boardString+placement) &&
                        areNeighboursValid(boardString, placement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * This method is used to control DraggablePiece :
     *      - Scroll on the tile: rotates 90 degrees clockwise
     *      - Double click: flip the tile (if not flipped)
     *      - Triple click: flip back (if flipped)
     *      - Drag and release the tile on the board to place it
     */
    private void handlePiece(Group group) {
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

                // In the last turn, check whether exits valid moves
                if (diceRollTimes == 7 ) {
                    if (!hasValidPlacement(true)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                                "No more moves, press OK to get the score", ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            if (group == root) {
                                int score = getAdvancedScore(boardString);
                                resultInfo = new Text(VIEWER_WIDTH / 2, 60,
                                                         "Total Score: " + score);
                                resultInfo.setFont(Font.font("Verdana", 20));
                                group.getChildren().add(resultInfo);
                            } else {
                                aiBoardString += generateMove(aiBoardString, dicesAI);
                                makePlacement(aiBoardString, true);
                                calculateScoreAiMode(group);
                            }
                        }
                    } else if (!hasValidPlacement(false)
                            && hasValidPlacement(true)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                                "You can still place special tile, do you want to end the game?",
                                ButtonType.YES, ButtonType.NO);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.YES) {
                            if (group == root) {
                                int score = getAdvancedScore(boardString);
                                resultInfo = new Text(VIEWER_WIDTH / 2, (double) Y_Side / 2,
                                                            "Advanced Score: " + score);
                                resultInfo.setFont(Font.font("Verdana", 20));
                                group.getChildren().add(resultInfo);
                            } else {
                                aiBoardString += generateMove(aiBoardString, dicesAI);
                                makePlacement(aiBoardString, true);
                                calculateScoreAiMode(group);
                            }
                        }
                    }
                }
            });

        }
    }

    // Get the total result of Ai and player.
    private void calculateScoreAiMode(Group group) {
        int scorePlayer = getAdvancedScore(boardString);
        int scoreAI = getAdvancedScore(aiBoardString);
        int errorPlayer = -countErrorsScore(boardString);
        int errorAI = -countErrorsScore(aiBoardString);
        String winner = "Winner: ";
        if (scoreAI == scorePlayer) {
            if (errorPlayer < errorAI) {
                winner += "Player!";
            } else if (errorAI < errorPlayer) {
                winner += "AI!";
            } else {
                winner = "Tie!";
            }
        } else if (scoreAI < scorePlayer) {
            winner += "Player!";
        } else {
            winner += "AI!";
        }
        resultInfo = new Text(X_Side + 2*Tile_Size, Y_Side / 3f, winner);
        resultInfo.setFont(Font.font("Verdana", 30));
        Label scoreP, scoreA;
        if (!winner.equals("Tie")) {
            scoreP = new Label("Player's Score: " + scorePlayer);
            scoreA = new Label("AI's Score: " + scoreAI);
        } else {
            scoreP = new Label("Player's Score: " + scorePlayer + " Errors: " + errorPlayer);
            scoreA = new Label("AI's Score: " + scoreAI + " Errors: " + errorAI);
        }
        VBox scores = new VBox(scoreP, scoreA);
        scores.setSpacing(10);
        scores.setLayoutX(X_Side + 5*Tile_Size);
        scores.setLayoutY(Y_Side/3f);
        group.getChildren().addAll(scores, resultInfo);
    }


    /* This method can init all the static variables are needed */
    private void clearAll() {
        if (textField != null) {
            textField.clear();
        }
        generatingPieces.getChildren().clear();
        placedPieces.getChildren().clear();
        sTilesNotPlaced.clear();
        diceRollTimes = sTilePerTurn = sTileTotal = 0;
        dices = dicesAI = boardString = aiBoardString = "";
        pieces.getChildren().clear();

        rootAIMode.getChildren().clear();
        rootAIMode.getChildren().addAll(boardAiModeA, controlsAiP , generatingPieces, placedPieces);

        aiBoardGroup.getChildren().clear();
        aiBoardGroup.getChildren().addAll(boardAiModeP, controlsAiA, pieces);

        root.getChildren().clear();
        root.getChildren().addAll(boardSingleMode, controls, generatingPieces, placedPieces, pieces);
    }


    /**
     * This method controls the main scene where user can switch to different modes
     * modes:
     *      - single mode ("single game")
     *      - AI mode ("play with computer")
     *      - Debug mode ("debug mode")
     * @param primaryStage
     */
    private void coverSceneSetting(Stage primaryStage) {
        primaryStage.setScene(mainScene);
        mainScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
                primaryStage.close();
            }
        });
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setLayoutX(VIEWER_WIDTH / 2 - Tile_Size);
        vBox.setLayoutY(VIEWER_HEIGHT / 2 - Tile_Size);
        vBox.setSpacing(30);
        Text title = new Text(VIEWER_WIDTH/3, X_Side ,"Railroad Ink");
        title.setFont(Font.font("Verdana", 50));

        Button single = new Button("Single game");
        single.setOnAction(e -> {
            singleMode(primaryStage, true);
        });

        Button debug = new Button("Debug mode");
        debug.setOnAction(e -> {
            singleMode(primaryStage, false);
        });

        Button computerMode = new Button("Play with computer");
        computerMode.setOnAction(e -> {
            aiMode(primaryStage);
        });
        vBox.getChildren().addAll(single, computerMode, debug);
        mainGroup.getChildren().addAll(vBox, title);
    }



    private void drawBoard(Group group) {
        Rectangle rectangle = new Rectangle(3*Tile_Size, 3*Tile_Size, Color.LIGHTGRAY);
        rectangle.setX(X_Side+2*Tile_Size);
        rectangle.setY(Y_Side +2*Tile_Size);
        group.getChildren().add(rectangle);
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
            group.getChildren().add(row[i]);
            group.getChildren().add(column[i]);
        }
    }



    /**
     * Create different buttons of different scene
     * @param group the Group which will add the buttons created
     * @param isGameMode true if is in game mode (exclude debug)
     * @param stage primaryStage
     */
    private void makeControls(Group group, boolean isGameMode, Stage stage) {
        Button diceRoll = new Button("Roll a dice");
        Button clear = new Button("Clear");
        Button changeView = new Button("Change to AI");
        Button newGame = new Button("New Game");
        Button switchBack = new Button("Go back to player");

        diceRoll.setOnAction(e -> {
            if (diceRollTimes == 7) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "7 rounds reached");
                alert.showAndWait();
            } else {
                if (group == rootAIMode && !dicesAI.isEmpty()) {
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

        changeView.setOnAction(e -> {
            if (!dices.isEmpty() && hasValidPlacement(false)) {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "You must place regular tiles as many as you can!");
                alert.showAndWait();
            } else {
                stage.setScene(aiBoardScene);
                if (!dicesAI.isEmpty()) {
                    aiBoardString += generateMove(aiBoardString, dicesAI);
                    makePlacement(aiBoardString, true);
                }
            }
        });

        newGame.setOnAction(e -> {
            clearAll();
            aiMode(stage);
        });

        switchBack.setOnAction(e -> {
            stage.setScene(aiModePlayerScene);
        });

        HBox buttonBox = new HBox();
        buttonBox.setLayoutX(40);
        buttonBox.setLayoutY(40);
        buttonBox.setSpacing(10);

        // play with computer
        if (group == rootAIMode) {
            buttonBox.getChildren().addAll(diceRoll, changeView, newGame);
            controlsAiP.getChildren().add(buttonBox);
            switchBack.setLayoutX(40);
            switchBack.setLayoutY(40);
            controlsAiA.getChildren().add(switchBack);
        }

        // debug or single game mode
        if (group == root) {
            buttonBox.getChildren().addAll(diceRoll, clear);
            HBox hb = new HBox();
            Label label1 = new Label("Placement:");
            textField = new TextField();
            textField.setPrefWidth(300);
            Button button = new Button("Refresh");
            button.setOnAction(e -> {
                makePlacement(textField.getText(), false);
                textField.clear();
            });
            hb.getChildren().addAll(label1, textField, button);
            hb.setSpacing(10);
            hb.setLayoutX(130);
            hb.setLayoutY(VIEWER_HEIGHT - 50);
            if (isGameMode) {
                controls.getChildren().clear();
                controls.getChildren().add(buttonBox);
            } else {
                controls.getChildren().clear();
                controls.getChildren().add(hb);
            }
        }
    }

    /* Init method for the aiMode */
    private void aiMode(Stage stage) {
        stage.setScene(aiModePlayerScene);

        aiModePlayerScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(mainScene);
            }
        });

        aiBoardScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(mainScene);
            }
        });

        makeControls(rootAIMode, true, stage);
        rootAIMode.getChildren().clear();
        rootAIMode.getChildren().addAll(boardAiModeA, controlsAiP ,generatingPieces, placedPieces);


        aiBoardGroup.getChildren().clear();
        aiBoardGroup.getChildren().addAll(boardAiModeP, controlsAiA, pieces);
    }

    /* Init method for the single game mode or debug mode */
    private void singleMode(Stage stage, boolean isGameMode) {
        stage.setScene(singleModeScene);

        singleModeScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                clearAll();
                stage.setScene(mainScene);
            }
        });

        makeControls(root, isGameMode, stage);
        root.getChildren().clear();
        root.getChildren().addAll(boardSingleMode, controls, generatingPieces, placedPieces, pieces);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        drawBoard(boardSingleMode);
        drawExits(boardSingleMode);

        drawBoard(boardAiModeP);
        drawExits(boardAiModeP);

        drawBoard(boardAiModeA);
        drawExits(boardAiModeA);

        coverSceneSetting(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
