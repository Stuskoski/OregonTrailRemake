package CharacterObjects;

import views.StaticScenes.FamilyStatus;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 2/16/16.
 * This is the child1 object.  This
 * has the status, and stats etc.
 */
public class Child1 {
    private static boolean isAlive = true;
    private static double chanceOfDying;
    //private static String healthStatus;
    public static Set<String> hashSet = new HashSet<>();
    private static String name;

    public Child1(double chanceOfDying, String healthStatus, String name){
        Child1.chanceOfDying = chanceOfDying;
        hashSet.add(healthStatus);
        //Child1.healthStatus = healthStatus;
        Child1.name = name;
    }

    public static double getChanceOfDying() {return chanceOfDying;}
    public static void setChanceOfDying(double chanceOfDying) {Child1.chanceOfDying = chanceOfDying;}

    public static boolean isAlive() {return isAlive;}
    public static void setIsAlive(boolean isAlive) {Child1.isAlive = isAlive;}

    //public static String getHealthStatus() {return healthStatus;}
    //public static void setHealthStatus(String healthStatus) {Child1.healthStatus = healthStatus;}
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
        if(FamilyStatus.stage.isShowing()){

        }else{

        }
        switch (healthstatus) {
            case "Healthy":
                hashSet.clear();
                hashSet.add(healthstatus);
                break;
            case "Dead":
                System.out.println("hit");
                hashSet.clear();
                hashSet.add("Dead");
                Child1.setIsAlive(false);
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
