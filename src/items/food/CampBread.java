package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * This is the model for delicious camp bread.
 * Implements interface to get the main qualities.
 */
public class CampBread implements ItemInterface {

    @Override
    public double getWeight() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Delicious Camp Bread.  Goes great with butter!";
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Camp Bread";
    }
}
