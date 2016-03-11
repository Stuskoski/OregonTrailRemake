package models;

import items.Clothing.*;
import items.Guns.Bullets;
import items.Guns.FlintlockPistol;
import items.Guns.Rifle;
import items.ItemInterface;
import items.food.*;
import items.meds.SmallBandage;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by augustus on 2/20/16.
 * Used to add items to a store and
 * randomly select a few ones as well
 * as the default ones.
 */
public class RandomizeStoreContents {
    private static ArrayList<ItemInterface> startTownList = new ArrayList<>();//use interface as the array startTownList so you get the functions of that interface

    //private static ItemInterface item1;

    public static ArrayList<ItemInterface> startingTown(){
        int randInt;
        Random random = new Random();
        boolean bool0=true;
        boolean bool1=true;
        boolean bool2=true;
        boolean bool3=true;
        boolean bool4=true;
        boolean bool5=true;
        boolean bool6=true;
        boolean bool7=true;
        boolean bool8=true;
        boolean bool9=true;

        //Items that are always available
        startTownList.add(new SmallBottleofWater(10));
        startTownList.add(new BeefJerky(10));
        startTownList.add(new CampBread(10));
        startTownList.add(new Shirt(10));
        startTownList.add(new Pants(10));
        startTownList.add(new Boots(10));
        startTownList.add(new FlintlockPistol(1));
        startTownList.add(new Bullets(100));


        for (int i = 0; i < 5; i++) {
            randInt = random.nextInt(10);

            //add static items first to the startTownList.
            switch (randInt) {
                case 0: {
                    if(bool0) {
                        startTownList.add(new Chaps(random.nextInt(3) + 1));
                        bool0 = false;
                    }
                    break;
                }
                case 1: {
                    if(bool1) {
                        startTownList.add(new Hat(random.nextInt(3) + 1));
                        bool1 = false;
                    }
                    break;
                }
                case 2: {
                    if(bool2) {
                        startTownList.add(new Jacket(random.nextInt(3) + 1));
                        bool2 = false;
                    }
                    break;
                }
                case 3: {
                    if(bool3) {
                        startTownList.add(new LeatherVest(random.nextInt(3) + 1));
                        bool3 = false;
                    }
                    break;
                }
                case 4: {
                    if(bool4) {
                        startTownList.add(new Rifle(1));
                        bool4 = false;
                    }
                    break;
                }
                case 5: {
                    if(bool5) {
                        startTownList.add(new SmallBandage(random.nextInt(3) + 1));
                        bool5 = false;
                    }
                    break;
                }
                case 6: {
                    if(bool6) {
                        startTownList.add(new Socks(random.nextInt(3) + 1));
                        bool6 = false;
                    }
                    break;
                }
                case 7: {
                    if(bool7) {
                        startTownList.add(new TrenchCoat(random.nextInt(3) + 1));
                        bool7 = false;
                    }
                    break;
                }
                case 8: {
                    if(bool8) {
                        startTownList.add(new TurkeyJerky(random.nextInt(3) + 1));
                        bool8 = false;
                    }
                    break;
                }
                case 9: {
                    if(bool9) {
                        startTownList.add(new LargeBottleofWater(random.nextInt(3) + 1));
                        bool9 = false;
                    }
                    break;
                }
            }

        }

      //  for (ItemInterface obj : startTownList) {
      //      System.out.println(obj.getName() + " " + obj.getQuantity());
      //  }

        return startTownList;
    }

    public static ArrayList<ItemInterface> getStartTownList(){ return startTownList; }
    public static void setStartTownList(ArrayList<ItemInterface> list){ startTownList = list; }

}
