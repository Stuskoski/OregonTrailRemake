package views.StaticScenes;

import CharacterObjects.*;
import items.ItemInterface;
import items.meds.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Inventory;

/**
 * Created by augustus on 3/31/16.
 * Create a sub menu for the items
 * passed in.  Window pops up when
 * you click on the item in your
 * inventory
 */
public class InventoryItemAction {
    public static void showActionMenu(ItemInterface item, double screenX, double screenY){
        VBox vBox = new VBox(3);
        Scene scene = new Scene(vBox, 150, 95);
        Stage stage = new Stage();
        final Timeline[] timeline = new Timeline[1];
        timeline[0] = new Timeline();

        vBox.setAlignment(Pos.CENTER);

        Button useOnCharacter = new Button("Use on a character");
        Button delete = new Button("Delete Item");

        useOnCharacter.setPrefWidth(145);
        delete.setPrefWidth(145);

        useOnCharacter.setId("mainScreenBtn");
        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");

        if(!item.getCategory().equals("meds"))
            useOnCharacter.setDisable(true);


        //Action listeners.
        //After 1 sec, close the window.  Else restart the timer. Beautiful.
        scene.setOnMouseExited(event -> {
            timeline[0] = new Timeline(new KeyFrame(Duration.seconds(1), event2 -> {
            }));
            timeline[0].setCycleCount(1);
            timeline[0].play();
            timeline[0].setOnFinished(event1 -> {
                stage.close();
            });
        });

        scene.setOnMouseEntered(event1 -> timeline[0].stop());

        delete.setOnAction(event -> showDelMenu(item, screenX, screenY));
        useOnCharacter.setOnAction(event -> showUseMenu(item, screenX, screenY));

        vBox.getChildren().addAll(useOnCharacter, delete);

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.show();

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
    }
    private static void showUseMenu(ItemInterface item, double screenX, double screenY){


        VBox vBox = new VBox(5);
        Scene scene = new Scene(vBox, 325, 225);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Button profileUse = new Button("Use on yourself");
        profileUse.setPrefWidth(300);
        profileUse.setId("mainScreenBtn");
        vBox.getChildren().add(profileUse);
        profileUse.setOnAction(event -> {
            useMedItem(item, "Profile");
        });

        if(Spouse.isAlive()){
            Button spouseUse = new Button("Use on " + Spouse.getName() + " (Spouse)");
            spouseUse.setPrefWidth(300);
            spouseUse.setId("mainScreenBtn");
            vBox.getChildren().add(spouseUse);
            spouseUse.setOnAction(event -> {
                useMedItem(item, "Spouse");
            });
        }
        if(Child1.isAlive()){
            Button child1Use = new Button("Use on " + Child1.getName() + " (Child1)");
            child1Use.setPrefWidth(300);
            child1Use.setId("mainScreenBtn");
            vBox.getChildren().add(child1Use);
            child1Use.setOnAction(event -> {
                useMedItem(item, "Child1");
            });
        }
        if(Child2.isAlive()){
            Button child2Use = new Button("Use on " + Child2.getName() + " (Child2)");
            child2Use.setPrefWidth(300);
            child2Use.setId("mainScreenBtn");
            vBox.getChildren().add(child2Use);
            child2Use.setOnAction(event -> {
                useMedItem(item, "Child2");
            });
        }
        if(Child3.isAlive()){
            Button child3Use = new Button("Use on " + Child3.getName() + " (Child3)");
            child3Use.setPrefWidth(300);
            child3Use.setId("mainScreenBtn");
            vBox.getChildren().add(child3Use);
            child3Use.setOnAction(event -> {
                useMedItem(item, "Child3");
            });
        }

        vBox.setId("actionMenuScreen");


        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
        stage.setTitle("Use Item");

        stage.show();




    }

    private static void useMedItem(ItemInterface item, String profile) {
        switch (profile){
            case "Profile":
                switch (item.getName()){
                    case "Antibiotics":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Syphilis")){
                            Profile.removeHealthStatusWithChecks(new Antibiotics(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("Antibiotics have cured your Syphilis", "green");
                        }
                        break;
                    case "Cough Medicine":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Small Pox")){
                            Profile.removeHealthStatusWithChecks("Small Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured your Small Pox.", "green");
                        }
                        if(Profile.returnHealthStatusAsString().contains("Chicken Pox")){
                            Profile.removeHealthStatusWithChecks("Chicken Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured your Chicken Pox.", "green");
                        }
                        break;
                    case "Ipecac":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Cursed")){
                            Profile.removeHealthStatusWithChecks(new Ipecac(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("You have thrown up some black stuff...gross", "green");
                        }
                        break;
                    case "Large Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Broken Bone")){
                            Profile.removeHealthStatusWithChecks(new LargeBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The large bandage has healed your broken leg.", "green");
                        }
                        break;
                    case "Small Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Herpes")){
                            Profile.removeHealthStatusWithChecks(new SmallBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The small bandage has healed your herp derp.", "green");
                        }

                        break;
                    case "Pain Killers":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Broken Bone")){
                            Profile.removeHealthStatusWithChecks(new PainKillers(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The pain killers have healed your broken leg.", "green");
                        }
                        break;
                    case "Splint":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Profile.returnHealthStatusAsString().contains("Broken Bone")){
                            Profile.removeHealthStatusWithChecks(new Splint(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The split has set your broken leg.", "green");
                        }
                        break;
                }
                break;
            case "Spouse":
                switch (item.getName()){
                    case "Antibiotics":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Syphilis")){
                            Spouse.removeHealthStatusWithChecks(new Antibiotics(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("Antibiotics have cured Syphilis for " + Spouse.getName()+".", "green");
                        }
                        break;
                    case "Cough Medicine":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Small Pox")){
                            Spouse.removeHealthStatusWithChecks("Small Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Small Pox for " + Spouse.getName()+".", "green");
                        }
                        if(Spouse.returnHealthStatusAsString().contains("Chicken Pox")){
                            Spouse.removeHealthStatusWithChecks("Chicken Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Chicken Pox for" + Spouse.getName()+".", "green");
                        }
                        break;
                    case "Ipecac":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Cursed")){
                            Spouse.removeHealthStatusWithChecks(new Ipecac(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane(Spouse.getName() + " has thrown up some black stuff...gross", "green");
                        }
                        break;
                    case "Large Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Broken Bone")){
                            Spouse.removeHealthStatusWithChecks(new LargeBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The large bandage has healed the broken leg for " + Spouse.getName()+".", "green");
                        }
                        break;
                    case "Small Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Herpes")){
                            Spouse.removeHealthStatusWithChecks(new SmallBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The small bandage has healed the herp derp for " + Spouse.getName()+".", "green");
                        }

                        break;
                    case "Pain Killers":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Broken Bone")){
                            Spouse.removeHealthStatusWithChecks(new PainKillers(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The pain killers have healed the broken leg for " + Spouse.getName()+".", "green");
                        }
                        break;
                    case "Splint":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Spouse.returnHealthStatusAsString().contains("Broken Bone")){
                            Spouse.removeHealthStatusWithChecks(new Splint(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The split has set the broken leg for " + Spouse.getName()+".", "green");
                        }
                        break;
                }
                break;
            case "Child1":
                switch (item.getName()){
                    case "Antibiotics":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Syphilis")){
                            Child1.removeHealthStatusWithChecks(new Antibiotics(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("Antibiotics have cured Syphilis for " + Child1.getName()+".", "green");
                        }
                        break;
                    case "Cough Medicine":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Small Pox")){
                            Child1.removeHealthStatusWithChecks("Small Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Small Pox for " + Child1.getName()+".", "green");
                        }
                        if(Child1.returnHealthStatusAsString().contains("Chicken Pox")){
                            Child1.removeHealthStatusWithChecks("Chicken Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Chicken Pox for" + Child1.getName()+".", "green");
                        }
                        break;
                    case "Ipecac":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Cursed")){
                            Child1.removeHealthStatusWithChecks(new Ipecac(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane(Child1.getName() + " has thrown up some black stuff...gross", "green");
                        }
                        break;
                    case "Large Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Broken Bone")){
                            Child1.removeHealthStatusWithChecks(new LargeBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The large bandage has healed the broken leg for " + Child1.getName()+".", "green");
                        }
                        break;
                    case "Small Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Herpes")){
                            Child1.removeHealthStatusWithChecks(new SmallBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The small bandage has healed the herp derp for " + Child1.getName()+".", "green");
                        }

                        break;
                    case "Pain Killers":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Broken Bone")){
                            Child1.removeHealthStatusWithChecks(new PainKillers(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The pain killers have healed the broken leg for " + Child1.getName()+".", "green");
                        }
                        break;
                    case "Splint":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child1.returnHealthStatusAsString().contains("Broken Bone")){
                            Child1.removeHealthStatusWithChecks(new Splint(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The split has set the broken leg for " + Child1.getName()+".", "green");
                        }
                        break;
                }
                break;
            case "Child2":
                switch (item.getName()){
                    case "Antibiotics":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Syphilis")){
                            Child2.removeHealthStatusWithChecks(new Antibiotics(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("Antibiotics have cured Syphilis for " + Child2.getName()+".", "green");
                        }
                        break;
                    case "Cough Medicine":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Small Pox")){
                            Child2.removeHealthStatusWithChecks("Small Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Small Pox for " + Child2.getName()+".", "green");
                        }
                        if(Child2.returnHealthStatusAsString().contains("Chicken Pox")){
                            Child2.removeHealthStatusWithChecks("Chicken Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Chicken Pox for" + Child2.getName()+".", "green");
                        }
                        break;
                    case "Ipecac":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Cursed")){
                            Child2.removeHealthStatusWithChecks(new Ipecac(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane(Child2.getName() + " has thrown up some black stuff...gross", "green");
                        }
                        break;
                    case "Large Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Broken Bone")){
                            Child2.removeHealthStatusWithChecks(new LargeBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The large bandage has healed the broken leg for " + Child2.getName()+".", "green");
                        }
                        break;
                    case "Small Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Herpes")){
                            Child2.removeHealthStatusWithChecks(new SmallBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The small bandage has healed the herp derp for " + Child2.getName()+".", "green");
                        }

                        break;
                    case "Pain Killers":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Broken Bone")){
                            Child2.removeHealthStatusWithChecks(new PainKillers(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The pain killers have healed the broken leg for " + Child2.getName()+".", "green");
                        }
                        break;
                    case "Splint":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child2.returnHealthStatusAsString().contains("Broken Bone")){
                            Child2.removeHealthStatusWithChecks(new Splint(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The split has set the broken leg for " + Child2.getName()+".", "green");
                        }
                        break;
                }
                break;
            case "Child3":
                switch (item.getName()){
                    case "Antibiotics":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Syphilis")){
                            Child3.removeHealthStatusWithChecks(new Antibiotics(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("Antibiotics have cured Syphilis for " + Child3.getName()+".", "green");
                        }
                        break;
                    case "Cough Medicine":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Small Pox")){
                            Child3.removeHealthStatusWithChecks("Small Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Small Pox for " + Child3.getName()+".", "green");
                        }
                        if(Child3.returnHealthStatusAsString().contains("Chicken Pox")){
                            Child3.removeHealthStatusWithChecks("Chicken Pox");
                            TimeLineStatusPage.addMessageToPane("Cough Medicine has cured Chicken Pox for" + Child3.getName()+".", "green");
                        }
                        break;
                    case "Ipecac":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Cursed")){
                            Child3.removeHealthStatusWithChecks(new Ipecac(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane(Child3.getName() + " has thrown up some black stuff...gross", "green");
                        }
                        break;
                    case "Large Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Broken Bone")){
                            Child3.removeHealthStatusWithChecks(new LargeBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The large bandage has healed the broken leg for " + Child3.getName()+".", "green");
                        }
                        break;
                    case "Small Bandage":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Herpes")){
                            Child3.removeHealthStatusWithChecks(new SmallBandage(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The small bandage has healed the herp derp for " + Child3.getName()+".", "green");
                        }

                        break;
                    case "Pain Killers":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Broken Bone")){
                            Child3.removeHealthStatusWithChecks(new PainKillers(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The pain killers have healed the broken leg for " + Child3.getName()+".", "green");
                        }
                        break;
                    case "Splint":
                        if(item.getQuantity() == 1){
                            Inventory.getInventory().remove(item);
                        }else{
                            item.setQuantity(item.getQuantity() - 1);
                        }

                        Inventory.updateInventoryScreen();

                        if(Child3.returnHealthStatusAsString().contains("Broken Bone")){
                            Child3.removeHealthStatusWithChecks(new Splint(0).diseaseHealed());
                            TimeLineStatusPage.addMessageToPane("The split has set the broken leg for " + Child3.getName()+".", "green");
                        }
                        break;
                }
                break;
        }
    }

    private static void showDelMenu(ItemInterface item, double screenX, double screenY){
        VBox vBox = new VBox(3);
        Scene scene = new Scene(vBox, 185, 95);
        Stage stage = new Stage();

        vBox.setAlignment(Pos.CENTER);

        Label delLabel = new Label("Number to delete:");
        delLabel.setId("inventoryItemLabel");

        Button delete = new Button("Delete");

        delete.setPrefWidth(100);

        delete.setId("mainScreenBtn");
        vBox.setId("actionMenuScreen");

        if(item.getName().equals("Game Meat")){ //special case for game meat since it goes by weight not quantity
            ComboBox<Double> comboBox = new ComboBox<>();
            comboBox.setPromptText("Select amount");
            for(double i = 1.00; i<=item.getWeight(); i++){
                comboBox.getItems().add(i);
            }
            comboBox.getItems().add(item.getWeight());

            delete.setOnAction(event -> {
                if(comboBox.getValue() != null){
                    delItemSpecialCaseForMeat(item, comboBox.getValue());
                    stage.close();
                }
            });
            vBox.getChildren().addAll(delLabel, comboBox, delete);

        }else{ //every other item
            ComboBox<Integer> comboBox = new ComboBox<>();
            comboBox.setPromptText("Select amount");
            for(int i = 1; i<=item.getQuantity(); i++){
                comboBox.getItems().add(i);
            }

            delete.setOnAction(event -> {
                if(comboBox.getValue() != null){
                    delItem(item, comboBox.getValue());
                    stage.close();
                }
            });
            vBox.getChildren().addAll(delLabel, comboBox, delete);
        }

        scene.getStylesheets().add("resources/main.css");

        stage.setScene(scene);

        stage.setResizable(false);
        stage.setX(screenX-50);
        stage.setY(screenY-50);
        stage.setTitle("Delete Item");

        stage.show();
    }

    private static void delItem(ItemInterface item, int number){
        if(item.getQuantity() == number){
            Inventory.getInventory().remove(item);
        }else{
            item.setQuantity(item.getQuantity()-number);
        }
        Inventory.updateInventoryScreen();
    }

    private static void delItemSpecialCaseForMeat(ItemInterface item, double number){
        if(item.getWeight() == number){
            Inventory.getInventory().remove(item);
        }else{
            item.setWeight(item.getWeight()-number);
        }
        Inventory.updateInventoryScreen();
    }
}
