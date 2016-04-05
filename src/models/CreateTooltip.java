package models;

import items.Animals.AnimalInterface;
import items.Clothing.ClothingInterface;
import items.Guns.GunInterface;
import items.ItemInterface;
import items.meds.MedsInterface;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Created by augustus on 4/4/16.
 * Return a tooltip for the item
 */
public class CreateTooltip {
    public static Tooltip getToolTipFromItem(ItemInterface item){
        String string;

        string = item.getDescription() + "\n" +
                "Stats: \n" +
                "Weight: " + item.getWeight() + "\n" +
                "Price: " + item.getPrice();

        switch (item.getCategory()){
            case "meds":
                MedsInterface meds = (MedsInterface) item;
                string += ("\nHeals: " + meds.diseaseHealed());
                break;
            case "clothing":
                ClothingInterface clothing = (ClothingInterface) item;
                string += ("\nWarmth: " + clothing.getWarmth());
                break;
            case "guns":
                if(!item.getName().equals("Bullet")) {
                    GunInterface gun = (GunInterface) item;
                    string += ("\n" +
                            "Bullets Shot: " + gun.getBulletsShot() + "\n" +
                            "Bullet Speed: " + gun.getBulletSpeed() + "\n" +
                            "Reload Time: " + gun.getReloadTime() + "\n");
                }
                break;
            case "animal":
                AnimalInterface animal = (AnimalInterface) item;
                string += "\nWeight Capacity: " + animal.getCarryingCapacity();
                break;
        }

        return new Tooltip(string);
    }
}
