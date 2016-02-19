package views;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.Main;

import java.io.File;

/**
 * Created by augustus on 2/18/16.
 * This is the scene for the first
 * town the player will see once the
 * game gets started
 */
public class StartingTownView {
    private static Scene startingTownView;

    public static void createStartingTownView(){
        GridPane gridPane = new GridPane();
        gridPane.setId("startingTownPane");

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        final Media media = new Media(new File("src/resources/startingTown.mp3").toURI().toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(99);

        Main.getPrimaryStage().setScene(scene);
    }

    public static Scene getStartingTownView() {return startingTownView;}
    public static void setStartingTownView(Scene startingTownView) {StartingTownView.startingTownView = startingTownView;}
}
