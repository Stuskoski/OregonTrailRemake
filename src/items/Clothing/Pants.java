package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Pants implements ItemInterface {
    private int quantity;

    public Pants(int quantity){
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
        return "Pants";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
