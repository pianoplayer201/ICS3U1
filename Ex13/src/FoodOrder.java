import java.util.Scanner;
/*
Program: FoodOrder
Programmer: Ryan Mehrian
Date: March 28, 2024
-----
This program will display a menu for the user. The program will accept user input indicating
their chosen meal, and output the cost of the item.
 */
public class FoodOrder {
    public static void main(String[]args) {
        //Declarations
        final double PRICE1 = 2.5;
        final double PRICE2 = 2.5;
        final double PRICE3 = 3;
        final double PRICE4 = 3.5;
        final double PRICE5 = 5;

        Scanner sc = new Scanner(System.in);

        //Menu Display
        System.out.println("1. Juice, muffin and coffee");
        System.out.println("2. Cereal, toast and milk");
        System.out.println("3. Egg, toast and coffee");
        System.out.println("4. Banana, granola and milk");
        System.out.println("5. Grapefruit, bacon, eggs and coffee");

        //Input Prompt
        System.out.print("\nWhich menu option would you like to order?\n > ");

        //Checks and Output
        switch(sc.nextInt()){
            case 1:
                System.out.printf("That will cost $%.2f", PRICE1);
                break;
            case 2:
                System.out.printf("That will cost $%.2f", PRICE2);
                break;
            case 3:
                System.out.printf("That will cost $%.2f", PRICE3);
                break;
            case 4:
                System.out.printf("That will cost $%.2f", PRICE4);
                break;
            case 5:
                System.out.printf("That will cost $%.2f", PRICE5);
                break;
            default:
                System.out.println("That option isn't on the menu.");
                break;

        }





    }

}
