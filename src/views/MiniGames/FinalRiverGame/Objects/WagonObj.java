package views.MiniGames.FinalRiverGame.Objects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 4/6/16.
 * Wagon object for the river
 */
public class WagonObj {
    public static int x = (int) Main.getPrimaryStage().getScene().getWidth()/2 - 30;
    public static int y = (int)Main.getPrimaryStage().getScene().getHeight() - 75;
    public static int w = 55;
    public static int h = 75;
    public static Image img = new Image("resources/FinalRiverGame/WagonObj.png");
}
