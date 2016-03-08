package views.MiniGames.HuntingGamePackage.HuntingObjects;

import items.Guns.*;
import items.ItemInterface;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import views.MiniGames.HuntingGamePackage.HuntingGame;

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
    public static void drawGun(GraphicsContext gc, String gun){
        localGc = gc;
        ItemInterface userGun;
        switch (gun){
            case "Alien Rifle":{
                userGun = new AlienRifle(1);
                gc.clearRect((HuntingGame.getScene().getWidth()/2) - 100, HuntingGame.getScene().getHeight()-150, 225, 175);
                break;
            }
            case "Flintlock Pistol":{
                userGun = new FlintlockPistol(1);
                gc.clearRect((HuntingGame.getScene().getWidth()/2) - 100, HuntingGame.getScene().getHeight()-150, 225, 175);
                break;
            }
            case "Musket":{
                userGun = new Musket(1);
                gc.fill();
                gc.clearRect((HuntingGame.getScene().getWidth()/2) - 100, HuntingGame.getScene().getHeight()-150, 225, 175);
                break;
            }
            case "Rifle":{
                userGun = new Rifle(1);
                gc.clearRect((HuntingGame.getScene().getWidth()/2) - 100, HuntingGame.getScene().getHeight()-150, 225, 175);
                break;
            }
            case "Shotgun":{
                userGun = new ShotGun(1);
                gc.clearRect((HuntingGame.getScene().getWidth()/2) - 100, HuntingGame.getScene().getHeight()-150, 225, 175);
                Image image = new Image("resources/HuntingMiniGame/shotgun.png");
                gc.drawImage(image, (HuntingGame.getScene().getWidth()/2) - 30, HuntingGame.getScene().getHeight()-125);
                break;
            }
        }

    }

    public static void startMouseListenerForGun(Scene createScene) {

        createScene.setOnMouseMoved(event -> {
            System.out.println(event.getX() + " " + event.getY());
            //Rotate r = new Rotate(45, event.getX(), event.getY());
            //localGc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        });

    }
}
