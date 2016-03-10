package views.MiniGames.HuntingGamePackage;

import items.Guns.Bullets;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import views.MiniGames.HuntingGamePackage.HuntingObjects.BulletObject;
import views.MiniGames.HuntingGamePackage.HuntingObjects.WildGameObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by augustus on 3/9/16.
 */
public class RandomCreateGameObjects {
    public static ArrayList<WildGameObject> wildGame = new ArrayList<>();

    public static void createGameObjects(GraphicsContext gc2, int secondsToHunt){
        Random random = new Random();

        //Get the number of animals to create
        int numOfAnimals = random.nextInt(7) + 1;

        for(int i = 0; i<numOfAnimals; i++){
            int animalSpeed = random.nextInt((12-5)+5);
            int yToStart = random.nextInt(((int)HuntingGame.getScene().getHeight() - 250) + 150); // (high - low) + low for numbers between x and y
            int wild1Start1 = random.nextInt(secondsToHunt);

            switch (random.nextInt(4)){
                case 0:{
                    WildGameObject wild1 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/shotgun.png"));
                    wildGame.add(wild1);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    wild1.setY(yToStart);
                                    gc2.clearRect(wild1.getX(), wild1.getY(), 35, 35);
                                    wild1.setX(wild1.getX()+1);
                                    gc2.setFill(Color.web("#ff1aff"));
                                    gc2.fillRect(wild1.getX(), wild1.getY(), 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] backward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 35, 35);
                                    backward[0]++;
                                    gc2.setFill(Color.web("#ff1aff"));
                                    gc2.fillRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                    }
                    break;
                }
                case 1:{
                    WildGameObject wild2 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/shotgun.png"));
                    wildGame.add(wild2);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] forward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(forward[0], yToStart, 35, 35);
                                    forward[0]++;
                                    gc2.setFill(Color.web("#ffff00"));
                                    gc2.fillRect(forward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] backward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 35, 35);
                                    backward[0]++;
                                    gc2.setFill(Color.web("#ffff00"));
                                    gc2.fillRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    WildGameObject wild3 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/shotgun.png"));
                    wildGame.add(wild3);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] forward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(forward[0], yToStart, 35, 35);
                                    forward[0]++;
                                    gc2.setFill(Color.web("#00ccff"));
                                    gc2.fillRect(forward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] backward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 35, 35);
                                    backward[0]++;
                                    gc2.setFill(Color.web("#00ccff"));
                                    gc2.fillRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    WildGameObject wild4 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/shotgun.png"));
                    wildGame.add(wild4);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] forward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(forward[0], yToStart, 35, 35);
                                    forward[0]++;
                                    gc2.setFill(Color.web("#99ff33"));
                                    gc2.fillRect(forward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] backward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 35, 35);
                                    backward[0]++;
                                    gc2.setFill(Color.web("#99ff33"));
                                    gc2.fillRect(HuntingGame.getScene().getWidth()-backward[0], yToStart, 30, 30);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
