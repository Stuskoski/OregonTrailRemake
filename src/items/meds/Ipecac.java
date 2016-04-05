package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Ipecac implements MedsInterface {
    private int quantity;

    public Ipecac(int quantity){
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
        return "Sure to expunge anything inside you.";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "Ipecac";
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
        return new Ipecac(1);
    }

    @Override
    public String diseaseHealed() {
        return "Cursed";
    }
}
