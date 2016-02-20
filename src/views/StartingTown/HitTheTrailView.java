package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;

/**
 * Created by augustus on 2/19/16.
 * Hit the trail and get started!
 */
public class HitTheTrailView {
    private static Scene startTrail;

    public static void createTrailView(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartStore(Scene scene){HitTheTrailView.startTrail = scene;}
    public static Scene getStartStore(){return HitTheTrailView.startTrail;}
}
