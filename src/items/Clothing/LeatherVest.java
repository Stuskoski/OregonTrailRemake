package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class LeatherVest implements ClothingInterface {
    private int quantity;

    public LeatherVest(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 2.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Leather vest to help with the elements.";
    }

    @Override
    public double getPrice() {
        return 3.00;
    }

    @Override
    public String getName() {
        return "Leather Vest";
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
        return new LeatherVest(1);
    }

    @Override
    public int getWarmth() {
        return 10;
    }
}
