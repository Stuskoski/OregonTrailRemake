package models;

import items.ItemInterface;
import javafx.scene.control.Tooltip;

/**
 * Created by augustus on 4/4/16.
 */
public class CreateTooltip {
    public static Tooltip getToolTipFromItem(ItemInterface item){

        String string;

        string = item.getDescription() + "\n" +
                "Stats: \n" +
                "Weight: " + item.getWeight() + "\n" +
                "Price: " + item.getPrice();

        return new Tooltip(string);
    }
}
