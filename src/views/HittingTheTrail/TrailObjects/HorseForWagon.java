package views.HittingTheTrail.TrailObjects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 3/25/16.
 */
public class HorseForWagon {
    public static int x = (int) Main.getPrimaryStage().getScene().getWidth()/2 + 100;
    public static int y = (int)Main.getPrimaryStage().getScene().getHeight() - 200;
    public static int w = 200;
    public static int h = 150;
    public static Image img = new Image("resources/OnTheTrail/horseGallop.gif");
}
