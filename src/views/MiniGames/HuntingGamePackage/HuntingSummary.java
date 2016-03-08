package views.MiniGames.HuntingGamePackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.Main;

import java.util.TimerTask;

/**
 * Created by augustus on 3/8/16.
 */
public class HuntingSummary{
    public static void showSummaryScreen(int animalsKilled, double poundsHunted){
        GridPane gridPane = new GridPane();
        VBox vBox = new VBox(10);

        gridPane.setAlignment(Pos.CENTER);

        Button continueBtn = new Button("Continue");
        continueBtn.setId("mainScreenBtn");

        Label animalsKilledLabel = new Label("Animals Killed: " + animalsKilled);
        Label poundsHuntedLabel = new Label("Pounds of Meat Hunted: " + poundsHunted);

        vBox.getChildren().addAll(animalsKilledLabel, poundsHuntedLabel, continueBtn);

        vBox.setAlignment(Pos.CENTER);

        gridPane.add(vBox, 0, 0);


        continueBtn.setOnAction(event -> {
            //go back to trail

        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(scene);

    }
}
