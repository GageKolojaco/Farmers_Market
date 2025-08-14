import java.util.InputMismatchException;
import java.util.Scanner;

import Market.Market;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Market market = new Market();

    public static void main(String[] args) {
        boolean mainMenu = true;
        while(mainMenu){
            System.out.println("Main Menu:");
            System.out.println("1:> Open Market");
            System.out.println("2:> Exit");
            try{    
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        openMarket();
                    case 2:
                        mainMenu = false;
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
            System.out.println();
            System.out.println("Market:");
            System.out.println("1:> Add Stand");
            System.out.println("2:> Assign Farmer to Stand");
            System.out.println("3:> Assign Produce to Stand");
            System.out.println("4:> View Stands");
            System.out.println("5:> Search by Produce Name");
            try{    
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                    //addStand();
                    case 2:
                    //assignFarmerToStand();
                    case 3:
                    //assignProduce to Stand();
                    case 4:
                    //viewStands();
                    case 5:
                    //search();
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
