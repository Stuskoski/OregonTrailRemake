package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class PainKillers implements MedsInterface {
    private int quantity;
    private double weight = 0.75;

    public PainKillers(int quantity){
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
        return "Sure to take the edge off anything that hurts.";
    }

    @Override
    public double getPrice() {
        return 25.00;
    }

    @Override
    public String getName() {
        return "Pain Killers";
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
        return new PainKillers(1);
    }

    @Override
    public String diseaseHealed() {
        return "Broken Bone";
    }
}
