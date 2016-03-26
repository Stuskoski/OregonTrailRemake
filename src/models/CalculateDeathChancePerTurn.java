package models;

import CharacterObjects.*;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by augustus on 2/17/16.
 */
public class CalculateDeathChancePerTurn {

    public static void CalculateDeaths(){
        if(Spouse.isAlive()){
            if(calcDidIDie(Spouse.getChanceOfDying(), Profile.getLuck(), Spouse.getHealthStatus())){
                Spouse.setIsAlive(false);
                Spouse.setHealthStatus("Dead");
                System.out.println(Spouse.getName()+" has died.");
            }
        }
        if(Child1.isAlive()){
            if(calcDidIDie(Child1.getChanceOfDying(), Profile.getLuck(), Child1.getHealthStatus())){
                Child1.setIsAlive(false);
                Child1.setHealthStatus("Dead");
                System.out.println(Child1.getName()+" has died.");
            }
        }
        if(Child2.isAlive()){
            if(calcDidIDie(Child2.getChanceOfDying(), Profile.getLuck(), Child2.getHealthStatus())){
                Child2.setIsAlive(false);
                Child2.setHealthStatus("Dead");
                System.out.println(Child2.getName()+" has died.");
            }
        }
        if(Child3.isAlive()){
            if(calcDidIDie(Child3.getChanceOfDying(), Profile.getLuck(), Child3.getHealthStatus())){
                Child3.setIsAlive(false);
                Child3.setHealthStatus("Dead");
                System.out.println(Child3.getName()+" has died.");
            }
        }
    }

    //returns true if character died.  Will be called once per turn.
    private static boolean calcDidIDie(Double chance, int luck, String healthStatus){
        double low = 0.00;
        double high = 100.00 + luck;
        Random random = new Random();
        double healthStatusReduction;

        switch (healthStatus){
            case "diseased":{
                healthStatusReduction = 30.0;
                break;
            }
            case "brokenBone":{
                healthStatusReduction = 10.0;
                break;
            }
            case "cursed":{
                healthStatusReduction = 50.0;
                break;
            }
            case "dying":{
                healthStatusReduction = 90.0;
                break;
            }
            default:{
                healthStatusReduction = 0.0;
            }
        }

        double death = low + ((high-healthStatusReduction) - low) * random.nextDouble();

        DecimalFormat df = new DecimalFormat("#.##");

        death = Double.parseDouble(df.format(death));

        if(chance >= death){
            return true; //I died
        }

        return false;// I didn't die
    }

}
