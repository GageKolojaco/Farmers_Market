package Stand;

import java.util.ArrayList;
import java.util.List;

import Farmer.Farmer;
import Inventory.InventoryItem;

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

    public String getFarmerName(){return farmer.getName();}

    public void setFarmer(Farmer farmer){this.farmer = farmer;}

    public void addItem(InventoryItem itemToAdd){
        for (InventoryItem item : inventory){//search through existing inventory
            if (item.getName().equals(itemToAdd.getName())){ //if the produce already exists then add more
                item.setNumberOfItems(item.getNumberOfItems()+itemToAdd.getNumberOfItems());
                return;
            }
        }
        //InventoryItem newItem = new Produce(produce, unitPrice, numberOfItems); //else it will hit this statement and add the new item
        inventory.add(itemToAdd);
    }

    public void removeProduce(InventoryItem produce, int numberOfItems){
        for (InventoryItem item : inventory){
            if (item.getName().equals(produce.getName())){
                item.setNumberOfItems(item.getNumberOfItems()-numberOfItems);
            }
        }
    }

    public List<InventoryItem> getInventory(){return inventory;}

    public String getInventoryToString(){
        String inventory = "";
        for (InventoryItem item : this.inventory){//search through existing inventory
            inventory += item.getName() + " Quantity: " + item.getNumberOfItems() + " ";
        }
        if (inventory.isEmpty()){inventory = "No Produce Assigned";}
        return inventory;
    }
}