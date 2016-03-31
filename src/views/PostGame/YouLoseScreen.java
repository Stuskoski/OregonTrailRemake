package views.PostGame;

import Start.Main;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.CalculateRandomChanceForHealth;
import models.NewGameClearExisiting;
import views.HittingTheTrail.TrailControlPanel;
import views.StaticScenes.TrailMap;

/**
 * Created by augustus on 3/28/16.
 */
public class YouLoseScreen {
    private static GridPane gridPane;
    private static Scene scene;

    public static void showYouLoseScene(){
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setId("youLoseGridPane");

        //stop timers
        TrailControlPanel.gameTimeline.stop();
        TrailControlPanel.consumeTimelineSlow.stop();
        TrailControlPanel.consumeTimelineFast.stop();
        ScoreBoard.scoreTimeline.stop();
        CalculateRandomChanceForHealth.statusRemoveTimeline.pause();
        TrailMap.timeline.stop();

        Label label = new Label("You Lose...");
        label.setId("youLoseLabel");

        HBox labelHbox = new HBox(label);
        labelHbox.setAlignment(Pos.CENTER);

        Button newGame = new Button("New Game");
        Button quit = new Button("Quit Game");

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(newGame, quit);

        newGame.setId("mainScreenBtn");
        quit.setId("mainScreenBtn");

        newGame.setOnAction(event -> NewGameClearExisiting.startNewGame());
        quit.setOnAction(event -> {
            System.exit(0);
            Platform.exit();
        });

        gridPane.add(labelHbox, 0, 0);
        gridPane.add(hBox, 0, 2);

        scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());
        scene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(scene);

    }
}
