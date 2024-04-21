import java.util.Scanner;

/*
Program: StringLen
Programmer; Ryan Mehrian
Date: April 19, 2024
-----
This program will calculate and print out the length of the user inputted string.
 */
public class StringLen {
    public static void main(String[] args) {
        //Declaration
        Scanner sc = new Scanner(System.in);

        //Input and Output
        System.out.print("Please enter a string: ");
        System.out.printf("The string you entered has a length of %d characters", sc.nextLine().length());
    }
}
