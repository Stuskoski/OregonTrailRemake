package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 * Standard rifle similar to musket but with
 * a better firing rate.
 */
public class Rifle implements GunInterface {
    private int quantity;

    public Rifle(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 5.00;
    }

    @Override
    public String getDescription() {
        return "Balanced rifle with a good rate of fire.";
    }

    @Override
    public double getPrice() {
        return 15.00;
    }

    @Override
    public String getName() {
        return "Rifle";
    }

    @Override
    public int getBulletsShot(){
        return 1;
    }

    @Override
    public int bulletSpeed() {
        return 5;
    }

    //returns ints as seconds
    @Override
    public int reloadTime() {
        return 4;
    }

    @Override
    public int getQuantity() {
        return quantity;
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
        return new Rifle(1);
    }
}
