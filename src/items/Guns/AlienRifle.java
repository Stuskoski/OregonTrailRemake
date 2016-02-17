package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 * Alien rifle that is very overpowered.
 * Bullets will home in to the target closest
 * to mouse click.
 */
public class AlienRifle implements GunInterface {
    @Override
    public double getWeight() {
        return 2.00;
    }

    @Override
    public String getDescription() {
        return "Rifle of unknown origin.  Aliens seem to have dropped" +
                "it on their last visit.";
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
    public int bulletSpeed() {
        return 10;
    }

    //returns ints as seconds
    @Override
    public int reloadTime() {
        return 1;
    }
}
