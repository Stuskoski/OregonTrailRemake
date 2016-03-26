package models;

import CharacterObjects.*;
import Characters.Characteristics;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/5/16.
 * This method in the class accepts a character object and
 * a name.  The method will then set all the initial values
 * for the profile.  Another class will be made to change
 * the values but for now this one just creates the initial
 * profile at the start of the game.
 */
public class InstantiateProfile {

    public void createProfile(Characteristics character, String name, String spouseName, String child1Name,
                              String child2Name, String child3Name){
        Profile.setHealth(character.getHealth());
        Profile.addHealthStatusWithChecks("Healthy");
        Profile.setThirst(100.00);
        Profile.setHunger(100.00);
        Profile.setThirstReduce(character.getThirstConsume());
        Profile.setHungerReduce(character.getHungerConsume());
        Profile.setStrength(character.getStrength());
        Profile.setLuck(character.getLuck());
        Profile.setSmarts(character.getSmarts());
        Profile.setAgility(character.getAgility());
        Profile.setPerception(character.getPerception());
        Profile.setEndurance(character.getEndurance());
        Profile.setMoney(character.getStartingMoney());
        Profile.setCarryingCapacity(character.getCarryingCapacity());
        Profile.setCharClass(character.getCharClass());
        Profile.setName(name);
        Profile.setHealthStatus("Healthy");
        createFamily(spouseName, child1Name, child2Name, child3Name);

    }

    //Create the objects for the spouse and the three kids
    //Also set their starting death chance and health status
    private static void createFamily(String spouseName, String child1Name, String child2Name, String child3Name){
        Profile.setSpouse(new Spouse(getStartingChance(), "Healthy", spouseName));
        Profile.setChild1(new Child1(getStartingChance(), "Healthy", child1Name));
        Profile.setChild2(new Child2(getStartingChance(), "Healthy", child2Name));
        Profile.setChild3(new Child3(getStartingChance(), "Healthy", child3Name));
    }

    private static double getStartingChance(){
        double low = 0.00;
        double high = 2.00;

        Random r = new Random();
        double randomValue = low + (high - low) * r.nextDouble();

        DecimalFormat df = new DecimalFormat("#.##");

        return Double.parseDouble(df.format(randomValue));
    }
}
