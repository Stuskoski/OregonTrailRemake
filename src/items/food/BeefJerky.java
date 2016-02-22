package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 1/28/16.
 * Mmm mm BeefJerky
 */
public class BeefJerky implements ItemInterface {
    private int quantity;

    public BeefJerky(int quantity){
        this.quantity = quantity;
    }
    @Override
    public double getWeight() {return 0.5;}

    @Override
    public String getDescription() {
        return "Tasty BeefJerky";
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
}
