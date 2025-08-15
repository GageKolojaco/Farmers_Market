package Market;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Farmer.Farmer;
import Inventory.InventoryItem;
import Inventory.Produce.Produce;
import Inventory.Produce.ProduceFactory;
import Inventory.Produce.Produce.produceTypes;
import Stand.Stand;

public class Market {  //using a basic linked list to connect all the stands in the market

    private static class Node { //nested node class
        Stand stand;
        int standID;
        Node next;

        Node(Stand stand) {
            this.stand = stand;
            this.standID = stand.getStandID();
            this.next = null;
        }
    }

    private Node head;
    private int size;
    Scanner input = new Scanner(System.in);

    public Market(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){return size;}//might not be necessary

    private Stand getStand(int standID){
        Node currentNode = head;
        Stand stand = null;
        while (currentNode != null){
            if (currentNode.standID == standID){
                stand = currentNode.stand;
            }
            currentNode = currentNode.next;
        }
        return stand;
    }

    private boolean containsStand(int standID){ //change this later to probably if (getStand) true, else false
        boolean containsStand = false;
        if (getStand(standID) != null){
            containsStand = true;
        }
        return containsStand;
    }

    public void openMarket() {
        boolean marketMenu = true;
        while(marketMenu){
            System.out.println("====================");
            System.out.println("Market Menu:");
            System.out.println("1:> Add Stand");
            System.out.println("2:> Assign Farmer to Stand");
            System.out.println("3:> Assign Produce to Stand");
            System.out.println("4:> View Stands");
            System.out.println("5:> View Stand in detail");
            System.out.println("6:> Search by Produce Name");
            System.out.println("7:> Exit to Main Menu");
            System.out.println("====================");
            try{    
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        addStand();
                        break;
                    case 2:
                        assignFarmer();
                        break;
                    case 3:
                        assignProduce();
                        break;
                    case 4:
                        listStands();
                        break;
                    case 5:
                        viewStandsInDetail();
                        break;
                    case 6:
                        searchProduce();
                        break;
                    case 7:
                        marketMenu = false;
                        return;
                    default:
                        System.out.println("Please enter an integer value 1 through 7");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please input a valid integer.");
                input.nextLine();
            }
        }
    } 

    /*private void insertStand(Stand stand){ //can comfortably move all the functionality into addStand() for clarity
        Node newNode = new Node(stand);
        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null){currentNode = currentNode.next;}
            currentNode.next = newNode;

        }
        size++;
    }*/
    //change most methods to private later now that most of the logic is handled within the market class
    private void addStand(){ //found bug with addStand()? only first created stand is displayed in listStands()
        System.out.println("====================");
        System.out.println("Please enter an integer value representing the ID of the stand to be added:");
        System.out.println("====================");
        int standID = input.nextInt();
        Stand newStand = new Stand(standID);
        Node newNode = new Node(newStand);
        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null){currentNode = currentNode.next;}
            currentNode.next = newNode;
        }
        size++;
        System.out.println("====================");
        System.out.println("Stand ID # " + standID + " added.");
    }
     /*private void assignFarmer(int standID, Farmer farmer){ //can also move functionality into assignFarmerToStand
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.standID == standID){
                currentNode.stand.setFarmerName(farmer);
            }
            currentNode = currentNode.next;
        }
    }*/
    private void assignFarmer(){
        System.out.println("====================");
        if(listStands()){
            System.out.println("Please select a Stand ID number to assign a farmer to:");
            System.out.println("====================");
            int standID = input.nextInt();
            boolean validStandSelected = false;
            while (!validStandSelected){
                if (containsStand(standID)){
                    validStandSelected = true;
                    System.out.println("====================");
                    System.out.println("Please enter the name of the farmer to be assigned to Stand ID #: " + standID);
                    System.out.println("====================");
                    input.nextLine();
                    String farmerName = input.nextLine();
                    Farmer newFarmer = new Farmer(farmerName);
                    //assignFarmer(standID, newFarmer);
                    Node currentNode = head;
                    while (currentNode != null){
                        if (currentNode.standID == standID){
                            currentNode.stand.setFarmer(newFarmer);
                        }
                        currentNode = currentNode.next;
                    }
                    System.out.println("====================");
                    System.out.println("Farmer " + farmerName + " assigned to Stand ID # " + standID + ".");    
                } else{
                    System.out.println("Please select a valid Stand ID #.");
                    standID = input.nextInt();
                }
            }
        }
    }

    private void assignProduce(){
        System.out.println("===================="); 
        if(listStands()){
            System.out.println("Please select a Stand ID number to assign produce to:");
            System.out.println("====================");
            int standID = input.nextInt();
            boolean validStandSelected = false;
            while (!validStandSelected){
                if(containsStand(standID)){
                    validStandSelected = true;
                    System.out.println("====================");
                    System.out.println("Please select the piece of produce to be assigned to Stand ID #: " + standID);
                    System.out.println("====================");
                    int i=1;
                    for (Produce.produceTypes type : produceTypes.values()) {
                        System.out.println(i + ": " + type.toString());
                        i++;
                    }
                    System.out.println("====================");
                    int produceChoice = input.nextInt();
                    System.out.println("====================");
                    System.out.println("Please enter a integer value representing the quantity of produce to be assigned to Stand ID #: " + standID);
                    System.out.println("====================");
                    int quantity = input.nextInt();
                    System.out.println("====================");
                    System.out.println("Please enter a decimal value representing the unit price of the produce to be assigned to Stand ID #: " + standID);
                    System.out.println("====================");
                    double unitPrice = input.nextDouble();
                    String produceChoiceString = null;
                    switch(produceChoice){
                        case 1: 
                            produceChoiceString = "asparagus";
                            break;
                        case 2: 
                            produceChoiceString = "celery";
                            break;
                        case 3: 
                            produceChoiceString = "dragonfruit";
                            break;
                        case 4: 
                            produceChoiceString = "strawberry";
                            break; 
                        case 5: 
                            produceChoiceString =  "watermelon";
                            break;
                        default: break;
                    }
                    InventoryItem newItem = ProduceFactory.build(produceChoiceString, unitPrice, quantity);
                    Stand stand = getStand(standID);
                    stand.addItem(newItem);
                    System.out.println("====================");
                    System.out.println("Added " + quantity + " " + produceChoiceString + " to Stand ID # " + standID + " at a unit price of $" + unitPrice);
                    System.out.println("====================");
                } else{
                System.out.println("Please select a valid Stand ID #.");
                standID = input.nextInt();
                }
            }
        }
    }

    private boolean listStands(){
        System.out.println("====================");
        System.out.println("Available Stands: ");
        System.out.println("====================");
        Node currentNode = head;
        boolean standsPresent = false;
        if (currentNode != null){
            while (currentNode.next != null){
            System.out.println("Stand ID#: " + currentNode.standID + " Farmer: " + currentNode.stand.getFarmerName());
            currentNode = currentNode.next;
            }
        System.out.println("Stand ID#: " + currentNode.standID + " | Farmer: " + currentNode.stand.getFarmerName()); //+ " Produce Sold: " + currentNode.stand.getInventoryToString());
        System.out.println("====================");
        standsPresent = true;
        return standsPresent;
        } else {
            System.out.println("No available stands");
            return standsPresent;
        }
        
    }

    private void viewStandsInDetail(){
        if(listStands()){
            System.out.println("====================");
            System.out.println("Please select a Stand ID # look at in further detail:");
            System.out.println("====================");
            int standID = input.nextInt();
            Stand stand = getStand(standID); //next step is pulling up stand details, exit stand button, and buy produce button.
            System.out.println("====================");
            System.out.println("Stand ID #: " + standID);
            System.out.println("Inventory: " + stand.getInventoryToString());
            System.out.println("====================");
            System.out.println("Options: ");
            System.out.println("1:> Purchase Produce");
            System.out.println("2:> Exit to Market Menu");
            System.out.println("====================");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    buyProduce(stand);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Please enter the integer value 1 or 2");
            }
        }
    }

    private void buyProduce(Stand stand){
        System.out.println("====================");
        System.out.println("Please select the produce you would like to purchase:");
        System.out.println("====================");
        List<InventoryItem> availableItems = new ArrayList<>();
        int i=1;
        for (InventoryItem item : stand.getInventory()) {
            System.out.println(i + ": " + item.getName() + " | Quantity: " + item.getNumberOfItems() + " | Unit Price: " + item.getUnitPrice());
            availableItems.add(item);
            i++;
        }
        System.out.println("====================");
        int choice = input.nextInt();
        if (choice <= 0 || choice > availableItems.size()){
            System.out.println("Please input a valid integer");
        } else{
            InventoryItem selectedItem = availableItems.get(choice-1);
            System.out.println("====================");
            System.out.println("Please enter an integer value representing the quantity you would like to purchase");
            System.out.println("====================");
            int quantity = input.nextInt();
            stand.removeProduce(selectedItem, quantity);
            System.out.println("====================");
            System.out.println("Purchased " + quantity + " of " + selectedItem.getName() + " at a unit price of " + selectedItem.getUnitPrice() + " for a total of $" + (quantity * selectedItem.getUnitPrice()));
            System.out.println("====================");
        }
    }

    private void searchProduce(){
        System.out.println("====================");
        System.out.println("Select the type of produce you would like to search for:");
        int i=1;
            for (Produce.produceTypes type : produceTypes.values()) {
                System.out.println(i + ": " + type.toString());
                i++;
            }
        System.out.println("====================");
        int produceChoice = input.nextInt();
        String produceName = "";
        switch(produceChoice){
                    case 1:
                        produceName = "Asparagus";
                        break;
                    case 2:
                        produceName = "Celery";
                        break;
                    case 3:
                        produceName = "Dragonfruit";
                        break;
                    case 4:
                        produceName = "Strawberry";
                        break;
                    case 5:
                        produceName = "Watermelon";
                        break;
                    default:
                        System.out.println("Please enter an integer value 1 through 6");
                }
        for (Stand tempStand : findStandsFromProduceName(produceName)){
            System.out.println("====================");
            System.out.println("Stand ID #: " + tempStand.getStandID());
            System.out.println("Inventory: " + tempStand.getInventoryToString());
            System.out.println("====================");
        }
    }

    private List<Stand> findStandsFromProduceName(String produceName){
        List<Stand> listOfStands = new ArrayList<>();
        Node currentNode = head;
        while (currentNode != null){
            for (InventoryItem item : currentNode.stand.getInventory())
                if (produceName.equals(item.getName())){
                    listOfStands.add(currentNode.stand);
                }
            currentNode = currentNode.next;
        }
        return listOfStands; 
    }

}