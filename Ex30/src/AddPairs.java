/*
Program: AddPairs
Programmer: Ryan Mehrian
Date: April 21, 2024
-----
This program will take a number input, and split it into pairs of digits. It will then add
these digit pairs and output the sum.
Example: 4560 -> 45 + 60
**ASSUMING NEGATIVE SIGNS ARE NOT USED!!!!!**
 */

import java.util.Scanner;

public class AddPairs {
    public static void main(String[] args) {
        //Declarations
        String userIn;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter an integer: ");
        userIn = sc.nextLine().strip();

        //Loop and Output
        for(int i = 0; i < userIn.length(); i+=2){

            try{
                sum += Integer.parseInt(""+userIn.charAt(i) + userIn.charAt(i+1));
            }
            //In case of odd number of digits
            catch (IndexOutOfBoundsException e){
                sum += Integer.parseInt("" + userIn.charAt(i));
            }
        }

        System.out.printf("All the digits in pairs of two add up to %d", sum);

    }
}
