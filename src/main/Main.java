package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane borderPane = new BorderPane();
        Scene test = new Scene(borderPane, 500, 500);

        Label label1 = new Label("Title");

        borderPane.setCenter(label1);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(test);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
