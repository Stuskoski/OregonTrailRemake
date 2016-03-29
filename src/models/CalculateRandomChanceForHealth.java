package models;

import CharacterObjects.*;
import views.PostGame.ScoreBoard;
import views.StaticScenes.FamilyStatus;
import views.StaticScenes.TimeLineStatusPage;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by augustus on 3/26/16.
 */
public class CalculateRandomChanceForHealth {
    public static void checkLifeAndThenCalc(){
        if(Spouse.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Spouse.hashSet.add(temp);
                switch (temp){
                    case "Broken Bone":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has a broken bone.");
                        break;
                    }
                    case "Cursed":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has an uneasy feeling...");
                        break;
                    }
                    case "Small Pox":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Small Pox.");
                        break;
                    }
                    case "Herpes":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has the Herpes.");
                        break;
                    }
                    case "Syphilis":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Syphilis.");
                        break;
                    }
                    case "Chicken Pox":{
                        TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Chicken Pox.");
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }
        if(Child1.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child1.hashSet.add(temp);
                switch (temp){
                    case "Broken Bone":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has a broken bone.");
                        break;
                    }
                    case "Cursed":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has an uneasy feeling...");
                        break;
                    }
                    case "Small Pox":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Small Pox.");
                        break;
                    }
                    case "Herpes":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has the Herpes.");
                        break;
                    }
                    case "Syphilis":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Syphilis.");
                        break;
                    }
                    case "Chicken Pox":{
                        TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Chicken Pox.");
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }
        if(Child2.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child2.hashSet.add(temp);
                switch (temp){
                    case "Broken Bone":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has a broken bone.");
                        break;
                    }
                    case "Cursed":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has an uneasy feeling...");
                        break;
                    }
                    case "Small Pox":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Small Pox.");
                        break;
                    }
                    case "Herpes":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has the Herpes.");
                        break;
                    }
                    case "Syphilis":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Syphilis.");
                        break;
                    }
                    case "Chicken Pox":{
                        TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Chicken Pox.");
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }
        if(Child3.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child3.hashSet.add(temp);
                switch (temp){
                    case "Broken Bone":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has a broken bone.");
                        break;
                    }
                    case "Cursed":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has an uneasy feeling...");
                        break;
                    }
                    case "Small Pox":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Small Pox.");
                        break;
                    }
                    case "Herpes":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has the Herpes.");
                        break;
                    }
                    case "Syphilis":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Syphilis.");
                        break;
                    }
                    case "Chicken Pox":{
                        TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Chicken Pox.");
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }

        String temp = calcChance();//always run for profile since game ends if you die
        if(!temp.equals("")){
            Profile.hashSet.add(temp);
            switch (temp){
                case "Broken Bone":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has a broken bone.");
                    break;
                }
                case "Cursed":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has an uneasy feeling...");
                    break;
                }
                case "Small Pox":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Small Pox.");
                    break;
                }
                case "Herpes":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has the Herpes.");
                    break;
                }
                case "Syphilis":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Syphilis.");
                    break;
                }
                case "Chicken Pox":{
                    TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Chicken Pox.");
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }

    private static String calcChance(){
        Random random = new Random();
        switch (random.nextInt(100)){
            case 5:{
                return "Broken Bone";
            }
            case 28:{
                return "Cursed";
            }
            case 45:{
                return "Small Pox";
            }
            case 63:{
                return "Herpes";
            }
            case 82:{
                return "Syphilis";
            }
            case 99:{
                return "Chicken Pox";
            }
            default:{
                return "";
            }
        }
    }

    public static void checkForAddingDyingStatus(){
        if(Spouse.isAlive()){
            if(Spouse.hashSet.size() > 3){
                Spouse.hashSet.add("Dying");
            }
        }
        if(Child1.isAlive()){
            if(Child1.hashSet.size() > 3){
                Child1.hashSet.add("Dying");
            }
        }
        if(Child2.isAlive()){
            if(Child2.hashSet.size() > 3){
                Child2.hashSet.add("Dying");
            }
        }
        if(Child3.isAlive()){
            if(Child3.hashSet.size() > 3){
                Child3.hashSet.add("Dying");
            }
        }

        if(Profile.hashSet.size() > 3){
            Profile.hashSet.add("Dying");
        }
    }
}
