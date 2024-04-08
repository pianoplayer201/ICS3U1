import java.util.Scanner;
/*
Program: SimpleInterestPrincipal
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
This program calculates the principal investment required in order to reach
a certain amount of money over user inputted amount of time.
 */
public class SimpleInterestPrincipal
{
    public static void main(String[]args){
        //Variables
        double interestRate;
        double principal;
        double numberOfYears;
        double amount;

        Scanner sc = new Scanner(System.in);

        //Inputs
        System.out.print("Enter Desired Amount: $");
        amount = sc.nextDouble();
        System.out.print("Enter Interest Rate (%): ");
        interestRate = sc.nextDouble();
        System.out.print("Enter Number of Years for Investment/Loan: ");
        numberOfYears = sc.nextDouble();

        //Calculations
        principal = amount/(1+numberOfYears*interestRate);

        // Output
        System.out.printf("You need to invest $%.2f principal to get that amount." ,principal);
        
    }
}

