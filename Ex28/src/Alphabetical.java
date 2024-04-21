import java.util.Scanner;

/*
Program: Alphabetical
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
This program accepts two string inputs, and outputs if the first string comes before, after, or equal
to the second string in an alphabetical arrangement.
 */
public class Alphabetical {
    public static void main(String[] args) {
        //Declarations
        String input1, input2;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter 1st String: ");
        input1 = sc.nextLine();
        System.out.print("Please enter 2nd String: ");
        input2 = sc.nextLine();

        //Output
        if (input1.compareTo(input2) > 0){

        }
    }
}
