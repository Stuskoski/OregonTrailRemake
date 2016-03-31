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

import java.awt.*;

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
        gridPane.add(canvas, 0, 0);

        timeline = new Timeline(new KeyFrame(Duration.millis(1000), timelineEvent -> {
            System.out.println(String.format("%.2f", (((double)TrailControlPanel.counterForMap/(double)TrailControlPanel.gameTimeline.getCycleCount())*100.00)));
            switch (String.format("%.2f", (((double)TrailControlPanel.counterForMap/(double)TrailControlPanel.gameTimeline.getCycleCount())*100.00))){
                case "0.00":
                    XForTheMap.x = 488.0 - 23.0;
                    XForTheMap.y = 268.0 - 23.0;
                    break;
                case "4.00":
                    XForTheMap.x = 465.0 - 23.0;
                    XForTheMap.y = 265.0 - 23.0;
                    break;
                case "16.00":
                    XForTheMap.x = 454.0 - 23.0;
                    XForTheMap.y = 251.0 - 23.0;
                    break;
                case "20.00":
                    XForTheMap.x = 434.0 - 23.0;
                    XForTheMap.y = 241.0 - 23.0;
                    break;
                case "24.00":
                    XForTheMap.x = 415.0 - 23.0;
                    XForTheMap.y = 233.0 - 23.0;
                    break;
                case "28.00":
                    XForTheMap.x = 394.0 - 23.0;
                    XForTheMap.y = 229.0 - 23.0;
                    break;
                case "32.00":
                    XForTheMap.x = 373.0 - 23.0;
                    XForTheMap.y = 223.0 - 23.0;
                    break;
                case "36.00":
                    XForTheMap.x = 351.0 - 23.0;
                    XForTheMap.y = 215.0 - 23.0;
                    break;
                case "40.00":
                    XForTheMap.x = 338.0 - 23.0;
                    XForTheMap.y = 204.0 - 23.0;
                    break;
                case "44.00":
                    XForTheMap.x = 322.0 - 23.0;
                    XForTheMap.y = 199.0 - 23.0;
                    break;
                case "48.00":
                    XForTheMap.x = 303.0 - 23.0;
                    XForTheMap.y = 195.0 - 23.0;
                    break;
                case "52.00":
                    XForTheMap.x = 278.0 - 23.0;
                    XForTheMap.y = 199.0 - 23.0;
                    break;
                case "56.00":
                    XForTheMap.x = 256.0 - 23.0;
                    XForTheMap.y = 204.0 - 23.0;
                    break;
                case "60.00":
                    XForTheMap.x = 234.0 - 23.0;
                    XForTheMap.y = 209.0 - 23.0;
                    break;
                case "64.00":
                    XForTheMap.x = 219.0 - 23.0;
                    XForTheMap.y = 189.0 - 23.0;
                    break;
                case "68.00":
                    XForTheMap.x = 202.0 - 23.0;
                    XForTheMap.y = 172.0 - 23.0;
                    break;
                case "72.00":
                    XForTheMap.x = 176.0 - 23.0;
                    XForTheMap.y = 167.0 - 23.0;
                    break;
                case "80.00":
                    XForTheMap.x = 130.0 - 23.0;
                    XForTheMap.y = 144.0 - 23.0;
                    break;
                case "84.00":
                    XForTheMap.x = 126.0 - 23.0;
                    XForTheMap.y = 121.0 - 23.0;
                    break;
                case "88.00":
                    XForTheMap.x = 122.0 - 23.0;
                    XForTheMap.y = 99.0 - 23.0;
                    break;
                case "92.00":
                    XForTheMap.x = 108.0 - 23.0;
                    XForTheMap.y = 91.0 - 23.0;
                    break;
                case "96.00":
                    XForTheMap.x = 81.0 - 23.0;
                    XForTheMap.y = 90.0 - 23.0;
                    break;
                case "100.00":
                    XForTheMap.x = 62.0 - 23.0;
                    XForTheMap.y = 80.0 - 23.0;
                    break;
                default:
                    break;
            }
            gc.clearRect(0,0,600,395);
            gc.drawImage(XForTheMap.img, XForTheMap.x, XForTheMap.y, XForTheMap.w, XForTheMap.h);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        scene.getStylesheets().add("resources/main.css");

        stage.setResizable(false);
        stage.setScene(scene);
    }
}
