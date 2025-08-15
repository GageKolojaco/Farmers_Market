import java.util.InputMismatchException;
import java.util.Scanner;
import Market.Market;

public class Main{
    private static Scanner input = new Scanner(System.in);
    private static Market market = new Market();

    public static void main(String[] args) {
        boolean mainMenuFlag = true;
        while(mainMenuFlag){
            mainMenu(mainMenuFlag);
        }
    }

    private static void mainMenu(boolean mainMenuFlag){
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
                    market.openMarket();
                    break;
                case 2:
                    mainMenuFlag = false;
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
