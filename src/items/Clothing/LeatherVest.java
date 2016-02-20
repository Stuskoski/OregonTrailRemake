package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class LeatherVest implements ItemInterface {
    private int quantity;

    public LeatherVest(int quantity){
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
        return "Leather Vest";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
