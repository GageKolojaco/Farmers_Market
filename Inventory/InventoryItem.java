package Inventory;

public interface InventoryItem { //maybe look into making inventory item a parent class to produce?

    String getName();

    int getNumberOfItems();

    void setNumberOfItems(int numberOfItems);

    double getUnitPrice();

}
