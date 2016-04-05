package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Socks implements ClothingInterface {
    private int quantity;

    public Socks(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 0.50;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "A must have...duh!";
    }

    @Override
    public double getPrice() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Socks";
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
        return new Socks(1);
    }

    @Override
    public int getWarmth() {
        return 7;
    }
}
