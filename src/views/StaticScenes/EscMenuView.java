package views.StaticScenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by augustus on 3/6/16.
 * Create the ESC menu
 */
public class EscMenuView {
    public static Stage stage = new Stage();
    public static void showEscMenu(){

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 200, 300);
        VBox vBox = new VBox(10);

        gridPane.setAlignment(Pos.CENTER);

        Button quit = new Button("Quit");
        Button save = new Button("Save Game");
        Button newGame = new Button("New Game");
        Button load = new Button("Load Game");

        quit.setId("escScreenBtn");
        save.setId("escScreenBtn");
        newGame.setId("escScreenBtn");
        load.setId("escScreenBtn");
        gridPane.setId("escScreenPopup");

        quit.setPrefWidth(150);
        save.setPrefWidth(150);
        newGame.setPrefWidth(150);
        load.setPrefWidth(150);

        quit.setOnAction(event -> System.exit(0));

        vBox.getChildren().addAll(save, load, newGame, quit);

        gridPane.add(vBox, 0, 0);

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.show();
    }
}
