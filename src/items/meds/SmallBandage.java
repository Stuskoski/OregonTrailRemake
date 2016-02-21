package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class SmallBandage implements ItemInterface {
    private int quantity;

    public SmallBandage(int quantity){
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
        return "Small Bandage";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
