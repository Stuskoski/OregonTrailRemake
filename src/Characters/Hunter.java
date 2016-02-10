package Characters;

/**
 * Created by augustus on 1/28/16.
 * This is the hunter class.  Average
 * thirst/hunger.  Good strength, ok
 * luck, great agility/perception.  He
 * is able to get food from wild animals
 * whenever he/she pleases.
 */
public class Hunter implements Characteristics {
    @Override
    public int getHealth() {return 100;}

    @Override
    public double getThirst() {
        return 0.4;
    }

    @Override
    public double getHunger() {
        return 0.5;
    }

    @Override
    public int getStrength() {
        return 20;
    }

    @Override
    public int getLuck() {
        return 10;
    }

    @Override
    public int getSmarts() {
        return 10;
    }

    @Override
    public int getAgility() {
        return 25;
    }

    @Override
    public int getPerception() {
        return 25;
    }

    @Override
    public int getEndurance() {
        return 15;
    }

    @Override
    public double getStartingMoney() {return 300.00;}

    @Override
    public double getCarryingCapacity() {return 100.00;}

    @Override
    public String getCharClass() { return "Hunter"; }

    @Override
    public String getDescription() {
        return "This is the hunter class.  Average\n" +
                " thirst/hunger.  Good strength, ok\n" +
                " luck, great agility/perception.  He\n" +
                " is able to get food from wild animals\n" +
                " whenever he/she pleases.";
    }
}
