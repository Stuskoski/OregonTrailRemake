package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class TurkeyJerky implements ItemInterface {
    private int quantity;
    private double weight = 1.0;

    public TurkeyJerky(int quantity){
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
        return "Delicious Turkey Jerky.";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "Turkey Jerky";
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
        return new TurkeyJerky(1);
    }
}
