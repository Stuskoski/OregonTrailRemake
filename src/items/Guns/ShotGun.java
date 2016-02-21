package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 * Shotgun that will shoot 3 bullets in a spread.
 * One down the middle and one to the left/right.
 */
public class ShotGun implements GunInterface {
    private int quantity;

    public ShotGun(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 6.00;
    }

    @Override
    public String getDescription() {
        return "Standard shotgun, low rate of fire but multiple bullets.";
    }

    @Override
    public double getPrice() {
        return 20.00;
    }

    @Override
    public String getName() {
        return "Shotgun";
    }
    @Override
    public int getBulletsShot(){
        return 3;
    }

    @Override
    public int bulletSpeed() {
        return 3;
    }

    //returns ints as seconds
    @Override
    public int reloadTime() {
        return 5;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getCategory() {
        return "guns";
    }
}
