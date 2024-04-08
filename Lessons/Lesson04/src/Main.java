import java.util.*;

/*
|========================================|
| Main.Java                              |
|----------------------------------------|
| Programmer: Ryan Mehrian               |
| Date: February 12, 2024                |
|----------------------------------------|
| Example of how to use Scanner class    |
| and Scanner object to take console     |
| input.                                 |
|========================================|
 */

public class Main{
    public static void main(String[] args){
        String text;
        int wholeNumber;
        double fpNumber;

        // Set up the Scanner object.
        Scanner sc = new Scanner(System.in);

        // Read string value and store it in text
        System.out.print("Please enter a string: ");
        text = sc.nextLine();

        // Read integer and store it in wholeNumber
        System.out.print("Please enter an int: ");
        wholeNumber = sc.nextInt();

        // Read double and store it in fpNumber
        System.out.print("Please enter a double: ");
        fpNumber = sc.nextDouble();

        // Output all variables
        System.out.println(text);
        System.out.println(wholeNumber);
        System.out.println(fpNumber);






    }
}