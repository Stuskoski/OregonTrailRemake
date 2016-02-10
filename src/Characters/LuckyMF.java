package Characters;

/**
 * Created by augustus on 1/28/16.
 * This is one lucky MF.  Slighty
 * dumb but he is crazy lucky! Don't
 * know how to change a light bulb? NO
 * BIG DEAL, the light bulb will luckly
 * change itself and everything will be
 * fine and dandy!
 */
public class LuckyMF implements Characteristics {
    @Override
    public int getHealth() {
        return 110;
    }

    @Override
    public double getThirst() {
        return 0.6;
    }

    @Override
    public double getHunger() {
        return 0.6;
    }

    @Override
    public int getStrength() {return 15;}

    @Override
    public int getLuck() {
        return 25;
    }

    @Override
    public int getSmarts() {
        return 5;
    }

    @Override
    public int getAgility() {
        return 15;
    }

    @Override
    public int getPerception() {
        return 10;
    }

    @Override
    public int getEndurance() {
        return 20;
    }

    @Override
    public double getStartingMoney() {return 900.00;}

    @Override
    public double getCarryingCapacity() {return 75.00;}

    @Override
    public String getCharClass() {
        return "Lucky MF";
    }

    @Override
    public String getDescription() {
        return "This is one lucky MF.  Slighty\n" +
                " dumb but he is crazy lucky! Don't\n" +
                " know how to change a light bulb? NO\n" +
                " BIG DEAL, the light bulb will luckly\n" +
                " change itself and everything will be\n" +
                " fine and dandy!";
    }
}
