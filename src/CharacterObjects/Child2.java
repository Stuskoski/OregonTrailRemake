package CharacterObjects;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 2/16/16.
 * This is the child2 object.  This
 * has the status, and stats etc.
 */
public class Child2 {
    private static boolean isAlive = true;
    private static double chanceOfDying;
    //private static String healthStatus;
    public static Set<String> hashSet = new HashSet<>();
    private static String name;

    public Child2(double chanceOfDying, String healthStatus, String name){
        Child2.chanceOfDying = chanceOfDying;
        hashSet.add(healthStatus);
        //Child2.healthStatus = healthStatus;
        Child2.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Child2.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child2.isAlive = isAlive;}

    //public static String getHealthStatus() {return healthStatus;}
    //public static void setHealthStatus(String healthStatus) {Child2.healthStatus = healthStatus;}
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
                Child2.setIsAlive(false);
                break;
            default:
                hashSet.remove("Healthy");
                hashSet.add(healthstatus);
                if(!hashSet.contains("Dying")){
                    if(hashSet.size() >= 3)
                        hashSet.add("Dying");
                }
                break;
        }
    }

    public static void removeHealthStatusWithChecks(String healthstatus){
        hashSet.remove(healthstatus);
        if (hashSet.size()==0){
            addHealthStatusWithChecks("Healthy");
        }
        if(hashSet.contains("Dying")){
            if((hashSet.size()-1) <= 2){
                hashSet.remove("Dying");
            }
        }
    }

    public static String getName() {return name;}
}
