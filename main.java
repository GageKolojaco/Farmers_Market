import java.util.Scanner;

import Market.Market;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Market market = new Market();

    public static void main(String[] args) {
        boolean on = true;
        while(on = true){
            System.out.println("Main Menu:");
            System.out.println("1:> Open Market");
            System.out.println("2:> Exit");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    openMarket();
                case 2:
                    on = false;
                default:
                    System.out.println("Please enter the value 1 or 2");
            }
        }
    }

    private static void openMarket() {
        
}
