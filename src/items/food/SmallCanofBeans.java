package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 */
public class SmallCanofBeans implements ItemInterface {
    private int quantity;

    public SmallCanofBeans(int quantity){
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
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "Small Can of Beans";
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
        return new SmallCanofBeans(1);
    }


}
