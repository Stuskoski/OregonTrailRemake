package views.HittingTheTrail;

import CharacterObjects.*;
import items.ItemInterface;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import Start.Main;
import models.Inventory;
import views.HittingTheTrail.TrailObjects.HorseForWagon;
import views.HittingTheTrail.TrailObjects.Wagon;
import views.MiniGames.HuntingGamePackage.HuntingGame;
import views.PostGame.ScoreBoard;

import java.util.Optional;

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
    public static Scene controlScene = new Scene(controlGridPane, 500, 135);
    public static Stage controlPanelStage = new Stage();
    public static Timeline gameTimeline;
    public static Timeline consumeTimelineFast;
    public static Timeline consumeTimelineSlow;
    public static boolean canIstartTimeline = true;

    public static void showControlPane(){
        controlPanelStage.setX(0);//Show the control panel in the upper left corner of screen
        controlPanelStage.setY(0);
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

        rest.setId("mainScreenBtn");
        carryOn.setId("mainScreenBtn");
        goHunt.setId("mainScreenBtn");
        map.setId("mainScreenBtn");
        familyStatus.setId("mainScreenBtn");
        inventory.setId("mainScreenBtn");

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

        /**
         * Timeline that controls when the game ends.
         */
        gameTimeline = new Timeline(new KeyFrame(Duration.millis(1), timelineEvent -> {

        }));
        gameTimeline.setCycleCount(1000000);
        gameTimeline.setOnFinished(event1 -> System.out.println("finished!"));



        /**
         * Two consume timelines.  One for resting and the other for not resting.
         */
        consumeTimelineFast = new Timeline(new KeyFrame(Duration.seconds(5), foodNDrinkEvent -> {
            consumeFood();
            consumeWater();
            Inventory.updateInventoryScreen();
        }));
        consumeTimelineFast.setCycleCount(Animation.INDEFINITE);

        consumeTimelineSlow = new Timeline(new KeyFrame(Duration.seconds(10), foodNDrinkEvent -> {
            consumeFood();
            consumeWater();
            Inventory.updateInventoryScreen();
        }));
        consumeTimelineSlow.setCycleCount(Animation.INDEFINITE);




        rest.setOnAction(restEvent -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Rest Menu");
            alert.setHeaderText("How many days would you like rest for?");
            alert.setContentText("Choose your option.");

            ButtonType buttonTypeOne = new ButtonType("One");
            ButtonType buttonTypeTwo = new ButtonType("Two");
            ButtonType buttonTypeThree = new ButtonType("Three");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){
                TheTrail.gc1.clearRect(Wagon.x, Wagon.y, Wagon.w+HorseForWagon.w+10+(HorseForWagon.x - Wagon.x), Wagon.h+HorseForWagon.h+10);
                TheTrail.animateTimeline.pause();
                gameTimeline.pause();
                consumeTimelineSlow.play();
                consumeTimelineFast.pause();
                TheTrail.gridPane.setId("TheTrailGridPaneRest");
                Timeline restTimeline = new Timeline(new KeyFrame(Duration.millis(1), timelineEvent -> {

                }));
                restTimeline.setCycleCount(3000);
                restTimeline.setOnFinished(event1 -> {
                    carryOn.fire();
                    TheTrail.animateTimeline.play();
                });
                restTimeline.play();
            } else if (result.get() == buttonTypeTwo) {
                TheTrail.gc1.clearRect(Wagon.x, Wagon.y, Wagon.w+HorseForWagon.w+10+(HorseForWagon.x - Wagon.x), Wagon.h+HorseForWagon.h+10);
                TheTrail.animateTimeline.pause();
                gameTimeline.pause();
                consumeTimelineSlow.play();
                consumeTimelineFast.pause();
                TheTrail.gridPane.setId("TheTrailGridPaneRest");
                Timeline restTimeline = new Timeline(new KeyFrame(Duration.millis(1), timelineEvent -> {

                }));
                restTimeline.setCycleCount(6000);
                restTimeline.setOnFinished(event1 -> {
                    carryOn.fire();
                    TheTrail.animateTimeline.play();
                });
                restTimeline.play();
            } else if (result.get() == buttonTypeThree) {
                TheTrail.gc1.clearRect(Wagon.x, Wagon.y, Wagon.w+HorseForWagon.w+10+(HorseForWagon.x - Wagon.x), Wagon.h+HorseForWagon.h+10);
                TheTrail.animateTimeline.pause();
                gameTimeline.pause();
                consumeTimelineSlow.play();
                consumeTimelineFast.pause();
                TheTrail.gridPane.setId("TheTrailGridPaneRest");
                Timeline restTimeline = new Timeline(new KeyFrame(Duration.millis(1), timelineEvent -> {

                }));
                restTimeline.setCycleCount(9000);
                restTimeline.setOnFinished(event1 -> {
                    carryOn.fire();
                    TheTrail.animateTimeline.play();
                });
                restTimeline.play();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        });

        carryOn.setOnAction(carryOnEvent -> {
            if(canIstartTimeline){
                gameTimeline.play();
                consumeTimelineSlow.pause();
                consumeTimelineFast.play();
                TheTrail.gridPane.setId("TheTrailGridPaneMoving");
            }
        });

        goHunt.setOnAction(huntEvent -> {
            canIstartTimeline = false;
            gameTimeline.pause();
            HuntingGame.randomizeHuntScreen(30);
            Main.getPrimaryStage().setScene(HuntingGame.getScene());
        });

        map.setOnAction(mapEvent -> {

        });

        familyStatus.setOnAction(familyEvent -> {
            ScoreBoard.showScoreBoard();
            //Spouse.getStatus() etc...
        });

        inventory.setOnAction(inventoryEvent -> {
            Inventory.updateInventoryScreen();
            Inventory.getInventoryStage().show();
        });

        //When user closes this menu, need a way to make sure they know how to reopen since this is such a crucial menu
        controlPanelStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("For your information");
            alert.setHeaderText(null);
            alert.setContentText("This menu can be reopened by pressing C on the keyboard.");
            alert.showAndWait();
        });
    }

    private static void consumeWater(){
        boolean removeLargeBottleOfWater = false;
        boolean removeSmallBottleOfWater = false;
        int InventoryPos = 0;
        boolean hasSomethingToDrink = false;
        boolean firstConsume = true;

        for(ItemInterface water : Inventory.getInventory()){
            switch (water.getName()){
                case"Large Bottle of Water":{
                    if(firstConsume) {
                        hasSomethingToDrink = true;
                        if (water.getWeight() > 0) {
                            water.setWeight(water.getWeight() - Profile.getThirstReduce());
                        } else {
                            if (water.getQuantity() > 0) {
                                water.setWeight(1.25);
                                water.setQuantity(water.getQuantity() - 1);
                                if (water.getQuantity() <= 0) {
                                    removeLargeBottleOfWater = true;
                                    InventoryPos = Inventory.getInventory().indexOf(water);
                                }
                            }
                        }
                        firstConsume = false;
                    }
                    break;
                }
                case"Small Bottle of Water":{
                    if(firstConsume) {
                        hasSomethingToDrink = true;
                        if (!(water.getWeight() <= 0)) {
                            water.setWeight(water.getWeight() - Profile.getThirstReduce());
                        } else {
                            if (water.getQuantity() > 0) {
                                water.setWeight(0.75);
                                water.setQuantity(water.getQuantity() - 1);
                                if (water.getQuantity() <= 0) {
                                    removeSmallBottleOfWater = true;
                                    InventoryPos = Inventory.getInventory().indexOf(water);
                                }
                            }
                        }
                        firstConsume = false;
                    }
                    break;
                }
            }
        }
        if(removeLargeBottleOfWater){
            Inventory.getInventory().remove(InventoryPos);
            removeLargeBottleOfWater = false;
        }
        if(removeSmallBottleOfWater){
            Inventory.getInventory().remove(InventoryPos);
            removeSmallBottleOfWater = false;
        }

        /**
         * If there is nothing to drink, set that they are thirsty.
         */
        if(!hasSomethingToDrink){
            System.out.println("Out of water");
            Profile.setHealthStatus("Thirsty");

            if(Spouse.isAlive()){
                Spouse.setHealthStatus("Thirsty");
            }
            if(Child1.isAlive()){
                Child1.setHealthStatus("Thirsty");
            }
            if(Child2.isAlive()){
                Child2.setHealthStatus("Thirsty");
            }
            if(Child3.isAlive()){
                Child3.setHealthStatus("Thirsty");
            }

        }
    }
    private static void consumeFood(){
        boolean removeBeefJerky = false;
        boolean removeCampBread = false;
        boolean removeGameMeat = false;
        boolean removeLargeCanOfBeans = false;
        boolean removeTurkeyJerky = false;
        int InventoryPos = 0;
        boolean hasSomethingToEat = false;
        boolean firstConsume = true;

        for(ItemInterface food : Inventory.getInventory()){
            switch (food.getName()){
                case"Beef Jerky":{
                    System.out.println("Jerky");
                    if(firstConsume) {
                        hasSomethingToEat = true;
                        if (food.getWeight() > 0) {
                            food.setWeight(food.getWeight() - Profile.getHungerReduce());
                        } else {
                            if (food.getQuantity() > 0) {
                                food.setWeight(.50);
                                food.setQuantity(food.getQuantity() - 1);
                                if (food.getQuantity() <= 0) {
                                    removeBeefJerky = true;
                                    InventoryPos = Inventory.getInventory().indexOf(food);
                                }
                            }
                        }
                        firstConsume = false;
                    }
                    break;
                }
                case"Camp Bread":{
                    if(firstConsume) {
                        hasSomethingToEat = true;
                        if (!(food.getWeight() <= 0)) {
                            food.setWeight(food.getWeight() - Profile.getHungerReduce());
                        } else {
                            if (food.getQuantity() > 0) {
                                food.setWeight(1.0);
                                food.setQuantity(food.getQuantity() - 1);
                                if (food.getQuantity() <= 0) {
                                    removeCampBread = true;
                                    InventoryPos = Inventory.getInventory().indexOf(food);
                                }
                            }
                        }
                        firstConsume = false;
                    }
                    break;
                }
            }
        }
        if(removeBeefJerky){
            Inventory.getInventory().remove(InventoryPos);
            removeBeefJerky = false;
        }
        if(removeCampBread){
            Inventory.getInventory().remove(InventoryPos);
            removeCampBread = false;
        }

        /**
         * If there is nothing to eat, set that they are hungry/
         */
        if(!hasSomethingToEat){
            System.out.println("Out of food");
            Profile.setHealthStatus("Hungry");

            if(Spouse.isAlive()){
                Spouse.setHealthStatus("Hungry");
            }
            if(Child1.isAlive()){
                Child1.setHealthStatus("Hungry");
            }
            if(Child2.isAlive()){
                Child2.setHealthStatus("Hungry");
            }
            if(Child3.isAlive()){
                Child3.setHealthStatus("Hungry");
            }

        }
    }
    public static Timeline getGameTimeLine(){return gameTimeline;}
    public static boolean getCanIStartTimeline(){return canIstartTimeline;}
    public static void setCanIstartTimeline(boolean setFlag){canIstartTimeline = setFlag;}
}
