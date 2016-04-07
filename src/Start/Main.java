package Start;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import views.PreGame.MainScreenView;

import java.io.IOException;

public class Main extends Application {

    private static Stage mainPrimaryStage;

    /**
     * Gets the primaryStage from start and sets it to
     * a instance variable so we can access it from
     * anywhere.  Creates the Start screen and sets it
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
        mainPrimaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        mainPrimaryStage.setX(850);
        mainPrimaryStage.setY(100);
        mainPrimaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage(){
        return mainPrimaryStage;
    }
}
