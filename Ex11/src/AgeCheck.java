import java.util.Scanner;
/*
Program: AgeCheck
Programmer: Ryan Mehrian
Date: March 6, 2023
----
The program checks to see if user is old enough to vote.
 */
public class AgeCheck {
    public static void main(String[] args) {
        //Declarations
        final int VOTING_AGE = 18;
        int userAge;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter your age: ");
        userAge = sc.nextInt();

        //Check and Output
        if (userAge >= VOTING_AGE)
            System.out.println("OLD ENOUGH TO VOTE");
        else
            System.out.println("You must wait " + (VOTING_AGE - userAge) + " years to vote.");
    }
}
