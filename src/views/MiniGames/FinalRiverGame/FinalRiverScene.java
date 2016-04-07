package views.MiniGames.FinalRiverGame;

import Start.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.CalculateRandomChanceForHealth;
import views.HittingTheTrail.TrailControlPanel;
import views.HittingTheTrail.TrailObjects.Wagon;
import views.MiniGames.FinalRiverGame.Objects.WagonObj;
import views.PostGame.ScoreBoard;
import views.PostGame.YouLoseScreen;
import views.StaticScenes.TrailMap;

import java.sql.Time;

/**
 * Created by augustus on 4/6/16.
 * This is it....the final minigame
 * to win!
 */
public class FinalRiverScene {
    public static Timeline timeToWin;
    public static Timeline drawingAndCollisionDetection;
    public static void ShowFinalRiverGame(){

        //Stop Timers
        TrailControlPanel.consumeTimelineFast.stop();
        TrailControlPanel.consumeTimelineSlow.stop();
        TrailControlPanel.gameTimeline.stop();
        CalculateRandomChanceForHealth.statusRemoveTimeline.pause();
        TrailMap.timeline.stop();

        Canvas canvas1 = new Canvas(850, 600);
        Canvas canvas2 = new Canvas(850, 600);
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        GraphicsContext gc2 = canvas2.getGraphicsContext2D();

        Pane pane = new Pane(canvas1, canvas2);

        pane.setId("FinalRiverGameBack");

        Scene scene = new Scene(pane, 850, 600);

        scene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(scene);


        scene.setOnMouseClicked(event -> {
            System.out.println("X: " + event.getX() + "| Y: " + event.getY());
        });

        startTimerTillWin();
        generateRandomRocks(gc2);
        drawWagonAndAddListenersForIt(scene, gc1, pane);
    }

    private static void drawWagonAndAddListenersForIt(Scene scene, GraphicsContext gc1, Pane pane) {
        int speed = 3;
        int clearRectXtraSpace = 50;

        Line lineL = new Line(12.0, 599.0, 311.0, 3.0);
        Line lineR = new Line(838.0, 599.0, 527.0, 3.0);
        pane.getChildren().addAll(lineL, lineR);


        Timeline left = new Timeline(new KeyFrame(Duration.millis(speed), timelineEvent -> {
            WagonObj.x--;
        }));
        left.setCycleCount(Animation.INDEFINITE);


        Timeline right = new Timeline(new KeyFrame(Duration.millis(speed), timelineEvent -> {
            WagonObj.x++;
        }));
        right.setCycleCount(Animation.INDEFINITE);


        Timeline down = new Timeline(new KeyFrame(Duration.millis(speed), timelineEvent -> {
            WagonObj.y++;
        }));
        down.setCycleCount(Animation.INDEFINITE);


        Timeline up = new Timeline(new KeyFrame(Duration.millis(speed), timelineEvent -> {
            WagonObj.y--;
        }));
        up.setCycleCount(Animation.INDEFINITE);




        drawingAndCollisionDetection = new Timeline(new KeyFrame(Duration.millis(0.25), timelineEvent -> {
            gc1.clearRect(WagonObj.x-clearRectXtraSpace, WagonObj.y-clearRectXtraSpace, WagonObj.w+clearRectXtraSpace*2, WagonObj.h+clearRectXtraSpace*2);
            gc1.drawImage(WagonObj.img, WagonObj.x, WagonObj.y, WagonObj.w, WagonObj.h);

            //get your x cord with your given y.
            //int x = getXCordForLeft(WagonObj.y);

            if(WagonObj.y <= 0){
                up.stop();
                WagonObj.y = 1;
                System.out.println("edge top");
            }
            if((WagonObj.y+WagonObj.h) >= 599.0){
                down.stop();
                WagonObj.y = (int) (599.0 - WagonObj.h) - 1;
                System.out.println("edge bottom");
            }

            if(WagonObj.x <= getXCordForLeft() || WagonObj.x >= getXCordForRight()){
                left.stop();
                down.stop();
                right.stop();
                up.stop();

                YouLoseScreen.showYouLoseScene();
            }



        }));
        drawingAndCollisionDetection.setCycleCount(Animation.INDEFINITE);
        drawingAndCollisionDetection.play();

        //Timeline shrinking = new Timeline();
        //Timeline expanding = new Timeline();



        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case LEFT:{
                    right.stop();
                    down.stop();
                    up.stop();
                    left.play();
                    break;
                }
                case RIGHT:{
                    left.stop();
                    down.stop();
                    up.stop();
                    right.play();
                    break;
                }
                case DOWN:{
                    left.stop();
                    right.stop();
                    up.stop();
                    down.play();
                    break;
                }
                case UP:{
                    left.stop();
                    down.stop();
                    right.stop();
                    up.play();
                    break;
                }
            }
        });

        //scene.setOnKeyReleased(event -> {
        //    left.stop();
       //     down.stop();
       //     right.stop();
        //    up.stop();

        //});
    }

    private static int getXCordForRight() {
        double temp = (599 - WagonObj.y) / 1.99164;
        return (int) (790 -temp);
        //(599 - WagonObj.y) / 1.9933 = temp
        //x = 12 + temp
    }

    //get x cord for left line.  1.9933 is slope, 599 is starting x from bottom
    private static int getXCordForLeft() {
        double temp = (599.0 - WagonObj.y) / 1.9933;
        return (int) (12 + temp);
        //(599 - WagonObj.y) / 1.9933 = temp
        //x = 12 + temp
    }

    private static void generateRandomRocks(GraphicsContext gc2) {
    }

    //Survive 60 seconds to win
    private static void startTimerTillWin() {
        timeToWin = new Timeline(new KeyFrame(Duration.seconds(1), timelineEvent -> {

        }));
        timeToWin.setCycleCount(60);
        timeToWin.setOnFinished(event1 -> {
            ScoreBoard.showScoreBoard();
        });

        timeToWin.play();
    }
}
