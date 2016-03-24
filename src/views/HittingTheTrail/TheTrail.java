package views.HittingTheTrail;

import Start.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        Button switchBack = new Button("Switch");
        Button switchBack2 = new Button("Switch2");

        gridPane.add(switchBack, 1, 1);
        gridPane.add(switchBack2, 2, 2);

        switchBack.setOnAction(event -> {
            gridPane.setId("TheTrailGridPaneMoving");
        });
        switchBack2.setOnAction(event -> {
            gridPane.setId("mainScreen");
        });


        scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());
        scene.getStylesheets().addAll("resources/main.css");

        Main.getPrimaryStage().setScene(scene);
    }

}
