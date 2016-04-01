package views.StaticScenes;

import CharacterObjects.Child1;
import CharacterObjects.Child2;
import CharacterObjects.Child3;
import CharacterObjects.Spouse;
import items.ItemInterface;
import items.food.BeefJerky;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Inventory;

/**
 * Created by augustus on 3/31/16.
 * Create a sub menu for the items
 * passed in.  Window pops up when
 * you click on the item in your
 * inventory
 */
public class InventoryItemAction {
    public static void showActionMenu(ItemInterface item, double screenX, double screenY){
        VBox vBox = new VBox(3);
        Scene scene = new Scene(vBox, 150, 95);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Button useOnCharacter = new Button("Use on a character");
        Button delete = new Button("Delete Item");

        useOnCharacter.setPrefWidth(145);
        delete.setPrefWidth(145);

        useOnCharacter.setId("mainScreenBtn");
        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");


        scene.setOnMouseExited(event -> {
            stage.close();
        });

        delete.setOnAction(event -> {
            showDelMenu(item, screenX, screenY);
        });

        vBox.getChildren().addAll(useOnCharacter, delete);

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.show();

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
    }
    private static void showUseMenu(ItemInterface item){
        if(Spouse.isAlive()){

        }
        if(Child1.isAlive()){

        }
        if(Child2.isAlive()){

        }
        if(Child3.isAlive()){

        }

    }
    private static void showDelMenu(ItemInterface item, double screenX, double screenY){
        VBox vBox = new VBox(3);
        Scene scene = new Scene(vBox, 185, 95);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Label delLabel = new Label("Number to delete:");
        delLabel.setId("inventoryItemLabel");

        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.setPromptText("Select amount");
        for(int i = 1; i<=item.getQuantity(); i++){
            comboBox.getItems().add(i);
        }

        Button delete = new Button("Delete");

        delete.setPrefWidth(100);

        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");

        delete.setOnAction(event -> {
            if(comboBox.getValue() != null){
                delItem(item, comboBox.getValue());
                stage.close();
            }
        });

        vBox.getChildren().addAll(delLabel, comboBox, delete);

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
        stage.setTitle("Item Deletion");

        stage.show();




    }

    private static void delItem(ItemInterface item, int number){
        if(item.getQuantity() == number){
            Inventory.getInventory().remove(item);
        }else{
            item.setQuantity(item.getQuantity()-number);
        }
        Inventory.updateInventoryScreen();
    }
}
