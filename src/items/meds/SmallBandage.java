package items.meds;

import items.ItemInterface;
import items.food.SmallCanofBeans;

/**
 * Created by augustus on 2/9/16.
 */
public class SmallBandage implements MedsInterface {
    private int quantity;
    private double weight = 0.25;

    public SmallBandage(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getDescription() {
        return "Small bandage used to cover some wounds.";
    }

    @Override
    public double getPrice() {
        return 10.00;
    }

    @Override
    public String getName() {
        return "Small Bandage";
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
        return "meds";
    }

    @Override
    public ItemInterface cloneObject() {
        return new SmallBandage(1);
    }

    @Override
    public String diseaseHealed() {
        return "Herpes";
    }
}
