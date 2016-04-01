package models;

import items.ItemInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.StaticScenes.InventoryItemAction;

import java.util.ArrayList;

/**
 * Created by augustus on 1/28/16.
 * This will be a list that holds all the items.
 * Lets make the inventory view sort your items
 * into category for better readability
 *
 * To-Do:
 * Add delete buttons for deleting items from inventory
 * Add how much their inventory weighs
 * Add checks when adding stuff to inventory to check if
 * they have the necessary carrying capacity
 */
public class Inventory {
    private static ArrayList<ItemInterface> inventory = new ArrayList<>();
    private static Stage inventoryStage = new Stage();
    private static GridPane inventoryGrid = new GridPane();
    private static ScrollPane inventoryScrollPane = new ScrollPane();
    private static Scene inventoryScene = new Scene(inventoryGrid, 400, 600);

    public static void updateInventoryScreen(){
        inventoryStage.setResizable(false);

        inventoryGrid.getChildren().clear();
        inventoryScrollPane.setId("inventoryScrollPane");
        inventoryScrollPane.setFitToHeight(true);
        inventoryScrollPane.setPrefViewportWidth(400);

        inventoryGrid.setId("inventoryBackground");
        inventoryGrid.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(5);

        //Collections.sort(inventory, ItemInterface);

        for (ItemInterface item : inventory){
            if(item.getName().equals("Game Meat")){
                item.setWeight(item.getWeight()*100);
                item.setWeight((double)Math.round(item.getWeight()));
                item.setWeight(item.getWeight()/100);
                Label label = new Label(item.getWeight()+"lbs of" + " " + item.getName());
                label.setId("inventoryItemLabel");
                vBox.getChildren().add(label);

                label.setOnMouseEntered(event -> label.setId("inventoryLabelBlack"));
                label.setOnMouseExited(event1 -> label.setId("inventoryItemLabel"));
                label.setOnMouseClicked(event -> InventoryItemAction.showActionMenu(item, event.getScreenX(), event.getScreenY()));
            }else{
                Label label = new Label(item.getQuantity() + " " + item.getName() +"("+item.getWeight()*item.getQuantity()+" lbs)");
                label.setId("inventoryItemLabel");
                vBox.getChildren().add(label);

                label.setOnMouseEntered(event -> label.setId("inventoryLabelBlack"));
                label.setOnMouseExited(event1 -> label.setId("inventoryItemLabel"));
                label.setOnMouseClicked(event -> InventoryItemAction.showActionMenu(item, event.getScreenX(), event.getScreenY()));
            }
        }

        inventoryScrollPane.setContent(vBox);

        inventoryGrid.add(inventoryScrollPane, 0, 0);

        inventoryGrid.getStylesheets().add("resources/main.css");
        inventoryStage.setTitle("Inventory");
        inventoryStage.setScene(inventoryScene);
    }

    public static ArrayList<ItemInterface> getInventory(){
        return inventory;
    }
    public static void setInventory(ArrayList<ItemInterface> inventorySet){inventory = inventorySet;}
    public static void setInventoryStage(Stage stage){ inventoryStage = stage;}
    public static Stage getInventoryStage(){return inventoryStage;}
}
