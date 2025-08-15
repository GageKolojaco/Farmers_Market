import java.util.InputMismatchException;
import java.util.Scanner;

import Farmer.Farmer;
import Inventory.InventoryItem;
import Market.Market;
import Produce.Asparagus;
import Produce.Celery;
import Produce.Dragonfruit;
import Produce.Produce;
import Produce.Strawberry;
import Produce.Watermelon;
import Produce.Produce.produceTypes;
import Stand.Stand;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Market market = new Market();

    public static void main(String[] args) {
        boolean mainMenu = true;
        while(mainMenu){
            System.out.println("====================");
            System.out.println("Main Menu:");
            System.out.println("1:> Open Market");
            System.out.println("2:> Exit");
            System.out.println("====================");
            try{    
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        openMarket();
                        break;
                    case 2:
                        mainMenu = false;
                        return;
                    default:
                        System.out.println("Please enter the integer value 1 or 2");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please input a valid integer.");
                input.nextLine();
            }
        }
    }

    private static void openMarket() {
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
                    //addStand();
                        System.out.println("====================");
                        System.out.println("Please enter an integer value representing the ID of the stand to be added:\n");
                        int standID = input.nextInt();
                        Stand newStand = new Stand(standID);
                        market.addStand(newStand);
                        System.out.println("\nStand ID # " + standID + " added.");
                        break;
                    case 2:
                    //assignFarmerToStand();
                        System.out.println("====================");
                        market.listStands();
                        System.out.println("Please select a Stand ID number to assign a farmer to:");
                        standID = input.nextInt();
                        boolean validStandSelected = false;
                        while (!validStandSelected){
                            if (market.containsStand(standID)){
                                validStandSelected = true;
                                System.out.println("Please enter the name of the farmer to be assigned to Stand ID #: " + standID);
                                input.nextLine();
                                String farmerName = input.nextLine();
                                Farmer newFarmer = new Farmer(farmerName);
                                market.assignFarmer(standID, newFarmer);
                                System.out.println("Farmer " + farmerName + " assigned to Stand ID # " + standID + ".");    
                            } else{
                                System.out.println("Please select a valid Stand ID #.");
                                standID = input.nextInt();
                            }
                        }
                        break;
                    case 3:
                    //assignProduce to Stand();
                        System.out.println("===================="); 
                        market.listStands();
                        System.out.println("Please select a Stand ID number to assign produce to:");
                        standID = input.nextInt();
                        validStandSelected = false;
                        while (!validStandSelected){
                            if(market.containsStand(standID)){
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
                                switch(produceChoice){
                                    case 1:
                                        Asparagus asparagus = new Asparagus(unitPrice);//change constructor so that it takes no args
                                        Stand stand = market.getStand(standID);
                                        stand.addProduce(asparagus, quantity, unitPrice);
                                        break;
                                    case 2:
                                        Celery celery = new Celery(unitPrice);
                                        stand = market.getStand(standID);
                                        stand.addProduce(celery, quantity, unitPrice);
                                        break;
                                    case 3:
                                        Dragonfruit dragonfruit = new Dragonfruit(unitPrice);
                                        stand = market.getStand(standID);
                                        stand.addProduce(dragonfruit, quantity, unitPrice);
                                        break;
                                    case 4:
                                        Strawberry strawberry = new Strawberry(unitPrice);
                                        stand = market.getStand(standID);
                                        stand.addProduce(strawberry, quantity, unitPrice);
                                        break;
                                    case 5:
                                        Watermelon watermelon = new Watermelon(unitPrice);
                                        stand = market.getStand(standID);
                                        stand.addProduce(watermelon, quantity, unitPrice);
                                        break;
                                    default:
                                        System.out.println("Please enter an integer value 1 through 6");
                                }

                            } else{
                            System.out.println("Please select a valid Stand ID #.");
                            standID = input.nextInt();
                            }
                        }
                        break;
                    case 4:
                        //listStands();
                        System.out.println("====================");
                        market.listStands();
                        break;
                    case 5:
                    //viewStandsInDetail();
                        System.out.println("====================");
                        System.out.println("Please select a Stand ID # look at in further detail:");
                        standID = input.nextInt();
                        Stand stand = market.getStand(standID);//next step is pulling up stand details, exit stand button, and buy produce button.
                        System.out.println("====================");
                        System.out.println("Stand ID #: " + standID);
                        System.out.println("Inventory: " + stand.getInventoryToString());
                        System.out.println("====================");
                        System.out.println("Options: ");
                        System.out.println("1:> Purchase Produce");
                        System.out.println("2:> Exit to Market Menu");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Please select the produce you would like to purchase:");
                                int i=1;
                                for (InventoryItem item : stand.getInventory()) {
                                    System.out.println(i + ": " + item.getProduceName() + " Unit Price: " + item.getUnitPrice());
                                    i++;
                                }
                                choice = input.nextInt();
                                if (choice <= 0 || choice >= i){
                                    System.out.println("Please input a valid integer");
                                } else{
                                    String produceName = stand.getInventory().get(choice).getProduceName();
                                    System.out.println("Please enter the quantity of " + produceName + " you would like to buy");
                                    int quantity = input.nextInt();
                                    stand.removeProduce(stand.getInventory().get(choice).getProduce(), quantity); 
                                }
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Please enter the integer value 1 or 2");
                        }
                        break;
                    case 6:
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
                        for (Stand tempStand : market.findStandsFromProduce(produce)){
                            System.out.println("====================");
                            System.out.println("Stand ID #: " + tempStand.getStandID());
                            System.out.println("Inventory: " + tempStand.getInventoryToString());
                            System.out.println("====================");
                        }
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
}
