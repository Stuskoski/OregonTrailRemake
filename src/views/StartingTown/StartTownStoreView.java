package views.StartingTown;

import items.ItemInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;
import models.RandomizeStoreContents;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
        ArrayList<ItemInterface> cartList = new ArrayList<>();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setId("startTownStoreGrid");

        if(canRun) { //might need to reset when user wants to start a new game
            RandomizeStoreContents.startingTown();
            canRun = false;
        }

        //ArrayList<ItemInterface> inventory = RandomizeStoreContents.getStartTownList();

        //create the tree root
        TreeItem<Label> inventoryRoot = new TreeItem<>(new Label("Store Inventory"));
        inventoryRoot.setExpanded(true);
        TreeView<Label> inventoryTreeView = new TreeView<>(inventoryRoot);
        inventoryTreeView.setShowRoot(false);
        inventoryTreeView.setId("treeStyle");

        HBox inventoryHeader = new HBox(new Label("Store Inventory"));
        inventoryHeader.setId("startStoreHeaders");
        inventoryHeader.setAlignment(Pos.CENTER);
        gridPane.add(inventoryHeader, 5, 4);
        gridPane.add(inventoryTreeView, 5, 5);

        HBox cartHeader = new HBox(new Label("Cart"));
        gridPane.add(cartHeader, 15, 4);
        VBox cart = new VBox(5);
        cart.setId("startStoreCart");
        gridPane.add(cart, 15, 5);

        //create the categories for the tree
        TreeItem<Label> food = new TreeItem<>(new Label("Food"));
        TreeItem<Label> clothing = new TreeItem<>(new Label("Clothing"));
        TreeItem<Label> medicine = new TreeItem<>(new Label("Medicine"));
        TreeItem<Label> guns = new TreeItem<>(new Label("Guns"));
        TreeItem<Label> wagonSupplies = new TreeItem<>(new Label("Wagon Supplies"));
        TreeItem<Label> misc = new TreeItem<>(new Label("Miscellaneous"));


        inventoryRoot.getChildren().addAll(food, clothing, medicine, guns, wagonSupplies, misc);

        //This creates the tree and adds the listeners to it
        for (ItemInterface obj : RandomizeStoreContents.getStartTownList()) {
            Label itemName = new Label(obj.getQuantity() + "\t" + obj.getName());

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
            //When user double clicks the item decrement it in the list.  Add to the cart(need to code)
            itemName.setOnMouseClicked(event -> {
                //Double click
                if(event.getClickCount() == 2) {
                    for (ItemInterface item : RandomizeStoreContents.getStartTownList()) {
                        if(itemName.getText().replace("\t", "").replaceAll("[0-9]+", "").equals(item.getName())){//maybe boolean to see if real item
                            item.setQuantity(item.getQuantity()-1);
                            try {
                                ItemInterface newItem = item.getClass().getConstructor().newInstance();

                                cartList.add(newItem);
                            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                                e.printStackTrace();
                            }

                            updateCart(cart, cartList);
                        }
                    }
                    itemName.setText(obj.getQuantity() + "\t" + obj.getName());
                    //treeView.refresh(); don't think refresh is needed
                }
            });
        }

        if(clothing.getChildren().isEmpty()){
            clothing.getChildren().add(new TreeItem<>(new Label("Empty")));
        }
        if(food.getChildren().isEmpty()){
            food.getChildren().add(new TreeItem<>(new Label("Empty")));
        }
        if(guns.getChildren().isEmpty()){
            guns.getChildren().add(new TreeItem<>(new Label("Empty")));
        }
        if(medicine.getChildren().isEmpty()){
            medicine.getChildren().add(new TreeItem<>(new Label("Empty")));
        }
        if(wagonSupplies.getChildren().isEmpty()){
            wagonSupplies.getChildren().add(new TreeItem<>(new Label("Empty")));
        }
        if(misc.getChildren().isEmpty()){
            misc.getChildren().add(new TreeItem<>(new Label("Empty")));
        }

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

    private static void updateCart(VBox vBox, ArrayList<ItemInterface> arrayList){
        vBox.getChildren().clear();
        for (ItemInterface obj : arrayList) {
            HBox hbox = new HBox(5);
            hbox.getChildren().addAll(new Label(String.valueOf(obj.getQuantity()), new Label(obj.getName())));
            vBox.getChildren().add(hbox);
        }
    }
    //getters and setters
    public static void setStartStore(Scene scene){StartTownStoreView.startStore = scene;}
    public static Scene getStartStore(){return StartTownStoreView.startStore;}
}
