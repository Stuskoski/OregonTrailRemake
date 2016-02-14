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
        comboBox.setOnAction(event -> getCharacterDescription(comboBox.getValue(), characterDescriptionArea));
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

        gridPane.setGridLinesVisible(true);

        borderPane.setCenter(gridPane);
        borderPane.setTop(hBox);

        //Get the width and height from the previous scene.
        height = Main.getPrimaryStage().getScene().getHeight();
        width = Main.getPrimaryStage().getScene().getWidth();

        Scene newScene = new Scene(borderPane, width, height);

        Main.getPrimaryStage().setScene(newScene);

    }

    private static void getCharacterDescription(String character, TextArea textArea){
        switch (character) {
            case "Banker":{
                textArea.setText(new Banker().getDescription());
                break;
            }
            case "Genius":{
                textArea.setText(new Genius().getDescription());
                break;
            }
            case "Hunter":{
                textArea.setText(new Hunter().getDescription());
                break;
            }
            case "Jack of All Trades":{
                textArea.setText(new JackOfAllTrades().getDescription());
                break;
            }
            case "Lucky MF":{
                textArea.setText(new LuckyMF().getDescription());
                break;
            }
            case "Survivalist":{
                textArea.setText(new Survivalist().getDescription());
                break;
            }

        }
    }

    public static void setNewGameView(Scene scene){newGameScene = scene;}
    public static Scene getNewGameView(){ return newGameScene;}
}
