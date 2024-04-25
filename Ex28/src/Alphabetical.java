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
        if (input1.compareToIgnoreCase(input2) < 0){
            System.out.printf("%s comes before %s when sorted alphabetically.", input1, input2);
        }
        else if (input1.compareToIgnoreCase(input2) > 0){
            System.out.printf("%s comes after %s when sorted alphabetically.", input1, input2);
        }
        else
            System.out.printf("%s and %s are equal.", input1, input2);
    }
}
