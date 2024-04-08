/*
Program Name: Input_3
Programmer: Ryan Mehrian
Date Created: February 13, 2024
--------------------
This program asks the user for their name and their age, and outputs a line
telling the user their name and their age.
 */

import java.util.*;

public class Input_3 {
    public static void main(String[]arg){

        // Declare Variables
        String userName;
        int userAge;

        // Create new Scanner object
        Scanner sc = new Scanner(System.in);

        // Print out prompt and read name
        System.out.print("What's your name? ");
        userName = sc.nextLine();

        // Print out prompt and read age
        System.out.print("How old are you? ");
        userAge = sc.nextInt();

        // Print output
        System.out.println("So you are "+ userName + " and you are " + userAge);

    }
}
