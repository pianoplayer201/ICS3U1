/*
Program: Cost
Programmer: Ryan Mehrian
Date Created: February 28, 2023.
----
The program helps a user calculate the cost of their shopping.
The user inputs the subtotal of their purchase, and the number of bags they require.
The program outputs the HST and cost for plastic bags, as well as the final total.
ASSUMED NO TAX ON BAGS
 */

import java.util.Scanner;

public class Cost{
    public static void main(String[] args){

        final double HST = 0.13;
        final double BAG_PRICE = 0.05;
        double subTotal;
        int numOfBags;

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter cost of item(s): $");
        subTotal = sc.nextDouble();
        System.out.print("Enter number of bags purchased: ");
        numOfBags = sc.nextInt();

        // Output
        System.out.println("\nHere is a breakdown of your purchase:");
        System.out.printf("Subtotal: $%.2f\n", subTotal);
        System.out.printf("HST: $%.2f\n", HST*subTotal);
        System.out.printf("Bags: $%.2f\n\n", numOfBags*BAG_PRICE);
        System.out.printf("Total: %.2f\n", numOfBags*BAG_PRICE+HST*subTotal+subTotal);
    }
}