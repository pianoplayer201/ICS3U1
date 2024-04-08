import java.util.Scanner;
/*
Program: SimpleInterestAmount
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
This program calculates the amount gained on an simple interest savings deposit,
based on user inputted principal, number of years and interest rate.
 */
public class SimpleInterestAmount
{
    public static void main(String[]args){
        //Variables
        double interestRate;
        double principal;
        double numberOfYears;
        double amount;

        Scanner sc = new Scanner(System.in);

        //Inputs
        System.out.print("Enter Principal: $");
        principal = sc.nextDouble();
        System.out.print("Enter Interest Rate (%): ");
        interestRate = sc.nextDouble();
        System.out.print("Enter Number of Years for Investment/Loan: ");
        numberOfYears = sc.nextDouble();

        //Calculations
        amount = principal*(1+numberOfYears*interestRate);

        // Output
        System.out.printf("The total amount with interest after that many years is $%.2f" ,amount);


    }
}
