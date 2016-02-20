package models;

import items.Clothing.*;
import items.ItemInterface;
import items.food.BeefJerky;
import items.food.LargeBottleOfWater;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by augustus on 2/20/16.
 * Used to add items to a store and
 * randomly select a few ones as well
 * as the default ones.
 */
public class RandomizeStoreContents {

    //private static ItemInterface item1;

    public static ArrayList<ItemInterface> startingTown(){
        ArrayList<ItemInterface> list = new ArrayList<>();
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

        for (int i = 0; i < 10; i++) {
            randInt = random.nextInt(10);

            //add static items first to the list.
            switch (randInt) {
                case 0: {
                    if(bool0) {
                        list.add(new Chaps(random.nextInt(3) + 1));
                        bool0 = false;
                    }
                    break;
                }
                case 1: {
                    if(bool1) {
                        list.add(new Hat(random.nextInt(3) + 1));
                        bool1 = false;
                    }
                    break;
                }
                case 2: {
                    if(bool2) {
                        list.add(new Jacket(random.nextInt(3) + 1));
                        bool2 = false;
                    }
                    break;
                }
                case 3: {
                    if(bool3) {
                        list.add(new LeatherVest(random.nextInt(3) + 1));
                        bool3 = false;
                    }
                    break;
                }
                case 4: {
                    if(bool4) {
                        list.add(new Pants(random.nextInt(3) + 1));
                        bool4 = false;
                    }
                    break;
                }
                case 5: {
                    if(bool5) {
                        list.add(new Shirt(random.nextInt(3) + 1));
                        bool5 = false;
                    }
                    break;
                }
                case 6: {
                    if(bool6) {
                        list.add(new Socks(random.nextInt(3) + 1));
                        bool6 = false;
                    }
                    break;
                }
                case 7: {
                    if(bool7) {
                        list.add(new TrenchCoat(random.nextInt(3) + 1));
                        bool7 = false;
                    }
                    break;
                }
                case 8: {
                    if(bool8) {
                        list.add(new BeefJerky(random.nextInt(3) + 1));
                        bool8 = false;
                    }
                    break;
                }
                case 9: {
                    if(bool9) {
                        list.add(new LargeBottleOfWater(random.nextInt(3) + 1));
                        bool9 = false;
                    }
                    break;
                }
            }

        }

        for (ItemInterface obj : list) {
            System.out.println(obj.getName() + " " + obj.getQuantity());
        }

        return list;
    }

}
