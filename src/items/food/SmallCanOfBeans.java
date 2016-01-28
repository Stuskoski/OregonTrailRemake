package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class SmallCanOfBeans implements ItemInterface {
    @Override
    public double getWeight() {
        return 0.75;
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
}
