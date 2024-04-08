import java.util.Scanner;

/*
Program: CheckInt
Programmer: Ryan Mehrian
Date: March 6, 2023
----
This program checks to see if the user inputted number is:
1. Positive or Negative
2. Even or Odd
3. A Multiple of 7 or not
...and outputs the results of these checks.
*/
public class CheckInt {
    public static void main(String[] args) {
        //Declarations
        boolean isPositive;
        boolean isZero;
        boolean isEven;
        boolean isMultipleOf7;
        int userNum;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter an integer: ");
        userNum = sc.nextInt();

        //Checks for All Booleans
        isPositive = userNum > 0;
        isZero = userNum == 0;
        isEven = userNum % 2 == 0;
        isMultipleOf7 = userNum % 7 == 0;

        //Output
        System.out.printf("The number %d is...\n", userNum);

        if(isZero)
            System.out.print("Neither positive nor negative, ");
        else if (isPositive)
            System.out.print("Positive, ");
        else
            System.out.print("Negative, ");

        if(isEven)
            System.out.print("Even, ");
        else
            System.out.print("Odd, ");

        if(isMultipleOf7)
            System.out.print("and a multiple of 7");
        else
            System.out.print("and not a multiple of 7");

    }
}
