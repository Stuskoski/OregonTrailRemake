package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by augustus on 2/11/16.
 * A simple class to set the primary stage.
 * Done this way to separate logic from view.
 */
public class SetPrimaryStage {

    public static void setPrimaryStage(Stage primary, Scene sceneToSet){
        primary.setScene(sceneToSet);
    }
}
