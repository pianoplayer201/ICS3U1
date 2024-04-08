import java.util.Scanner;

/*
Program: Currency
Programmer: Ryan Mehrian
Date Created: February 28, 2023.
----
This program converts an inputted amount in USD into CAD
 */
public class Currency {
    public static void main(String[] args) {
        // Variable Declaration
        final double RATE = 1.35;
        double usd;
        double cad;

        // Obj Declaration
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Please enter amount in USD: $");
        usd = sc.nextDouble();

        // Calculation and Output
        cad = usd * RATE;
        System.out.printf("\n$%.2f USD is equal to $%.2f CAD", usd, cad);


    }
}
