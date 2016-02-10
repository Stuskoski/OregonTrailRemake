package Characters;

/**
 * Created by augustus on 1/28/16.
 * This is the genius class.  He starts off with
 * a good amount of money, not as much as banker,
 * but has the smarts to acquire more money! Can
 * also do more actions than others since he/she
 * is so smart.
 */
public class Genius implements Characteristics {
    @Override
    public int getHealth() {return 80;}

    @Override
    public double getThirst() {
        return 0.30;
    } //Thirsty but smart enough not to go through all the water

    @Override
    public double getHunger() {
        return 0.30;
    }

    @Override
    public int getStrength() {
        return 5;
    }

    @Override
    public int getLuck() {
        return 15;
    }

    @Override
    public int getSmarts() {
        return 25;
    }

    @Override
    public int getAgility() {
        return 10;
    }

    @Override
    public int getPerception() {
        return 20;
    }

    @Override
    public int getEndurance() {
        return 10;
    }

    @Override
    public double getStartingMoney() {
        return 750.00;
    }

    @Override
    public double getCarryingCapacity() {return 50.00;}

    @Override
    public String getCharClass() {
        return "Genius";
    }

    @Override
    public String getDescription() {
        return "This is the genius class.  He starts off with\n" +
                " a good amount of money, not as much as banker,\n" +
                " but has the smarts to acquire more money! Can\n" +
                " also do more actions than others since he/she\n" +
                " is so smart.";
    }
}
