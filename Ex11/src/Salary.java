import java.util.Scanner;

/*
Program: Salary
Programmer: Ryan Mehrian
Date: March 6, 2023
----
This program calculates monthly salary in relation to inputted number of sales: Starting
with a 1000 salary, and each sale adding a 1% bonus commission per sale (if 10 or more sales
have been made)
 */
public class Salary {
    public static void main(String[] args) {
        //Declarations
        final int SALARY_BASE = 1000;
        final double COMMISSION_PER_SALE = 0.01 * SALARY_BASE;
        final int MIN_SALE_COMMISSION = 10;
        int numberOfSales;
        double finalSalary;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter number of sales: ");
        numberOfSales = sc.nextInt();

        //Calculation
        if (numberOfSales >= MIN_SALE_COMMISSION){
             finalSalary = numberOfSales*COMMISSION_PER_SALE + SALARY_BASE;
        }
        else
            finalSalary = SALARY_BASE;

        //Output
        System.out.printf("Total Salary This Month: $%.2f" , finalSalary);
    }
}
