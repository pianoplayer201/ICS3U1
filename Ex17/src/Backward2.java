import java.util.Scanner;
/*
Program: Backward2
Programmer: Ryan Mehrian
Date: April 19, 2024
----
This program outputs numbers down from 100 in increments of 5, down
to a user inputted number.
 */
public class Backward2 {
    public static void main(String[] args) {
        //Declarations
        final int START = 100;
        int end = 5;

        Scanner sc = new Scanner(System.in);

        //Input
        do{
            System.out.print("Please enter a number between 100 and 50: ");
            end = sc.nextInt();
            if (end < 50 || end > 100){
                System.out.println("Invalid input. Please enter a number between 100 and 50.");
            }
        } while(end < 50 || end > 100);


        //Loop and Output
        for (int i = START; i >= end; i -= 5) {
            System.out.println(i);
        }
    }
}
