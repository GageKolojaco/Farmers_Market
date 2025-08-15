package Inventory;

import Produce.Produce;

public class InventoryItem { //maybe look into making inventory item a parent class to produce?
    private Produce produce;
    private int numberOfItems;
    private double unitPrice;

    public InventoryItem(Produce produce, int numberOfItems, double unitPrice){
        this.produce = produce;
        this.numberOfItems = numberOfItems;
        this.unitPrice = unitPrice;
    }

    public Produce getProduce(){return produce;}

    public String getProduceName(){return produce.getName();}

    public int getNumberOfItems(){return numberOfItems;}

    public void setNumberOfItems(int numberOfItems){this.numberOfItems = numberOfItems;}

    public double getUnitPrice(){return unitPrice;}

    public void setUnitPrice(double unitPrice){this.unitPrice = unitPrice;}

}
