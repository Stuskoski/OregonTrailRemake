package views.MiniGames.FinalRiverGame.Objects;

import Start.Main;
import javafx.scene.image.Image;

/**
 * Created by augustus on 4/6/16.
 */
public class RockObj {
    public int startTime;
    public double x;
    public int y;
    public int w;
    public int h;
    public Image img;
    public double xDec;
    public double yDec;

    public RockObj(Image img, double x, int y, int w, int h, int startTime, double xDec, double yDec){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.img = img;
        this.startTime = startTime;
        this.xDec = xDec;
        this.yDec = yDec;
    }
}
