package views.StaticScenes.StaticObjects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 3/31/16.
 * Just a simple x that will be
 * displayed on the map.  Hope to
 * find a gif of a blinking x that
 * way I don't have to animate it
 * myself.
 */
public class XForTheMap {
    public static double x = 488.0 - 23.0;
    public static double y = 268.0 - 23.0;
    public static int w = 45;
    public static int h = 45;
    public static Image img = new Image("resources/StaticSceneResources/xForMap.gif");

}
