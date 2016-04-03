package views.StartingTown;

import CharacterObjects.Profile;
import items.Animals.Donkey;
import items.Animals.Horse;
import items.Animals.Ox;
import items.ItemInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Start.Main;
import models.AddKeyListenerToScene;
import models.Inventory;

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

        VBox animals = new VBox(15);
        VBox animalsPics = new VBox(15);

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

        oxToggleBtn.setId("mainStoreBtn");
        oxToggleBtn.setPrefWidth(200);
        horseToggleBtn.setId("mainStoreBtn");
        horseToggleBtn.setPrefWidth(200);
        donkeyToggleBtn.setId("mainStoreBtn");
        donkeyToggleBtn.setPrefWidth(200);

        animals.setAlignment(Pos.CENTER);
        animals.getChildren().addAll(oxToggleBtn, horseToggleBtn, donkeyToggleBtn);

        animalsPics.setAlignment(Pos.CENTER);

        Button buyOx = new Button("Buy Ox - $" + new Ox(1).getPrice());
        Button buyDonkey = new Button("Buy Donkey - $" + new Donkey(1).getPrice());
        Button buyHorse = new Button("Buy Horse - $" + new Horse(1).getPrice());
        Button wallet = new Button("$" + String.format("%.2f", Profile.getMoney()) + " - Wallet");

        buyOx.setId("mainStoreBtn");
        buyDonkey.setId("mainStoreBtn");
        buyHorse.setId("mainStoreBtn");
        wallet.setId("mainStoreUserCashBtn");

        HBox buyAnimalBtnHbox = new HBox(5);
        buyAnimalBtnHbox.setAlignment(Pos.CENTER);

        oxToggleBtn.setOnAction(event1 -> {
            if(oxToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                horseToggleBtn.setSelected(false);
                donkeyToggleBtn.setSelected(false);
                buyAnimalBtnHbox.getChildren().clear();
                buyAnimalBtnHbox.getChildren().addAll(buyOx, wallet);
                animalsPics.getChildren().addAll(oxImgView, buyAnimalBtnHbox);
            }else{
                animalsPics.getChildren().clear();
            }
        });
        horseToggleBtn.setOnAction(event1 -> {
            if(horseToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                donkeyToggleBtn.setSelected(false);
                oxToggleBtn.setSelected(false);
                buyAnimalBtnHbox.getChildren().clear();
                buyAnimalBtnHbox.getChildren().addAll(buyHorse, wallet);
                animalsPics.getChildren().addAll(horseImgView, buyAnimalBtnHbox);
            }else{
                animalsPics.getChildren().clear();
            }
        });
        donkeyToggleBtn.setOnAction(event1 -> {
            if(donkeyToggleBtn.isSelected()){
                animalsPics.getChildren().clear();
                oxToggleBtn.setSelected(false);
                horseToggleBtn.setSelected(false);
                buyAnimalBtnHbox.getChildren().clear();
                buyAnimalBtnHbox.getChildren().addAll(buyDonkey, wallet);
                animalsPics.getChildren().addAll(donkeyImgView, buyAnimalBtnHbox);
            }else{
                animalsPics.getChildren().clear();
            }
        });

        buyOx.setOnAction(event1 -> {
            if(Profile.getMoney() >= new Ox(1).getPrice()){
                Profile.setMoney(Profile.getMoney() - new Ox(1).getPrice());
                wallet.setText("$" + String.format("%.2f", Profile.getMoney()) + " - Wallet");

                //Counter to check for an ox
                int counter = 0;

                for(ItemInterface oxCheck : Inventory.getInventory()){
                    if(oxCheck.getName().equals(new Ox(1).getName())){
                        oxCheck.setQuantity(oxCheck.getQuantity()+1);
                    }else{
                        counter++;
                    }
                }

                //If counter is equal to length of the inventory then no ox was found, so add one.
                if(counter == Inventory.getInventory().size()){
                    Inventory.getInventory().add(new Ox(1));
                }

                Inventory.updateInventoryScreen();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Unable to checkout");
                alert.setHeaderText(null);
                alert.setContentText("You do not have enough cash to buy an Ox!");
                alert.showAndWait();
            }
        });
        buyDonkey.setOnAction(event1 -> {
            if(Profile.getMoney() >= new Donkey(1).getPrice()){
                Profile.setMoney(Profile.getMoney() - new Donkey(1).getPrice());
                wallet.setText("$" + String.format("%.2f", Profile.getMoney()) + " - Wallet");

                //Counter to check for an ox
                int counter = 0;

                for(ItemInterface donkeyCheck : Inventory.getInventory()){
                    if(donkeyCheck.getName().equals(new Donkey(1).getName())){
                        donkeyCheck.setQuantity(donkeyCheck.getQuantity()+1);
                    }else{
                        counter++;
                    }
                }

                //If counter is equal to length of the inventory then no ox was found, so add one.
                if(counter == Inventory.getInventory().size()){
                    Inventory.getInventory().add(new Donkey(1));
                }

                Inventory.updateInventoryScreen();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Unable to checkout");
                alert.setHeaderText(null);
                alert.setContentText("You do not have enough cash to buy a Donkey!");
                alert.showAndWait();
            }
        });
        buyHorse.setOnAction(event1 -> {
            if(Profile.getMoney() >= new Horse(1).getPrice()){
                Profile.setMoney(Profile.getMoney() - new Horse(1).getPrice());
                wallet.setText("$" + String.format("%.2f", Profile.getMoney()) + " - Wallet");

                //Counter to check for an ox
                int counter = 0;

                for(ItemInterface horseCheck : Inventory.getInventory()){
                    if(horseCheck.getName().equals(new Horse(1).getName())){
                        horseCheck.setQuantity(horseCheck.getQuantity()+1);
                    }else{
                        counter++;
                    }
                }

                //If counter is equal to length of the inventory then no ox was found, so add one.
                if(counter == Inventory.getInventory().size()){
                    Inventory.getInventory().add(new Horse(1));
                }

                Inventory.updateInventoryScreen();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Unable to checkout");
                alert.setHeaderText(null);
                alert.setContentText("You do not have enough cash to buy a HorseForWagon!");
                alert.showAndWait();
            }
        });


        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
            //for (ItemInterface print : Inventory.getInventory()){
            //    System.out.println(print.getName() + "\t" + print.getQuantity());  CHECK FOR INVENTORY
            //}
        });


        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        AddKeyListenerToScene.addGeneralKeyListener(scene);

        scene.getStylesheets().add("resources/main.css");

        StartTownSaloonView.setStartSaloon(scene);
        Main.getPrimaryStage().setScene(scene);
    }

    //getters and setters
    public static void setStartStore(Scene scene){StartTownStableView.startStable = scene;}
    public static Scene getStartStore(){return StartTownStableView.startStable;}
}
