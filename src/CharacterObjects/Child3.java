package CharacterObjects;

/**
 * Created by augustus on 2/16/16.
 * This is the child3 object.  This
 * has the status, and stats etc.
 */
public class Child3 {
    private static boolean isAlive = true;
    private static double chanceOfDying;

    public Child3(double chanceOfDying){
        Child3.chanceOfDying = chanceOfDying;
    }

    public double isChanceOfDying() {return chanceOfDying;}
    public void setChanceOfDying(double chanceOfDying) {Child3.chanceOfDying = chanceOfDying;}

    public boolean isAlive() {return isAlive;}
    public void setIsAlive(boolean isAlive) {Child3.isAlive = isAlive;}


}
