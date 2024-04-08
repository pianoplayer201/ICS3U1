import java.util.Scanner;

/*
Program: Driving
Programmer: Ryan Mehrian
Date: March 10, 2024
-----
This program outputs the user's age eligibility for a driving licence depending
on their inputted age.
 */
public class Driving {
    public static void main(String[] args) {
        //Declarations
        final int MIN_AGE = 18;
        final int MAX_AGE = 75;
        int userAge;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter your age: ");
        userAge = sc.nextInt();

        //Checks and Output
        if(userAge < MIN_AGE){
            System.out.println("Too young to drive.");
        }
        else if(userAge > MAX_AGE){
            System.out.println("Sorry, you are over the legal age limit for driving.");
        }
        else
            System.out.println("Age OK. Have you got a driver's licence?");
    }
}
