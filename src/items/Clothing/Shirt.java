package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Shirt implements ClothingInterface {
    private int quantity;

    public Shirt(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 1.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Better have a shirt to avoid a nasty sunburn.";
    }

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Shirt";
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
        return "clothing";
    }

    @Override
    public ItemInterface cloneObject() {
        return new Shirt(1);
    }

    @Override
    public int getWarmth() {
        return 5;
    }
}
