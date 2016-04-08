package views.MiniGames.FinalRiverGame;

import Start.Main;
import com.sun.javafx.geom.Area;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.CalculateRandomChanceForHealth;
import views.HittingTheTrail.TrailControlPanel;
import views.MiniGames.FinalRiverGame.Objects.RockObj;
import views.MiniGames.FinalRiverGame.Objects.WagonObj;
import views.PostGame.ScoreBoard;
import views.PostGame.YouLoseScreen;
import views.StaticScenes.TrailMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by augustus on 4/6/16.
 * This is it....the final minigame
 * to win!
 */
public class FinalRiverScene {
    public static Timeline timeToWin;
    public static Timeline drawingAndCollisionDetection;
    public static ArrayList<RockObj> riverObjCollision = new ArrayList<>();
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
        int speed = 5;
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
            }
            if((WagonObj.y+WagonObj.h) >= 599.0){
                down.stop();
                WagonObj.y = (int) (599.0 - WagonObj.h) - 1;
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
        Random rand = new Random();
        int max = 35;
        int min = 20;
        ArrayList<RockObj> riverObjs = new ArrayList<>();

        //number of objects
        int randomNum = randomIntBtwTwoPoints(max, min);
        //create the number of objects
        for(int i=0; i<randomNum; i++){
            switch (rand.nextInt(4)){
                case 0:{
                    riverObjs.add(new RockObj(new Image("resources/FinalRiverGame/bolder1.png"), randomIntBtwTwoPoints(527,311), 0, randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(55, 0), returnNegOrPos(), randomDoubleBtwnTwoPoints(1.0, 2.5)));
                    break;
                }
                case 1:{
                    riverObjs.add(new RockObj(new Image("resources/FinalRiverGame/bolder2.png"), randomIntBtwTwoPoints(527,311), 0, randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(55, 0), returnNegOrPos(), randomDoubleBtwnTwoPoints(1.0, 2.5)));
                    break;
                }
                case 2:{
                    riverObjs.add(new RockObj(new Image("resources/FinalRiverGame/bolder3.png"), randomIntBtwTwoPoints(527,311), 0, randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(80,40), randomIntBtwTwoPoints(55, 0), returnNegOrPos(), randomDoubleBtwnTwoPoints(1.0, 2.5)));
                    break;
                }
                case 3:{
                    riverObjs.add(new RockObj(new Image("resources/FinalRiverGame/log1.png"), randomIntBtwTwoPoints(527,311), 0, randomIntBtwTwoPoints(40,30), randomIntBtwTwoPoints(20,10), randomIntBtwTwoPoints(55, 0), returnNegOrPos(), randomDoubleBtwnTwoPoints(1.0, 2.5)));
                    break;
                }
            }
        }

        final int[] counter = {0};
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(1), timelineEvent -> {
            for (RockObj obj : riverObjs) {
                System.out.println(counter[0]);
                if(obj.startTime == counter[0]){
                    riverObjCollision.add(obj); //if its time then add it to collision detection
                }
            }
            counter[0]++;
        }));
        time.setCycleCount(60);
        time.play();

        Timeline time2 = new Timeline(new KeyFrame(Duration.millis(randomIntBtwTwoPoints(15, 7)), timelineEvent -> {
            for (RockObj obj : riverObjCollision) {
                gc2.clearRect(obj.x-1, obj.y-1, obj.w+1, obj.h+1);
                obj.x += obj.xDec;
                obj.y += obj.yDec;
                gc2.drawImage(obj.img, obj.x, obj.y, obj.w, obj.h);
                checkForCollision();
            }
        }));
        time2.setCycleCount(Animation.INDEFINITE);
        time2.play();

        Timeline time3 = new Timeline(new KeyFrame(Duration.seconds(1), timelineEvent -> {
            for (RockObj obj : riverObjs) {
                if(obj.y >= 700){
                    riverObjCollision.remove(obj);
                }
            }
        }));
        time3.setCycleCount(Animation.INDEFINITE);
        time3.play();

    }

    //Better native collision detection...should of used this earlier -.-
    private static void checkForCollision() {
        for (RockObj obj:riverObjCollision) {
            Rectangle rect = new Rectangle(obj.x, obj.y, obj.w, obj.h);
            Rectangle rect2 = new Rectangle(WagonObj.x, WagonObj.y, WagonObj.w, WagonObj.h);
            if(rect.intersects(rect2.getBoundsInLocal())){
                YouLoseScreen.showYouLoseScene();
            }
        }
    }

    private static double returnNegOrPos(){
        Random random = new Random();

        switch (random.nextInt(11)){
            case 0:{
                return -0.1;
            }
            case 1:{
                return 0.1;
            }
            case 2:{
                return -0.2;
            }
            case 3:{
                return 0.2;
            }
            case 4:{
                return -0.3;
            }
            case 5:{
                return 0.3;
            }
            case 6:{
                return -0.4;
            }
            case 7:{
                return 0.4;
            }
            case 8:{
                return -0.5;
            }
            case 9:{
                return 0.5;
            }
            case 10:{
                return 0.0;
            }
        }
        return 0.5;
    }

    private static int randomIntBtwTwoPoints(int max, int min){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private static double randomDoubleBtwnTwoPoints(double max, double min){
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
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
