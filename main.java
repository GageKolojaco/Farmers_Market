import java.util.InputMismatchException;
import java.util.Scanner;

import Farmer.Farmer;
import Market.Market;
import Produce.Asparagus;
import Produce.Produce;
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
            System.out.println("5:> Search by Produce Name");
            System.out.println("6:> Exit to Main Menu");
            System.out.println("====================");
            try{    
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
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
                                        Asparagus asparagus = new Asparagus(unitPrice);
                                        Stand stand = market.getStand(standID);
                                        stand.addProduce(asparagus, quantity);
                                        break;
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
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
                        System.out.println("====================");
                        market.listStands();
                        break;
                    case 5:
                    //search();
                    case 6:
                        marketMenu = false;
                        return;
                    default:
                        System.out.println("Please enter an integer value 1 through 6");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please input a valid integer.");
                input.nextLine();
            }
        }
    }   
}
