package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Ipecac implements MedsInterface {
    private int quantity;
    private double weight = 1.00;

    public Ipecac(int quantity){
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
        return "Sure to expunge anything inside you.";
    }

    @Override
    public double getPrice() {
        return 35.00;
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
