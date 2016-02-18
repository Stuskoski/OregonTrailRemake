package CharacterObjects;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/16/16.
 * This is the child3 object.  This
 * has the status, and stats etc.
 */
public class Child3 {
    private static boolean isAlive = true;
    private static double chanceOfDying;
    private static String healthStatus;
    private static String name;

    public Child3(double chanceOfDying, String healthStatus, String name){
        Child3.chanceOfDying = chanceOfDying;
        Child3.healthStatus = healthStatus;
        Child3.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Child3.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child3.isAlive = isAlive;}

    public static String getHealthStatus() {return healthStatus;}
    public static void setHealthStatus(String healthStatus) {Child3.healthStatus = healthStatus;}

    public static String getName() {return name;}
}
