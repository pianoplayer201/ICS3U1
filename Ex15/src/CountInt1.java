import java.util.Scanner;

/*
Program: CountInt1
Programmer: Ryan Mehrian
Date: April 1, 2024
----
This program will prompt the user to continuously enter integers. When the user enters -1, the program
will output the number of integers the user had previously entered, not including -1.
 */
public class CountInt1 {
    public static void main(String[]args){
        //Declaration
        int input = 0, counter = 0;

        Scanner sc = new Scanner(System.in);

        //Input explanation
        System.out.println("Enter integers to count them. Enter '-1' to stop the count, and display the number of previously entered integers.");

        //Loop and Inputs
        do{
            counter++;
            System.out.printf("Integer #%d > ", counter);
            input = sc.nextInt();
        }   while(input != -1);

        //Display sum and exit
        System.out.printf("\nExiting Program...\nYour total integer count was %d.", counter-1);

    }
}
