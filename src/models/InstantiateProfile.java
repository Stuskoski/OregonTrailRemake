package models;

import CharacterObjects.*;
import Characters.Characteristics;

import java.awt.peer.ScrollbarPeer;
import java.security.SecureRandom;
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

    public void createProfile(Characteristics character, String name){
        Profile.setHealth(character.getHealth());
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
        Profile.setCarryingCapactity(character.getCarryingCapacity());
        Profile.setCharClass(character.getCharClass());
        Profile.setName(name);
        createFamily();
    }

    //Create the objects for the spouse and the three kids
    //Also set their starting death chance.
    private static void createFamily(){
        Spouse spouse = new Spouse(getStartingChance());
        Child1 child1 = new Child1(getStartingChance());
        Child2 child2 = new Child2(getStartingChance());
        Child3 child3 = new Child3(getStartingChance());
    }

    private static double getStartingChance(){
        double low = 0.00;
        double high = 5.00;

        Random r = new Random();
        double randomValue = low + (high - low) * r.nextDouble();

        DecimalFormat df = new DecimalFormat("#.##");

        return randomValue;
    }
}
