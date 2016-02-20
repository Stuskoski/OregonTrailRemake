package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
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
    static final Media media = new Media(new File("src/resources/startingTown.mp3").toURI().toString());
    static final MediaPlayer mediaPlayer = new MediaPlayer(media);

    public static void createStartingTownView(){
        GridPane gridPane = new GridPane();
        gridPane.setId("startingTownPane");
        gridPane.setHgap(10); //need to add gaps so you can move with grid positions.
        gridPane.setVgap(10);
        //gridPane.setGridLinesVisible(true);

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth()+200, Main.getPrimaryStage().getScene().getHeight()+100);

        scene.getStylesheets().add("resources/main.css");

        mediaPlayer.setVolume(35);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(99999);

        Button storeBtn = new Button("Country Store");
        storeBtn.setId("startTownBtn");
        gridPane.add(storeBtn, 0, 35, 8, 3);

        Button hitTheTrailBtn = new Button("Hit The Trail");
        hitTheTrailBtn.setId("startTownBtn");
        gridPane.add(hitTheTrailBtn, 59, 35);

        Button saloonBtn = new Button("Saloon");
        saloonBtn.setId("startTownBtn");
        gridPane.add(saloonBtn, 35, 39);

        Button stableBtn = new Button("Stable");
        stableBtn.setId("startTownBtn");
        gridPane.add(stableBtn, 79, 38); //left/right ----  up/down

        /**
         * Add sounds for entering buttons the scene.
         */
        storeBtn.setOnMouseEntered(event -> {
            final Media doorMedia = new Media(new File("src/resources/doorOpen.mp3").toURI().toString());
            final MediaPlayer doorMP = new MediaPlayer(doorMedia);
            doorMP.setVolume(100);
            doorMP.play();
            mediaPlayer.play();//make sure to restart other mediaplayer after sound played

        });
        hitTheTrailBtn.setOnMouseEntered(event -> {
            final Media doorMedia = new Media(new File("src/resources/windBlowShort.mp3").toURI().toString());
            final MediaPlayer trailMP = new MediaPlayer(doorMedia);
            trailMP.setVolume(100);
            trailMP.play();
            mediaPlayer.play();
        });
        stableBtn.setOnMouseEntered(event -> {
            final Media doorMedia = new Media(new File("src/resources/horseSnort.mp3").toURI().toString());
            final MediaPlayer stableMP = new MediaPlayer(doorMedia);
            stableMP.setVolume(100);
            stableMP.play();
            mediaPlayer.play();
        });
        saloonBtn.setOnMouseEntered(event -> {
            final Media doorMedia = new Media(new File("src/resources/barSoundShort.mp3").toURI().toString());
            final MediaPlayer saloonMP = new MediaPlayer(doorMedia);
            saloonMP.setVolume(100);
            saloonMP.play();
            mediaPlayer.play();
        });


        //Action listeners for on click to go to next scene.
        storeBtn.setOnMouseClicked(event -> {
            mediaPlayer.stop();
            StartTownStoreView.createStartTownStoreView();
        });
        hitTheTrailBtn.setOnMouseClicked(event -> {
            //HitTheTrailView.createStartTownTrailView();
        });
        stableBtn.setOnMouseClicked(event -> {
            mediaPlayer.stop();
            StartTownStableView.createStartTownStableView();
        });
        saloonBtn.setOnMouseClicked(event -> {
            mediaPlayer.stop();
            StartTownSaloonView.createStartTownSaloonView();
        });

        setStartingTownView(scene);
        Main.getPrimaryStage().setScene(scene);
    }

    public static Scene getStartingTownView() {
        //restart the music too
         mediaPlayer.play();
        return startingTownView;
    }
    public static void setStartingTownView(Scene startingTownView) {StartingTownView.startingTownView = startingTownView;}
}
