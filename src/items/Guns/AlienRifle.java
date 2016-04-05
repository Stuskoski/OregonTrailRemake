package items.Guns;

import items.ItemInterface;
import javafx.scene.image.*;

import java.awt.*;
import java.awt.Image;

/**
 * Created by augustus on 2/16/16.
 * Alien rifle that is very overpowered.
 * Bullets will home in to the target closest
 * to mouse click.
 */
public class AlienRifle implements GunInterface {
    private int quantity;

    public AlienRifle(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 2.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Rifle of unknown origin.  Did aliens drop" +
                "it on their last visit?";
    }

    @Override
    public double getPrice() {
        return 100.00;
    }

    @Override
    public String getName() {
        return "Alien Rifle";
    }

    @Override
    public int getBulletsShot(){
        return 1;
    }

    @Override
    public double getBulletSpeed() {
        return 0.5;
    }

    //returns ints as seconds
    @Override
    public int getReloadTime() {
        return 1;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public javafx.scene.image.Image getImage() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("resources/HuntingMiniGame/alienRifle2.png");
        return image;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getCategory() {
        return "guns";
    }

    @Override
    public ItemInterface cloneObject() {
        return new AlienRifle(1);
    }
}
