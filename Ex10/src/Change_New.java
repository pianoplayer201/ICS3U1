import java.util.Scanner;

/*
Program: Average
Programmer: Ryan Mehrian
Date: Feb 29, 2023
-----
The program will ask the user for a cost, and output the minimum number of coins
needed to fulfill it.
 */
public class Change_New {
    public static void main(String[] args) {
        // Variables
        int pennies = 0;
        int toonies = 0;
        int loonies = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int userAmount;
        int changeTotal = 0;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter the amount (in dollars): $");
        userAmount = (int)(sc.nextDouble()*100);

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
        System.out.println("     Pennies: " + (userAmount%changeTotal));
    }
}
