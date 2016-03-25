package views.HittingTheTrail.TrailObjects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 3/25/16.
 * The wagon for the player.
 */
public class Wagon {
    public static int x = (int)Main.getPrimaryStage().getScene().getWidth()/2 - 100;
    public static int y = (int)Main.getPrimaryStage().getScene().getHeight() - 225;
    public static int w = 250;
    public static int h = 200;
    public static Image img = new Image("resources/OnTheTrail/wagon.gif");
}
