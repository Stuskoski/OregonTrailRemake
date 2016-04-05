package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * Mmm mm BeefJerky
 */
public class BeefJerky implements ItemInterface {
    private int quantity;
    private double weight = 0.5;

    public BeefJerky(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {return weight;}

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getDescription() {
        return "Tasty Beef Jerky";
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Beef Jerky";
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
        return new BeefJerky(1);
    }
}
