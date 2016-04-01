package models;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import views.HittingTheTrail.TrailControlPanel;
import views.StartingTown.StartTownStoreView;
import views.StaticScenes.EscMenuView;

/**
 * Created by augustus on 3/6/16.
 */
public class AddKeyListenerToScene {
    public static void addGeneralKeyListener(Scene scene){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case I: {
                    Inventory.updateInventoryScreen();
                    Inventory.getInventoryStage().show();
                    break;
                }
                case ESCAPE:{
                    EscMenuView.showEscMenu();
                    break;
                }
                case H:{
                    System.out.println("Implement Help Screen");
                    break;
                }
                case C:{
                    TrailControlPanel.showControlPane();
                    break;
                }
            }
        });
    }
    public static void addGeneralKeyListenerToStore(Scene scene){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case I: {
                    Inventory.updateInventoryScreen();
                    Inventory.getInventoryStage().show();
                    break;
                }
                case ESCAPE:{
                    EscMenuView.showEscMenu();
                    break;
                }
                case H:{
                    System.out.println("Implement Help Screen");
                    break;
                }
                case C:{
                    StartTownStoreView.checkOut.fire();
                    break;
                }
            }
        });
    }
    public static void addKeyListenerToStartingTownSaloonView(Scene scene){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case I: {
                    Inventory.updateInventoryScreen();
                    Inventory.getInventoryStage().show();
                    break;
                }
                case ESCAPE:{
                    EscMenuView.showEscMenu();
                    break;
                }
            }
        });
    }
}
