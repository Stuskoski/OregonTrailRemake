package models;

import CharacterObjects.*;
import views.PostGame.ScoreBoard;
import views.PostGame.YouLoseScreen;
import views.StaticScenes.FamilyStatus;
import views.StaticScenes.TimeLineStatusPage;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 2/17/16.
 * Calc the death chances for each person that
 * is alive, per turn.
 */
public class CalculateDeathChancePerTurn {

    public static void CalculateDeaths(){

        if(Spouse.isAlive()){
            if(calcDidIDie(Spouse.getChanceOfDying(), Profile.getLuck(), Spouse.hashSet)){
                Spouse.setIsAlive(false);
                Spouse.addHealthStatusWithChecks("Dead");
                FamilyStatus.showFamilyStatus();
                System.out.println(Spouse.getName()+" has died.");
                TimeLineStatusPage.addMessageToPane(Spouse.getName()+" has died.");
            }
        }
        if(Child1.isAlive()){
            if(calcDidIDie(Child1.getChanceOfDying(), Profile.getLuck(), Child1.hashSet)){
                Child1.setIsAlive(false);
                Child1.addHealthStatusWithChecks("Dead");
                FamilyStatus.showFamilyStatus();
                System.out.println(Child1.getName()+" has died.");
                TimeLineStatusPage.addMessageToPane(Child1.getName()+" has died.");
            }
        }
        if(Child2.isAlive()){
            if(calcDidIDie(Child2.getChanceOfDying(), Profile.getLuck(), Child2.hashSet)){
                Child2.setIsAlive(false);
                Child2.addHealthStatusWithChecks("Dead");
                FamilyStatus.showFamilyStatus();
                System.out.println(Child2.getName()+" has died.");
                TimeLineStatusPage.addMessageToPane(Child2.getName()+" has died.");
            }
        }
        if(Child3.isAlive()){
            if(calcDidIDie(Child3.getChanceOfDying(), Profile.getLuck(), Child3.hashSet)){
                Child3.setIsAlive(false);
                Child3.addHealthStatusWithChecks("Dead");
                FamilyStatus.showFamilyStatus();
                System.out.println(Child3.getName()+" has died.");
                TimeLineStatusPage.addMessageToPane(Child3.getName()+" has died.");
            }
        }
        if(calcDidIDie(0.00, Profile.getLuck(), Profile.hashSet)){
            YouLoseScreen.showYouLoseScene();
        }
    }

    //returns true if character died.  Will be called once per turn.
    private static boolean calcDidIDie(Double chance, int luck, Set<String> healthStatus){
        double low = 0.00;
        double high = 100.00 + luck;
        Random random = new Random();
        double healthStatusReduction = 0.0;

        for (String str : healthStatus) {
            switch (str.toLowerCase()){
                case "small pox":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "broken bone":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "cursed":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "thirsty":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "hungry":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "syphilis":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "chicken pox":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "herpes":{
                    healthStatusReduction += 0.0;
                    break;
                }
                case "dying":{
                    healthStatusReduction += 0.0;
                    break;
                }
                default:{
                    healthStatusReduction += 0.0;
                    break;
                }
            }
        }

       // System.out.println("HERE" + random.nextDouble()*100);

        double death = low + (high - low) * random.nextDouble();

        DecimalFormat df = new DecimalFormat("#.##");

        death = Double.parseDouble(df.format(death));
        System.out.println(chance+healthStatusReduction + "     " + death);
        if((chance + healthStatusReduction) >= death){
            return true; //I died
        }

        return false;// I didn't die
    }

}
