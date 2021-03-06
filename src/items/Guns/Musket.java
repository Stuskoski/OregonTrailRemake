package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 2/16/16.
 * Slow firing rifle that is cheap.
 */
public class Musket implements GunInterface {
    private int quantity;

    public Musket(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 5.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    public javafx.scene.image.Image getImage() {
        javafx.scene.image.Image image = new javafx.scene.image.Image("resources/HuntingMiniGame/shotgun.png");
        return image;
    }

    @Override
    public String getDescription() {
        return "Is that a freaking musket? Yes that's a freaking musket.";
    }

    @Override
    public double getPrice() {
        return 12.00;
    }

    @Override
    public String getName() {
        return "Musket";
    }

    @Override
    public int getBulletsShot(){
        return 1;
    }

    @Override
    public double getBulletSpeed() {
        return 3;
    }

    //returns ints as seconds
    @Override
    public int getReloadTime() {
        return 7;
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
        return new Musket(1);    }
}
