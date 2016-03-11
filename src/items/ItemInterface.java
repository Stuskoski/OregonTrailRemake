package items;

/**
 * Created by augustus on 1/28/16.
 */
public interface ItemInterface{
    double getWeight();
    void   setWeight(double weight);
    String getDescription();
    double getPrice();
    String getName();
    int    getQuantity();
    void   setQuantity(int quantity);
    String getCategory();
    ItemInterface cloneObject();
    //ItemInterface clone();
}
