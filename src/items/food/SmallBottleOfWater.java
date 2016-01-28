package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class SmallBottleOfWater implements ItemInterface {
    @Override
    public double getWeight() {
        return 0.75;
    }

    @Override
    public String getDescription() {
        return "A fresh bottle of water.  A little small though...";
    }

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Small Bottle of Water";
    }
}
