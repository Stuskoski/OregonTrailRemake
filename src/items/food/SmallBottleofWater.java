package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class SmallBottleofWater implements ItemInterface {
    private int quantity;

    public SmallBottleofWater(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 0.75;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "A fresh bottle of water.  A little small though...";
    }

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Small Bottle of Water";
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
        return new SmallBottleofWater(1);
    }
}
