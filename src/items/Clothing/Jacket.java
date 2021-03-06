package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Jacket implements ClothingInterface {
    private int quantity;

    public Jacket(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 1.50;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "A warm jacket sure you keep you from the harsh elements.";
    }

    @Override
    public double getPrice() {
        return 3.00;
    }

    @Override
    public String getName() {
        return "Jacket";
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
        return new Jacket(1);
    }

    @Override
    public int getWarmth() {
        return 15;
    }
}
