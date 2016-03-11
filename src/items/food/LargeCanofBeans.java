package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class LargeCanofBeans implements ItemInterface {
    private int quantity;

    public LargeCanofBeans(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 1;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "One large can of beans.  Careful where you sleep!";
    }

    @Override
    public double getPrice() {
        return (0.50);
    }

    @Override
    public String getName() {
        return "Large Can of Beans";
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
        return new LargeCanofBeans(1);
    }
}
