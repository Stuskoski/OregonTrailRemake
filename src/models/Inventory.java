package models;

import CharacterObjects.Profile;
import items.Animals.Donkey;
import items.Animals.Horse;
import items.Animals.Ox;
import items.ItemInterface;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    private static BorderPane inventoryGrid = new BorderPane();
    private static ScrollPane inventoryScrollPane = new ScrollPane();
    private static Scene inventoryScene = new Scene(inventoryGrid, 400, 600);

    public static void updateInventoryScreen(){
        inventoryStage.setResizable(false);

        inventoryGrid.getChildren().clear();
        inventoryScrollPane.setId("inventoryScrollPane");
        inventoryScrollPane.setFitToHeight(true);
        inventoryScrollPane.setPrefViewportWidth(400);

        inventoryGrid.setId("inventoryBackground");

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

                Tooltip itemTooltip = new Tooltip(item.getDescription());
                label.setOnMouseEntered(event -> {
                    label.setId("inventoryLabelBlack");
                    itemTooltip.show(inventoryScrollPane, inventoryScene.getWindow().getX(), inventoryScene.getWindow().getY()+(vBox.getChildren().indexOf(label) * 25 + 75));
                    hideItemTooltip(label, itemTooltip);
                });

                label.setOnMouseClicked(event -> InventoryItemAction.showActionMenu(item, event.getScreenX(), event.getScreenY()));
            }else{
                Label label = new Label(item.getQuantity() + " " + item.getName() +"("+item.getWeight()*item.getQuantity()+" lbs)");
                label.setId("inventoryItemLabel");
                vBox.getChildren().add(label);

                label.setOnMouseEntered(event -> label.setId("inventoryLabelBlack"));
                label.setOnMouseExited(event1 -> label.setId("inventoryItemLabel"));
                label.setOnMouseClicked(event -> InventoryItemAction.showActionMenu(item, event.getScreenX(), event.getScreenY()));
                if(item.getName().equals("Donkey")){
                    Profile.setCarryingCapacity(Profile.getCarryingCapacity() + item.getQuantity() * new Donkey(1).getWeightCapacityIncrease());
                }
                if(item.getName().equals("American Pure Bred")){
                    Profile.setCarryingCapacity(Profile.getCarryingCapacity() + item.getQuantity() * new Horse(1).getWeightCapacityIncrease());
                }
                if(item.getName().equals("English Ox")){
                    Profile.setCarryingCapacity(Profile.getCarryingCapacity() + item.getQuantity() * new Ox(1).getWeightCapacityIncrease());
                }

                //Sometimes the tooltip gets in the way so it resets....need to offset it
                Tooltip itemTooltip = new Tooltip(item.getDescription());
                label.setOnMouseEntered(event -> {
                    label.setId("inventoryLabelBlack");
                    itemTooltip.show(inventoryScrollPane, inventoryScene.getWindow().getX(), inventoryScene.getWindow().getY()+(vBox.getChildren().indexOf(label) * 25 + 75));
                    hideItemTooltip(label, itemTooltip);
                });

            }
        }

        inventoryScrollPane.setContent(vBox);

        HBox hBox1 = new HBox(inventoryScrollPane);
        hBox1.setAlignment(Pos.CENTER);

        inventoryGrid.setCenter(hBox1);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        Label label = new Label("Carrying Capacity: " + returnInventoryWeight() + "/" + Profile.getCarryingCapacity()+"\n\n\n");
        hBox.getChildren().add(label);
        label.setId("inventoryCarryingCapacityLabel");

        inventoryGrid.setTop(hBox);

        inventoryGrid.getStylesheets().add("resources/main.css");
        inventoryStage.setTitle("Inventory");
        inventoryStage.setScene(inventoryScene);
    }

    private static void showItemTooltip(Tooltip itemTooltip, double sceneX, double sceneY, Label label) {
        itemTooltip.show(inventoryScrollPane, sceneX, sceneY);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
        }));
        timeline.setCycleCount(1);
        timeline.setOnFinished(event1 -> itemTooltip.hide());
        label.setOnMouseExited(event -> {
            timeline.play();
            label.setId("inventoryItemLabel");
        });
        label.setOnMouseEntered(event -> timeline.stop());
    }

    private static void hideItemTooltip(Label label, Tooltip itemTooltip){
        label.setOnMouseExited(event -> {
            label.setId("inventoryItemLabel");
            itemTooltip.hide();
        });
    }

    public static double returnInventoryWeight(){
        double weight = 0.00;

        for (ItemInterface item : Inventory.getInventory()) {
            if(!(item.getName().equals("American Pure Bred")) && !(item.getName().equals("English Ox")) && !(item.getName().equals("Donkey"))){
                if(item.getName().equals("Game Meat")){
                    weight += item.getWeight();
                }else{
                    weight += item.getWeight() * item.getQuantity();
                }
            }
        }

        return weight;
    }

    public static ArrayList<ItemInterface> getInventory(){
        return inventory;
    }
    public static void setInventory(ArrayList<ItemInterface> inventorySet){inventory = inventorySet;}
    public static void setInventoryStage(Stage stage){ inventoryStage = stage;}
    public static Stage getInventoryStage(){return inventoryStage;}
}
