package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Hat implements ClothingInterface {
    private int quantity;

    public Hat(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {
        return 1.00;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Regular straw hat to provide some shade.";
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

    @Override
    public int getWarmth() {
        return 5;
    }
}
