package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class CoughMedicine implements MedsInterface {
    private int quantity;
    private double weight = 0.75;

    public CoughMedicine(int quantity){
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
        return "COUGH COUgh Cough coug cou co ....you get the point.";
    }

    @Override
    public double getPrice() {
        return 30.00;
    }

    @Override
    public String getName() {
        return "Cough Medicine";
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
        return new CoughMedicine(1);
    }

    @Override
    public String diseaseHealed() {
        return "Small Pox\nChicken Pox";
    }
}
