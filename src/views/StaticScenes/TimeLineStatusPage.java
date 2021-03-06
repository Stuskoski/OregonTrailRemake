package views.StaticScenes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by augustus on 3/28/16.
 * Shows the time for each event
 * that happens.  Like the console
 * log for the user.
 */
public class TimeLineStatusPage {
    public static VBox vBox = new VBox(2);
    public static ScrollPane scrollPane = new ScrollPane(vBox);
    public static Scene scene = new Scene(scrollPane, 300, 500);
    public static Stage timeLineStatusStage = new Stage();

    public static void showTimeLineStatusPage(){
        timeLineStatusStage.setScene(scene);
        scene.getStylesheets().add("resources/main.css");
        scrollPane.setId("timeLineStatusPage");
        if(!timeLineStatusStage.isShowing())
            timeLineStatusStage.show();
    }
    public static void addMessageToPane(String string, String color){
        LocalDateTime time = LocalDateTime.now();
        Label label = new Label();

        switch (color){
            case "green":
                label.setId("greenLabel");
                break;
            case "red":
                label.setId("redLabel");
                break;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //String text = time.format(formatter);
        label.setText(time.format(formatter) + " - " + string);

        vBox.getChildren().add(0,label);
    }
}
