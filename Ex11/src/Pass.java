import java.util.Scanner;

/*
Program: Pass
Programmer: Ryan Mehrian
Date: March 6, 2023
----
This program shows a math equation, and checks to see if user input
is the correct answer to the equation or not.
 */
public class Pass{
    public static void main(String[] args) {
        //Declarations
        final int INT_1 = 4;
        final int INT_2 = 5;
        final int ANSWER = INT_1 + INT_2;
        int userAnswer;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.printf("What is the answer to %d + %d?\n> ", INT_1, INT_2);
        userAnswer = sc.nextInt();

        //Check to see if userAnswer == ANSWER, then output result
        if (userAnswer == ANSWER)
            System.out.println("Correct! :)");
        else
            System.out.println("Incorrect! :(");
    }
}