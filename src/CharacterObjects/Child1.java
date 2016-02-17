package CharacterObjects;

/**
 * Created by augustus on 2/16/16.
 */
public class Child1 {
    private static boolean isAlive = true;
    private static double chanceOfDying;

    public Child1(double chanceOfDying){
        Child1.chanceOfDying = chanceOfDying;
    }

    public double isChanceOfDying() {return chanceOfDying;}
    public void setChanceOfDying(double chanceOfDying) {Child1.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child1.isAlive = isAlive;}
}
