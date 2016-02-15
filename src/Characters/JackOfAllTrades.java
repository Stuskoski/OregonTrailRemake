package Characters;

/**
 * Created by augustus on 1/28/16.
 * The jack of all trades.  He is the master
 * of average, the average joe.  If there were
 * 100 people in the world he would be 50.  The
 * man in the middle. Got it?
 */
public class JackOfAllTrades implements Characteristics {
    @Override
    public int getHealth() {return 100;}

    @Override
    public double getThirstConsume() {
        return 0.5;
    }

    @Override
    public double getHungerConsume() {
        return 0.5;
    }

    @Override
    public int getStrength() {
        return 13;
    }

    @Override
    public int getLuck() {
        return 13;
    }

    @Override
    public int getSmarts() {
        return 13;
    }

    @Override
    public int getAgility() {
        return 13;
    }

    @Override
    public int getPerception() {
        return 13;
    }

    @Override
    public int getEndurance() {
        return 13;
    }

    @Override
    public double getStartingMoney() {return 500.00;}

    @Override
    public double getCarryingCapacity() {return 75.00;}

    @Override
    public String getCharClass() {return "Jack of All Trades";}

    @Override
    public String getDescription() {
        return "The jack of all trades.  He is the master\n" +
                " of average, the average joe.  If there were\n" +
                " 100 people in the world he would be 50.  The\n" +
                " man in the middle. Got it?";
    }
}
