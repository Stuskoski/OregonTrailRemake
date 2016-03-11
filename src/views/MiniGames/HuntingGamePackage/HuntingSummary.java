package views.MiniGames.HuntingGamePackage;

import items.ItemInterface;
import items.food.GameMeat;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.Main;
import models.Inventory;
import views.StartingTown.StartingTownView;


/**
 * Created by augustus on 3/8/16.
 * Shows the summary for the hunting minigame
 * Need to make it where it stops all activity
 * of the minigame
 */
public class HuntingSummary{
    public static void showSummaryScreen(int animalsKilled, double poundsHunted){
        GridPane gridPane = new GridPane();
        VBox vBox = new VBox(10);

        gridPane.setAlignment(Pos.CENTER);

        Button continueBtn = new Button("Continue");
        continueBtn.setId("mainScreenBtn");

        poundsHunted = poundsHunted*100;
        poundsHunted = (double)Math.round(poundsHunted);
        poundsHunted = poundsHunted / 100;

        Label animalsKilledLabel = new Label("Animals Killed: " + animalsKilled);
        Label poundsHuntedLabel = new Label("Pounds of Meat Hunted: " + poundsHunted);

        vBox.getChildren().addAll(animalsKilledLabel, poundsHuntedLabel, continueBtn);

        vBox.setAlignment(Pos.CENTER);

        gridPane.add(vBox, 0, 0);



        //Add the pounds to your inventory, first check if it exists tho.
        final double finalPoundsHunted = poundsHunted;
        continueBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
            double weight = 0.0;
            int counter=0;
            for (ItemInterface weightCheck : Inventory.getInventory()){
                if(weightCheck.getName().equals("Game Meat")){
                    weight = weightCheck.getWeight();
                    System.out.println(weight);
                    weightCheck.setWeight(weightCheck.getWeight()+finalPoundsHunted);
                }else{
                    counter++;
                }
            }
            if(counter == Inventory.getInventory().size()){
                Inventory.getInventory().add(new GameMeat(1,finalPoundsHunted));
            }

            Inventory.updateInventoryScreen();
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(scene);

    }
}
