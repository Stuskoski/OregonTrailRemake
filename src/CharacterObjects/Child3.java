package CharacterObjects;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 2/16/16.
 * This is the child3 object.  This
 * has the status, and stats etc.
 */
public class Child3 {
    private static boolean isAlive = true;
    private static double chanceOfDying;
    //private static String healthStatus;
    public static Set<String> hashSet = new HashSet<>();
    private static String name;

    public Child3(double chanceOfDying, String healthStatus, String name){
        Child3.chanceOfDying = chanceOfDying;
        hashSet.add(healthStatus);
        //Child3.healthStatus = healthStatus;
        Child3.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Child3.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child3.isAlive = isAlive;}

    //public static String getHealthStatus() {return healthStatus;}
    //public static void setHealthStatus(String healthStatus) {Child3.healthStatus = healthStatus;}
    public static String returnHealthStatusAsString(){
        String temp = "";
        String temp2;
        for (String str: hashSet) {
            temp += (str+",");
        }
        temp2 = temp.substring(0, temp.length()-1);

        return temp2;
    }
    public static void addHealthStatusWithChecks(String healthstatus){
        switch (healthstatus) {
            case "Healthy":
                hashSet.clear();
                hashSet.add(healthstatus);
                break;
            case "Dead":
                hashSet.clear();
                hashSet.add("Dead");
                Child3.setIsAlive(false);
                break;
            default:
                hashSet.remove("Healthy");
                hashSet.add(healthstatus);
                break;
        }
    }

    public static void removeHealthStatusWithChecks(String healthstatus){
        hashSet.remove(healthstatus);
        if (hashSet.size()==0){
            addHealthStatusWithChecks("Healthy");
        }
    }

    public static String getName() {return name;}
}
