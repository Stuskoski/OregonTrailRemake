package views.HittingTheTrail;

import Start.Main;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 * Created by augustus on 3/7/16.
 */
public class TheTrail {
    //public static GridPane gridPane = new GridPane();
    public static Scene scene;

    public static void showTheTrailScene(){
        GridPane gridPane = new GridPane();
        gridPane.setId("TheTrailGridPaneMoving");

        scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        Main.getPrimaryStage().setScene(scene);
    }

}
