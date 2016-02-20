package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class TurkeyJerky implements ItemInterface {
    private int quantity;

    public TurkeyJerky(int quantity){
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
