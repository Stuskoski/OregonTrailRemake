package views.MiniGames.FinalRiverGame.Objects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 4/6/16.
 */
public class WagonObj {
    public static int x = (int) Main.getPrimaryStage().getScene().getWidth()/2 - 30;
    public static int y = (int)Main.getPrimaryStage().getScene().getHeight() - 75;
    public static int w = 45;
    public static int h = 65;
    public static Image img = new Image("resources/FinalRiverGame/wagonObj.png");
}
