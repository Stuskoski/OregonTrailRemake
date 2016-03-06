package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;
import models.AddKeyListenerToScene;

/**
 * Created by augustus on 2/19/16.
 * Saloon view.  Just an added on
 * room to view.  Might add some
 * secret items here for people
 * to discover.  Or give info
 * about secret items and where
 * to find them.  Who knows?
 */
public class StartTownSaloonView {
    private static Scene startSaloon;

    public static void createStartTownSaloonView(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        AddKeyListenerToScene.addKeyListener(scene);
        setStartSaloon(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartSaloon(Scene scene){StartTownSaloonView.startSaloon = scene;}
    public static Scene getStartSaloon(){return StartTownSaloonView.startSaloon;}
}
