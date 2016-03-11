package views.HittingTheTrail;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by augustus on 3/11/16.
 * This is the control panel opened
 * once the user clicks to start on
 * the trail.  This will include the
 * stop, go, hunt, rest, all that good
 * stuff!
 */
public class TrailControlPanel {
    public static GridPane controlGridPane = new GridPane();
    public static Scene controlScene = new Scene(controlGridPane, 500, 225);
    public static Stage controlPanelStage = new Stage();

    public static void showControlPane(){
        controlPanelStage.setScene(controlScene);
        controlPanelStage.setResizable(true);
        controlPanelStage.show();

        controlGridPane.setId("controlPanelGrid");
        controlScene.getStylesheets().add("resources/main.css");

        Button rest = new Button("Rest");
        Button carryOn = new Button("Carry On");
        Button goHunt = new Button("Go Hunting");
        Button map = new Button("Map");
        Button familyStatus = new Button("Family Status");
        Button inventory = new Button("Inventory");

        rest.setPrefWidth(125);
        carryOn.setPrefWidth(125);
        goHunt.setPrefWidth(125);
        map.setPrefWidth(125);
        familyStatus.setPrefWidth(125);
        inventory.setPrefWidth(125);

        controlGridPane.setAlignment(Pos.CENTER);
        controlGridPane.setHgap(1);
        controlGridPane.setVgap(1);
        controlGridPane.setPadding(new Insets(20, 20, 20, 20));

        controlGridPane.add(carryOn, 10, 5);
        controlGridPane.add(rest, 5, 5);
        controlGridPane.add(map, 0, 15);
        controlGridPane.add(inventory, 0, 0);
        controlGridPane.add(goHunt, 15, 0);
        controlGridPane.add(familyStatus, 15, 15);




        //When user closes this menu, need a way to make sure they know how to reopen since this is such a crucial menu
        controlPanelStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("For your information");
            alert.setHeaderText(null);
            alert.setContentText("This menu can be reopened by pressing C on the keyboard.");
            alert.showAndWait();
        });
    }
}
