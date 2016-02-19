package main;

import javafx.application.Application;
import javafx.stage.Stage;
import views.MainScreenView;

public class Main extends Application {

    private static Stage mainPrimaryStage;

    /**
     * Gets the primaryStage from start and sets it to
     * a instance variable so we can access it from
     * anywhere.  Creates the main screen and sets it
     * so it has a starting point.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainPrimaryStage = primaryStage;
        MainScreenView.createLoginScene();
        mainPrimaryStage.setTitle("Oregon Trail - Remake");
        mainPrimaryStage.setScene(MainScreenView.getLoginScene());
        mainPrimaryStage.setResizable(false);
        mainPrimaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage(){
        return mainPrimaryStage;
    }
}
