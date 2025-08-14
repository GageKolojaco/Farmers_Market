package Stand;

import java.util.ArrayList;
import java.util.List;

import Farmer.Farmer;
import Inventory.InventoryItem;
import Produce.Produce;

public class Stand {
    private Farmer farmer = new Farmer(null);
    private List<InventoryItem> inventory;
    private int standID;

    //public Stand (Farmer farmer, int standID){ //Stand constructor
    public Stand (int standID){
        //this.farmer = farmer; // we will see how we want to implement this
                              // thinking about making the constructor only use the list
        this.inventory = new ArrayList<>();
        this.standID = standID;
    }
    
    public int getStandID(){return standID;}

    public void setStandID(int standID){this.standID = standID;}

    //public Farmer getFarmer(){return farmer;}
    public String getFarmerName(){return farmer.getName();}

    public void setFarmer(Farmer farmer){this.farmer = farmer;}

    public void addProduce(Produce produce, int numberOfItems){
        for (InventoryItem item : inventory){//search through existing inventory
            if (item.getProduce().equals(produce)){ //if the produce already exists then add more
                item.setNumberOfItems(item.getNumberOfItems()+numberOfItems);
                return;
            }
        }
        InventoryItem newItem = new InventoryItem(produce, numberOfItems); //else it will hit this statement and add the new item
        inventory.add(newItem);
    }

    public void removeProduce(Produce produce, int numberOfItems){
        for (InventoryItem item : inventory){
            if (item.getProduce().equals(produce)){
                item.setNumberOfItems(item.getNumberOfItems()-numberOfItems);
            }
        }
    }

    public List<InventoryItem> getIventory(){return inventory;}

}