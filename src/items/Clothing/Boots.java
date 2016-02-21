package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/20/16.
 */
public class Boots implements ItemInterface {
    int quantity;

    public Boots(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
