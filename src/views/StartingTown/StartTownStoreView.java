package views.StartingTown;

import items.ItemInterface;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.Main;
import models.RandomizeStoreContents;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by augustus on 2/19/16.
 * The initial store.  Need to randomize items
 * available but also have items that are always
 * there because they are needed.
 */
public class StartTownStoreView {
    private static Scene startStore;
    private static boolean canRun = true;

    public static void createStartTownStoreView(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setId("startTownStoreGrid");

        if(canRun) { //might need to reset when user wants to start a new game
            RandomizeStoreContents.startingTown();
            canRun = false;
        }

        //ArrayList<ItemInterface> inventory = RandomizeStoreContents.getStartTownList();

        //create the tree root
        TreeItem<Label> root = new TreeItem<>(new Label("Store Inventory"));
        root.setExpanded(false);

        //create the categories for the tree
        TreeItem<Label> food = new TreeItem<>(new Label("Food"));
        TreeItem<Label> clothing = new TreeItem<>(new Label("Clothing"));
        TreeItem<Label> medicine = new TreeItem<>(new Label("Medicine"));
        TreeItem<Label> guns = new TreeItem<>(new Label("Guns"));
        TreeItem<Label> wagonSupplies = new TreeItem<>(new Label("Wagon Supplies"));
        TreeItem<Label> misc = new TreeItem<>(new Label("Miscellaneous"));


        root.getChildren().addAll(food, clothing, medicine, guns, wagonSupplies, misc);

        //This creates the tree and adds the listeners to it
        for (ItemInterface obj : RandomizeStoreContents.getStartTownList()) {
            HBox hBox = new HBox(5);
            Label itemName = new Label(obj.getName() + "\t\t\t" + obj.getQuantity());
            //Label itemNum = new Label(String.valueOf(obj.getQuantity()));
            //hBox.getChildren().addAll(itemName, itemNum);
            //hBox.setOnMouseClicked(event -> {
            //    System.out.println("clicked");
            //});
            switch (obj.getCategory()){
                case "clothing":{
                    clothing.getChildren().add(new TreeItem<>(itemName));
                    //add counter for empty
                    break;
                }
                case "food":{
                    food.getChildren().add(new TreeItem<>(itemName));
                    break;
                }
                case "guns":{
                    guns.getChildren().add(new TreeItem<>(itemName));
                    break;
                }
                case "meds":{
                    medicine.getChildren().add(new TreeItem<>(itemName));
                    break;
                }
                case "supplies":{
                    wagonSupplies.getChildren().add(new TreeItem<>(itemName));
                    break;
                }
                case "misc":{
                    misc.getChildren().add(new TreeItem<>(itemName));
                    break;
                }
            }

            itemName.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    System.out.println("double clicked");
                }
            });
        }

        TreeView<Label> treeView = new TreeView<>(root);
        treeView.setId("treeStyle");

        gridPane.add(treeView, 5, 5);

        Button backBtn = new Button("Back");
        gridPane.add(backBtn, 0, 0);

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        setStartStore(scene);
        Main.getPrimaryStage().setScene(scene);
    }


    //getters and setters
    public static void setStartStore(Scene scene){StartTownStoreView.startStore = scene;}
    public static Scene getStartStore(){return StartTownStoreView.startStore;}
}
