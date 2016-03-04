package views.StartingTown;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;

/**
 * Created by augustus on 2/19/16.
 * Stable view where the player
 * will buy their horses or oxes
 * to start the game.  They must visit
 * here and buy something to pull
 * their wagon.
 */
public class StartTownStableView {
    private static Scene startStable;

    public static void createStartTownStableView(){
        Boolean showDonkey = false;
        Boolean showOx = false;
        Boolean showHorse = false;
        Image oxImg = new Image("resources/cow-icon.png");
        Image donkeyImg = new Image("resources/donkey-icon.png");
        Image horseImg = new Image("resources/horse-icon.png");
        ImageView oxImgView = new ImageView(oxImg);
        ImageView donkeyImgView = new ImageView(donkeyImg);
        ImageView horseImgView = new ImageView(horseImg);


        GridPane gridPane = new GridPane();
        gridPane.setHgap(3);
        gridPane.setVgap(3);
        gridPane.setId("startStableGrid");
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 1, 1);
        backBtn.setId("mainScreenBtn");

        VBox animals = new VBox(10);
        VBox animalsPics = new VBox(5);

        animals.setId("stableVbox1");
        animalsPics.setId("stableVbox2");

        animals.setPrefWidth(400);
        animalsPics.setPrefWidth(400);
        animals.setPrefHeight(600);
        animalsPics.setPrefHeight(600);

        gridPane.add(animals, 5, 5);
        gridPane.add(animalsPics, 15, 5);

        ToggleButton oxToggleBtn = new ToggleButton("Ox");
        ToggleButton horseToggleBtn = new ToggleButton("Horse");
        ToggleButton donkeyToggleBtn = new ToggleButton("Donkey");

        animals.setAlignment(Pos.CENTER);
        animals.getChildren().addAll(oxToggleBtn, horseToggleBtn, donkeyToggleBtn);

        oxToggleBtn.setOnAction(event1 -> {
            if(oxToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                horseToggleBtn.setSelected(false);
                donkeyToggleBtn.setSelected(false);
                animalsPics.getChildren().add(oxImgView);
            }else{
                animalsPics.getChildren().clear();
            }
        });
        horseToggleBtn.setOnAction(event1 -> {
            if(horseToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                donkeyToggleBtn.setSelected(false);
                oxToggleBtn.setSelected(false);
                animalsPics.getChildren().add(horseImgView);
            }else{
                animalsPics.getChildren().clear();
            }
        });
        donkeyToggleBtn.setOnAction(event1 -> {
            if(donkeyToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                oxToggleBtn.setSelected(false);
                horseToggleBtn.setSelected(false);
                animalsPics.getChildren().add(donkeyImgView);
            }else{
                animalsPics.getChildren().clear();
            }
        });


        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        StartTownSaloonView.setStartSaloon(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartStore(Scene scene){StartTownStableView.startStable = scene;}
    public static Scene getStartStore(){return StartTownStableView.startStable;}
}
