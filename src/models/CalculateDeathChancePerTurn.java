package models;

import CharacterObjects.*;
import Characters.Characteristics;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/17/16.
 */
public class CalculateDeathChancePerTurn {

    public static void CalculateDeaths(){
        if(Spouse.isAlive()){
            if(calcDidIDie(Profile.getSpouse().getChanceOfDying())){
                Spouse.setIsAlive(false);
                System.out.println(Spouse.getName()+" has died.");
            }
        }
        if(Child1.isAlive()){
            if(calcDidIDie(Profile.getChild1().getChanceOfDying())){
                Child1.setIsAlive(false);
                System.out.println(Child1.getName()+" has died.");
            }
        }
        if(Child2.isAlive()){
            if(calcDidIDie(Profile.getChild2().getChanceOfDying())){
                Child2.setIsAlive(false);
                System.out.println(Child2.getName()+" has died.");
            }
        }
        if(Child3.isAlive()){
            if(calcDidIDie(Profile.getChild3().getChanceOfDying())){
                Child3.setIsAlive(false);
                System.out.println(Child3.getName()+" has died.");
            }
        }
    }

    //returns true if character died.  Will be called once per turn.
    private static boolean calcDidIDie(Double chance){
        double low = 0.00;
        double high = 100.00;
        Random random = new Random();

        double death = low + (high - low) * random.nextDouble();

        DecimalFormat df = new DecimalFormat("#.##");

        death = Double.parseDouble(df.format(death));

        if(chance >= death){
            return true; //I died
        }

        return false;// I didn't die
    }

}
