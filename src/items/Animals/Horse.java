package items.Animals;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class Horse implements ItemInterface {
    @Override
    public double getWeight() {
        return 800.00;
    }

    @Override
    public String getDescription() {
        return "A powerful steed.  Great for increasing how far you can travel in a day.";
    }

    @Override
    public double getPrice() {
        return 25.00;
    }

    @Override
    public String getName() {
        return "American Pure Bred";
    }
}
