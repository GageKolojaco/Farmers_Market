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
                if (itemToAdd.getUnitPrice() > 0) {item.setUnitPrice(itemToAdd.getUnitPrice());}
                return;
            }
        }
        //InventoryItem newItem = new Produce(produce, unitPrice, numberOfItems); //else it will hit this statement and add the new item //OBSOLETE
        inventory.add(itemToAdd);
    }

    public void removeProduce(InventoryItem produce, int numberOfItems){ //for each loop doesn't work here as the list will need to be modified while looping
        /*for (InventoryItem item : inventory){
            if (item.getName().equals(produce.getName())){
                item.setNumberOfItems(item.getNumberOfItems()-numberOfItems);
            }
        }*/
        for (int i=0; i < inventory.size(); i++){
            InventoryItem item = inventory.get(i);
            if (item.getName().equals(produce.getName())){
                int quantityRemaining = item.getNumberOfItems() - numberOfItems;
                if (quantityRemaining < 0){System.out.println("Invalid Selection: Attempt to remove a higher quantity than stocked");}
                else{
                    if (quantityRemaining == 0) {
                        inventory.remove(i);
                    } else {
                        item.setNumberOfItems(quantityRemaining);
                    }
                }
            }
        }
    }

    public List<InventoryItem> getInventory(){return inventory;}

    public String getInventoryOfSpecifiedProduce(String produceName){
        String specificInventory = "\n";
        for (InventoryItem item : this.inventory){//search through existing inventory
            if (item.getName().equals(produceName)) {
                specificInventory += item.getName() + " | Quantity: " + item.getNumberOfItems() + " " + " | Unit Price: " + item.getUnitPrice();
            }
        }
        return specificInventory;
    }

    public String getInventoryToString(){
        String inventory = "\n";
        for (InventoryItem item : this.inventory){//search through existing inventory
            inventory += item.getName() + " | Quantity: " + item.getNumberOfItems() + " " + " | Unit Price: " + item.getUnitPrice() +"\n";
        }
        if (inventory.isEmpty()){inventory = "No Produce Assigned";}
        return inventory;
    }
}