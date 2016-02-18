package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Main;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by augustus on 2/18/16.
 * Quick view that gives an introduction
 * in a star wars manner
 */
public class StartingGameInfoView {
    public static Scene startingGameInfoView;
    public static Canvas canvas = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static GraphicsContext gc = canvas.getGraphicsContext2D();
    public static int x = 0;
    private static Timer timer = new Timer();

    public static void createStartingGameInfoView(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setId("startingGameInfoViewBackground");

        gridPane.add(canvas, 0, 0);

        gc.setFill(Color.YELLOW);
        gc.setFont(new Font(20));
        gc.fillText("The Oregon Trail", (Main.getPrimaryStage().getWidth()/2)-80 ,15);
        gc.fillText("---Press any button to continue---", (Main.getPrimaryStage().getWidth()/2)-170 ,Main.getPrimaryStage().getHeight()-400);

        timer.schedule(new scrollTextTimer(), 0, 35);

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        scene.setOnKeyReleased(event -> {
            timer.cancel();
        });

  //      final Media media = new Media(new File("src/resources/starWars.mp3").toURI().toString());
 //       final MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();

       // String path = "resources/starWars.mp3";
       // String path = ("src/resources/starWars.mp3");
        //Media media = new Media(new File(path).toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(media);
        //mediaPlayer.play();
        //mediaPlayer.setAutoPlay(true);
        //MediaView mediaView = new MediaView(mediaPlayer);
        //gridPane.add(mediaView,5,5);


        Main.getPrimaryStage().setScene(scene);
    }

    public static void scrollText(){
        double height = Main.getPrimaryStage().getHeight();
        double width = Main.getPrimaryStage().getWidth();
        gc.setFill(Color.YELLOW);
        gc.setFont(new Font(20));
        x++;
        gc.clearRect(0, height-x-10, width, 500);
        gc.fillText("Welcome to Oregon Trail Remade!\n" +
                "The Oregon Trail is a 2,200-mile\n" +
                "historic east–west large-wheeled\n" +
                "wagon route and emigrant trail that\n" +
                "connected the Missouri River to valleys\n" +
                "in Oregon. \n" +
                "This game was created in the trails\n" +
                "memory.  The trail is a long and\n" +
                "treacherous one and for some reason\n" +
                "you decided the \"Grass is greener\n" +
                "on the other side.\" You also decided\n" +
                "to take your spouse and three children\n" +
                "with you(Man you're smart...). Make sure\n" +
                "to plan accordingly and make smart\n" +
                "decisions throughout the trail or\n" +
                "it might end up costing you or your\n" +
                "families life.\n" +
                "Anyways....I hope you enjoy the game\n" +
                "and good luck ;)\n" , (width/2)-160 ,height+10-x);

        //Execution finished code
        if(height+30-x <= -450){
            gc.fillText("---Press any button to continue---", (width/2)-170 ,height-400);
            timer.cancel();
        }
    }
    public static void setStartingGameInfoView(Scene scene){StartingGameInfoView.startingGameInfoView = scene;}
    public static Scene getStartingGameInfoView(){ return StartingGameInfoView.startingGameInfoView;}
}

class scrollTextTimer extends TimerTask{
    @Override
    public void run() {
        StartingGameInfoView.scrollText();
    }
}