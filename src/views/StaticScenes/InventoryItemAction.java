package views.StaticScenes;

import CharacterObjects.Child1;
import CharacterObjects.Child2;
import CharacterObjects.Child3;
import CharacterObjects.Spouse;
import items.ItemInterface;
import items.food.BeefJerky;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
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
        final Timeline[] timeline = new Timeline[1];
        timeline[0] = new Timeline();

        vBox.setAlignment(Pos.CENTER);

        Button useOnCharacter = new Button("Use on a character");
        Button delete = new Button("Delete Item");

        useOnCharacter.setPrefWidth(145);
        delete.setPrefWidth(145);

        useOnCharacter.setId("mainScreenBtn");
        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");

        if(!item.getCategory().equals("meds"))
            useOnCharacter.setDisable(true);


        //Action listeners.
        //After 1 sec, close the window.  Else restart the timer. Beautiful.
        scene.setOnMouseExited(event -> {
            timeline[0] = new Timeline(new KeyFrame(Duration.seconds(1), event2 -> {
            }));
            timeline[0].setCycleCount(1);
            timeline[0].play();
            timeline[0].setOnFinished(event1 -> {
                stage.close();
            });
        });

        scene.setOnMouseEntered(event1 -> timeline[0].stop());

        delete.setOnAction(event -> showDelMenu(item, screenX, screenY));
        useOnCharacter.setOnAction(event -> showUseMenu(item, screenX, screenY));

        vBox.getChildren().addAll(useOnCharacter, delete);

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.show();

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
    }
    private static void showUseMenu(ItemInterface item, double screenX, double screenY){


        VBox vBox = new VBox(5);
        Scene scene = new Scene(vBox, 325, 225);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Button profileUse = new Button("Use on yourself");
        profileUse.setPrefWidth(300);
        profileUse.setId("mainScreenBtn");
        vBox.getChildren().add(profileUse);

        if(Spouse.isAlive()){
            Button spouseUse = new Button("Use on " + Spouse.getName() + " (Spouse)");
            spouseUse.setPrefWidth(300);
            spouseUse.setId("mainScreenBtn");
            vBox.getChildren().add(spouseUse);
        }
        if(Child1.isAlive()){
            Button child1Use = new Button("Use on " + Child1.getName() + " (Child1)");
            child1Use.setPrefWidth(300);
            child1Use.setId("mainScreenBtn");
            vBox.getChildren().add(child1Use);
        }
        if(Child2.isAlive()){
            Button child2Use = new Button("Use on " + Child2.getName() + " (Child2)");
            child2Use.setPrefWidth(300);
            child2Use.setId("mainScreenBtn");
            vBox.getChildren().add(child2Use);
        }
        if(Child3.isAlive()){
            Button child3Use = new Button("Use on " + Child3.getName() + " (Child3)");
            child3Use.setPrefWidth(300);
            child3Use.setId("mainScreenBtn");
            vBox.getChildren().add(child3Use);
        }

        vBox.setId("actionMenuScreen");


        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
        stage.setTitle("Use Item");

        stage.show();




    }
    private static void showDelMenu(ItemInterface item, double screenX, double screenY){
        VBox vBox = new VBox(3);
        Scene scene = new Scene(vBox, 185, 95);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Label delLabel = new Label("Number to delete:");
        delLabel.setId("inventoryItemLabel");

        Button delete = new Button("Delete");

        delete.setPrefWidth(100);

        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");

        if(item.getName().equals("Game Meat")){ //special case for game meat since it goes by weight not quantity
            ComboBox<Double> comboBox = new ComboBox<>();
            comboBox.setPromptText("Select amount");
            for(double i = 1.00; i<=item.getWeight(); i++){
                comboBox.getItems().add(i);
            }
            comboBox.getItems().add(item.getWeight());

            delete.setOnAction(event -> {
                if(comboBox.getValue() != null){
                    delItemSpecialCaseForMeat(item, comboBox.getValue());
                    stage.close();
                }
            });
            vBox.getChildren().addAll(delLabel, comboBox, delete);

        }else{ //every other item
            ComboBox<Integer> comboBox = new ComboBox<>();
            comboBox.setPromptText("Select amount");
            for(int i = 1; i<=item.getQuantity(); i++){
                comboBox.getItems().add(i);
            }

            delete.setOnAction(event -> {
                if(comboBox.getValue() != null){
                    delItem(item, comboBox.getValue());
                    stage.close();
                }
            });
            vBox.getChildren().addAll(delLabel, comboBox, delete);
        }

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
        stage.setTitle("Delete Item");

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

    private static void delItemSpecialCaseForMeat(ItemInterface item, double number){
        if(item.getWeight() == number){
            Inventory.getInventory().remove(item);
        }else{
            item.setWeight(item.getWeight()-number);
        }
        Inventory.updateInventoryScreen();
    }
}
