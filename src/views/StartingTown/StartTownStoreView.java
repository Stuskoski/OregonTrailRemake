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
import java.util.Iterator;

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
        inventoryTreeView.setPrefWidth(350);

        Label cartInventoryLabel = new Label("Store Inventory");
        HBox inventoryHeader = new HBox(cartInventoryLabel);
        cartInventoryLabel.setId("startStoreHeaders");
        inventoryHeader.setAlignment(Pos.CENTER);
        gridPane.add(inventoryHeader, 10, 24);//col row
        gridPane.add(inventoryTreeView, 10, 25);

        Label cartHeaderLabel = new Label("Cart");
        HBox cartHeader = new HBox(cartHeaderLabel);
        cartHeaderLabel.setId("startStoreHeaders");
        cartHeader.setAlignment(Pos.CENTER);
        VBox cart = new VBox(5);
        cart.setPrefWidth(300);
        cart.setId("startStoreCart");
        gridPane.add(cartHeader, 50, 24);
        gridPane.add(cart, 50, 25);
        cart.setPrefWidth(350);

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
                    for (ItemInterface item : RandomizeStoreContents.getStartTownList())
                        if (itemName.getText().replace("\t", "").replaceAll("[0-9]+", "").equals(item.getName())) {//maybe boolean to see if real item
                            if(item.getQuantity() > 0) {
                                item.setQuantity(item.getQuantity() - 1);
                                //cartList.add(item.cloneObject());
                                updateCart(cart, cartList, item.cloneObject());
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
        gridPane.add(backBtn, 1, 1);
        backBtn.setId("mainScreenBtn");

        backBtn.setOnAction(event -> {
            Main.getPrimaryStage().setScene(StartingTownView.getStartingTownView());
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        setStartStore(scene);
        Main.getPrimaryStage().setScene(scene);
    }

    //This method is used to update the cart when adding items.  It's a little sloppy
    private static void updateCart(VBox vBox, ArrayList<ItemInterface> arrayList, ItemInterface item){
        ArrayList<ItemInterface> toAdd = new ArrayList<>();
        int counter = 0;

        //Remove all objects
        toAdd.clear();
        vBox.getChildren().clear();

        //if array list is empty add the item, if not check if item exists, if so add to quantity, if not just add item
        if(arrayList.isEmpty()){
            arrayList.add(item);
        }else {
            for (ItemInterface check : arrayList) {
                    if(check.getName().equals(item.getName())){//match
                        check.setQuantity(check.getQuantity()+1);
                    }else{
                        counter++;
                    }
                }
        }

        //If the counter has the same number as the size of the arraylist then the item was not found so add to list
        if(counter == arrayList.size()){
            arrayList.add(item);
        }

        for (ItemInterface obj : arrayList) {
            HBox hbox = new HBox(10);
            Label quantity = new Label(String.valueOf(obj.getQuantity()));
            quantity.setId("cartItems");
            Label name = new Label(obj.getName());
            name.setId("cartItems");
            hbox.getChildren().addAll(quantity, name);
            hbox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hbox);
        }

        updateCartPrice(arrayList);
    }

    public static void updateCartPrice(ArrayList<ItemInterface> arrayList){
        double price = 0;

        for (ItemInterface obj : arrayList) {
            System.out.println(obj.getName());
            price += obj.getPrice() * obj.getQuantity();
        }

        System.out.println(price);
    }
    //getters and setters
    public static void setStartStore(Scene scene){StartTownStoreView.startStore = scene;}
    public static Scene getStartStore(){return StartTownStoreView.startStore;}
}
