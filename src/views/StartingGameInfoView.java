package views;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import main.Main;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by augustus on 2/18/16.
 * Quick view that gives an introduction
 * in a star wars manner
 */
public class StartingGameInfoView {
    public static Scene startingGameInfoView;
    public static Canvas canvas = new Canvas(Main.getPrimaryStage().getWidth()-200, Main.getPrimaryStage().getHeight()-200);
    public static GraphicsContext gc = canvas.getGraphicsContext2D();
    public static int x = 0;

    public static void createStartingGameInfoView(){
        BorderPane borderPane = new BorderPane();
        borderPane.setId("startingGameInfoViewBackground");

        HBox topHbox = new HBox();
        Label topBorderLabel = new Label("The Oregon Trail");
        topBorderLabel.setId("topLabelStartingGameInfoView");
        topHbox.setAlignment(Pos.CENTER);
        topHbox.getChildren().add(topBorderLabel);
        borderPane.setTop(topHbox);

        HBox bottomHbox = new HBox();
        Label bottomBorderLabel = new Label("---Press any key to continue---");
        bottomBorderLabel.setId("bottomLabelStartingGameInfoView");
        bottomHbox.setAlignment(Pos.CENTER);
        bottomHbox.getChildren().add(bottomBorderLabel);
        borderPane.setBottom(bottomHbox);

        borderPane.setCenter(canvas);

        Timer timer = new Timer();
        timer.schedule(new test(), 0, 100);

        Scene scene = new Scene(borderPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        scene.setOnKeyReleased(event -> {
            timer.cancel();
        });

        Main.getPrimaryStage().setScene(scene);
    }

    public static void testMe(){
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.YELLOW);
        gc.clearRect(10+x, 60+x, 30+x, 30+x);
        gc.fillOval(10+x, 60+x, 30+x, 30+x);
        x++;
        //gc.clearRect(10,60,30,30);
    }
    public static void setStartingGameInfoView(Scene scene){StartingGameInfoView.startingGameInfoView = scene;}
    public static Scene getStartingGameInfoView(){ return StartingGameInfoView.startingGameInfoView;}
}

class test extends TimerTask{

    @Override
    public void run() {
        StartingGameInfoView.testMe();
    }
}