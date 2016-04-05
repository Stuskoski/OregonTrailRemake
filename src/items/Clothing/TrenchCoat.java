package items.Clothing;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class TrenchCoat implements ClothingInterface {
    private int quantity;

    public TrenchCoat(int quantity){
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
        return "Standard issue military Trench Coat.  Provides excellent warmth.";
    }

    @Override
    public double getPrice() {
        return 3.00;
    }

    @Override
    public String getName() {
        return "Trench Coat";
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
        return new TrenchCoat(1);
    }

    @Override
    public int getWarmth() {
        return 15;
    }
}
