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
 ---Depending how far the bird is, make it smaller or bigger
 */
public class RandomCreateGameObjects {
    public static ArrayList<WildGameObject> wildGame = new ArrayList<>();

    public static void createGameObjects(GraphicsContext gc2, int secondsToHunt){
        Random random = new Random();

        //Get the number of animals to create
        int numOfAnimals = 40;

        for(int i = 0; i<numOfAnimals; i++){
            int animalSpeed = random.nextInt(8-2) + 2;
            int yToStart = random.nextInt(((int)HuntingGame.getScene().getHeight()-300)) + 100; // (high - low) + low for numbers between x and y
            int wild1Start1 = random.nextInt(secondsToHunt);

            switch (random.nextInt(4)){
                case 0:{
                    WildGameObject wild1 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying1.gif-c200"));
                    wildGame.add(wild1);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    wild1.setY(yToStart);
                                    gc2.clearRect(wild1.getX(), wild1.getY(), 45, 45);
                                    wild1.setX(wild1.getX()+1);
                                    gc2.setFill(Color.web("#ff1aff"));
                                    gc2.drawImage(wild1.getImage(), wild1.getX(), wild1.getY(), 40, 40);
                                }));
                                timeline2.setCycleCount(Animation.INDEFINITE);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            wild1.setImage(new Image("resources/HuntingMiniGame/birdFlying1Backwards.gif")); ///Make sure you put these here so it animates!
                            wild1.setX(HuntingGame.getScene().getWidth());
                            wild1.setY(yToStart);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild1.getX(), wild1.getY(), 45, 45);
                                    wild1.setX(wild1.getX()-1);
                                    gc2.drawImage(wild1.getImage(), wild1.getX(), wild1.getY(), 40, 40);
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
                    WildGameObject wild2 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying2.gif"));
                    wildGame.add(wild2);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] forward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    wild2.setY(yToStart);
                                    gc2.clearRect(wild2.getX(), wild2.getY(), 45, 45);
                                    wild2.setX(wild2.getX()+1);
                                    gc2.setFill(Color.web("#ffff00"));
                                    gc2.drawImage(wild2.getImage(), wild2.getX(), wild2.getY(), 40, 40);
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
                    WildGameObject wild3 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying1.gif-c200"));
                    wildGame.add(wild3);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] forward = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    wild3.setY(yToStart);
                                    gc2.clearRect(wild3.getX(), wild3.getY(), 45, 45);
                                    wild3.setX(wild3.getX()+1);
                                    gc2.drawImage(wild3.getImage(), wild3.getX(), wild3.getY(), 40, 40);
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
                                    wild4.setY(yToStart);
                                    gc2.clearRect(wild4.getX(), wild4.getY(), 45, 45);
                                    wild4.setX(wild4.getX()+1);
                                    gc2.drawImage(wild4.getImage(), wild4.getX(), wild4.getY(), 40, 40);
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
