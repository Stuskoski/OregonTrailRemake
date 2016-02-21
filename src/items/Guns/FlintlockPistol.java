package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 * Cheap weapon that has a slow rate of fire and a slow bullet.
 */
public class FlintlockPistol implements GunInterface {
    private int quantity;

    public FlintlockPistol(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 3.00;
    }

    @Override
    public String getDescription() {
        return "Standard flintlock pistol. Cheap but fires slow.";
    }

    @Override
    public double getPrice() {
        return 5.00;
    }

    @Override
    public String getName() {
        return "Flintlock Pistol";
    }

    @Override
    public int getBulletsShot(){
        return 1;
    }

    @Override
    public int bulletSpeed() {
        return 2;
    }

    //returns ints as seconds
    @Override
    public int reloadTime() {
        return 8;
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
