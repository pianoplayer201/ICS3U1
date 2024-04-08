/*
Program Name: DigitSum
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
This program prompts the user for a 3 digit number, and outputs the number and the sum of its digits.
 */

import java.util.Scanner;

public class DigitSum{
    public static void main(String[]args){

        // Declare Variables and Objects
        String num;
        int digitSum = 0;
        Scanner sc = new Scanner(System.in);

        // Ask user to input the num.
        System.out.print("Enter a 3 digit number: ");
        num = sc.nextLine();

        // Calculate sum
        for (int i = 0; i < 3; i++) {
            digitSum += Character.getNumericValue((num.toCharArray()[i]));
        }

        // Output
        System.out.printf("The sum of the digits in %s is %d", num, digitSum);
    }
}
