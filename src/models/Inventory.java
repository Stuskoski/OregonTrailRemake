package models;

import items.ItemInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by augustus on 1/28/16.
 * This will be a list that holds all the items.
 */
public class Inventory {
    private static ArrayList<ItemInterface> inventory = new ArrayList<>();

    public static void showInventoryScreen(){
        Stage inventoryStage = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 600);

        gridPane.setId("inventoryBackground");
        gridPane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(5);

        //Collections.sort(inventory, ItemInterface);

        for (ItemInterface item : inventory){
            Label label = new Label(item.getQuantity() + " " + item.getName());
            label.setId("inventoryItemLabel");
            vBox.getChildren().add(label);
        }

        gridPane.add(vBox, 0, 0);

        gridPane.getStylesheets().add("resources/main.css");
        inventoryStage.setTitle("Inventory");
        inventoryStage.setScene(scene);
        inventoryStage.show();
    }

    public static ArrayList<ItemInterface> getInventory(){
        return inventory;
    }
    public static void setInventory(ArrayList<ItemInterface> inventorySet){
        inventory = inventorySet;
    }
}
