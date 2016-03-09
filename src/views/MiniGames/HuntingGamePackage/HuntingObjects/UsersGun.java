package views.MiniGames.HuntingGamePackage.HuntingObjects;

import CharacterObjects.Profile;
import items.Guns.*;
import items.ItemInterface;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;
import models.Inventory;
import views.MiniGames.HuntingGamePackage.HuntingGame;
import views.MiniGames.HuntingGamePackage.HuntingSummary;

import java.awt.*;

/**
 * Created by augustus on 3/8/16.
 * Creates the users gun and gets
 * all the properties to be used
 * in the hunting mini game
 *
 * Can have multiple canvas for layers
 * to only erase certain items.
 */
public class UsersGun {
    private static GraphicsContext localGc;
    public static void drawGun(GraphicsContext gc1, String gun, Scene huntingScene){
        localGc = gc1;
        ItemInterface userGun;
        switch (gun){
            case "Alien Rifle":{
                userGun = new AlienRifle(1);
                startMouseListenerForGun(gc1, huntingScene, (GunInterface) userGun);
                gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
                break;
            }
            case "Flintlock Pistol":{
                userGun = new FlintlockPistol(1);
                startMouseListenerForGun(gc1, huntingScene, (GunInterface) userGun);
                gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
                break;
            }
            case "Musket":{
                userGun = new Musket(1);
                startMouseListenerForGun(gc1, huntingScene, (GunInterface) userGun);
                gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
                break;
            }
            case "Rifle":{
                userGun = new Rifle(1);
                startMouseListenerForGun(gc1, huntingScene, (GunInterface) userGun);
                gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
                break;
            }
            case "Shotgun":{
                userGun = new ShotGun(1);
                startMouseListenerForGun(gc1, huntingScene, (GunInterface) userGun);
                gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
                //Image image = new Image("resources/HuntingMiniGame/shotgun.png");
                //gc.drawImage(image, MouseInfo.getPointerInfo().getLocation().getX(), HuntingGame.getScene().getHeight()-125);
                break;
            }
        }
    }

    private static void startMouseListenerForGun(GraphicsContext gc1, Scene huntingScene, GunInterface gun) {
        double bulletSpeed = gun.getBulletSpeed();
        int bulletsShot = gun.getBulletsShot();
        int reloadTime = gun.getReloadTime();
        final int[] bullets = {0};

        for(ItemInterface bulletCheck : Inventory.getInventory()){
            if(bulletCheck.getName().equals("Bullet")){
                bullets[0] = bulletCheck.getQuantity();
            }
        }

        huntingScene.setOnMouseMoved(event1 -> {
            gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
            Image image = new Image("resources/HuntingMiniGame/shotgun.png");
            gc1.drawImage(image, event1.getX()-45, HuntingGame.getScene().getHeight()-125);

                huntingScene.setOnMouseClicked(event2 -> {
                    if(bullets[0] > 0) {
                        bullets[0]--;
                        HuntingGame.getNumOfBullets().setText("Bullets: " + bullets[0]);
                        final int[] x = {0};
                        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(bulletSpeed), timelineEvent -> {
                            switch (gun.getName()) {
                                case "Alien Rifle": {
                                    gc1.clearRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 15);
                                    x[0]++;
                                    gc1.setFill(Color.web("#ff1aff"));
                                    gc1.fillRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 15);
                                    break;
                                }
                                case "Flintlock Pistol": {
                                    gc1.clearRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 4, 4);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 4, 4);
                                    break;
                                }
                                case "Musket": {
                                    gc1.clearRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 12, 12);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 12, 12);
                                    break;
                                }
                                case "Rifle": {
                                    gc1.clearRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 8);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 8);
                                    break;
                                }
                                case "Shotgun": {
                                    gc1.clearRect(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 3);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(event2.getX(), HuntingGame.getScene().getHeight() - 155 - x[0], 3, 3);
                                    break;
                                }
                            }


                        }));
                        timeline.setCycleCount(1000);
                        timeline.play();
                        System.out.println("Bang!");
                    }
                });
        });
    }

    private static void startMouseListenerForBullet(GraphicsContext gc1, Scene huntingScene, GunInterface gun){


        // add check for users bullet inventory, get the parameter
        //passed from the trail to the minigame

    }
}
