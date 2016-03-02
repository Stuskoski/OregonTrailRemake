package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;

/**
 * Created by augustus on 2/19/16.
 * Stable view where the player
 * will buy their horses or oxes
 * to start the game.  They must visit
 * here and buy something to pull
 * their wagon.
 */
public class StartTownStableView {
    private static Scene startStable;

    public static void createStartTownStableView(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(3);
        gridPane.setVgap(3);
        gridPane.setId("startStableGrid");

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        StartTownSaloonView.setStartSaloon(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartStore(Scene scene){StartTownStableView.startStable = scene;}
    public static Scene getStartStore(){return StartTownStableView.startStable;}
}
