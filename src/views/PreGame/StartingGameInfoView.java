package views.PreGame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import Start.Main;
import views.StartingTown.StartingTownView;
import java.net.URL;
import java.util.TimerTask;

/**
 * Created by augustus on 2/18/16.
 * Quick view that gives an introduction
 * in a star wars manner
 *
 * Added a timeline to replace timer.
 * Keeping timer code just for reference.
 */
public class StartingGameInfoView {
    public static Scene startingGameInfoView;
    public static Canvas canvas = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static GraphicsContext gc = canvas.getGraphicsContext2D();
    public static int x = 0;
    //private static Timer timer = new Timer();
    private static Timeline timeline;


    public static void createStartingGameInfoView(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setId("startingGameInfoViewBackground");

        gridPane.add(canvas, 0, 0);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFill(Color.YELLOW);
        gc.setFont(new Font(20));
       // gc.fillText("The Oregon Trail", (Start.getPrimaryStage().getWidth()/2) ,15);
        gc.fillText("---Press any button to continue---", (Main.getPrimaryStage().getWidth()/2) ,Main.getPrimaryStage().getHeight()-400);

        timeline = new Timeline(new KeyFrame(Duration.millis(35), event -> {
            scrollText();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        //timer.schedule(new scrollTextTimer(), 0, 35);

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        URL url = StartingGameInfoView.class.getClassLoader().getResource("resources/sw.mp3");
//        InputStreamReader inputStreamReader = new InputStreamReader(is);

        //final Media media = new Media(new File("src/resources/sw.mp3").toURI().toString());
        assert url != null;
        final Media media = new Media(url.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
           // mediaPlayer.setCycleCount(99);

           // scene.setOnKeyReleased(event -> {
           //     mediaPlayer.setMute(true);
           //     System.out.println("muted");
           // });
        //}catch (Exception e){
        //    System.out.println("Unable to play intro music for ya.");
        //}

        scene.setOnKeyPressed(event -> {
            mediaPlayer.setMute(true);
            timeline.stop();
            //timer.cancel();
            StartingTownView.createStartingTownView(); //move on to the next scene
            StartingGameInfoView.setStartingGameInfoView(null);
        });

        Main.getPrimaryStage().setScene(scene);
    }

    public static void scrollText(){
        double height = Main.getPrimaryStage().getHeight();
        double width = Main.getPrimaryStage().getWidth();
        gc.setFill(Color.YELLOW);
        gc.setFont(new Font(20));
        x++;
        gc.clearRect(0, height-x-10, width, 520);
        gc.setTextAlign(TextAlignment.CENTER);
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
                "and good luck ;)\n" , (width/2) ,height+10-x);

        //Execution finished code
        if(height+30-x <= -450){
            gc.fillText("---Press any button to continue---", (width/2) ,height-(height/2));
            //timer.cancel();
            timeline.stop();
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