package items.food;

import items.ItemInterface;

/**
 * Created by augustus on 3/11/16.
 * Special case for this guy.  Has
 * a different way for weight to work
 * than the other items.
 */
public class GameMeat implements ItemInterface {
    private int quantity;
    private double weight;

    public GameMeat(int quantity, double weight){
        this.quantity = quantity;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight){
        this.weight = weight;
    }

    @Override
    public String getDescription() {
        return "Game meat you hunted from the wild.";
    }

    @Override
    public double getPrice() {
        return 0.25;
    }

    @Override
    public String getName() {
        return "Game Meat";
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
        return "food";
    }

    @Override
    public ItemInterface cloneObject() {
        return new GameMeat(1, 1.0);
    }
}
