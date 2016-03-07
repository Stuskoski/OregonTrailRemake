package views.StartingTown;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.Main;
import models.AddKeyListenerToScene;

import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;

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
        gridPane.setId("saloonGridBackground");

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        URL url = StartTownSaloonView.class.getClassLoader().getResource("resources/saloonPianoMusic.mp3");
        assert url != null;
        final Media media = new Media(url.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(25);
        mediaPlayer.setCycleCount(99);
        mediaPlayer.play();


        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        ArrayList<Tooltip> tooltipArrayList = new ArrayList<>();

        AddKeyListenerToScene.addGeneralKeyListener(scene);
        /**
         * Need to add a bunch of collision detection
         * rectangles for clicking on people and getting
         * a toolip to popup.
         */
        scene.setOnMouseClicked(event -> {
            double x = event.getScreenX();
            double y = event.getScreenY();
            for (Tooltip eraseTooltip : tooltipArrayList){
                eraseTooltip.hide();
            }


            if(x>=1312.0 && x<=1371.0 && y>=536.0 && y<=617.0){
                Tooltip bartender = new Tooltip("What can I get ya?");
                bartender.show(gridPane, x, y);
                tooltipArrayList.add(bartender);
            }
            //1235.0
            //550.0
            //1298.0
            //552.0
            //1305.0
            //655.0
            //1237.0
            //649.0
            if(x>=1235.0 && x<= 1298.0 && y>=550.0 && y<=649.0){
                Tooltip oldManAtTheBar = new Tooltip("Whiskey, Mmm Mmm Mmm down to my belly, yum yum yum...*hiccup*");
                oldManAtTheBar.show(gridPane, x, y);
                tooltipArrayList.add(oldManAtTheBar);
            }


            //Tooltip tooltip = new Tooltip("testing node");
            //tooltip.show(gridPane, event.getScreenX()+5, event.getScreenY()-15);
            //tooltipArrayList.add(tooltip);
            System.out.println(event.getScreenX());
            System.out.println(event.getScreenY());
            //Timer timer = new Timer(); add timer to remove node in 10 seconds
        });

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
            mediaPlayer.stop();
            for (Tooltip eraseTooltip : tooltipArrayList){
                eraseTooltip.hide();
                eraseTooltip = null;
            }
        });

        setStartSaloon(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartSaloon(Scene scene){StartTownSaloonView.startSaloon = scene;}
    public static Scene getStartSaloon(){return StartTownSaloonView.startSaloon;}
}
