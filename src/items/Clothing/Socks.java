package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Socks implements ItemInterface {
    private int quantity;

    public Socks(int quantity){
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
        return "Socks";
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
