package items.Guns;

import items.ItemInterface;

/**
 * Created by augustus on 3/9/16.
 */
public class Bullets implements ItemInterface {
    private int quantity;

    public Bullets(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 0.1;
    }

    @Override
    public String getDescription() {
        return "Just a regular lead bullet.";
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Bullet";
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
        return new Bullets(1);
    }
}
