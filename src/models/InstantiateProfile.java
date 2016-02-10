package models;

import Characters.Characteristics;
import main.Profile;

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
    }
}
