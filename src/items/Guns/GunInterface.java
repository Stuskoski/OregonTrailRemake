package items.Guns;

import items.ItemInterface;
import javafx.scene.image.Image;


/**
 * Created by augustus on 2/16/16.
 */
public interface GunInterface extends ItemInterface {
    int getBulletsShot();
    double getBulletSpeed();
    int getReloadTime();
    int getQuantity();
    Image getImage();
}
