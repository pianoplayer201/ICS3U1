/*
Program Name: Drop
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
This program calculates the position of an object dropped from a height of 100
metres using the formula 100 - 4.9^2. The user will be asked to input the time passed.
 */
import java.util.*;
public class Drop {
    public static void main(String[]args){

        // Variable Declaration
        double time;
        double height;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Please enter a time less than 4.5 seconds: ");
        time = sc.nextDouble();

        // Calculations
        height = 100 - 4.9 * time * time;

        // Print
        System.out.println("The height of the object after that many seconds is " + height + "m");
    }
}
