package views.MiniGames.HuntingGamePackage.HuntingObjects;

/**
 * Created by augustus on 3/9/16.
 * This is a bullet Object you must
 * use in order to detect collisions.
 * Basically all the properties needed
 * to draw the bullet.  Then keep track
 * of it's x and y.  EZPZ
 */
public class BulletObject {
    double x;
    double y;
    int w;
    int h;

    public BulletObject(double x, double y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }


    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
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
}
