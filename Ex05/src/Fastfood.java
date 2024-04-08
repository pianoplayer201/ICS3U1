import java.util.Scanner;

/*
Program Name: Fastfood
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
The program helps the cashier of a fast-food restaurant calculate the price
of their order (subtotal, HST 13%, and final total). The program will
also tell the cashier how much change should be given back to the customer.
 */
public class Fastfood {

    public static void main(String[] args){
        // CONSTANTS & VARIABLES
        final double HST = 0.13;
        final double burgerPrice = 1.69;
        final double friesPrice = 1.09;
        final double sodaPrice = 0.99;
        double subTotal = 0;
        double taxTotal;
        double finalTotal;
        double tenderedAmount;
        double dueChange;

        // Scanner Object
        Scanner sc = new Scanner(System.in);

        // Inputs for Order
        System.out.println("Please enter the number of items the user ordered: ");
        System.out.print("Burgers: ");
        subTotal += burgerPrice*sc.nextDouble();
        System.out.print("Fries: ");
        subTotal += friesPrice*sc.nextDouble();
        System.out.print("Sodas: ");
        subTotal += sodaPrice*sc.nextDouble();

        // Outputs for costs
        taxTotal = subTotal*HST;
        finalTotal = taxTotal + subTotal;
        System.out.println("Here is the total cost of the order:");
        System.out.printf("%n%-9s $%.2f%n %-9s  + %n%-9s $%.2f%n%n%-9s $%.2f%n%n" , "Subtotal", subTotal, "", "Tax", taxTotal,"Total", finalTotal);

        // Input for Tender
        System.out.print("How much money was tended by the customer (in $)?: ");
        tenderedAmount = sc.nextDouble();

        // Calc and output for change
        System.out.printf("Change due: $%.2f", (tenderedAmount-finalTotal));







    }
}