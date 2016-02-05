package Characters;

/**
 * Created by augustus on 1/28/16.
 * Banker class.  Very rich but just not
 * the best for traveling across the plains.
 * But hey, money can fix quite a bit.
 */
public class Banker implements Characteristics{
    @Override
    public int getHealth() {
        return 80;
    }

    @Override
    public double getThirst() {return 0.75;}

    @Override
    public double getHunger() {
        return 0.75;
    }

    @Override
    public int getStrength() {
        return 10;
    }

    @Override
    public int getLuck() {
        return 15;
    }

    @Override
    public int getSmarts() {
        return 20;
    }

    @Override
    public int getAgility() {
        return 10;
    }

    @Override
    public int getPerception() {
        return 15;
    }

    @Override
    public int getEndurance() {
        return 15;
    }

    @Override
    public double getStartingMoney() {return 1000.00;}

    @Override
    public String getName() {
        return "Banker";
    }

    @Override
    public String getDescription() {
        return "Banker class.  Very rich but just not\n" +
                " the best for traveling across the plains.\n" +
                "  But hey, money can fix quite a bit.";
    }
}
