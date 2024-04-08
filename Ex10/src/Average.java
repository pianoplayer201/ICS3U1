import java.util.Scanner;

/*
Program: Average
Programmer: Ryan Mehrian
Date: Feb 29, 2023
-----
This program calculates the average of 5 user inputted grades.
 */
public class Average {
    public static void main(String[] args) {
        //Variables and Objects
        double average;
        int gradesTotal = 0;

        Scanner sc = new Scanner(System.in);

        //Input;
        System.out.println("Please enter " +
                "your grades.");
        System.out.print("Grade 1: ");
        gradesTotal += sc.nextInt();
        System.out.print("Grade 2: ");
        gradesTotal += sc.nextInt();
        System.out.print("Grade 3: ");
        gradesTotal += sc.nextInt();
        System.out.print("Grade 4: ");
        gradesTotal += sc.nextInt();
        System.out.print("Grade 5: ");
        gradesTotal += sc.nextInt();

        //Calculation and Output
        System.out.println("Your average grade is " + (gradesTotal/5d));

    }
}
