package models;

import javafx.application.Platform;

/**
 * Created by augustus on 3/6/16.
 */
public class InventoryChecker{

    private static int arraySize = Inventory.getInventory().size();


    public static void checkIt() {
        System.out.println(arraySize);
        while (true){
            if(Inventory.getInventory().size() != arraySize){
                Platform.runLater(Inventory::getInventory);
                arraySize = Inventory.getInventory().size();
            }

        }
    }
}
