package views.StaticScenes;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.CalculateDeathChancePerTurn;
import models.CalculateRandomChanceForHealth;
import views.HittingTheTrail.TrailControlPanel;
import views.PostGame.ScoreBoard;
import views.StaticScenes.StaticObjects.XForTheMap;

/**
 * Created by augustus on 3/31/16.
 * This class will open the map whenever
 * the user clicks on the control panel
 * button.  Simply class that will show
 * how far away the user is from objects
 * or from the end of the game.
 */
public class TrailMap {
    public static Canvas canvas = new Canvas(600,386);
    public static GraphicsContext gc = canvas.getGraphicsContext2D();
    public static GridPane gridPane = new GridPane();
    public static Scene scene = new Scene(gridPane, 600, 395);
    public static Stage stage = new Stage();
    public static Timeline timeline;


    public static void showMap(){
        gridPane.setId("mapBackground");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(canvas, 0, 0);

        timeline = new Timeline(new KeyFrame(Duration.millis(1000), timelineEvent -> {
            System.out.println("drawing");
            gc.clearRect(0,0,600,395);
            gc.drawImage(XForTheMap.img, 200, 200, XForTheMap.w, XForTheMap.h);

            switch (String.format("%.2f", (((double)TrailControlPanel.counterForMap/(double)TrailControlPanel.gameTimeline.getCycleCount())*100.00))){
                case "0.00":
                   // gc.drawImage(XForTheMap.img, (TrailControlPanel.counterForMap/TrailControlPanel.gameTimeline.getCycleCount())*100,
                   //         (TrailControlPanel.counterForMap/TrailControlPanel.gameTimeline.getCycleCount())*100, XForTheMap.w, XForTheMap.h);
                    break;
                case "0.01":
                    break;
                case "0.02":
                    break;
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        scene.getStylesheets().add("resources/main.css");

        stage.setResizable(false);
        stage.setScene(scene);
    }
}
