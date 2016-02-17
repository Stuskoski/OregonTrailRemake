package CharacterObjects;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/16/16.
 * This is the child2 object.  This
 * has the status, and stats etc.
 */
public class Child2 {
    private static boolean isAlive = true;
    private static double chanceOfDying;
    private static String healthStatus;
    private static String name;

    public Child2(double chanceOfDying, String healthStatus, String name){
        Child2.chanceOfDying = chanceOfDying;
        Child2.healthStatus = healthStatus;
        Child2.name = name;
    }

    public double getChanceOfDying() {return chanceOfDying;}
    public void setChanceOfDying(double chanceOfDying) {Child2.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child2.isAlive = isAlive;}

    public static String getHealthStatus() {return healthStatus;}
    public static void setHealthStatus(String healthStatus) {Child2.healthStatus = healthStatus;}

    public static String getName() {return name;}
}
