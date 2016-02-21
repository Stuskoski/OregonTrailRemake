package items.Animals;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * The powerful Oxen
 */
public class Ox implements ItemInterface {
    private int quantity;

    @Override
    public double getWeight() {return 1000.0;}

    @Override
    public String getDescription() {
        return "A large English Ox.  One of the best.  Essential for traveling the Oregon Trail.";
    }

    @Override
    public double getPrice() {
        return 20.00;
    }

    @Override
    public String getName() {
        return "English Ox";
    }

    public double getWeightCapacityIncrease(){
        return 50.00;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getCategory() {
        return "animal";
    }
}
