/*
Program Name: Input_2
Programmer: Ryan Mehrian
Date Created: February 13, 2024
--------------------
This program asks the user for their name than outputs a greeting to the user
using their name.
 */

import java.util.*;

public class Input_2{
    public static void main(String[]arg){

        // Declare Variables
        String userName;

        // Create new Scanner object
        Scanner sc = new Scanner(System.in);

        // Print out prompt and read name
        System.out.print("What's your name? ");
        userName = sc.nextLine();

        // Print output
        System.out.println("Hello " + userName);

    }
}