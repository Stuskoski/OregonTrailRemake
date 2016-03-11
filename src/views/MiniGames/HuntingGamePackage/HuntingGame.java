package views.MiniGames.HuntingGamePackage;

import items.Guns.*;
import items.ItemInterface;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;
import models.Inventory;
import views.MiniGames.HuntingGamePackage.HuntingObjects.UsersGun;
import views.StartingTown.StartingTownView;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by augustus on 3/8/16.
 * This is the hunting minigame the
 * user will play to acquire food to
 * survive.  Need to randomize everything
 * on it pretty much.  Need reloader
 * indicators, ammo indicators and
 * a bunch of graphics!
 */
public class HuntingGame {
    private static Scene scene;
    public static Canvas canvas1 = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static Canvas canvas2 = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static GraphicsContext gc1 = canvas1.getGraphicsContext2D();
    public static GraphicsContext gc2 = canvas2.getGraphicsContext2D();
    public static Label numOfBullets;
    public static double poundsHunted = 0;
    public static int animalsKilled = 0;

    public static void randomizeHuntScreen(int secondsToHunt) {
        int bullets = 0;

        BorderPane borderPane = new BorderPane();
        HBox topHbox = new HBox(5);
        Button back = new Button("Back");
        Pane layeredCanvas = new Pane(canvas1, canvas2);


        back.setId("mainScreenBtn");

        borderPane.setTop(topHbox);
        borderPane.setCenter(layeredCanvas);

        topHbox.getChildren().add(back);

        Random random = new Random();

        switch (random.nextInt(3)) {
            case 0: {
                borderPane.setId("huntBackground1");
                break;
            }
            case 1: {
                borderPane.setId("huntBackground2");
                break;
            }
            case 2: {
                borderPane.setId("huntBackground3");
                break;
            }
        }

        Inventory.getInventory().clear(); // Causes a bug with the meat adding to inventory.  No biggy though this isnt permanent

        Inventory.getInventory().add(new Bullets(100));

        for(ItemInterface bulletCheck : Inventory.getInventory()){
            if(bulletCheck.getName().equals("Bullet")){
                bullets = bulletCheck.getQuantity();
            }
        }

        Inventory.getInventory().add(new AlienRifle(1));
        Inventory.getInventory().add(new Rifle(1));
        Inventory.getInventory().add(new ShotGun(1));
        Inventory.getInventory().add(new FlintlockPistol(1));
        Inventory.getInventory().add(new Musket(1));


        ArrayList<ToggleButton> gunInventory = new ArrayList<>();

        for (ItemInterface guns : Inventory.getInventory()) {
            if (guns.getCategory().equals("guns")) {
                ToggleButton gunBtn = new ToggleButton(guns.getName());
                //Button gunBtn = new Button(guns.getName());
                gunBtn.setId("huntingGameGunBtn");
                gunBtn.setPrefWidth(85);
                gunInventory.add(gunBtn);
            }
        }

        //Create Gun Buttons for switching guns.
        for (ToggleButton gunBtn : gunInventory) {
            if(!gunBtn.getText().equals("Bullet")) {
                topHbox.getChildren().add(gunBtn);
            }
        }

        numOfBullets = new Label("Bullets: " + bullets);
        numOfBullets.setId("numOfBulletsLabel");
        topHbox.getChildren().add(numOfBullets);


        Scene createScene = new Scene(borderPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        createScene.getStylesheets().add("resources/main.css");


        //Create listeners for gun selection
        for (ToggleButton gunBtn : gunInventory) {
            gunBtn.setOnAction(event -> {
                if (gunBtn.isSelected()) {
                    for (ToggleButton unselectBtns : gunInventory) {
                        unselectBtns.setSelected(false);
                    }
                    gunBtn.setSelected(true);
                    UsersGun.drawGun(gc1, gunBtn.getText(), createScene, secondsToHunt);
                }

            });
        }

        scene = createScene;

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(secondsToHunt), event -> {
            HuntingSummary.showSummaryScreen(animalsKilled, poundsHunted);
        }));
        timeline.setCycleCount(1);
        timeline.play();

        RandomCreateGameObjects.createGameObjects(gc2, secondsToHunt);

        back.setOnAction(event -> {
            timeline.stop();
            HuntingSummary.showSummaryScreen(animalsKilled, poundsHunted);
            setPoundsHunted(0);
            setAnimalsKilled(0);
           // Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

    }

    public static Scene getScene(){return scene;}
    public static Label getNumOfBullets(){return numOfBullets;}

    public static double getPoundsHunted(){return poundsHunted;}
    public static void setPoundsHunted(double pounds){ poundsHunted = pounds;}

    public static int getAnimalsKilled(){return animalsKilled;}
    public static void setAnimalsKilled(int killed){ animalsKilled = killed;}
}

