package views.MiniGames.HuntingGamePackage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
        int numOfAnimals = 30;

        for(int i = 0; i<numOfAnimals; i++){
            int animalSpeed = random.nextInt(15-14) + 14;
            int yToStart = random.nextInt(((int)HuntingGame.getScene().getHeight()-300)) + 100; // (high - low) + low for numbers between x and y
            int wild1Start1 = random.nextInt(secondsToHunt);

            switch (random.nextInt(4)){
                case 0:{
                    WildGameObject wild1 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying1.gif-c200"));
                    wild1.setWeight( 5 + (40 - 5) * random.nextDouble()); //Formula = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                    wildGame.add(wild1);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            wild1.setY(yToStart);
                            wild1.setW(45);
                            wild1.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild1.getX(), wild1.getY(), wild1.getW()+5, wild1.getH()+5);
                                    wild1.setX(wild1.getX()+1);
                                    gc2.setFill(Color.web("#ff1aff"));
                                    gc2.drawImage(wild1.getImage(), wild1.getX(), wild1.getY(), wild1.getW(), wild1.getH());
                                    //when animation is done, remove object from array list
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild1);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
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
                            wild1.setW(45);
                            wild1.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild1.getX(), wild1.getY(), wild1.getW()+5, wild1.getH()+5);
                                    wild1.setX(wild1.getX()-1);
                                    gc2.drawImage(wild1.getImage(), wild1.getX(), wild1.getY(), wild1.getW(), wild1.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild1);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
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
                    WildGameObject wild2 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying1.gif-c200"));
                    wildGame.add(wild2);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            wild2.setY(yToStart);
                            wild2.setW(45);
                            wild2.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild2.getX(), wild2.getY(), wild2.getW()+5, wild2.getH()+5);
                                    wild2.setX(wild2.getX()+1);
                                    gc2.setFill(Color.web("#ffff00"));
                                    gc2.drawImage(wild2.getImage(), wild2.getX(), wild2.getY(), wild2.getW(), wild2.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild2);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            wild2.setImage(new Image("resources/HuntingMiniGame/birdFlying2Backwards.gif-c200"));
                            wild2.setX(HuntingGame.getScene().getWidth());
                            wild2.setY(yToStart);
                            wild2.setW(45);
                            wild2.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild2.getX(), wild2.getY(), wild2.getW()+5, wild2.getH()+5);
                                    wild2.setX(wild2.getX()-1);
                                    gc2.drawImage(wild2.getImage(), wild2.getX(), wild2.getY(), wild2.getW(), wild2.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild2);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
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
                    WildGameObject wild3 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying3.gif"));
                    wildGame.add(wild3);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            wild3.setY(yToStart);
                            wild3.setW(45);
                            wild3.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {

                                    gc2.clearRect(wild3.getX(), wild3.getY(), wild3.getW(), wild3.getH());
                                    wild3.setX(wild3.getX()+1);
                                    gc2.drawImage(wild3.getImage(), wild3.getX(), wild3.getY(), wild3.getW(), wild3.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild3);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            wild3.setImage(new Image("resources/HuntingMiniGame/birdFlying2Backwards.gif-c200"));
                            wild3.setX(HuntingGame.getScene().getWidth());
                            wild3.setY(yToStart);
                            wild3.setW(45);
                            wild3.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild3.getX(), wild3.getY(), wild3.getW(), wild3.getH());
                                    wild3.setX(wild3.getX()-1);
                                    gc2.drawImage(wild3.getImage(), wild3.getX(), wild3.getY(), wild3.getW(), wild3.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild3);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
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
                    WildGameObject wild4 = new WildGameObject(0,0,0,0,new Image("resources/HuntingMiniGame/birdFlying4.gif"));
                    wildGame.add(wild4);

                    //Quick check to decide if object going from left or going from right
                    switch (random.nextInt(2)){
                        case 0:{//left
                            wild4.setY(yToStart);
                            wild4.setW(45);
                            wild4.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild4.getX(), wild4.getY(), wild4.getW(), wild4.getH());
                                    wild4.setX(wild4.getX()+1);
                                    gc2.drawImage(wild4.getImage(), wild4.getX(), wild4.getY(), wild4.getW(), wild4.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild4);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
                                timeline2.play();
                            }));
                            timeline.setCycleCount(1);
                            timeline.play();
                            break;
                        }
                        case 1:{//right
                            wild4.setImage(new Image("resources/HuntingMiniGame/birdFlying2Backwards.gif-c200"));
                            wild4.setX(HuntingGame.getScene().getWidth());
                            wild4.setY(yToStart);
                            wild4.setW(45);
                            wild4.setH(45);
                            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(wild1Start1), event -> {
                                final int[] counter = {0};
                                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(animalSpeed), event2 -> {
                                    gc2.clearRect(wild4.getX(), wild4.getY(), wild4.getW(), wild4.getH());
                                    wild4.setX(wild4.getX()-1);
                                    gc2.drawImage(wild4.getImage(), wild4.getX(), wild4.getY(), wild4.getW(), wild4.getH());
                                    counter[0]++;
                                    if(counter[0] == 1500){
                                        wildGame.remove(wild4);
                                    }
                                }));
                                timeline2.setCycleCount(1500);
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
