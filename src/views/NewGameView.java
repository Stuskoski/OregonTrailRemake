package views;

import Characters.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        Label title = new Label("Create A Character");
        HBox hBox = new HBox(title);
        VBox vBox = new VBox(10);
        TextArea characterDescriptionArea = new TextArea();

        hBox.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
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
        createCharHbox.setPadding(new Insets(0,0,25,0));
        borderPane.setBottom(createCharHbox);

       // gridPane.setGridLinesVisible(true);

        HBox charStatsHbox = new HBox();
        Label charStatsLabel = new Label("Character Stats");
        charStatsHbox.getChildren().add(charStatsLabel);
        charStatsHbox.setAlignment(Pos.CENTER);
        gridPane.add(charStatsHbox, 2, 2);

        HBox stat1 = new HBox(10);
        HBox stat2 = new HBox(10);
        HBox stat3 = new HBox(10);
        HBox stat4 = new HBox(10);
        HBox stat5 = new HBox(10);
        HBox stat6 = new HBox(10);
        HBox stat7 = new HBox(10);
        HBox stat8 = new HBox(10);
        HBox stat9 = new HBox(10);
        HBox stat10 = new HBox(10);
        HBox stat11 = new HBox(10);

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

        Label stat1Label = new Label();
        Label stat2Label = new Label();
        Label stat3Label = new Label();
        Label stat4Label = new Label();
        Label stat5Label = new Label();
        Label stat6Label = new Label();
        Label stat7Label = new Label();
        Label stat8Label = new Label();
        Label stat9Label = new Label();
        Label stat10Label = new Label();
        Label stat11Label = new Label();

        stat1.getChildren().addAll(strengthLabel, stat1Label);
        stat2.getChildren().addAll(luckLabel, stat2Label);
        stat3.getChildren().addAll(smartsLabel, stat3Label);
        stat4.getChildren().addAll(agilityLabel, stat4Label);
        stat5.getChildren().addAll(perceptionLabel, stat5Label);
        stat6.getChildren().addAll(enduranceLabel, stat6Label);
        stat7.getChildren().addAll(startingMoneyLabel, stat7Label);
        stat8.getChildren().addAll(carryingCapacityLabel, stat8Label);
        stat9.getChildren().addAll(healthLabel, stat9Label);
        stat10.getChildren().addAll(thirstLabel, stat10Label);
        stat11.getChildren().addAll(hungerLabel, stat11Label);

        VBox charStatsVbox = new VBox(1);
        charStatsVbox.getChildren().addAll(stat1,stat2,stat3,stat4,stat5,stat6,stat7,stat8,stat9,stat10,stat11);
        gridPane.add(charStatsVbox, 2, 3, 1, 10);

        borderPane.setCenter(gridPane);
        borderPane.setTop(hBox);

        comboBox.setOnAction(event -> getCharacterDescription(comboBox.getValue(), characterDescriptionArea, stat1Label,
                stat2Label, stat3Label, stat4Label, stat5Label, stat6Label, stat7Label, stat8Label, stat9Label,
                stat10Label, stat11Label));

        //Get the width and height from the previous scene.
        height = Main.getPrimaryStage().getScene().getHeight();
        width = Main.getPrimaryStage().getScene().getWidth();

        Scene newScene = new Scene(borderPane, width, height);

        Main.getPrimaryStage().setScene(newScene);

    }

    private static void getCharacterDescription(String character, TextArea textArea, Label stat1, Label stat2,
                                                Label stat3, Label stat4, Label stat5, Label stat6, Label stat7,
                                                Label stat8, Label stat9, Label stat10, Label stat11){
        switch (character) {
            case "Banker":{
                Banker banker = new Banker();
                textArea.setText(banker.getDescription());
                stat1.setText(String.valueOf(banker.getStrength()));
                stat2.setText(String.valueOf(banker.getLuck()));
                stat3.setText(String.valueOf(banker.getSmarts()));
                stat4.setText(String.valueOf(banker.getAgility()));
                stat5.setText(String.valueOf(banker.getPerception()));
                stat6.setText(String.valueOf(banker.getEndurance()));
                stat7.setText(String.valueOf(banker.getStartingMoney()));
                stat8.setText(String.valueOf(banker.getCarryingCapacity()));
                stat9.setText(String.valueOf(banker.getHealth()));
                stat10.setText(String.valueOf(banker.getThirstConsume()));
                stat11.setText(String.valueOf(banker.getHungerConsume()));
                break;
            }
            case "Genius":{
                Genius genius = new Genius();
                textArea.setText(genius.getDescription());
                stat1.setText(String.valueOf(genius.getStrength()));
                stat2.setText(String.valueOf(genius.getLuck()));
                stat3.setText(String.valueOf(genius.getSmarts()));
                stat4.setText(String.valueOf(genius.getAgility()));
                stat5.setText(String.valueOf(genius.getPerception()));
                stat6.setText(String.valueOf(genius.getEndurance()));
                stat7.setText(String.valueOf(genius.getStartingMoney()));
                stat8.setText(String.valueOf(genius.getCarryingCapacity()));
                stat9.setText(String.valueOf(genius.getHealth()));
                stat10.setText(String.valueOf(genius.getThirstConsume()));
                stat11.setText(String.valueOf(genius.getHungerConsume()));
                break;
            }
            case "Hunter":{
                Hunter hunter = new Hunter();
                textArea.setText(hunter.getDescription());
                stat1.setText(String.valueOf(hunter.getStrength()));
                stat2.setText(String.valueOf(hunter.getLuck()));
                stat3.setText(String.valueOf(hunter.getSmarts()));
                stat4.setText(String.valueOf(hunter.getAgility()));
                stat5.setText(String.valueOf(hunter.getPerception()));
                stat6.setText(String.valueOf(hunter.getEndurance()));
                stat7.setText(String.valueOf(hunter.getStartingMoney()));
                stat8.setText(String.valueOf(hunter.getCarryingCapacity()));
                stat9.setText(String.valueOf(hunter.getHealth()));
                stat10.setText(String.valueOf(hunter.getThirstConsume()));
                stat11.setText(String.valueOf(hunter.getHungerConsume()));
                break;
            }
            case "Jack of All Trades":{
                JackOfAllTrades jack = new JackOfAllTrades();
                textArea.setText(jack.getDescription());
                stat1.setText(String.valueOf(jack.getStrength()));
                stat2.setText(String.valueOf(jack.getLuck()));
                stat3.setText(String.valueOf(jack.getSmarts()));
                stat4.setText(String.valueOf(jack.getAgility()));
                stat5.setText(String.valueOf(jack.getPerception()));
                stat6.setText(String.valueOf(jack.getEndurance()));
                stat7.setText(String.valueOf(jack.getStartingMoney()));
                stat8.setText(String.valueOf(jack.getCarryingCapacity()));
                stat9.setText(String.valueOf(jack.getHealth()));
                stat10.setText(String.valueOf(jack.getThirstConsume()));
                stat11.setText(String.valueOf(jack.getHungerConsume()));
                break;
            }
            case "Lucky MF":{
                LuckyMF lucky = new LuckyMF();
                textArea.setText(lucky.getDescription());
                stat1.setText(String.valueOf(lucky.getStrength()));
                stat2.setText(String.valueOf(lucky.getLuck()));
                stat3.setText(String.valueOf(lucky.getSmarts()));
                stat4.setText(String.valueOf(lucky.getAgility()));
                stat5.setText(String.valueOf(lucky.getPerception()));
                stat6.setText(String.valueOf(lucky.getEndurance()));
                stat7.setText(String.valueOf(lucky.getStartingMoney()));
                stat8.setText(String.valueOf(lucky.getCarryingCapacity()));
                stat9.setText(String.valueOf(lucky.getHealth()));
                stat10.setText(String.valueOf(lucky.getThirstConsume()));
                stat11.setText(String.valueOf(lucky.getHungerConsume()));
                break;
            }
            case "Survivalist":{
                Survivalist survival = new Survivalist();
                textArea.setText(survival.getDescription());
                stat1.setText("\t\t" + String.valueOf(survival.getStrength()) + "/25");
                stat2.setText("\t\t\t" + String.valueOf(survival.getLuck()) + "/25");
                stat3.setText("\t\t" + String.valueOf(survival.getSmarts()) + "/25");
                stat4.setText("\t\t" + String.valueOf(survival.getAgility()) + "/25");
                stat5.setText("\t\t" + String.valueOf(survival.getPerception()) + "/25");
                stat6.setText("\t\t" + String.valueOf(survival.getEndurance()) + "/25");
                stat7.setText("\t\t" + "$"+String.valueOf(survival.getStartingMoney()) + "/1000.00");
                stat8.setText("\t\t" + String.valueOf(survival.getCarryingCapacity()));
                stat9.setText("\t\t" + String.valueOf(survival.getHealth()));
                stat10.setText("\t\t" + String.valueOf(survival.getThirstConsume()));
                stat11.setText("\t\t" + String.valueOf(survival.getHungerConsume()));
                break;
            }

        }
    }

    public static void setNewGameView(Scene scene){newGameScene = scene;}
    public static Scene getNewGameView(){ return newGameScene;}
}
