package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Pants implements ClothingInterface {
    private int quantity;

    public Pants(int quantity){
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
        return "Don't forget to put on some pants before you leave!";
    }

    @Override
    public double getPrice() {
        return 2.00;
    }

    @Override
    public String getName() {
        return "Pants";
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
        return new Pants(1);
    }

    @Override
    public int getWarmth() {
        return 10;
    }
}
