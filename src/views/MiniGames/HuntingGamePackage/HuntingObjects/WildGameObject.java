package views.MiniGames.HuntingGamePackage.HuntingObjects;

import javafx.scene.image.Image;

/**
 * Created by augustus on 3/9/16.
 */
public class WildGameObject {
    double x;
    double y;
    int w;
    int h;
    Image image;

    public WildGameObject(double x, double y, int w, int h, Image image){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Image getImage(){ return this.image;}

    public void setImage(Image image){ this.image = image;}
}
