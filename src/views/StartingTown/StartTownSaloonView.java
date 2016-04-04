package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Start.Main;
import models.AddKeyListenerToScene;
import java.net.URL;
import java.util.ArrayList;

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
        backBtn.setId("mainScreenBtn");
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
            double x = event.getX();
            double y = event.getY();
            for (Tooltip eraseTooltip : tooltipArrayList){
                eraseTooltip.hide();
            }


            if(x>=767.0 && x<=814.0 && y>=378.0 && y<=461.0){
                Tooltip bartender = new Tooltip("What can I get ya?");
                bartender.setId("startTownSaloonTooltip");
                bartender.show(gridPane, 776.0+scene.getWindow().getX(), 407.0+scene.getWindow().getY());
                tooltipArrayList.add(bartender);
            }
            if(x>=687.0 && x<= 759.0 && y>=387.0 && y<=507.0){
                Tooltip oldManAtTheBar = new Tooltip("Whiskey, Mmm Mmm Mmm down to my belly, yum yum yum...*hiccup*");
                oldManAtTheBar.setId("startTownSaloonTooltip");
                oldManAtTheBar.show(gridPane, 745.0+scene.getWindow().getX(), 432.0+scene.getWindow().getY());
                tooltipArrayList.add(oldManAtTheBar);
            }
            if(x>=43.0 && x<= 102.0 && y>=330.0 && y<=545.0){
                Tooltip banjoPlayerInBack = new Tooltip("Yoddle yoddleeeee yoddleeeeheeeehoooo...");
                banjoPlayerInBack.setId("startTownSaloonTooltip");
                banjoPlayerInBack.show(gridPane, 83.0+scene.getWindow().getX(), 356.0+scene.getWindow().getY());
                tooltipArrayList.add(banjoPlayerInBack);
            }
            if(x>=606.0 && x<= 662.0 && y>=383.0 && y<=688.0){
                Tooltip secretAlienTechHintDude = new Tooltip("I was out in the fields...staring\n" +
                        "at the sky when suddenly a huge blinding\n" +
                        "light shot up from the ground. Aliens man\n" +
                        "I hope they left something behind for me to\n" +
                        "find!");
                secretAlienTechHintDude.setId("startTownSaloonTooltip");
                secretAlienTechHintDude.show(gridPane, 645.0+scene.getWindow().getX(), 428.0+scene.getWindow().getY());
                tooltipArrayList.add(secretAlienTechHintDude);
            }
            if(x>=923.0 && x<= 1029.0 && y>=385.0 && y<=752.0){
                Tooltip guyHittingOnGirlOnRight = new Tooltip("Sup baby gurrllllll");
                guyHittingOnGirlOnRight.setId("startTownSaloonTooltip");
                guyHittingOnGirlOnRight.show(gridPane, 952.0+scene.getWindow().getX(), 427.0+scene.getWindow().getY());
                tooltipArrayList.add(guyHittingOnGirlOnRight);
            }

            /**
             * Set listeners for window drags.
             * If user drags the window then hide
             * all the tooltips or they will stay
             * where they are until user hides them
             * with the other commands. Aesthetics
             * only really.
             */
            scene.getWindow().xProperty().addListener((observable, oldValue, newValue) -> {
                for (Tooltip eraseTooltip : tooltipArrayList){
                    eraseTooltip.hide();
                }
            });
            scene.getWindow().yProperty().addListener((observable, oldValue, newValue) -> {
                for (Tooltip eraseTooltip : tooltipArrayList){
                    eraseTooltip.hide();
                }
            });

            //System.out.println(event.getX());
            //System.out.println(event.getY());
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
