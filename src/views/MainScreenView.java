package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by augustus on 2/11/16.
 * The main screen the user will see
 * whenever they open the application.
 */
public class MainScreenView {
    private static Scene loginScene;

    /**
     * Create the login scene with default values
     * and set it to the class variable.
     */
    public static void createLoginScene(){
        GridPane gridPane = new GridPane();
        VBox vBox = new VBox(15);
        HBox hBox = new HBox();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label title = new Label("The Oregon Trail");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: white");
        hBox.getChildren().add(title);
        hBox.setAlignment(Pos.CENTER);

        gridPane.add(hBox, 0, 0);

        Button newGame = new Button("New Game");
        Button loadGame = new Button("Load Game");
        Button exit = new Button("Exit");

        newGame.setId("mainScreenBtn");
        loadGame.setId("mainScreenBtn");
        exit.setId("mainScreenBtn");
        newGame.setPrefWidth(120);
        loadGame.setPrefWidth(120);
        exit.setPrefWidth(120);

        vBox.getChildren().addAll(newGame, loadGame, exit);

        gridPane.add(vBox, 0, 2);

        Scene newScene = new Scene(gridPane, 900, 700);

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
