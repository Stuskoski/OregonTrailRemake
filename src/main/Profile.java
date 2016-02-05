package main;

/**
 * Created by augustus on 1/28/16. THis is the main profile
 * for the user when he starts a new game.  The majority of
 * these characteristics are pulled from the character
 * templates whenever the user selects a class.  The other
 * variables like health/thirst/hunger are set to max intially
 * but will be decremented/incremented through the game.
 */
public class Profile {

    private static int health;
    private static double thirst;
    private static double hunger;
    private static double thirstReduce;
    private static double hungerReduce;
    private static int strength;
    private static int luck;
    private static int smarts;
    private static int agility;
    private static int perception;
    private static int endurance;
    private static double money;
    private static double carryingCapactity;
    private static String charClass;
    private static String name;

    public static int getHealth() {
        return health;
    }
    public static void setHealth(int health) {
        Profile.health = health;
    }


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


    public static double getCarryingCapactity() {return carryingCapactity;}
    public static void setCarryingCapactity(double carryingCapactity) {Profile.carryingCapactity = carryingCapactity;}


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
}
