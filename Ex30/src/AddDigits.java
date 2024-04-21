import java.util.Scanner;

/*
Program: AddDigits
Programmer: Ryan Mehrian
Date: April 21, 2024
-----
This program will output the sum of all the digits in a number inputted by the user.

**ASSUMING NEGATIVE SIGNS ARE NOT USED!!!!!**
 */
public class AddDigits {
    public static void main(String[] args) {
        //Declarations
        int sum=0;
        String input;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a number: ");
        input = sc.nextLine();

        //Add the Digits
        for(int i = 0; i < input.strip().length(); i ++){
            sum += Integer.parseInt("" + input.charAt(i));
        }

        //Output
        System.out.printf("All the digits of %s added up are equal to %d", input, sum);
    }
}
