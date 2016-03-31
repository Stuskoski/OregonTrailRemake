package models;

import CharacterObjects.*;
import views.StaticScenes.TimeLineStatusPage;

import java.sql.Time;
import java.util.Random;

/**
 * Created by augustus on 3/31/16.
 * Whenever the user decides to rest
 * I needed to make it worth while.
 * So for every second(day) that they
 * rest they have a chance at healing an ailment for a family member.
 */
public class ChanceToRemoveAilmentWhenResting {

    public static void checkChanceForAilmentRemoval() {
        Random random = new Random();

        if(!Profile.returnHealthStatusAsString().contains("Healthy")){
            switch (random.nextInt(100)){
                case 25:
                    System.out.println("Profile cured");
                    Boolean flag = true;
                    if(Profile.hashSet.contains("Broken Bone")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+" has rested his Broken Bone. It is fixed.", "green");
                        Profile.removeHealthStatusWithChecks("Broken Bone");
                        flag = false;
                    }
                    if(flag && Profile.hashSet.contains("Cursed")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+" has rested long enough to break the Curse.", "green");
                        Profile.removeHealthStatusWithChecks("Cursed");
                        flag = false;
                    }
                    if(flag && Profile.hashSet.contains("Small Pox")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+" has recovered from Small Pox.", "green");
                        Profile.removeHealthStatusWithChecks("Small Pox");
                        flag = false;
                    }
                    if(flag && Profile.hashSet.contains("Herpes")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+": The Herpes have disappeared after resting!", "green");
                        Profile.removeHealthStatusWithChecks("Herpes");
                        flag = false;
                    }
                    if(flag && Profile.hashSet.contains("Syphilis")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+" has rested away the Syphilis.", "green");
                        Profile.removeHealthStatusWithChecks("Syphilis");
                        flag = false;
                    }
                    if(flag && Profile.hashSet.contains("Chicken Pox")){
                        TimeLineStatusPage.addMessageToPane(Profile.getName()+": Chicken Pox are no more!", "green");
                        Profile.removeHealthStatusWithChecks("Chicken Pox");
                    }
                    break;
            }
        }
        if(Spouse.isAlive() && !Spouse.returnHealthStatusAsString().contains("Healthy")){
            switch (random.nextInt(100)){
                case 25:
                    System.out.println("Spouse cured");
                    Boolean flag = true;
                    if(Spouse.hashSet.contains("Broken Bone")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+" has rested his Broken Bone. It is fixed.", "green");
                        Spouse.removeHealthStatusWithChecks("Broken Bone");
                        flag = false;
                    }
                    if(flag && Spouse.hashSet.contains("Cursed")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+" has rested long enough to break the Curse.", "green");
                        Spouse.removeHealthStatusWithChecks("Cursed");
                        flag = false;
                    }
                    if(flag && Spouse.hashSet.contains("Small Pox")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+" has recovered from Small Pox.", "green");
                        Spouse.removeHealthStatusWithChecks("Small Pox");
                        flag = false;
                    }
                    if(flag && Spouse.hashSet.contains("Herpes")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+": The Herpes have disappeared after resting!", "green");
                        Spouse.removeHealthStatusWithChecks("Herpes");
                        flag = false;
                    }
                    if(flag && Spouse.hashSet.contains("Syphilis")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+" has rested away the Syphilis.", "green");
                        Spouse.removeHealthStatusWithChecks("Syphilis");
                        flag = false;
                    }
                    if(flag && Spouse.hashSet.contains("Chicken Pox")){
                        TimeLineStatusPage.addMessageToPane(Spouse.getName()+": Chicken Pox are no more!", "green");
                        Spouse.removeHealthStatusWithChecks("Chicken Pox");
                    }
                    break;
            }
        }
        if(Child1.isAlive() && !Child1.returnHealthStatusAsString().contains("Healthy")){
            switch (random.nextInt(100)){
                case 25:
                    System.out.println("1 cured");
                    Boolean flag = true;
                    if(Child1.hashSet.contains("Broken Bone")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+" has rested his Broken Bone. It is fixed.", "green");
                        Child1.removeHealthStatusWithChecks("Broken Bone");
                        flag = false;
                    }
                    if(flag && Child1.hashSet.contains("Cursed")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+" has rested long enough to break the Curse.", "green");
                        Child1.removeHealthStatusWithChecks("Cursed");
                        flag = false;
                    }
                    if(flag && Child1.hashSet.contains("Small Pox")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+" has recovered from Small Pox.", "green");
                        Child1.removeHealthStatusWithChecks("Small Pox");
                        flag = false;
                    }
                    if(flag && Child1.hashSet.contains("Herpes")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+": The Herpes have disappeared after resting!", "green");
                        Child1.removeHealthStatusWithChecks("Herpes");
                        flag = false;
                    }
                    if(flag && Child1.hashSet.contains("Syphilis")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+" has rested away the Syphilis.", "green");
                        Child1.removeHealthStatusWithChecks("Syphilis");
                        flag = false;
                    }
                    if(flag && Child1.hashSet.contains("Chicken Pox")){
                        TimeLineStatusPage.addMessageToPane(Child1.getName()+": Chicken Pox are no more!", "green");
                        Child1.removeHealthStatusWithChecks("Chicken Pox");
                    }
                    break;
            }
        }
        if(Child2.isAlive() && !Child2.returnHealthStatusAsString().contains("Healthy")){
            switch (random.nextInt(100)){
                case 25:
                    System.out.println("2 cured");
                    Boolean flag = true;
                    if(Child2.hashSet.contains("Broken Bone")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+" has rested his Broken Bone. It is fixed.", "green");
                        Child2.removeHealthStatusWithChecks("Broken Bone");
                        flag = false;
                    }
                    if(flag && Child2.hashSet.contains("Cursed")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+" has rested long enough to break the Curse.", "green");
                        Child2.removeHealthStatusWithChecks("Cursed");
                        flag = false;
                    }
                    if(flag && Child2.hashSet.contains("Small Pox")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+" has recovered from Small Pox.", "green");
                        Child2.removeHealthStatusWithChecks("Small Pox");
                        flag = false;
                    }
                    if(flag && Child2.hashSet.contains("Herpes")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+": The Herpes have disappeared after resting!", "green");
                        Child2.removeHealthStatusWithChecks("Herpes");
                        flag = false;
                    }
                    if(flag && Child2.hashSet.contains("Syphilis")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+" has rested away the Syphilis.", "green");
                        Child2.removeHealthStatusWithChecks("Syphilis");
                        flag = false;
                    }
                    if(flag && Child2.hashSet.contains("Chicken Pox")){
                        TimeLineStatusPage.addMessageToPane(Child2.getName()+": Chicken Pox are no more!", "green");
                        Child2.removeHealthStatusWithChecks("Chicken Pox");
                    }
                    break;
            }
        }
        if(Child3.isAlive() && !Child3.returnHealthStatusAsString().contains("Healthy")){
            switch (random.nextInt(100)){
                case 25:
                    System.out.println("3 cured");
                    Boolean flag = true;
                    if(Child3.hashSet.contains("Broken Bone")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+" has rested his Broken Bone. It is fixed.", "green");
                        Child3.removeHealthStatusWithChecks("Broken Bone");
                        flag = false;
                    }
                    if(flag && Child3.hashSet.contains("Cursed")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+" has rested long enough to break the Curse.", "green");
                        Child3.removeHealthStatusWithChecks("Cursed");
                        flag = false;
                    }
                    if(flag && Child3.hashSet.contains("Small Pox")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+" has recovered from Small Pox.", "green");
                        Child3.removeHealthStatusWithChecks("Small Pox");
                        flag = false;
                    }
                    if(flag && Child3.hashSet.contains("Herpes")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+": The Herpes have disappeared after resting!", "green");
                        Child3.removeHealthStatusWithChecks("Herpes");
                        flag = false;
                    }
                    if(flag && Child3.hashSet.contains("Syphilis")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+" has rested away the Syphilis.", "green");
                        Child3.removeHealthStatusWithChecks("Syphilis");
                        flag = false;
                    }
                    if(flag && Child3.hashSet.contains("Chicken Pox")){
                        TimeLineStatusPage.addMessageToPane(Child3.getName()+": Chicken Pox are no more!", "green");
                        Child3.removeHealthStatusWithChecks("Chicken Pox");
                    }
                    break;
            }
        }
    }
}
