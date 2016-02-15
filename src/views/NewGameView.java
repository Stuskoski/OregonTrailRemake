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
import javafx.scene.text.Text;
import javafx.stage.Popup;
import main.Main;

import javax.swing.*;
import java.awt.*;

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
        final int statMax25 = 25;
        final int cashMax1000 = 1000;
        final int carryMax150 = 150;
        final int healthMax120 = 120;
        final String WORK_DONE_LABEL_FORMAT = "%.0f";
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

        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        Label title = new Label("Create A Character");
        HBox hBox = new HBox(title);
        VBox vBox = new VBox(10);
        TextArea characterDescriptionArea = new TextArea();

        hBox.setAlignment(Pos.CENTER);
        gridPane.setHgap(40);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label characterLabel = new Label("Select A Character");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Select Character Type");
        comboBox.getItems().addAll("Banker", "Genius", "Hunter", "Jack of All Trades", "Lucky MF", "Survivalist");
        gridPane.add(characterLabel, 0, 1);
        gridPane.add(comboBox, 1, 1);

        Label name1Label = new Label("Your Name");
        TextField name1Field = new TextField();
        name1Field.setPromptText("Your Name");
        gridPane.add(name1Label, 0, 4);
        gridPane.add(name1Field, 1, 4);

        Label name2Label = new Label("Wife's Name");
        TextField name2Field = new TextField();
        name2Field.setPromptText("Wife's Name");
        gridPane.add(name2Label, 0, 5);
        gridPane.add(name2Field, 1, 5);

        Label name3Label = new Label("Child One's Name");
        TextField name3Field = new TextField();
        name3Field.setPromptText("Child One's Name");
        gridPane.add(name3Label, 0, 6);
        gridPane.add(name3Field, 1, 6);

        Label name4Label = new Label("Child Two's Name");
        TextField name4Field = new TextField();
        name4Field.setPromptText("Child Two's Name");
        gridPane.add(name4Label, 0, 7);
        gridPane.add(name4Field, 1, 7);

        Label name5Label = new Label("Child Three's Name");
        TextField name5Field = new TextField();
        name5Field.setPromptText("Child Three's Name");
        gridPane.add(name5Label, 0, 8);
        gridPane.add(name5Field, 1, 8);

        characterDescriptionArea.setPrefWidth(350);
        characterDescriptionArea.setEditable(false);
        HBox charDescriptionLabelHbox = new HBox();
        Label characterDescriptionLabel = new Label("Character Description");
        charDescriptionLabelHbox.setAlignment(Pos.CENTER);
        charDescriptionLabelHbox.getChildren().add(characterDescriptionLabel);
        characterDescriptionArea.setTooltip(new Tooltip("Description of the selected character"));
        vBox.getChildren().addAll(charDescriptionLabelHbox, characterDescriptionArea);
        gridPane.add(vBox, 2, 1);

        HBox createCharHbox = new HBox();
        Button createChar = new Button("Create Character");
        createChar.setTooltip(new Tooltip("Submit Character Creation"));
        createCharHbox.getChildren().add(createChar);
        createCharHbox.setAlignment(Pos.CENTER);
        createCharHbox.setPadding(new Insets(25,0,25,0));
        borderPane.setBottom(createCharHbox);

       // gridPane.setGridLinesVisible(true);

        HBox charStatsHbox = new HBox();
        Label charStatsLabel = new Label("Character Stats");
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

        Label strengthLabel = new Label("Strength: ");
        Label luckLabel = new Label("Luck: ");
        Label smartsLabel = new Label("Smarts: ");
        Label agilityLabel = new Label("Agility: ");
        Label perceptionLabel = new Label("Perception: ");
        Label enduranceLabel = new Label("Endurance: ");
        Label startingMoneyLabel = new Label("Starting Money: ");
        Label carryingCapacityLabel = new Label("Carrying Capacity: ");
        Label healthLabel = new Label("Health: ");
        Label thirstLabel = new Label("Thirst: ");
        Label hungerLabel = new Label("Hunger: ");

        final ProgressIndicatorBar strBar = new ProgressIndicatorBar(
                strengthWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar luckBar = new ProgressIndicatorBar(
                luckWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar agilityBar = new ProgressIndicatorBar(
                agilityWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar smartsBar = new ProgressIndicatorBar(
                smartWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar perceptionBar = new ProgressIndicatorBar(
                perceptionWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar enduranceBar = new ProgressIndicatorBar(
                enduranceWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar moneyBar = new ProgressIndicatorBar(
                moneyWrapper.getReadOnlyProperty(),
                cashMax1000,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar carryBar = new ProgressIndicatorBar(
                carryWrapper.getReadOnlyProperty(),
                carryMax150,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar healthBar = new ProgressIndicatorBar(
                healthWrapper.getReadOnlyProperty(),
                healthMax120,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar thirstBar = new ProgressIndicatorBar(
                thirstWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
        );
        final ProgressIndicatorBar hungerBar = new ProgressIndicatorBar(
                hungerWrapper.getReadOnlyProperty(),
                statMax25,
                WORK_DONE_LABEL_FORMAT
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

        comboBox.setOnAction(event -> getCharacterDescription(comboBox.getValue(), characterDescriptionArea, strengthWrapper,
                luckWrapper, smartWrapper, agilityWrapper, perceptionWrapper, enduranceWrapper, moneyWrapper, carryWrapper,
                healthWrapper, thirstWrapper, hungerWrapper));

        //Get the width and height from the previous scene.
        height = Main.getPrimaryStage().getScene().getHeight();
        width = Main.getPrimaryStage().getScene().getWidth();

        Scene newScene = new Scene(borderPane, width, height);

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

    public static void setNewGameView(Scene scene){newGameScene = scene;}
    public static Scene getNewGameView(){ return newGameScene;}
}
