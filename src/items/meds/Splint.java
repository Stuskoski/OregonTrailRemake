package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Splint implements MedsInterface {
    private int quantity;
    private double weight = 1.50;

    public Splint(int quantity){
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
        return "Excellent splint used to help mend bones.";
    }

    @Override
    public double getPrice() {
        return 20.00;
    }

    @Override
    public String getName() {
        return "Splint";
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
        return new Splint(1);
    }

    @Override
    public String diseaseHealed() {
        return "Broken Bone";
    }
}
