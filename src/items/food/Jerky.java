package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class Jerky implements ItemInterface {
    @Override
    public double getWeight() {
        return 0.5;
    }

    @Override
    public String getDescription() {
        return "Tasty Jerky";
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Jerky";
    }
}
