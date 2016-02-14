package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sun.nio.ch.sctp.SctpNet;

/**
 * Created by augustus on 2/11/16.
 */
public class MainScreenView {
    private static Scene loginScene;

    /**
     * Create the login scene with default values
     * and set it to the class variable.
     */
    public static void createLoginScene(){
        GridPane gridPane = new GridPane();
        VBox vBox = new VBox(10);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Button newGame = new Button("New Game");
        Button loadGame = new Button("Load Game");
        Button exit = new Button("Exit");

        newGame.setId("mainScreenBtn");
        loadGame.setId("mainScreenBtn");
        exit.setId("mainScreenBtn");

        vBox.getChildren().addAll(newGame, loadGame, exit);

        gridPane.add(vBox, 0, 0);

        Scene newScene = new Scene(gridPane, 800, 600);

        gridPane.setId("mainScreen");
        newScene.getStylesheets().add("resources/main.css");

        //Action listeners
        newGame.setOnAction(event -> {
            NewGameView.createNewGameView();
        });
        loadGame.setOnAction(event -> {
            System.out.println("Load Game");
        });
        exit.setOnAction(event -> {
            System.exit(0);
        });

        setLoginScene(newScene);
    }

    public static Scene getLoginScene(){ return loginScene; }
    public static void setLoginScene(Scene scene){ loginScene = scene; }

}
