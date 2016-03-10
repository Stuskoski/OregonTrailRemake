package views.MiniGames.HuntingGamePackage.HuntingObjects;

import items.Guns.*;
import items.ItemInterface;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import models.Inventory;
import views.MiniGames.HuntingGamePackage.HuntingGame;

import java.net.URL;
import java.util.ArrayList;

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
        int bulletsIndexInInventory = 0;

        for(ItemInterface bulletCheck : Inventory.getInventory()){
            if(bulletCheck.getName().equals("Bullet")){
                bullets[0] = bulletCheck.getQuantity();
            }
        }

        ArrayList<BulletObject> bulletObjects = new ArrayList<>(); //add the bullets into here when they are shot
        ArrayList<ItemInterface> Animals = new ArrayList<>(); //add the animals into here when they are across the screen

        huntingScene.setOnMouseMoved(event1 -> {
            gc1.clearRect(0, HuntingGame.getScene().getHeight()-150, HuntingGame.getScene().getWidth(), 175);
            Image image = new Image("resources/HuntingMiniGame/shotgun.png");
            gc1.drawImage(image, event1.getX()-45, HuntingGame.getScene().getHeight()-125);

                huntingScene.setOnMouseClicked(event2 -> {
                    if(bullets[0] > 0) {
                        bullets[0]--;
                        for(ItemInterface bulletCheck : Inventory.getInventory()){ //Make sure to get rid of the bullets in the inventory also
                            if(bulletCheck.getName().equals("Bullet")){
                                bulletCheck.setQuantity(bulletCheck.getQuantity()-1);
                            }
                        }
                        HuntingGame.getNumOfBullets().setText("Bullets: " + bullets[0]);

                        //Gun sounds switch
                        switch (gun.getName()) {
                            case "Alien Rifle": {
                                URL url = UsersGun.class.getClassLoader().getResource("resources/HuntingMiniGame/laserFiring.mp3");
                                assert url != null;
                                final Media media = new Media(url.toString());
                                final MediaPlayer mediaPlayer = new MediaPlayer(media);
                                mediaPlayer.setVolume(25);
                                mediaPlayer.setCycleCount(1);
                                mediaPlayer.play();
                                break;
                            }
                            case "Flintlock Pistol": {

                                break;
                            }
                            case "Musket": {

                                break;
                            }
                            case "Rifle": {

                                break;
                            }
                            case "Shotgun": {

                                break;
                            }
                        }


                        //Make the bullet object here so the loop doesn't create a lot of them.  Then go and set the values
                        BulletObject bulletObject = new BulletObject(event2.getX(), HuntingGame.getScene().getHeight() - 155, 1, 1);
                        BulletObject bulletObject2 = new BulletObject(event2.getX(), HuntingGame.getScene().getHeight() - 155, 1, 1);
                        BulletObject bulletObject3 = new BulletObject(event2.getX(), HuntingGame.getScene().getHeight() - 155, 1, 1);


                        //Add the bullets to a list to check for collisions later, two extra bullets for shotgun added but removed if uneeded
                        bulletObjects.add(bulletObject);
                        bulletObjects.add(bulletObject2);
                        bulletObjects.add(bulletObject3);

                        //remove the bullets if you are not using a shotgun
                        if(!gun.getName().equals("Shotgun")){
                            bulletObjects.remove(bulletObject2);
                            bulletObjects.remove(bulletObject3);
                        }

                        final double[] x = {0.00};
                        final int[] counter = {0};
                        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(bulletSpeed), timelineEvent -> {
                            switch (gun.getName()) {
                                case "Alien Rifle": {
                                    bulletObject.w = 4;
                                    bulletObject.h = 30;
                                    gc1.clearRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    x[0]++;
                                    gc1.setFill(Color.web("#ff1aff"));
                                    gc1.fillRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    break;
                                }
                                case "Flintlock Pistol": {
                                    bulletObject.w = 4;
                                    bulletObject.h = 4;
                                    gc1.clearRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    break;
                                }
                                case "Musket": {
                                    bulletObject.w = 12;
                                    bulletObject.h = 12;
                                    gc1.clearRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    break;
                                }
                                case "Rifle": {
                                    bulletObject.w = 3;
                                    bulletObject.h = 8;
                                    gc1.clearRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    break;
                                }
                                //Need three bullets here for the shotgun.  Should I make it consume 3 bullets or nah?
                                case "Shotgun": {
                                    bulletObject.w = 3;
                                    bulletObject.h = 3;
                                    bulletObject2.w = 3;
                                    bulletObject2.h = 3;
                                    bulletObject3.w = 3;
                                    bulletObject3.h = 3;
                                    gc1.clearRect(bulletObject.x-(x[0]/9), bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    gc1.clearRect(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    gc1.clearRect(bulletObject.x+(x[0]/9), bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    x[0]++;
                                    gc1.setFill(Color.BLACK);
                                    gc1.fillOval(bulletObject.x-(x[0]/9), bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    gc1.fillOval(bulletObject.x, bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    gc1.fillOval(bulletObject.x+(x[0]/9), bulletObject.y-x[0], bulletObject.w, bulletObject.h);
                                    break;
                                }
                            }

                            counter[0]++; // check if end of animation, if so remove the object
                            if(counter[0] == 700){
                                bulletObjects.remove(bulletObject);

                                if(gun.getName().equals("Shotgun")){
                                    bulletObjects.remove(bulletObject2);
                                    bulletObjects.remove(bulletObject3);
                                }
                            }

                        }));
                        timeline.setCycleCount(700);
                        timeline.play();
                    }
                });
        });
    }

    private static void startMouseListenerForBullet(GraphicsContext gc1, Scene huntingScene, GunInterface gun){


        // add check for users bullet inventory, get the parameter
        //passed from the trail to the minigame

    }
}
