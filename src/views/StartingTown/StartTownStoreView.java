package views.StartingTown;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;

/**
 * Created by augustus on 2/19/16.
 * The initial store.  Need to randomize items
 * available but also have items that are always
 * there because they are needed.
 */
public class StartTownStoreView {
    private static Scene startStore;

    public static void createStartTownStoreView(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        setStartStore(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartStore(Scene scene){StartTownStoreView.startStore = scene;}
    public static Scene getStartStore(){return StartTownStoreView.startStore;}
}
