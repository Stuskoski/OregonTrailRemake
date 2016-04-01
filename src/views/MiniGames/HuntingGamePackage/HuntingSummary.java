package views.MiniGames.HuntingGamePackage;

import CharacterObjects.Profile;
import items.ItemInterface;
import items.food.GameMeat;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import Start.Main;
import models.Inventory;
import views.HittingTheTrail.TheTrail;
import views.HittingTheTrail.TrailControlPanel;
import views.MiniGames.HuntingGamePackage.HuntingObjects.WildGameObject;
import views.StartingTown.StartingTownView;


/**
 * Created by augustus on 3/8/16.
 * Shows the summary for the hunting minigame
 * Need to make it where it stops all activity
 * of the minigame
 */
public class HuntingSummary{
    public static void showSummaryScreen(int animalsKilled, double poundsHunted){

        //Erase all the pictures of the hunting game then remove them from array to prevent hit counters.
        for (WildGameObject wild: RandomCreateGameObjects.wildGame) {
            wild.setImage(null);
        }
        RandomCreateGameObjects.wildGame.clear();

        GridPane gridPane = new GridPane();
        VBox vBox = new VBox(10);
        gridPane.setId("summaryBackground");

        gridPane.setAlignment(Pos.CENTER);

        Button continueBtn = new Button("Continue");
        continueBtn.setId("mainScreenBtn");

        poundsHunted = poundsHunted*100;
        poundsHunted = (double)Math.round(poundsHunted);
        poundsHunted = poundsHunted / 100;

        Label animalsKilledLabel = new Label("Animals Killed: " + animalsKilled);
        Label poundsHuntedLabel = new Label("Pounds of Meat Hunted: " + poundsHunted);

        animalsKilledLabel.setId("summaryLabel");
        poundsHuntedLabel.setId("summaryLabel");

        Profile.setAnimalsKilled(Profile.getAnimalsKilled() + animalsKilled);

        vBox.getChildren().addAll(animalsKilledLabel, poundsHuntedLabel, continueBtn);

        vBox.setAlignment(Pos.CENTER);

        gridPane.add(vBox, 0, 0);



        //Add the pounds to your inventory, first check if it exists tho.
        final double finalPoundsHunted = poundsHunted;
        continueBtn.setOnAction(event -> {
            TrailControlPanel.goHunt.setDisable(false);
            Main.getPrimaryStage().setScene(TheTrail.scene);
            TrailControlPanel.rest.setDisable(false);//reenable the button for resting
            int counter=0;
            for (ItemInterface weightCheck : Inventory.getInventory()){
                if(weightCheck.getName().equals("Game Meat")){
                    weightCheck.setWeight(weightCheck.getWeight()+finalPoundsHunted);
                }else{
                    counter++;
                }
            }
            if(counter == Inventory.getInventory().size()){
                if(!(finalPoundsHunted == 0.00))
                    Inventory.getInventory().add(new GameMeat(1,finalPoundsHunted));
            }

            Inventory.updateInventoryScreen();
            HuntingGame.setScene(null);
            for (WildGameObject obj : RandomCreateGameObjects.wildGame){
                obj.setImage(null);
                obj.setHasBeenHit(true);
            }
            HuntingGame.getProgressBar().setProgress(1.0);
            TrailControlPanel.setCanIstartTimeline(true);
            TrailControlPanel.carryOn.fire();
            //RandomCreateGameObjects.wildGame.clear();
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(scene);

    }
}
