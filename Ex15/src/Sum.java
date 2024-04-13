import java.util.Scanner;

/*
Program: Count1
Programmer: Ryan Mehrian
Date: April 1, 2024
----
This program will repeatedly prompt the user for positive integers. When the user enters a negative number, the program will output the sum
of all previously entered positive integers. For the sake of this exercise, zero will be counted as a positive number.
 */
public class Sum {
    public static void main(String[]args){
        //Declaration
        int sum = 0, input = 0, counter = 0;

        Scanner sc = new Scanner(System.in);

        //Input explanation
        System.out.println("Please enter positive integers to calculate their sum. Enter a negative integer to exit program and display the calculated total sum.");

        //Loop and Inputs
        do{
            sum += input;
            counter++;
            System.out.printf("Integer #%d > ", counter);
            input = sc.nextInt();
        }   while(input >= 0);

        //Display sum and exit
        System.out.printf("\nExiting Program...\nYour total sum was %d.", sum);

    }
}
