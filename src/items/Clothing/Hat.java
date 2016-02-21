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
    public String getDescription() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
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
    public String getCategory() {
        return "clothing";
    }
}
