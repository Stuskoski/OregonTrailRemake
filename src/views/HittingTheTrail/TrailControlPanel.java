package views.HittingTheTrail;

import CharacterObjects.*;
import items.ItemInterface;
import items.food.LargeBottleofWater;
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
import models.CalculateDeathChancePerTurn;
import models.CalculateRandomChanceForHealth;
import models.Inventory;
import views.HittingTheTrail.TrailObjects.HorseForWagon;
import views.HittingTheTrail.TrailObjects.Wagon;
import views.MiniGames.HuntingGamePackage.HuntingGame;
import views.PostGame.ScoreBoard;
import views.StaticScenes.FamilyStatus;
import views.StaticScenes.TimeLineStatusPage;

import java.sql.Time;
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
    public static Scene controlScene = new Scene(controlGridPane, 600, 135);
    public static Stage controlPanelStage = new Stage();
    public static Timeline gameTimeline;
    public static Timeline consumeTimelineFast;
    public static Timeline consumeTimelineSlow;
    public static boolean canIstartTimeline = true;
    public static Button carryOn;
    public static Button rest;
    public static int counterForMap = 0;

    public static void showControlPane(){
        controlPanelStage.setX(0);//Show the control panel in the upper left corner of screen
        controlPanelStage.setY(0);
        controlPanelStage.setScene(controlScene);
        controlPanelStage.setResizable(true);
        controlPanelStage.show();

        controlGridPane.setId("controlPanelGrid");
        controlScene.getStylesheets().add("resources/main.css");

        rest = new Button("Rest");
        carryOn = new Button("Carry On");
        Button goHunt = new Button("Go Hunting");
        Button map = new Button("Map");
        Button familyStatus = new Button("Family Status");
        Button inventory = new Button("Inventory");
        Button timeLine = new Button("TimeLine");

        rest.setPrefWidth(125);
        carryOn.setPrefWidth(125);
        goHunt.setPrefWidth(125);
        map.setPrefWidth(125);
        familyStatus.setPrefWidth(125);
        inventory.setPrefWidth(125);
        timeLine.setPrefWidth(125);

        rest.setId("mainScreenBtn");
        carryOn.setId("mainScreenBtn");
        goHunt.setId("mainScreenBtn");
        map.setId("mainScreenBtn");
        familyStatus.setId("mainScreenBtn");
        inventory.setId("mainScreenBtn");
        timeLine.setId("mainScreenBtn");

        controlGridPane.setAlignment(Pos.CENTER);
        controlGridPane.setHgap(1);
        controlGridPane.setVgap(1);
        controlGridPane.setPadding(new Insets(20, 20, 20, 20));

        controlGridPane.add(carryOn, 10, 5);
        controlGridPane.add(rest, 5, 5); //7 7
        controlGridPane.add(timeLine, 7, 7);
        controlGridPane.add(map, 0, 15);
        controlGridPane.add(inventory, 0, 0);
        controlGridPane.add(goHunt, 15, 0);
        controlGridPane.add(familyStatus, 15, 15);

        /**
         * Timeline that controls when the game ends.
         */
        gameTimeline = new Timeline(new KeyFrame(Duration.millis(5000), timelineEvent -> {
            CalculateDeathChancePerTurn.CalculateDeaths();//Every 5 seconds is considered a turn.
            CalculateRandomChanceForHealth.checkLifeAndThenCalc();
            CalculateRandomChanceForHealth.checkForAddingDyingStatus();
            counterForMap++;
            System.out.println(((double)counterForMap/(double)gameTimeline.getCycleCount())*100);
            TimeLineStatusPage.addMessageToPane(String.format("%.2f", (((double)counterForMap/(double)gameTimeline.getCycleCount())*100.00))+"% done");
        }));
        gameTimeline.setCycleCount(200);
        gameTimeline.setOnFinished(event1 -> ScoreBoard.showScoreBoard());



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
                CalculateRandomChanceForHealth.statusRemoveTimeline.play();
            }
        });

        goHunt.setOnAction(huntEvent -> {
            canIstartTimeline = false;
            gameTimeline.pause();
            consumeTimelineFast.pause();
            consumeTimelineSlow.pause();
            HuntingGame.randomizeHuntScreen(30);
            Main.getPrimaryStage().setScene(HuntingGame.getScene());
            CalculateRandomChanceForHealth.statusRemoveTimeline.pause();
        });

        map.setOnAction(mapEvent -> {

        });

        familyStatus.setOnAction(familyEvent -> {
            FamilyStatus.showFamilyStatus();
            if(!FamilyStatus.stage.isShowing()){
                FamilyStatus.stage.show();
            }
        });

        inventory.setOnAction(inventoryEvent -> {
            Inventory.updateInventoryScreen();
            Inventory.getInventoryStage().show();
        });

        timeLine.setOnAction(event1 -> {
            TimeLineStatusPage.showTimeLineStatusPage();
        });

        //When user closes this menu, need a way to make sure they know how to reopen since this is such a crucial menu
        controlPanelStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("For your information");
            alert.setHeaderText(null);
            alert.setContentText("This menu can be reopened by pressing C on the keyboard.");
            alert.showAndWait();
        });

        gameTimeline.play();
        //consumeTimelineSlow.pause();
        consumeTimelineFast.play();
        //TheTrail.gridPane.setId("TheTrailGridPaneMoving");
        CalculateRandomChanceForHealth.constantChecker();
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
            TimeLineStatusPage.addMessageToPane("Out of water");
            System.out.println("Out of water");
           // Profile.setHealthStatus("Thirsty");

            Profile.addHealthStatusWithChecks("Thirsty");
            if(Spouse.isAlive()){
                Spouse.addHealthStatusWithChecks("Thirsty");
            }
            if(Child1.isAlive()){
                Child1.addHealthStatusWithChecks("Thirsty");
            }
            if(Child2.isAlive()){
                Child2.addHealthStatusWithChecks("Thirsty");
            }
            if(Child3.isAlive()){
                Child3.addHealthStatusWithChecks("Thirsty");
            }
            FamilyStatus.showFamilyStatus();
        }else{
            Profile.hashSet.remove("Thirsty");
            if(Spouse.isAlive()){
                Spouse.hashSet.remove("Thirsty");
            }
            if(Child1.isAlive()){
                Child1.hashSet.remove("Thirsty");
            }
            if(Child2.isAlive()){
                Child2.hashSet.remove("Thirsty");
            }
            if(Child3.isAlive()){
                Child3.hashSet.remove("Thirsty");
            }
            FamilyStatus.showFamilyStatus();
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
            TimeLineStatusPage.addMessageToPane("Out of food");
            System.out.println("Out of food");
           // Profile.setHealthStatus("Hungry");

            Profile.addHealthStatusWithChecks("Hungry");
            if(Spouse.isAlive()){
                Spouse.addHealthStatusWithChecks("Hungry");
            }
            if(Child1.isAlive()){
                Child1.addHealthStatusWithChecks("Hungry");
            }
            if(Child2.isAlive()){
                Child2.addHealthStatusWithChecks("Hungry");
            }
            if(Child3.isAlive()){
                Child3.addHealthStatusWithChecks("Hungry");
            }
            FamilyStatus.showFamilyStatus();
        }else{
            Profile.hashSet.remove("Hungry");
            if(Spouse.isAlive()){
                Spouse.hashSet.remove("Hungry");
            }
            if(Child1.isAlive()){
                Child1.hashSet.remove("Hungry");
            }
            if(Child2.isAlive()){
                Child2.hashSet.remove("Hungry");
            }
            if(Child3.isAlive()){
                Child3.hashSet.remove("Hungry");
            }
            FamilyStatus.showFamilyStatus();
        }
    }
    public static Timeline getGameTimeLine(){return gameTimeline;}
    public static boolean getCanIStartTimeline(){return canIstartTimeline;}
    public static void setCanIstartTimeline(boolean setFlag){canIstartTimeline = setFlag;}
}
