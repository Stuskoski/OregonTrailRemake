package models;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;
import views.StaticScenes.EscMenuView;

/**
 * Created by augustus on 3/6/16.
 */
public class AddKeyListenerToScene {
    public static void addKeyListener(Scene scene){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case I: {
                        Inventory.updateInventoryScreen();
                        Inventory.getInventoryStage().show();
                        break;
                    }
                    case ESCAPE:{
                        EscMenuView.showEscMenu();
                    }
                }
            }
        });
    }
}
