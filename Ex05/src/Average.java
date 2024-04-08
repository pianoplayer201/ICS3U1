/*
Program Name: Average
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
This program prompts the user for 3 numbers, and outputs their average.
 */

import java.util.Scanner;

public class Average{
    public static void main(String[]args){

        // Declare Variables and Objects
        double num1, num2, num3, average;
        Scanner sc = new Scanner(System.in);

        // Ask user to input the 3 doubles.
        System.out.print("Enter num #1: ");
        num1 = sc.nextDouble();
        System.out.print("Enter num #2: ");
        num2 = sc.nextDouble();
        System.out.print("Enter num #3: ");
        num3 = sc.nextDouble();

        // Calculate Average
        average = (num1 + num2 + num3) / 3;

        // Output
        System.out.println("The average is " + average);
    }
}