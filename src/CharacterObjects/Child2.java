package CharacterObjects;

/**
 * Created by augustus on 2/16/16.
 */
public class Child2 {
    private static boolean isAlive = true;
    private static double chanceOfDying;

    public Child2(double chanceOfDying){
        Child2.chanceOfDying = chanceOfDying;
    }

    public double isChanceOfDying() {return chanceOfDying;}
    public void setChanceOfDying(double chanceOfDying) {Child2.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child2.isAlive = isAlive;}
}
