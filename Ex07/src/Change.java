/*
Program: Change
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
Calculates number of coins required to meet the user inputted price in cents.
 */
import java.util.*;
public class Change {
    public static void main(String[] args){
        // Variables
        int leftover = 0;
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int userAmount;
        int changeTotal = 0;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the amount (in cents): ");
        userAmount = sc.nextInt();

        // Calculations
        toonies = userAmount/200;
        changeTotal+= toonies*200;
        loonies = (userAmount-changeTotal)/100;
        changeTotal+= loonies*100;
        quarters = (userAmount-changeTotal)/25;
        changeTotal += quarters*25;
        dimes += (userAmount-changeTotal)/10;
        changeTotal+= 10*dimes;
        nickels += (userAmount-changeTotal)/5;
        changeTotal += 5*nickels;

        // Output
        System.out.println("The minimum number of coins is:");
        System.out.println("     Toonies: " + toonies);
        System.out.println("     Loonies: " + loonies);
        System.out.println("     Quarters: " + quarters);
        System.out.println("     Dimes: " + dimes);
        System.out.println("     Nickels: " + nickels);
        System.out.println("     Leftover Cents: " + (userAmount%changeTotal));

    }
}
