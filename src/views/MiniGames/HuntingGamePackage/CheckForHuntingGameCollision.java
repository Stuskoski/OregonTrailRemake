package views.MiniGames.HuntingGamePackage;

import items.Guns.Bullets;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import views.MiniGames.HuntingGamePackage.HuntingObjects.BulletObject;
import views.MiniGames.HuntingGamePackage.HuntingObjects.WildGameObject;

import java.util.ArrayList;

/**
 * Created by augustus on 3/9/16.
 */
public class CheckForHuntingGameCollision {
    public static void checkForCollision(ArrayList<BulletObject> bulletList, ArrayList<WildGameObject> animalList, int secondsToHunt){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(0.1), timelineEvent -> {
            for (BulletObject bullet : bulletList){
                for (WildGameObject wildGame : animalList){
                    System.out.println(wildGame.getY()+wildGame.getH());
                    if((bullet.getY() == wildGame.getY()+wildGame.getH()) ){ //height check
                        if((bullet.getX() >= wildGame.getX())&&(bullet.getX()<=wildGame.getX()+wildGame.getW())){

                        }

                    }
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(secondsToHunt), timelineEvent -> {
            timeline.stop();
        }));
        timeline.setCycleCount(1);
        timeline.play();

    }
}
