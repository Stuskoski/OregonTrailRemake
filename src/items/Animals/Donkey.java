package items.Animals;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * Donkey and all his details.
 */
public class Donkey implements ItemInterface {
    private int quantity;

    @Override
    public double getWeight() {
        return 400.00;
    }

    @Override
    public String getDescription() {
        return "El Burro! Donkeys are great for increasing carrying capacity.";
    }

    @Override
    public double getPrice() {
        return 15.00;
    }

    @Override
    public String getName() {
        return "Donkey";
    }

    public double getWeightCapacityIncrease(){
        return 45.00;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
