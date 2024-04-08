import java.util.Scanner;

/*
Program Name: PizzaCost
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
This program calculates the position of an object dropped from a height of 100
metres using the formula 100 - 4.9^2. The user will be asked to input the time passed.
 */

public class PizzaCost {
    public static void main(String[] args){

        // Declaring Variables & Constants & Objects
        final double labourCost = 0.75;
        final double rentCost = 1;
        double materialsCost;
        double pizzaDiameter;
        double totalCost;

        Scanner sc = new Scanner(System.in);

        // Taking Input
        System.out.print("Please enter pizza diameter in inches: ");
        pizzaDiameter = sc.nextDouble();

        // Equation to get costs
        materialsCost = 0.05 * pizzaDiameter * pizzaDiameter;
        totalCost = materialsCost + labourCost + rentCost;

        // Output
        System.out.printf("The total cost of the pizza of a diameter of %.0f\" is $%.2f ", pizzaDiameter, totalCost);



    }
}
