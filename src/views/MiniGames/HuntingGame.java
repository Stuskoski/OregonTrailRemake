package views.MiniGames;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;

import java.util.Random;

/**
 * Created by augustus on 3/8/16.
 * This is the hunting minigame the
 * user will play to acquire food to
 * survive.  Need to randomize everything
 * on it pretty much.  Need reloader
 * indicators, ammo indicators and
 * a bunch of graphics!
 */
public class HuntingGame {
    private static Scene scene;


    public static void randomizeHuntScreen(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Button back = new Button("Back");

        gridPane.add(back, 1, 1);

        Random random = new Random();




        back.setOnAction(event -> {
            switch(random.nextInt(4)){
                case 0:{
                    gridPane.setId("huntBackground1");
                    break;
                }
                case 1:{
                    gridPane.setId("huntBackground2");
                    break;
                }
                case 2:{
                    gridPane.setId("huntBackground3");
                    break;
                }
                case 3:{
                    gridPane.setId("huntBackground4");
                    break;
                }
            }
        });


        Scene createScene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(),Main.getPrimaryStage().getScene().getHeight());

        createScene.getStylesheets().add("resources/main.css");

        scene = createScene;
    }

    public static Scene getScene(){return scene;}
}
