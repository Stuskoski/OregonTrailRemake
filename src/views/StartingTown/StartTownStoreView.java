package views.StartingTown;

import items.ItemInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import main.Main;
import models.RandomizeStoreContents;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
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
    private static Button checkOut = new Button("");
    private static TreeItem<Label> inventoryRoot;
    private static TreeView<Label> inventoryTreeView;


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

        inventoryRoot = new TreeItem<>(new Label("Store Inventory"));
        inventoryTreeView = new TreeView<>(inventoryRoot);
        inventoryRoot.setExpanded(true);
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

        HBox cartTotal = new HBox();
        cartTotal.setAlignment(Pos.CENTER);
        //Label cartTotalLabel = new Label("$0.00");
        checkOut.setText("$0.00 - Checkout");
        checkOut.setId("mainStoreBtn");
        cartTotal.getChildren().add(checkOut);
        gridPane.add(cartTotal, 50, 26);


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
                //Single click
                for (ItemInterface item : RandomizeStoreContents.getStartTownList())
                    if (itemName.getText().replace("\t", "").replaceAll("[0-9]+", "").equals(item.getName())) {//maybe boolean to see if real item
                        if(item.getQuantity() > 0) {
                            item.setQuantity(item.getQuantity() - 1);
                            //cartList.add(item.cloneObject());
                            updateCart(cart, cartList, item.cloneObject(), itemName);
                        }
                    }
                itemName.setText(obj.getQuantity() + "\t" + obj.getName());
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

        //Check users money to see if they have enough.
        //If they do add the items to their cart and make
        //sure to subtract from their cash
        checkOut.setOnAction(event -> {
            System.out.println("OMG");
        });

        Scene scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());

        scene.getStylesheets().add("resources/main.css");

        setStartStore(scene);
        Main.getPrimaryStage().setScene(scene);
    }

    //This method is used to update the cart when adding items.  It's a little sloppy
    private static void updateCart(VBox vBox, ArrayList<ItemInterface> cartList, ItemInterface item, Label itemName){
        ArrayList<ItemInterface> toAdd = new ArrayList<>();
        int counter = 0;

        //Remove all objects
        toAdd.clear();
        vBox.getChildren().clear();

        //if array list is empty add the item, if not check if item exists, if so add to quantity, if not just add item
        if(cartList.isEmpty()){
            cartList.add(item);
        }else {
            for (ItemInterface check : cartList) {
                    if(check.getName().equals(item.getName())){//match
                        check.setQuantity(check.getQuantity()+1);
                    }else{
                        counter++;
                    }
                }
        }

        //If the counter has the same number as the size of the arraylist then the item was not found so add to list
        if(counter == cartList.size()){
            cartList.add(item);
        }

        for (ItemInterface obj : cartList) {
            HBox hbox = new HBox(10);
            Label quantity = new Label(String.valueOf(obj.getQuantity()));
            quantity.setId("cartItems");
            Label name = new Label(obj.getName());
            name.setId("cartItems");
           // Button add = new Button("+");
            //Button minus = new Button("-");
            hbox.getChildren().addAll(quantity, name);
            hbox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hbox);


            hbox.setOnMouseEntered(event -> {
                quantity.setStyle("-fx-text-fill: darkred;");
                name.setStyle("-fx-text-fill: darkred;");
            });
            hbox.setOnMouseExited(event -> {
                quantity.setStyle("-fx-text-fill: white;");
                name.setStyle("-fx-text-fill: white;");
            });

            /**
             * BUG ALERT:
             * Currently works in the background but
             * in the foreground the item is not updating
             * correctly if you select another object to
             * add to the cart.  It goes off the last item
             * selected and only increments back into inventory
             * for that item(text wise not the actual list).
             */
            //set action event to decrement if they click on their cart items
            hbox.setOnMouseClicked(event -> {
                //System.out.println(itemName.getText());
                obj.setQuantity(obj.getQuantity()-1);
                updateInventory(obj, itemName);
                //update cart total also
                if(obj.getQuantity() > 0){
                    quantity.setText(String.valueOf(obj.getQuantity()));
                }else{
                    vBox.getChildren().remove(hbox);
                    cartList.remove(obj);
                }
            });
        }
        updateCartPrice(cartList);
    }

    public static void updateCartPrice(ArrayList<ItemInterface> arrayList){
        double price = 0;

        for (ItemInterface obj : arrayList) {
            price += obj.getPrice() * obj.getQuantity();
        }

        DecimalFormat df = new DecimalFormat("#.##");

       // price = Double.parseDouble(df.format(price));

        checkOut.setText("$"+String.format("%.2f",price) + " - Checkout");
        //System.out.println(price);
    }

    public static void updateInventory(ItemInterface obj, Label itemName){
        ArrayList<ItemInterface> inventory = RandomizeStoreContents.getStartTownList();
        String test = itemName.getText();
        test = test.replace("\t", "");
        test = test.replaceAll("[0-9]", "");
        System.out.println(test);

        for(ItemInterface check : inventory){
            if (obj.getName().equals(check.getName())){
                check.setQuantity(check.getQuantity()+1);
                for(ItemInterface refresh : RandomizeStoreContents.getStartTownList()) {
                    if (refresh.getName().equals(test)){
                        System.out.println("hit");
                        itemName.setText(refresh.getQuantity() + "\t" + refresh.getName());
                    }
                }
            }
        }
    }
    //getters and setters
    public static void setStartStore(Scene scene){StartTownStoreView.startStore = scene;}
    public static Scene getStartStore(){return StartTownStoreView.startStore;}
}
