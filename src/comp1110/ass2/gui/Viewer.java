package comp1110.ass2.gui;

import comp1110.ass2.RailroadInk;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

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
    private static final int Tile_Size = 80;
    private static final int X_Side = 232;   //(VIEWER_WIDTH - Tile_Size * 7)/2
    private static final int Y__Side = 104;   //(VIEWER_HEIGHT - Tile_Size * 7)/2

    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group Pieces = new Group();
    private TextField textField;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        Pieces.getChildren().clear();
        if (RailroadInk.isBoardStringWellFormed(placement)){
            for (int i = 0; i+5 <= placement.length(); i += 5) {
                String tile = placement.substring(0, i+5);
                makeOnePlacement(placement);
            }
        }



    }
    void makeOnePlacement(String placement) {
        for (int j, i = placement.length() - 5; i >= 0; i -= 5) {
            ImageView tileImage = new ImageView(new Image(
                    Viewer.class.getResource(URI_BASE + placement.substring(i, i + 2) + ".png").toString()));
            tileImage.setFitWidth(Tile_Size);
            tileImage.setFitHeight(Tile_Size);
            tileImage.setLayoutY((VIEWER_HEIGHT - 7 * Tile_Size)/2 + (placement.charAt(i + 2) - 'A') * Tile_Size);
            tileImage.setLayoutX((VIEWER_WIDTH - 7 * Tile_Size)/2 + (placement.charAt(i + 3) - '0') * Tile_Size);
            j = placement.charAt(i + 4) - '0';
            if (j > 3) tileImage.setScaleX(-1);
            tileImage.setRotate(j < 4 ? j * 90 : (j - 4) * 90);
            Pieces.getChildren().add(tileImage);
        }
    }

    void drawExits() {

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
                        railExit.setLayoutY(Y__Side - Tile_Size/2);
                        railExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(railExit);
                    }else if (col == 1){
                        highExit.setLayoutY(Y__Side - Tile_Size/2);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }else { // col == 5
                        highExit.setLayoutY(Y__Side - Tile_Size/2);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }
                }
                if (row == 7) {
                    highExit.setRotate(180);
                    railExit.setRotate(180);
                    if (col == 3) {
                        railExit.setLayoutY(Y__Side - Tile_Size/2 + 7 * Tile_Size);
                        railExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(railExit);
                    }else if (col == 1){
                        highExit.setLayoutY(Y__Side - Tile_Size/2 + 7 * Tile_Size);
                        highExit.setLayoutX(X_Side + col * Tile_Size);
                        root.getChildren().add(highExit);
                    }else { // col == 5
                        highExit.setLayoutY(Y__Side - Tile_Size/2 + 7 * Tile_Size);
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
                        highExit.setLayoutY(Y__Side + row * Tile_Size);
                        highExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(highExit);
                    }else if (row == 1){
                        railExit.setLayoutY(Y__Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(railExit);
                    }else {
                        railExit.setLayoutY(Y__Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2);
                        root.getChildren().add(railExit);
                    }
                }
                if (col == 7) {
                    highExit.setRotate(90);
                    railExit.setRotate(90);
                    if (row == 3) {
                        highExit.setLayoutY(Y__Side + row * Tile_Size);
                        highExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(highExit);
                    }else if (row == 1){
                        railExit.setLayoutY(Y__Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(railExit);
                    }else {
                        railExit.setLayoutY(Y__Side + row * Tile_Size);
                        railExit.setLayoutX(X_Side- Tile_Size/2 + 7 * Tile_Size);
                        root.getChildren().add(railExit);
                    }
                }
            }
        }


    }
    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("StepsGame Viewer");
            Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

            root.getChildren().add(controls);
            root.getChildren().add(Pieces);

            makeControls();

            Line[] row = new Line[8];
            Line[] column = new Line[8];
            for (int i = 0; i < 8; i ++){
                row[i] = new Line();
                column[i] = new Line();
                row[i].setStartX(X_Side);
                row[i].setStartY(Y__Side + i * Tile_Size);
                row[i].setEndX(X_Side + 7 * Tile_Size);
                row[i].setEndY(Y__Side + i * Tile_Size);
                column[i].setStartX(X_Side + i * Tile_Size);
                column[i].setStartY(Y__Side);
                column[i].setEndX(X_Side + i * Tile_Size);
                column[i].setEndY(Y__Side + 7 * Tile_Size);
                root.getChildren().add(row[i]);
                root.getChildren().add(column[i]);
            }

            drawExits();

            primaryStage.setScene(scene);
            primaryStage.show();
            //makePlacement("B2A01B2A10B2G01B2A61B2G61");
            makePlacement("A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52");
        }
    }
