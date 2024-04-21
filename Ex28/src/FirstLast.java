import java.util.Scanner;

/*
Program: FirstLast
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
This program will print out the first and last character of a user inputted string.
 */
public class FirstLast {
    public static void main(String[]args){
        //Declarations
        String input;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a string: ");
        input = sc.nextLine();

        //Output
        System.out.printf("In the string \"%s\", '%s' is the first character, and '%s' is the last character.", input, input.charAt(0), input.charAt(input.length()-1));
    }
}
