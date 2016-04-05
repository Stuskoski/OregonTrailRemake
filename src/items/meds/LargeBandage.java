package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class LargeBandage implements MedsInterface{
    private int quantity;

    public LargeBandage(int quantity){
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void setWeight(double weight) {

    }

    @Override
    public String getDescription() {
        return "Large bandage able to help stabilize a limb.";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "Large Bandage";
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
        return new LargeBandage(1);
    }

    @Override
    public String diseaseHealed() {
        return "Broken Bone";
    }
}
