package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 */
public interface GunInterface extends ItemInterface {
    int getBulletsShot();
    int bulletSpeed();
    int reloadTime();
    int getQuantity();
}
