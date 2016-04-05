package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/20/16.
 */
public class Boots implements ClothingInterface {
    int quantity;

    public Boots(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 3.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Essential rawhide boots to keep your feet warm and dry.";
    }

    @Override
    public double getPrice() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Boots";
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
        return new Boots(1);
    }


    @Override
    public int getWarmth() {
        return 10;
    }
}
