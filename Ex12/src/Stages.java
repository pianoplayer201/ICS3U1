import java.util.Scanner;

/*
Program: Stages
Programmer: Ryan Mehrian
Date: March 18, 2023
----
This program asks the user for an age input, and outputs what stage of life
they would be in that age.
 */
public class Stages {
    public static void main(String[] args) {
        //Variable Declaration
        final int TEEN_CAP = 18;
        final int CHILD_CAP = 10;
        final int PRETEEN_CAP = 12;
        final int TODDLER_CAP = 5;
        int userAge;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter an age: ");
        userAge = sc.nextInt();

        //Checks and Outputs
        System.out.printf("The %d year-old would be ", userAge);

        if (userAge > TEEN_CAP){
            System.out.println("an Adult");
        }
        else if (userAge > PRETEEN_CAP){
            System.out.println("a Teen");
        }
        else if (userAge > CHILD_CAP){
            System.out.println("a Child");
        }
        else if (userAge > TODDLER_CAP){
            System.out.println("a Pre-Teen");
        }
        else{
            System.out.println("a Toddler");
        }
    }
}
