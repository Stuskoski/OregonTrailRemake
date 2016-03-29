package CharacterObjects;

import views.PostGame.ScoreBoard;
import views.PostGame.YouLoseScreen;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by augustus on 1/28/16. THis is the Start profile
 * for the user when he starts a new game.  The majority of
 * these characteristics are pulled from the character
 * templates whenever the user selects a class.  The other
 * variables like health/thirst/hunger are set to max intially
 * but will be decremented/incremented through the game.
 */
public class Profile {

    private static double thirst, hunger, thirstReduce, hungerReduce, money, carryingCapacity;
    private static int health, strength, luck, smarts, agility, perception, endurance;
    private static String charClass, name, healthStatus;
    public static Set<String> hashSet = new HashSet<>();
    private static Child1 child1;
    private static Child2 child2;
    private static Child3 child3;
    private static Spouse spouse;
    private static int animalsKilled = 0;

    public static int getHealth() {return health;}
    public static void setHealth(int health) {Profile.health = health;}


    public static double getThirst() {
        return thirst;
    }
    public static void setThirst(double thirst) {
        Profile.thirst = thirst;
    }


    public static double getHunger() {
        return hunger;
    }
    public static void setHunger(double hunger) {
        Profile.hunger = hunger;
    }


    public static double getThirstReduce() {return thirstReduce;}
    public static void setThirstReduce(double thirstReduce) {Profile.thirstReduce = thirstReduce;}


    public static double getHungerReduce() {return hungerReduce;}
    public static void setHungerReduce(double hungerReduce) {Profile.hungerReduce = hungerReduce;}


    public static int getStrength() {
        return strength;
    }
    public static void setStrength(int strength) {
        Profile.strength = strength;
    }


    public static int getLuck() {
        return luck;
    }
    public static void setLuck(int luck) {
        Profile.luck = luck;
    }


    public static int getSmarts() {
        return smarts;
    }
    public static void setSmarts(int smarts) {
        Profile.smarts = smarts;
    }


    public static int getAgility() {
        return agility;
    }
    public static void setAgility(int agility) {
        Profile.agility = agility;
    }


    public static int getPerception() {
        return perception;
    }
    public static void setPerception(int perception) {
        Profile.perception = perception;
    }


    public static int getEndurance() {
        return endurance;
    }
    public static void setEndurance(int endurance) {
        Profile.endurance = endurance;
    }


    public static double getMoney() {return money;}
    public static void setMoney(double money) {Profile.money = money;}


    public static double getCarryingCapacity() {return carryingCapacity;}
    public static void setCarryingCapacity(double carryingCapacity) {Profile.carryingCapacity = carryingCapacity;}


    public static String getCharClass() {
        return charClass;
    }
    public static void setCharClass(String charClass) {
        Profile.charClass = charClass;
    }


    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Profile.name = name;
    }

    public static String getHealthStatus(){ return healthStatus; }
    public static void setHealthStatus(String status){healthStatus = status;}

    public static Child1 getChild1(){return child1;}
    public static void setChild1(Child1 child){child1 = child;}

    public static Child2 getChild2(){return child2;}
    public static void setChild2(Child2 child){child2 = child;}

    public static Child3 getChild3(){return child3;}
    public static void setChild3(Child3 child){child3 = child;}

    public static Spouse getSpouse(){return spouse;}
    public static void setSpouse(Spouse spouseSet){spouse = spouseSet;}

    public static int getAnimalsKilled(){return animalsKilled;}
    public static void setAnimalsKilled(int killed){animalsKilled=killed;}

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
                YouLoseScreen.showYouLoseScene();
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


}
