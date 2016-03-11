package items.Animals;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class Horse implements ItemInterface {
    private int quantity;
    private double weight;

    public Horse(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {return 800.00;}

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
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

    public double getWeightCapacityIncrease(){
        return 40.00;
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
        return new Horse(1);
    }
}
