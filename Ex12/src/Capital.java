import java.util.Scanner;

/*
Program: Capital
Programmer: Ryan Mehrian
Date: March 18, 2023
----
Program asks user to input capital of Canada, and outputs if they are correct or not.
 */
public class Capital {
    public static void main(String[] args) {
        //Variables
        final String ANSWER = "Ottawa";
        String input;

        Scanner sc = new Scanner(System.in);

        //Input

        System.out.print("What is the capital of Canada? \n > ");
        input = sc.nextLine();

        //Check and Output
        if(input.toUpperCase() == ANSWER.toUpperCase())
            System.out.println("Correct");
        else
            System.out.print("Incorrect");
    }
}
