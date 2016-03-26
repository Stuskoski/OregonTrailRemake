package models;

import CharacterObjects.*;
import views.PostGame.ScoreBoard;
import views.StaticScenes.FamilyStatus;

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
            }
        }
        if(Child1.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child1.hashSet.add(temp);
            }
        }
        if(Child2.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child2.hashSet.add(temp);
            }
        }
        if(Child3.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                Child3.hashSet.add(temp);
            }
        }

        String temp = calcChance();//always run for profile since game ends if you die
        if(!temp.equals("")){
            Profile.hashSet.add(temp);
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
