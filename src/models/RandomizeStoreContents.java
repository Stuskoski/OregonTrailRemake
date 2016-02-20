package models;

import items.ItemInterface;

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
        ArrayList<ItemInterface> list = null;
        int randInt=0;
        Random random = new Random();

        for (int i=0; i<10; i++){
            randInt = random.nextInt(10);

            switch (randInt){
                case 0:{
                    list.add();
                    break;
                }
                case 1:{
                    list.add();
                    break;
                }
                case 2:{
                    list.add();
                    break;
                }
                case 3:{
                    list.add();
                    break;
                }
                case 4:{
                    list.add();
                    break;
                }
                case 5:{
                    list.add();
                    break;
                }
                case 6:{
                    list.add();
                    break;
                }
                case 7:{
                    list.add();
                    break;
                }
                case 8:{
                    list.add();
                    break;
                }
                case 9:{
                    list.add();
                    break;
                }
            }

        }




        return list;
    }
}
