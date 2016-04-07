package views.StaticScenes;

import CharacterObjects.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by augustus on 3/25/16.
 */
public class FamilyStatus {
    public static GridPane gridPane;
    public static Scene scene;
    public static Stage stage = new Stage();

    public static void showFamilyStatus(){
        gridPane = new GridPane();
        //stage = new Stage();
        gridPane.setHgap(100);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();

        Label label1 = new Label("Character");
        Label label2 = new Label("Status");

        hBox1.getChildren().add(label1);
        hBox2.getChildren().add(label2);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(5);
        VBox vBox2 = new VBox(5);

        Label you = new Label(Profile.getName() + "(You): ");
        Label spouse = new Label(Spouse.getName() + "(Spouse): ");
        Label child1 = new Label(Child1.getName() + "(Child1): ");
        Label child2 = new Label(Child2.getName() + "(Child2): ");
        Label child3 = new Label(Child3.getName() + "(Child3): ");

        vBox1.getChildren().addAll(you, spouse, child1, child2, child3);

        Label youStatus = new Label(Profile.returnHealthStatusAsString());
        Label spouseStatus = new Label(Spouse.returnHealthStatusAsString());
        Label child1Status = new Label(Child1.returnHealthStatusAsString());
        Label child2Status = new Label(Child2.returnHealthStatusAsString());
        Label child3Status = new Label(Child3.returnHealthStatusAsString());

        vBox2.getChildren().addAll(youStatus, spouseStatus, child1Status, child2Status, child3Status);

        gridPane.add(hBox1, 0, 0);
        gridPane.add(hBox2, 1, 0);
        gridPane.add(vBox1, 0, 2);
        gridPane.add(vBox2, 1, 2);

        scene = new Scene(gridPane, 450, 175);
        stage.setScene(scene);
        //stage.show();
    }
}
