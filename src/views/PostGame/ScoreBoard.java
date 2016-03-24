package views.PostGame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import models.Inventory;

/**
 * Created by augustus on 3/24/16.
 * This is the score board screen.
 * Keep track of how long it took
 * for the player to beat the game
 * This is factored into the score
 * as well as alive family members.
 * inventory, and all that jazz.
 *
 * Present the information in a new
 * stage once the game is completed
 * and also give them the option to
 * start a new game or exit the game.
 */
public class ScoreBoard {
    public static Timeline scoreTimeline;
    public static int counter = 0;

    public static void startTimeLine(){
        scoreTimeline = new Timeline(new KeyFrame(Duration.seconds(1), foodNDrinkEvent -> {
            counter++;
        }));
        scoreTimeline.setCycleCount(Animation.INDEFINITE);
        scoreTimeline.play();
    }
}
