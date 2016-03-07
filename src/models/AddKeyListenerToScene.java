package models;

import javafx.scene.Scene;
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
