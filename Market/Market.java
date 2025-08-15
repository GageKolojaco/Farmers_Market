package Market;

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

    public int getSize(){return size;}

    public void openMarket() {
        boolean marketMenu = true;
        while(marketMenu){
            System.out.println("====================");
            System.out.println("Market:");
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
                        assignFarmerToStand();
                        break;
                    case 3:
                        assignProduceToStand();
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

    private void insertStand(Stand stand){
        Node newNode = new Node(stand);
        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null){currentNode = currentNode.next;}
            currentNode.next = newNode;

        }
        size++;
    }
    //change most methods to private later now that most of the logic is handled within the market class
    private void addStand(){
        System.out.println("====================");
        System.out.println("Please enter an integer value representing the ID of the stand to be added:\n");
        int standID = input.nextInt();
        Stand newStand = new Stand(standID);
        insertStand(newStand);
        System.out.println("\nStand ID # " + standID + " added.");
    }

    private boolean listStands(){
        System.out.println("====================");
        Node currentNode = head;
        boolean standsPresent = false;
        if (currentNode != null){
            while (currentNode.next != null){
            System.out.println("Stand ID#: " + currentNode.standID + " Farmer: " + currentNode.stand.getFarmerName());
            currentNode = currentNode.next;
            }
        System.out.println("Stand ID#: " + currentNode.standID + " Farmer: " + currentNode.stand.getFarmerName()); //+ " Produce Sold: " + currentNode.stand.getInventoryToString());
        standsPresent = true;
        return standsPresent;
        } else {
            System.out.println("No available stands");
            return standsPresent;
        }
        
    }

    private void assignFarmer(int standID, Farmer farmer){
        Node currentNode = head;
        while (currentNode.next != null){
            if (currentNode.standID == standID){
                currentNode.stand.setFarmerName(farmer);
            }
            currentNode = currentNode.next;
        }
        if (currentNode.standID == standID){currentNode.stand.setFarmerName(farmer);}
    }

    private void assignFarmerToStand(){
        System.out.println("====================");
        if(listStands()){
            System.out.println("Please select a Stand ID number to assign a farmer to:");
            int standID = input.nextInt();
            boolean validStandSelected = false;
            while (!validStandSelected){
                if (containsStand(standID)){
                    validStandSelected = true;
                    System.out.println("Please enter the name of the farmer to be assigned to Stand ID #: " + standID);
                    input.nextLine();
                    String farmerName = input.nextLine();
                    Farmer newFarmer = new Farmer(farmerName);
                    assignFarmer(standID, newFarmer);
                    System.out.println("Farmer " + farmerName + " assigned to Stand ID # " + standID + ".");    
                } else{
                    System.out.println("Please select a valid Stand ID #.");
                    standID = input.nextInt();
                }
            }
        }
    }

    private boolean containsStand(int standID){ //change this later to probably if (getStand) true, else false
        Node currentNode = head;
        boolean containsStand = false;
        while (currentNode.next != null){
            if (currentNode.standID == standID){
                containsStand = true;
            }
            currentNode = currentNode.next;
        }
        if (currentNode.standID == standID){containsStand = true;}
        return containsStand;
    }

    private Stand getStand(int standID){
        Node currentNode = head;
        Stand stand = null;
        while (currentNode.next != null){
            if (currentNode.standID == standID){
                stand = currentNode.stand;
            }
            currentNode = currentNode.next;
        }
        if (currentNode.standID == standID){stand = currentNode.stand;}
        return stand;
    }

    private List<Stand> findStandsFromProduce(String produce){
        List<Stand> listOfStands = null;
        Node currentNode = head;
        while (currentNode.next != null){
            for (InventoryItem item : currentNode.stand.getInventory())
                if (produce.equals(item.getName())){
                    listOfStands.add(currentNode.stand);
                }
            currentNode = currentNode.next;
        }
        for (InventoryItem item : currentNode.stand.getInventory())
            if (produce.equals(item.getName())){
                listOfStands.add(currentNode.stand);
            }
        return listOfStands; 
    }

    private void assignProduceToStand(){
        System.out.println("===================="); 
        if(listStands()){
            System.out.println("Please select a Stand ID number to assign produce to:");
            int standID = input.nextInt();
            boolean validStandSelected = false;
            while (!validStandSelected){
                if(containsStand(standID)){
                    validStandSelected = true;
                    System.out.println("Please select the piece of produce to be assigned to Stand ID #: " + standID);
                    int i=1;
                    for (Produce.produceTypes type : produceTypes.values()) {
                        System.out.println(i + ": " + type.toString());
                        i++;
                    }
                    int produceChoice = input.nextInt();
                    System.out.println("Please enter a integer value representing the quantity of produce to be assigned to Stand ID #: " + standID);
                    int quantity = input.nextInt();
                    System.out.println("Please enter a decimal value representing the unit price of the produce to be assigned to Stand ID #: " + standID);
                    double unitPrice = input.nextDouble();
                    String produceChoiceString = null;
                    switch(produceChoice){
                        case 1: produceChoiceString = "asparagus";
                        case 2: produceChoiceString = "celery";
                        case 3: produceChoiceString = "dragonfruit";
                        case 4: produceChoiceString = "strawberry"; 
                        case 5: produceChoiceString =  "watermelon";
                        default: break;
                    }
                    InventoryItem newItem = ProduceFactory.build(produceChoiceString, unitPrice, quantity);
                    Stand stand = getStand(standID);
                    stand.addItem(newItem);
                    System.out.println("Added " + quantity + " " + produceChoiceString + "to Stand ID # " + standID);
                } else{
                System.out.println("Please select a valid Stand ID #.");
                standID = input.nextInt();
                }
            }
        }
    }

    private void viewStandsInDetail(){
        if(listStands()){
            System.out.println("====================");
            System.out.println("Please select a Stand ID # look at in further detail:");
            int standID = input.nextInt();
            Stand stand = getStand(standID);//next step is pulling up stand details, exit stand button, and buy produce button.
            System.out.println("====================");
            System.out.println("Stand ID #: " + standID);
            System.out.println("Inventory: " + stand.getInventoryToString());
            System.out.println("====================");
            System.out.println("Options: ");
            System.out.println("1:> Purchase Produce");
            System.out.println("2:> Exit to Market Menu");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please select the produce you would like to purchase:");
                    int i=1;
                    for (InventoryItem item : stand.getInventory()) {
                        System.out.println(i + ": " + item.getName() + " Unit Price: " + item.getUnitPrice());
                        i++;
                    }
                    choice = input.nextInt();
                    if (choice <= 0 || choice >= i){
                        System.out.println("Please input a valid integer");
                    } else{
                        String produceName = stand.getInventory().get(choice).getName();
                        System.out.println("Please enter the quantity of " + produceName + " you would like to buy");
                        int quantity = input.nextInt();
                        //stand.removeProduce(stand.getInventory().get(choice).getProduce(), quantity); 
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Please enter the integer value 1 or 2");
            }
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
        int produceChoice = input.nextInt();
        String produce = "";
        switch(produceChoice){
                    case 1:
                        produce = "Asparagus";
                        break;
                    case 2:
                        produce = "Celery";
                        break;
                    case 3:
                        produce = "Dragonfruit";
                        break;
                    case 4:
                        produce = "Strawberry";
                        break;
                    case 5:
                        produce = "Watermelon";
                        break;
                    default:
                        System.out.println("Please enter an integer value 1 through 6");
                }
        for (Stand tempStand : findStandsFromProduce(produce)){
            System.out.println("====================");
            System.out.println("Stand ID #: " + tempStand.getStandID());
            System.out.println("Inventory: " + tempStand.getInventoryToString());
            System.out.println("====================");
        }
    }
}