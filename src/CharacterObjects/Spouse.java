package CharacterObjects;

import views.PostGame.ScoreBoard;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 2/16/16.
 * This is the Spouse object.  This
 * has the status, and stats etc.
 */
public class Spouse {
    private static boolean isAlive = true; //Initially alive of course
    private static double chanceOfDying;
    //private static String healthStatus;
    public static Set<String> hashSet = new HashSet<>();
    private static String name;

    public Spouse(double chanceOfDying, String healthStatus, String name){
        Spouse.chanceOfDying = chanceOfDying;
        hashSet.add(healthStatus);
        //Spouse.healthStatus = healthStatus;
        Spouse.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Spouse.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Spouse.isAlive = isAlive;}

    //public static String getHealthStatus() {return healthStatus;}
    //public static void setHealthStatus(String healthStatus) {Spouse.healthStatus = healthStatus;}
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
                Spouse.setIsAlive(false);
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
