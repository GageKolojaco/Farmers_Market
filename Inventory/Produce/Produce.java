package Inventory.Produce;

import Inventory.InventoryItem;

public abstract class Produce implements InventoryItem{
    public enum produceTypes {ASPARAGUS, CELERY, DRAGONFRUIT, STRAWBERRY, WATERMELON;} //gotta be something better than this
    protected String name;
    protected double unitPrice;
    protected int numberOfItems;
    


    public Produce(String name, double unitPrice, int numberOfItems){ //Constructor
        this.name = name;
        this.unitPrice = unitPrice;
        this.numberOfItems = numberOfItems;
    }

    @Override
    public String getName(){return name;}

    @Override
    public int getNumberOfItems(){return numberOfItems;}

    @Override
    public void setNumberOfItems(int numberOfItems){this.numberOfItems = numberOfItems;}

    @Override
    public double getUnitPrice(){return unitPrice;}

    
}
