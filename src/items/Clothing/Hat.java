package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Hat implements ItemInterface {
    private int quantity;

    public Hat(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 0;
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
        return 1.00;
    }

    @Override
    public String getName() {
        return "Hat";
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
        return new Hat(1);
    }
}
