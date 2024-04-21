import java.util.Scanner;

/*
Program: Half
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
This program takes a string input, and outputs its first half on one line and its second half on another.
 */
public class Half {
    public static void main(String[] args) {
        //Declaration
        String userInput;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a string: ");
        userInput = sc.nextLine();

        //Output
        System.out.printf("The first half of your string: %s\n", userInput.substring(0,userInput.length()/2 + 1));
        System.out.printf("The second half of your string: %s", userInput.substring(userInput.length()/2));
    }
}
