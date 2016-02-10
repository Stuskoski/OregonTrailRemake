package Characters;

/**
 * Created by augustus on 1/28/16.
 * The survivalist.  The grade A badass
 * that knows how to stay alive.  Not the
 * best luck though so hey, stay away
 * from that dysentery!
 */
public class Survivalist implements Characteristics {
    @Override
    public int getHealth() {return 120;}

    @Override
    public double getThirst() {
        return 0.2;
    }

    @Override
    public double getHunger() {
        return 0.2;
    }

    @Override
    public int getStrength() {
        return 20;
    }

    @Override
    public int getLuck() {
        return 5;
    }

    @Override
    public int getSmarts() {
        return 10;
    }

    @Override
    public int getAgility() {
        return 20;
    }

    @Override
    public int getPerception() {
        return 25;
    }

    @Override
    public int getEndurance() {return 25;}

    @Override
    public double getStartingMoney() {return 300.00;}

    @Override
    public double getCarryingCapacity() {return 150.00;}

    @Override
    public String getCharClass() {
        return "Survivalist";
    }

    @Override
    public String getDescription() {
        return "The survivalist.  The grade A badass\n" +
                " that knows how to stay alive.  Not the\n" +
                " best luck though so hey, stay away\n" +
                " from that dysentery!";
    }
}
