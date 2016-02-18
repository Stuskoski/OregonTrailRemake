package CharacterObjects;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/16/16.
 * This is the Spouse object.  This
 * has the status, and stats etc.
 */
public class Spouse {
    private static boolean isAlive = true; //Initially alive of course
    private static double chanceOfDying;
    private static String healthStatus;
    private static String name;

    public Spouse(double chanceOfDying, String healthStatus, String name){
        Spouse.chanceOfDying = chanceOfDying;
        Spouse.healthStatus = healthStatus;
        Spouse.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Spouse.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Spouse.isAlive = isAlive;}

    public static String getHealthStatus() {return healthStatus;}
    public static void setHealthStatus(String healthStatus) {Spouse.healthStatus = healthStatus;}

    public static String getName() {return name;}
}
