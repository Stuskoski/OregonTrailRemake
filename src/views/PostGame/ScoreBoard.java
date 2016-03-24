package views.PostGame;

import CharacterObjects.*;
import Start.Main;
import items.ItemInterface;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Inventory;
import models.NewGameClearExisiting;
import views.HittingTheTrail.TrailControlPanel;

/**
 * Created by augustus on 3/24/16.
 * This is the score board screen.
 * Keep track of how long it took
 * for the player to beat the game
 * This is factored into the score
 * as well as alive family members.
 * inventory, and all that jazz.
 *
 * Present the information in a new
 * stage once the game is completed
 * and also give them the option to
 * start a new game or exit the game.
 */
public class ScoreBoard {
    public static Timeline scoreTimeline;
    public static int counter = 0;
    public static Stage stage = new Stage();


    public static void startTimeLine(){
        scoreTimeline = new Timeline(new KeyFrame(Duration.seconds(1), timeGameEvent -> {
            counter++;
        }));
        scoreTimeline.setCycleCount(Animation.INDEFINITE);
        scoreTimeline.play();
    }

    public static void showScoreBoard(){
        //hide previous stages
        TrailControlPanel.controlPanelStage.hide();
        Main.getPrimaryStage().hide();
        Inventory.getInventoryStage().hide();

        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setId("scoreBoardGrid");

        Button newGame = new Button("New Game");
        Button quit = new Button("Quit");

        scoreTimeline.stop();

        Label timeTaken = new Label("Time taken to beat the game: " + counter + " seconds(" + (10000 - counter) + ")");
        Label animalsKilled = new Label("Animals killed: " + Profile.getAnimalsKilled() + "(" + (Profile.getAnimalsKilled() * 50) + ")"); //need to implement
        Label familyAlive = new Label("Family members still alive: " + getFamilyAlive() + "(" + (getFamilyAlive() * 100) + ")");
        Label moneyLeft = new Label("Money Left: " + Profile.getMoney() + "(" + (Math.round(Profile.getMoney()) * 2) + ")");
        Label inventoryItems = new Label("Inventory Items: " + getInventory() + "(" + (getInventory()) + ")");
        Label finalScore = new Label("Final Score: " + calcFinalScore());

        timeTaken.setId("scoreBoardLabel");
        animalsKilled.setId("scoreBoardLabel");
        familyAlive.setId("scoreBoardLabel");
        moneyLeft.setId("scoreBoardLabel");
        inventoryItems.setId("scoreBoardLabel");
        finalScore.setId("scoreBoardLabel");

        HBox timeTakenH = new HBox(timeTaken);
        HBox animalsKilledH = new HBox(animalsKilled);
        HBox familyAliveH = new HBox(familyAlive);
        HBox moneyLeftH = new HBox(moneyLeft);
        HBox inventoryItemsH = new HBox(inventoryItems);
        HBox finalScoreH = new HBox(finalScore);

        timeTakenH.setAlignment(Pos.CENTER);
        animalsKilledH.setAlignment(Pos.CENTER);
        familyAliveH.setAlignment(Pos.CENTER);
        moneyLeftH.setAlignment(Pos.CENTER);
        inventoryItemsH.setAlignment(Pos.CENTER);
        finalScoreH.setAlignment(Pos.CENTER);

        timeTaken.setAlignment(Pos.CENTER);
        animalsKilled.setAlignment(Pos.CENTER);
        familyAlive.setAlignment(Pos.CENTER);
        moneyLeft.setAlignment(Pos.CENTER);
        inventoryItems.setAlignment(Pos.CENTER);
        finalScore.setAlignment(Pos.CENTER);


        newGame.setOnAction(event -> NewGameClearExisiting.startNewGame());
        quit.setOnAction(event -> System.exit(0));

        gridPane.add(timeTakenH, 0, 0);
        gridPane.add(animalsKilledH, 0, 1);
        gridPane.add(familyAliveH, 0, 2);
        gridPane.add(moneyLeftH, 0, 3);
        gridPane.add(inventoryItemsH, 0, 4);
        gridPane.add(finalScoreH, 0, 5);

        newGame.setId("scoreBoardBtn");
        quit.setId("scoreBoardBtn");

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(newGame, quit);
        hBox.setAlignment(Pos.CENTER);

        gridPane.add(hBox, 0, 6);

        Scene scene = new Scene(gridPane, 1200, 800);
        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);
        stage.show();
    }

    private static int getFamilyAlive(){
        int familyNum = 0;
        if(Spouse.isAlive())
            familyNum++;
        if(Child1.isAlive())
            familyNum++;
        if(Child2.isAlive())
            familyNum++;
        if(Child3.isAlive())
            familyNum++;

        return  familyNum;
    }

    private static int getInventory(){
        int num = 0;

        for (ItemInterface item : Inventory.getInventory()) {
            num += item.getQuantity();
        }

        return num;
    }

    //Rough outline of how the final score should go.  Needs refining.
    private static long calcFinalScore(){
        return (Profile.getAnimalsKilled() * 50) + (getFamilyAlive() * 100) + (Math.round(Profile.getMoney()) * 2) +
                (getInventory()) + (10000 - counter);
    }
}
