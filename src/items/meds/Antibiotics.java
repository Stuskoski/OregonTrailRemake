package items.meds;

import items.ItemInterface;

/**
 * Created by augustus on 2/9/16.
 */
public class Antibiotics implements MedsInterface {
    private int quantity;
    private double weight = 0.50;

    public Antibiotics(int quantity){
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
        return "General antibiotics used to cure a bacterial infection.";
    }

    @Override
    public double getPrice() {
        return 20.00;
    }

    @Override
    public String getName() {
        return "Antibiotics";
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
        return new Antibiotics(1);
    }

    @Override
    public String diseaseHealed() {
        return "Syphilis";
    }
}
