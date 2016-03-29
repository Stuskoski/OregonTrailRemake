package models;

import CharacterObjects.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import views.HittingTheTrail.TrailControlPanel;
import views.PostGame.ScoreBoard;
import views.StaticScenes.FamilyStatus;
import views.StaticScenes.TimeLineStatusPage;

import java.sql.Time;
import java.util.*;

/**
 * Created by augustus on 3/26/16.
 */
public class CalculateRandomChanceForHealth {
    public static HashMap<String, Timeline> healthStatusHashMap = new HashMap<>();
    public static void checkLifeAndThenCalc(){
        if(Spouse.isAlive()){
            String temp = calcChance();
            if(!temp.equals("")){
                switch (temp){
                    case "Broken Bone":{
                        if(!Spouse.hashSet.contains("Broken Bone")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has a broken bone.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s1 = true;
                                    TimeLineStatusPage.addMessageToPane("The Bone has healed for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s1", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Cursed":{
                        if(!Spouse.hashSet.contains("Cursed")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has an uneasy feeling...");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s2 = true;
                                    TimeLineStatusPage.addMessageToPane("The Curse is lifted for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s2", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Small Pox":{
                        if(!Spouse.hashSet.contains("Small Pox")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Small Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s3 = true;
                                    TimeLineStatusPage.addMessageToPane("Small Pox cured for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s3", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Herpes":{
                        if(!Spouse.hashSet.contains("Herpes")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has the Herpes.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s4 = true;
                                    TimeLineStatusPage.addMessageToPane("The Herp Derp is no more for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s4", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Syphilis":{
                        if(!Spouse.hashSet.contains("Syphilis")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Syphilis.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s5 = true;
                                    TimeLineStatusPage.addMessageToPane("Syphilis has been cured for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s5", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Chicken Pox":{
                        if(!Spouse.hashSet.contains("Chicken Pox")) {
                            Spouse.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has contracted Chicken Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Spouse.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    s6 = true;
                                    TimeLineStatusPage.addMessageToPane("Chicken Pox has been cured for " + Spouse.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("s6", statusRemoveTimeline);
                        }
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
                switch (temp){
                    case "Broken Bone":{
                        if(!Child1.hashSet.contains("Broken Bone")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has a broken bone.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c1 = true;
                                    TimeLineStatusPage.addMessageToPane("The Bone has healed for " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c1", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Cursed":{
                        if(!Child1.hashSet.contains("Cursed")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has an uneasy feeling...");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2 = true;
                                    TimeLineStatusPage.addMessageToPane("The Curse is lifted for  " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Small Pox":{
                        if(!Child1.hashSet.contains("Small Pox")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Small Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3 = true;
                                    TimeLineStatusPage.addMessageToPane("Small Pox cured for  " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Herpes":{
                        if(!Child1.hashSet.contains("Herpes")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has the Herpes.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c4 = true;
                                    TimeLineStatusPage.addMessageToPane("The Herp Derp is no more for " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c4", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Syphilis":{
                        if(!Child1.hashSet.contains("Syphilis")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Syphilis.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c5 = true;
                                    TimeLineStatusPage.addMessageToPane("Syphilis has been cured for " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c5", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Chicken Pox":{
                        if(!Child1.hashSet.contains("Chicken Pox")) {
                            Child1.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has contracted Chicken Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child1.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c6 = true;
                                    TimeLineStatusPage.addMessageToPane("Chicken Pox has been cured for " + Child1.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c6", statusRemoveTimeline);
                        }
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
                switch (temp){
                    case "Broken Bone":{
                        if(!Child2.hashSet.contains("Chicken Pox")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has a broken bone.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_1 = true;
                                    TimeLineStatusPage.addMessageToPane("The Bone has healed for " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_1", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Cursed":{
                        if(!Child2.hashSet.contains("Cursed")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has an uneasy feeling...");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_2 = true;
                                    TimeLineStatusPage.addMessageToPane("The Curse is lifted for  " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_2", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Small Pox":{
                        if(!Child2.hashSet.contains("Small Pox")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Small Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_3 = true;
                                    TimeLineStatusPage.addMessageToPane("Small Pox cured for  " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_3", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Herpes":{
                        if(!Child2.hashSet.contains("Herpes")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has the Herpes.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_4 = true;
                                    TimeLineStatusPage.addMessageToPane("The Herp Derp is no more for " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_4", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Syphilis":{
                        if(!Child2.hashSet.contains("Syphilis")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Syphilis.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_5 = true;
                                    TimeLineStatusPage.addMessageToPane("Syphilis has been cured for " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_5", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Chicken Pox":{
                        if(!Child2.hashSet.contains("Chicken Pox")) {
                            Child2.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has contracted Chicken Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child2.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c2_6 = true;
                                    TimeLineStatusPage.addMessageToPane("Chicken Pox has been cured for " + Child2.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c2_6", statusRemoveTimeline);
                        }
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
                switch (temp){
                    case "Broken Bone":{
                        if(!Child3.hashSet.contains("Broken Bone")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has a broken bone.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_1 = true;
                                    TimeLineStatusPage.addMessageToPane("The Bone has healed for " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_1", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Cursed":{
                        if(!Child3.hashSet.contains("Cursed")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has an uneasy feeling...");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_2 = true;
                                    TimeLineStatusPage.addMessageToPane("The Curse is lifted for  " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_2", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Small Pox":{
                        if(!Child3.hashSet.contains("Small Pox")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Small Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_3 = true;
                                    TimeLineStatusPage.addMessageToPane("Small Pox cured for  " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_3", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Herpes":{
                        if(!Child3.hashSet.contains("Herpes")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has the Herpes.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_4 = true;
                                    TimeLineStatusPage.addMessageToPane("The Herp Derp is no more for " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_4", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Syphilis":{
                        if(!Child3.hashSet.contains("Syphilis")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Syphilis.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_5 = true;
                                    TimeLineStatusPage.addMessageToPane("Syphilis has been cured for " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_5", statusRemoveTimeline);
                        }
                        break;
                    }
                    case "Chicken Pox":{
                        if(!Child3.hashSet.contains("Chicken Pox")) {
                            Child3.addHealthStatusWithChecks(temp);
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has contracted Chicken Pox.");

                            int count = TrailControlPanel.counterForMap;
                            Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                                if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                    Child3.hashSet.remove(temp);
                                    FamilyStatus.showFamilyStatus();
                                    c3_6 = true;
                                    TimeLineStatusPage.addMessageToPane("Chicken Pox has been cured for " + Child3.getName());
                                }
                            }));
                            statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                            statusRemoveTimeline.play();
                            healthStatusHashMap.put("c3_6", statusRemoveTimeline);
                        }
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
            switch (temp){
                case "Broken Bone":{
                    if(!Profile.hashSet.contains("Broken Bone")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has a broken bone.");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p1 = true;
                                TimeLineStatusPage.addMessageToPane("The Bone has healed for " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p1", statusRemoveTimeline);
                    }
                    break;
                }
                case "Cursed":{
                    if(!Profile.hashSet.contains("Cursed")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has an uneasy feeling...");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p2 = true;
                                TimeLineStatusPage.addMessageToPane("The Curse is lifted for  " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p2", statusRemoveTimeline);
                    }
                    break;
                }
                case "Small Pox":{
                    if(!Profile.hashSet.contains("Small Pox")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Small Pox.");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p3 = true;
                                TimeLineStatusPage.addMessageToPane("Small Pox cured for  " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p3", statusRemoveTimeline);
                    }
                    break;
                }
                case "Herpes":{
                    if(!Profile.hashSet.contains("Herpes")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has the Herpes.");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p4 = true;
                                TimeLineStatusPage.addMessageToPane("The Herp Derp is no more for " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p4", statusRemoveTimeline);
                    }
                    break;
                }
                case "Syphilis":{
                    if(!Profile.hashSet.contains("Syphilis")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Syphilis.");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p5 = true;
                                TimeLineStatusPage.addMessageToPane("Syphilis has been cured for " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p5", statusRemoveTimeline);
                    }
                    break;
                }
                case "Chicken Pox":{
                    if(!Profile.hashSet.contains("Chicken Pox")) {
                        Profile.addHealthStatusWithChecks(temp);
                        TimeLineStatusPage.addMessageToPane(Profile.getName() + " has contracted Chicken Pox.");

                        int count = TrailControlPanel.counterForMap;
                        Timeline statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
                            if (TrailControlPanel.counterForMap - count >= 10) { // 10 turns to fix
                                Profile.hashSet.remove(temp);
                                FamilyStatus.showFamilyStatus();
                                p6 = true;
                                TimeLineStatusPage.addMessageToPane("Chicken Pox has been cured for " + Profile.getName());
                            }
                        }));
                        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
                        statusRemoveTimeline.play();
                        healthStatusHashMap.put("p6", statusRemoveTimeline);
                    }
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
        int chance = random.nextInt(200);

        if(chance >= 0 && chance <= 3) // a 4 in 200 chance (2%)
            return "Broken Bone";
        if(chance == 4) // a 1 in 200 chance (0.5%)
            return "Cursed";
        if(chance == 5 || chance == 6) // a 2 in 200 chance (1%)
            return "Small Pox";
        if(chance == 7 || chance == 8 || chance == 9) // a 3 in 200 chance (1.75%)
            return "Herpes";
        if(chance == 10 || chance == 11) // a 2 in 200 chance (1%)
            return "Syphilis";
        if(chance >= 12 && chance <= 15) // a 4 in 200 chance (2%)
            return "Chicken Pox";
        return "";
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

    private static boolean p1 = false;
    private static boolean p2 = false;
    private static boolean p3 = false;
    private static boolean p4 = false;
    private static boolean p5 = false;
    private static boolean p6 = false;

    private static boolean s1 = false;
    private static boolean s2 = false;
    private static boolean s3 = false;
    private static boolean s4 = false;
    private static boolean s5 = false;
    private static boolean s6 = false;

    private static boolean c1 = false;
    private static boolean c2 = false;
    private static boolean c3 = false;
    private static boolean c4 = false;
    private static boolean c5 = false;
    private static boolean c6 = false;

    private static boolean c2_1 = false;
    private static boolean c2_2 = false;
    private static boolean c2_3 = false;
    private static boolean c2_4 = false;
    private static boolean c2_5 = false;
    private static boolean c2_6 = false;

    private static boolean c3_1 = false;
    private static boolean c3_2 = false;
    private static boolean c3_3 = false;
    private static boolean c3_4 = false;
    private static boolean c3_5 = false;
    private static boolean c3_6 = false;

    public static Timeline statusRemoveTimeline;

    public static void constantChecker(){
        statusRemoveTimeline = new Timeline(new KeyFrame(Duration.millis(5050), timelineEvent -> {
            //Profile checks
            if(p1) {
                healthStatusHashMap.get("p1").stop();
                p1 = false;
                healthStatusHashMap.remove("p1");
            }
            if(p2) {
                healthStatusHashMap.get("p2").stop();
                p2 = false;
                healthStatusHashMap.remove("p2");
            }
            if(p3) {
                healthStatusHashMap.get("p3").stop();
                p3 = false;
                healthStatusHashMap.remove("p3");
            }
            if(p4) {
                healthStatusHashMap.get("p4").stop();
                p4 = false;
                healthStatusHashMap.remove("p4");
            }
            if(p5) {
                healthStatusHashMap.get("p5").stop();
                p5 = false;
                healthStatusHashMap.remove("p5");
            }
            if(p6) {
                healthStatusHashMap.get("p6").stop();
                p6 = false;
                healthStatusHashMap.remove("p16");
            }

            //Spouse checks
            if(s1) {
                healthStatusHashMap.get("s1").stop();
                s1 = false;
                healthStatusHashMap.remove("s1");
            }
            if(s2) {
                healthStatusHashMap.get("s2").stop();
                s2 = false;
                healthStatusHashMap.remove("s2");
            }
            if(s3) {
                healthStatusHashMap.get("s3").stop();
                s3 = false;
                healthStatusHashMap.remove("s3");
            }
            if(s4) {
                healthStatusHashMap.get("s4").stop();
                s4 = false;
                healthStatusHashMap.remove("s4");
            }
            if(s5) {
                healthStatusHashMap.get("s5").stop();
                s5 = false;
                healthStatusHashMap.remove("s5");
            }
            if(s6) {
                healthStatusHashMap.get("s6").stop();
                s6 = false;
                healthStatusHashMap.remove("s6");
            }

            //Child 1 checks
            if(c1) {
                healthStatusHashMap.get("c1").stop();
                c1 = false;
                healthStatusHashMap.remove("c1");
            }
            if(c2) {
                healthStatusHashMap.get("c2").stop();
                c2 = false;
                healthStatusHashMap.remove("c2");
            }
            if(c3) {
                healthStatusHashMap.get("c3").stop();
                c3 = false;
                healthStatusHashMap.remove("c3");
            }
            if(c4) {
                healthStatusHashMap.get("c4").stop();
                c4 = false;
                healthStatusHashMap.remove("c4");
            }
            if(c5) {
                healthStatusHashMap.get("c5").stop();
                c5 = false;
                healthStatusHashMap.remove("c5");
            }
            if(c6) {
                healthStatusHashMap.get("c6").stop();
                c6 = false;
                healthStatusHashMap.remove("c6");
            }


            //Child 2 checks
            if(c2_1) {
                healthStatusHashMap.get("c2_1").stop();
                c2_1 = false;
                healthStatusHashMap.remove("c2_1");
            }
            if(c2_2) {
                healthStatusHashMap.get("c2_2").stop();
                c2_2 = false;
                healthStatusHashMap.remove("c2_2");
            }
            if(c2_3) {
                healthStatusHashMap.get("c2_3").stop();
                c2_3 = false;
                healthStatusHashMap.remove("c2_3");
            }
            if(c2_4) {
                healthStatusHashMap.get("c2_4").stop();
                c2_4 = false;
                healthStatusHashMap.remove("c2_4");
            }
            if(c2_5) {
                healthStatusHashMap.get("c2_5").stop();
                c2_5 = false;
                healthStatusHashMap.remove("c2_5");
            }
            if(c2_6) {
                healthStatusHashMap.get("c2_6").stop();
                c2_6 = false;
                healthStatusHashMap.remove("c2_6");
            }

            //Child 3 checks
            if(c3_1) {
                healthStatusHashMap.get("c3_1").stop();
                c3_1 = false;
                healthStatusHashMap.remove("c3_1");
            }
            if(c3_2) {
                healthStatusHashMap.get("c3_2").stop();
                c3_2 = false;
                healthStatusHashMap.remove("c3_2");
            }
            if(c3_3) {
                healthStatusHashMap.get("c3_3").stop();
                c3_3 = false;
                healthStatusHashMap.remove("c3_3");
            }
            if(c3_4) {
                healthStatusHashMap.get("c3_4").stop();
                c3_4 = false;
                healthStatusHashMap.remove("c3_4");
            }
            if(c3_5) {
                healthStatusHashMap.get("c3_5").stop();
                c3_5 = false;
                healthStatusHashMap.remove("c3_5");
            }
            if(c3_6) {
                healthStatusHashMap.get("c3_6").stop();
                c3_6 = false;
                healthStatusHashMap.remove("c3_6");
            }

        }));
        statusRemoveTimeline.setCycleCount(Animation.INDEFINITE);
        statusRemoveTimeline.play();
    }

    private static boolean checkIfStatusExists(String healthStatus, HashSet<String> set){
        return set.contains(healthStatus);
    }
}
