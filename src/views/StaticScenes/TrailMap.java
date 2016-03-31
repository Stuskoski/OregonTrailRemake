package views.StaticScenes;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by augustus on 3/31/16.
 * This class will open the map whenever
 * the user clicks on the control panel
 * button.  Simply class that will show
 * how far away the user is from objects
 * or from the end of the game.
 */
public class TrailMap {
    public static GridPane gridPane = new GridPane();
    public static Scene scene = new Scene(gridPane, 400, 400);
    public static Stage stage = new Stage();
    public static Canvas canvas = new Canvas();
    public static GraphicsContext gc = canvas.getGraphicsContext2D();


    public static void showMap(){
        gridPane.setId("mapBackground");
        stage.setScene(scene);
    }
}
