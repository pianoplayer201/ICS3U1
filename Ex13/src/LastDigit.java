import java.util.Scanner;

/*
Program: LastDigit
Programmer: Ryan Mehrian
Date: March 28, 2024
-----
This program will prompt the user for a number, and output the last digit of that number.
*/
public class LastDigit {
    public static void main(String[] args) {
        //Declarations
        int userNum;
        int finalDigit;
        String textOutput = null;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter an integer: ");
        userNum = sc.nextInt();

        //Calculation and Output
        finalDigit = Math.abs(userNum%10);
        switch (finalDigit){
            case 0:
                textOutput = "Zero";
                break;
            case 1:
                textOutput = "One";
                break;
            case 2:
                textOutput = "Two";
                break;
            case 3:
                textOutput = "Three";
                break;
            case 4:
                textOutput = "Four";
                break;
            case 5:
                textOutput = "Five";
                break;
            case 6:
                textOutput = "Six";
                break;
            case 7:
                textOutput = "Seven";
                break;
            case 8:
                textOutput = "Eight";
                break;
            case 9:
                textOutput = "Nine";
                break;
        }

        System.out.printf("The final digit of %d is %s", userNum, textOutput);

    }
}
