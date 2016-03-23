package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * This is the model for delicious camp bread.
 * Implements interface to get the Start qualities.
 */
public class CampBread implements ItemInterface {
    private int quantity;
    private double weight = 0.5;

    public CampBread(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
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
        return "food";
    }

    @Override
    public ItemInterface cloneObject() {
        return new CampBread(1);
    }
}
