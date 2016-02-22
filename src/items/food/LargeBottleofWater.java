package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class LargeBottleofWater implements ItemInterface {
    private int quantity;

    public LargeBottleofWater(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 1.25;
    }

    @Override
    public String getDescription() {
        return "A large bottle of water.  Now that's refreshing!";
    }

    @Override
    public double getPrice() {
        return 3.00;
    }

    @Override
    public String getName() {
        return "Large Bottle of Water";
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
        return new LargeBottleofWater(1);
    }
}
