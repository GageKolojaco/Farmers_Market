package Inventory;

import Produce.Produce;

public class InventoryItem {
    private Produce produce;
    private int numberOfItems;

    public InventoryItem(Produce produce, int numberOfItems){
        this.produce = produce;
        this.numberOfItems = numberOfItems;
    }

    public Produce getProduce(){return produce;}
    
    public String getProduceName(){return produce.getName();}

    public int getNumberOfItems(){return numberOfItems;}

    public void setNumberOfItems(int numberOfItems){this.numberOfItems = numberOfItems;}

}
