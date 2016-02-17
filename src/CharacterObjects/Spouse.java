package CharacterObjects;

/**
 * Created by augustus on 2/16/16.
 */
public class Spouse {
    private static boolean isAlive = true;
    private static double chanceOfDying;

    public Spouse(double chanceOfDying){
        Spouse.chanceOfDying = chanceOfDying;
    }

    public double isChanceOfDying() {return chanceOfDying;}
    public void setChanceOfDying(double chanceOfDying) {Spouse.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Spouse.isAlive = isAlive;}
}
