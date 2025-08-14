import java.util.InputMismatchException;
import java.util.Scanner;

import Farmer.Farmer;
import Market.Market;
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
                        //addStand();
                        //market.addStand();
                        System.out.println("====================");
                        System.out.println("Please enter an integer value representing the ID of the stand to be added:");
                        int standID = input.nextInt();
                        Stand newStand = new Stand(standID);
                        market.addStand(newStand);
                        System.out.println("Stand ID # " + standID + " added.");
                        break;
                    case 2:
                    //assignFarmerToStand();
                        System.out.println("====================");
                        market.listStands();
                        System.out.println("Please select a Stand ID number to assign a farmer to:");
                        standID = input.nextInt();
                        System.out.println("Please enter the name of the farmer to be assigned to Stand ID #: " + standID);
                        String farmerName = input.next();
                        Farmer newFarmer = new Farmer(farmerName);
                        
                    case 3:
                    //assignProduce to Stand();
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
                        System.out.println("Please enter an integer value 1 through 5");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please input a valid integer.");
                input.nextLine();
            }
        }
    }   
}
