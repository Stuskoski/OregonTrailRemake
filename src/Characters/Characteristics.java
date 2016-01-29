package Characters;

/**
 * Created by augustus on 1/28/16.
 * Interface for all the characters.
 * When a character is selected the
 * characters stats are loaded into
 * the players profile.
 */
public interface Characteristics {
    int getHealth(); //Health will be an int between 0-120
    double getThirst(); //Thirst will be a double 0.00-10.00, typically goes through quarter changes(0.25)
    double getHunger(); //Hunger will be a double 0.00-10.00, typically goes through quarter changes(0.25)
    int getStrength(); //How strong the character is. 1-25
    int getLuck(); //How lucky the the characters is. 1-25
    int getSmarts(); //Smarts is how well a character is able to do things 1-25
    int getAgility(); //Agility is how well a character can escape traps and dangers. 1-25
    int getPerception(); //Perception is how well a character can see things such as items or traps 1-25
    int getEndurance(); //Endurance is how long a character can travel before they have to reset 1-25
    String getName(); //get the name of the character class
}