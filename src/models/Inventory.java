package models;

import items.ItemInterface;

import java.util.ArrayList;

/**
 * Created by augustus on 1/28/16.
 * This will be a list that holds all the items.
 */
public class Inventory {
    private static ArrayList<ItemInterface> inventory = new ArrayList<>();

    public static ArrayList<ItemInterface> getInventory(){
        return inventory;
    }
    public static void setInventory(ArrayList<ItemInterface> inventorySet){
        inventory = inventorySet;
    }
}
