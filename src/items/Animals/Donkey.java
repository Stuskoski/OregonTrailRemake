package items.Animals;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * Donkey and all his details.
 */
public class Donkey implements ItemInterface {
    private int quantity;
    private double weight;

    public Donkey(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 400.00;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getDescription() {
        return "El Burro! Donkeys are great for increasing carrying capacity.\n" +
                "Stats:\n" +
                "Weight Capacity: +45.00\n" +
                "Cost: $" + getPrice();
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

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getCategory() {
        return "animal";
    }

    @Override
    public ItemInterface cloneObject() {
        return new Donkey(1);
    }
}
