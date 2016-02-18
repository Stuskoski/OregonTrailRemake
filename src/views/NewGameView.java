package views;

import Characters.*;
import CustomClasses.ProgressIndicatorBar;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import main.Main;
import models.InstantiateProfile;

import java.util.ArrayList;

/**
 * Created by augustus on 2/13/16.
 * This is the New Game View.  This
 * scene will display all the options
 * for a new game.  The player will
 * choose all their character options
 * and then proceed to a new scene
 * in which the game starts.
 */
public class NewGameView {
    private static Scene newGameScene;


    public static void createNewGameView(){
        double height, width;
        final double statMax25 = 25.0;
        final double cashMax1000 = 1000;
        final double carryMax150 = 150;
        final double healthMax120 = 120;
        final double consumeMax1 = 1;
        final String WORK_DONE_LABEL_FORMAT = "%.2f";
        final ReadOnlyDoubleWrapper strengthWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper luckWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper smartWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper agilityWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper perceptionWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper enduranceWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper moneyWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper carryWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper healthWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper thirstWrapper = new ReadOnlyDoubleWrapper();
        final ReadOnlyDoubleWrapper hungerWrapper = new ReadOnlyDoubleWrapper();
        boolean creatCharBtnHit;

        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        Label title = new Label("Create A Character");
        title.setStyle("-fx-font-size: 24;-fx-font-weight: bold;");
        HBox hBox = new HBox(title);
        VBox vBox = new VBox(10);
        TextArea characterDescriptionArea = new TextArea();

        hBox.setAlignment(Pos.CENTER);
        gridPane.setHgap(40);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label characterLabel = new Label("Select A Character");
        characterLabel.setId("boldText");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Select Character Type");
        comboBox.getItems().addAll("Banker", "Genius", "Hunter", "Jack of All Trades", "Lucky MF", "Survivalist");
        gridPane.add(characterLabel, 0, 1);
        gridPane.add(comboBox, 1, 1);

        Label name1Label = new Label("Your Name");
        name1Label.setId("boldText");
        TextField name1Field = new TextField();
        name1Field.setPromptText("Your Name");
        gridPane.add(name1Label, 0, 4);
        gridPane.add(name1Field, 1, 4);

        Label name2Label = new Label("Spouse's Name");
        name2Label.setId("boldText");
        TextField name2Field = new TextField();
        name2Field.setPromptText("Wife's Name");
        gridPane.add(name2Label, 0, 5);
        gridPane.add(name2Field, 1, 5);

        Label name3Label = new Label("Child One's Name");
        name3Label.setId("boldText");
        TextField name3Field = new TextField();
        name3Field.setPromptText("Child One's Name");
        gridPane.add(name3Label, 0, 6);
        gridPane.add(name3Field, 1, 6);

        Label name4Label = new Label("Child Two's Name");
        name4Label.setId("boldText");
        TextField name4Field = new TextField();
        name4Field.setPromptText("Child Two's Name");
        gridPane.add(name4Label, 0, 7);
        gridPane.add(name4Field, 1, 7);

        Label name5Label = new Label("Child Three's Name");
        name5Label.setId("boldText");
        TextField name5Field = new TextField();
        name5Field.setPromptText("Child Three's Name");
        gridPane.add(name5Label, 0, 8);
        gridPane.add(name5Field, 1, 8);

        characterDescriptionArea.setPrefWidth(350);
        characterDescriptionArea.setStyle("-fx-border-radius: 10 10 10 10; -fx-border-insets: -6 -9 -8 -8;");
        characterDescriptionArea.setEditable(false);
        HBox charDescriptionLabelHbox = new HBox();
        Label characterDescriptionLabel = new Label("Character Description");
        characterDescriptionLabel.setId("boldText");
        charDescriptionLabelHbox.setAlignment(Pos.CENTER);
        charDescriptionLabelHbox.getChildren().add(characterDescriptionLabel);
        characterDescriptionArea.setTooltip(new Tooltip("Description of the selected character"));
        vBox.getChildren().addAll(charDescriptionLabelHbox, characterDescriptionArea);
        gridPane.add(vBox, 2, 1);

        HBox createCharHbox = new HBox();
        Button createCharBtn = new Button("Create Character");
        createCharBtn.setId("mainScreenBtn");
        createCharBtn.setTooltip(new Tooltip("Submit Character Creation"));
        createCharHbox.getChildren().add(createCharBtn);
        createCharHbox.setAlignment(Pos.CENTER);
        createCharHbox.setPadding(new Insets(25,0,25,0));
        borderPane.setBottom(createCharHbox);

        Button backBtn = new Button("Back");
        backBtn.setId("mainScreenBtn");

        gridPane.add(backBtn, 0, 0);

       // gridPane.setGridLinesVisible(true);

        HBox charStatsHbox = new HBox();
        Label charStatsLabel = new Label("Character Stats");
        charStatsLabel.setId("boldText");
        charStatsHbox.getChildren().add(charStatsLabel);
        charStatsHbox.setAlignment(Pos.CENTER);

        HBox strengthHbox = new HBox(10);
        HBox luckHbox = new HBox(10);
        HBox smartsHbox = new HBox(10);
        HBox agilityHbox = new HBox(10);
        HBox perceptionHbox = new HBox(10);
        HBox enduranceHbox = new HBox(10);
        HBox moneyHbox = new HBox(10);
        HBox carryHbox = new HBox(10);
        HBox healthHbox = new HBox(10);
        HBox thirstHbox = new HBox(10);
        HBox hungerHbox = new HBox(10);

        Label strengthLabel = new Label("Strength:\t\t\t");
        strengthLabel.setId("boldText");
        Label luckLabel = new Label("Luck:\t\t\t");
        luckLabel.setId("boldText");
        Label smartsLabel = new Label("Smarts:\t\t\t");
        smartsLabel.setId("boldText");
        Label agilityLabel = new Label("Agility:\t\t\t");
        agilityLabel.setId("boldText");
        Label perceptionLabel = new Label("Perception:\t\t");
        perceptionLabel.setId("boldText");
        Label enduranceLabel = new Label("Endurance:\t\t");
        enduranceLabel.setId("boldText");
        Label startingMoneyLabel = new Label("Starting Money:\t");
        startingMoneyLabel.setId("boldText");
        Label carryingCapacityLabel = new Label("Carrying Capacity:\t");
        carryingCapacityLabel.setId("boldText");
        Label healthLabel = new Label("Health:\t\t\t");
        healthLabel.setId("boldText");
        Label thirstLabel = new Label("Thirst:\t\t\t");
        thirstLabel.setId("boldText");
        Label hungerLabel = new Label("Hunger:\t\t\t");
        hungerLabel.setId("boldText");

        final ProgressIndicatorBar strBar = new ProgressIndicatorBar(
                strengthWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar luckBar = new ProgressIndicatorBar(
                luckWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar agilityBar = new ProgressIndicatorBar(
                agilityWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar smartsBar = new ProgressIndicatorBar(
                smartWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar perceptionBar = new ProgressIndicatorBar(
                perceptionWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar enduranceBar = new ProgressIndicatorBar(
                enduranceWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar moneyBar = new ProgressIndicatorBar(
                moneyWrapper.getReadOnlyProperty(),
                cashMax1000,
                WORK_DONE_LABEL_FORMAT,
                true
        );
        final ProgressIndicatorBar carryBar = new ProgressIndicatorBar(
                carryWrapper.getReadOnlyProperty(),
                carryMax150,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar healthBar = new ProgressIndicatorBar(
                healthWrapper.getReadOnlyProperty(),
                healthMax120,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar thirstBar = new ProgressIndicatorBar(
                thirstWrapper.getReadOnlyProperty(),
                consumeMax1,
                WORK_DONE_LABEL_FORMAT,
                false
        );
        final ProgressIndicatorBar hungerBar = new ProgressIndicatorBar(
                hungerWrapper.getReadOnlyProperty(),
                consumeMax1,
                WORK_DONE_LABEL_FORMAT,
                false
        );

        strengthHbox.getChildren().addAll(strengthLabel, strBar);
        luckHbox.getChildren().addAll(luckLabel, luckBar);
        smartsHbox.getChildren().addAll(smartsLabel, smartsBar);
        agilityHbox.getChildren().addAll(agilityLabel, agilityBar);
        perceptionHbox.getChildren().addAll(perceptionLabel, perceptionBar);
        enduranceHbox.getChildren().addAll(enduranceLabel, enduranceBar);
        moneyHbox.getChildren().addAll(startingMoneyLabel, moneyBar);
        carryHbox.getChildren().addAll(carryingCapacityLabel, carryBar);
        healthHbox.getChildren().addAll(healthLabel, healthBar);
        thirstHbox.getChildren().addAll(thirstLabel, thirstBar);
        hungerHbox.getChildren().addAll(hungerLabel, hungerBar);


        VBox charStatsVbox = new VBox(1);
        charStatsVbox.getChildren().addAll(charStatsHbox,strengthHbox,luckHbox,smartsHbox,agilityHbox,perceptionHbox,enduranceHbox,moneyHbox,carryHbox,healthHbox,thirstHbox,hungerHbox);
        gridPane.add(charStatsVbox, 2, 3, 1, 10);

        borderPane.setCenter(gridPane);
        borderPane.setTop(hBox);

        comboBox.setOnAction(event -> {
            getCharacterDescription(comboBox.getValue(), characterDescriptionArea, strengthWrapper,
                    luckWrapper, smartWrapper, agilityWrapper, perceptionWrapper, enduranceWrapper, moneyWrapper, carryWrapper,
                    healthWrapper, thirstWrapper, hungerWrapper);
            comboBox.setStyle("-fx-border-color: none");
        });

        /**
         * Action listener to check for empty fields.
         * Only enable red outlining of TextFields if
         * the create char button has been tried once.
         */
        createCharBtn.setOnAction(event -> {
            //Adds or removes red outlines for empty/non-empty fields
            name1Field.setOnKeyReleased(event1 -> {
                if (name1Field.getText().length() > 0) {
                    name1Field.setStyle("-fx-border-color: none");
                } else {
                    name1Field.setStyle("-fx-border-color: red");
                }
            });
            name2Field.setOnKeyReleased(event1 -> {
                if (name2Field.getText().length() > 0) {
                    name2Field.setStyle("-fx-border-color: none");
                } else {
                    name2Field.setStyle("-fx-border-color: red");
                }
            });
            name3Field.setOnKeyReleased(event1 -> {
                if (name3Field.getText().length() > 0) {
                    name3Field.setStyle("-fx-border-color: none");
                } else {
                    name3Field.setStyle("-fx-border-color: red");
                }
            });
            name4Field.setOnKeyReleased(event1 -> {
                if (name4Field.getText().length() > 0) {
                    name4Field.setStyle("-fx-border-color: none");
                } else {
                    name4Field.setStyle("-fx-border-color: red");
                }
            });
            name5Field.setOnKeyReleased(event1 -> {
                if (name5Field.getText().length() > 0) {
                    name5Field.setStyle("-fx-border-color: none");
                } else {
                    name5Field.setStyle("-fx-border-color: red");
                }
            });

            Boolean flag = true;
            ArrayList<String> errorList = new ArrayList<>();
            comboBox.setStyle("-fx-border-color: none");
            name1Field.setStyle("-fx-border-color: none");
            name2Field.setStyle("-fx-border-color: none");
            name3Field.setStyle("-fx-border-color: none");
            name4Field.setStyle("-fx-border-color: none");
            name5Field.setStyle("-fx-border-color: none");
            if(comboBox.getValue() == null){
                flag = false;
                errorList.add("Character Type");
                comboBox.setStyle("-fx-border-color: red");
            }
            if(name1Field.getText().length() == 0){
                flag = false;
                errorList.add("Your Name");
                name1Field.setStyle("-fx-border-color: red");

            }
            if(name2Field.getText().length() == 0){
                flag = false;
                errorList.add("Spouse's Name");
                name2Field.setStyle("-fx-border-color: red");
            }
            if(name3Field.getText().length() == 0){
                flag = false;
                errorList.add("Child One's Name");
                name3Field.setStyle("-fx-border-color: red");
            }
            if(name4Field.getText().length() == 0){
                flag = false;
                errorList.add("Child Two's Name");
                name4Field.setStyle("-fx-border-color: red");
            }
            if(name5Field.getText().length() == 0){
                flag = false;
                errorList.add("Child Three's Name");
                name5Field.setStyle("-fx-border-color: red");
            }

            if(flag) {
                createCharacter(name1Field.getText(), name2Field.getText(), name3Field.getText(),
                        name4Field.getText(), name5Field.getText(), comboBox.getValue());
            }else{
                String errorStr = "";
                for (String str: errorList) {
                    errorStr += str + "\n";
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Character Creation Error");
                alert.setContentText("The following fields are empty:\n" + errorStr);
                alert.setHeaderText(null);
                alert.showAndWait();
                errorList.clear();
            }
        });

        //Back button to go back to home screen.
        //Need testing to see if Garbage collector will clear home scene and leave you with a null scene.
        backBtn.setOnAction(event -> Main.getPrimaryStage().setScene(MainScreenView.getLoginScene()));
        //need to add code for removing existing profile characteristics...maybe(should go to next screen if button hit not back)


        //Get the width and height from the previous scene.
        height = Main.getPrimaryStage().getScene().getHeight();
        width = Main.getPrimaryStage().getScene().getWidth();

        borderPane.setId("newGameScreen");

        Scene newScene = new Scene(borderPane, width, height);

        newScene.getStylesheets().add("resources/main.css");

        Main.getPrimaryStage().setScene(newScene);

    }

    private static void getCharacterDescription(String character, TextArea textArea, ReadOnlyDoubleWrapper strength,
                                                ReadOnlyDoubleWrapper luck, ReadOnlyDoubleWrapper smarts,
                                                ReadOnlyDoubleWrapper agility, ReadOnlyDoubleWrapper perception,
                                                ReadOnlyDoubleWrapper endurance, ReadOnlyDoubleWrapper money,
                                                ReadOnlyDoubleWrapper carry, ReadOnlyDoubleWrapper health,
                                                ReadOnlyDoubleWrapper thirst, ReadOnlyDoubleWrapper hunger){
        switch (character) {
            case "Banker":{
                Banker banker = new Banker();
                textArea.setText(banker.getDescription());
                strength.setValue(banker.getStrength());
                luck.setValue(banker.getLuck());
                smarts.setValue(banker.getSmarts());
                agility.setValue(banker.getAgility());
                perception.setValue(banker.getPerception());
                endurance.setValue(banker.getEndurance());
                money.setValue(banker.getStartingMoney());
                carry.setValue(banker.getCarryingCapacity());
                health.setValue(banker.getHealth());
                thirst.setValue(banker.getThirstConsume());
                hunger.setValue(banker.getHungerConsume());
                break;
            }
            case "Genius":{
                Genius genius = new Genius();
                textArea.setText(genius.getDescription());
                strength.setValue(genius.getStrength());
                luck.setValue(genius.getLuck());
                smarts.setValue(genius.getSmarts());
                agility.setValue(genius.getAgility());
                perception.setValue(genius.getPerception());
                endurance.setValue(genius.getEndurance());
                money.setValue(genius.getStartingMoney());
                carry.setValue(genius.getCarryingCapacity());
                health.setValue(genius.getHealth());
                thirst.setValue(genius.getThirstConsume());
                hunger.setValue(genius.getHungerConsume());
                break;
            }
            case "Hunter":{
                Hunter hunter = new Hunter();
                textArea.setText(hunter.getDescription());
                strength.setValue(hunter.getStrength());
                luck.setValue(hunter.getLuck());
                smarts.setValue(hunter.getSmarts());
                agility.setValue(hunter.getAgility());
                perception.setValue(hunter.getPerception());
                endurance.setValue(hunter.getEndurance());
                money.setValue(hunter.getStartingMoney());
                carry.setValue(hunter.getCarryingCapacity());
                health.setValue(hunter.getHealth());
                thirst.setValue(hunter.getThirstConsume());
                hunger.setValue(hunter.getHungerConsume());
                break;
            }
            case "Jack of All Trades":{
                JackOfAllTrades jack = new JackOfAllTrades();
                textArea.setText(jack.getDescription());
                strength.setValue(jack.getStrength());
                luck.setValue(jack.getLuck());
                smarts.setValue(jack.getSmarts());
                agility.setValue(jack.getAgility());
                perception.setValue(jack.getPerception());
                endurance.setValue(jack.getEndurance());
                money.setValue(jack.getStartingMoney());
                carry.setValue(jack.getCarryingCapacity());
                health.setValue(jack.getHealth());
                thirst.setValue(jack.getThirstConsume());
                hunger.setValue(jack.getHungerConsume());
                break;
            }
            case "Lucky MF":{
                LuckyMF lucky = new LuckyMF();
                textArea.setText(lucky.getDescription());strength.setValue(lucky.getStrength());
                strength.setValue(lucky.getStrength());
                luck.setValue(lucky.getLuck());
                smarts.setValue(lucky.getSmarts());
                agility.setValue(lucky.getAgility());
                perception.setValue(lucky.getPerception());
                endurance.setValue(lucky.getEndurance());
                money.setValue(lucky.getStartingMoney());
                carry.setValue(lucky.getCarryingCapacity());
                health.setValue(lucky.getHealth());
                thirst.setValue(lucky.getThirstConsume());
                hunger.setValue(lucky.getHungerConsume());
                break;
            }
            case "Survivalist":{
                Survivalist survival = new Survivalist();
                textArea.setText(survival.getDescription());
                strength.setValue(survival.getStrength());
                luck.setValue(survival.getLuck());
                smarts.setValue(survival.getSmarts());
                agility.setValue(survival.getAgility());
                perception.setValue(survival.getPerception());
                endurance.setValue(survival.getEndurance());
                money.setValue(survival.getStartingMoney());
                carry.setValue(survival.getCarryingCapacity());
                health.setValue(survival.getHealth());
                thirst.setValue(survival.getThirstConsume());
                hunger.setValue(survival.getHungerConsume());
                break;
            }

        }
    }

    private static void createCharacter(String charName, String spouseName, String child1, String child2, String child3, String characterType){

        InstantiateProfile profile = new InstantiateProfile();
        switch (characterType){
            case "Banker":{
                profile.createProfile(new Banker(), charName, spouseName, child1, child2, child3);
                break;
            }
            case "Genius":{
                profile.createProfile(new Genius(), charName, spouseName, child1, child2, child3);
                break;
            }
            case "Hunter":{
                profile.createProfile(new Hunter(), charName, spouseName, child1, child2, child3);
                break;
            }
            case "Jack of All Trades":{
                profile.createProfile(new JackOfAllTrades(), charName, spouseName, child1, child2, child3);
                break;
            }
            case "Lucky MF":{
                profile.createProfile(new LuckyMF(), charName, spouseName, child1, child2, child3);
                break;
            }
            case "Survivalist":{
                profile.createProfile(new Survivalist(), charName, spouseName, child1, child2, child3);
                break;
            }
            default:{
                break;
            }
        }
    }

    public static void setNewGameView(Scene scene){newGameScene = scene;}
    public static Scene getNewGameView(){ return newGameScene;}
}
