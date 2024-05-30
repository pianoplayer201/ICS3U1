import java.util.Scanner;

/*
Program: Power
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
Prompts the user for floating point x and integer n, and then calculates x^n.
The program will stop and notify the user if they entered a negative exponent.
 */
public class Power {
    public static void main(String[]args){
        // Declarations
        int result = 0;
        double x;
        int n;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Please enter base (floating point x): ");
        x = sc.nextDouble();
        System.out.print("Please enter exponent (integer n): ");
        n = sc.nextInt();

        //Process and Output
        if(n>=0){
            System.out.printf("x raised to the power of n is %f", Math.pow(x,n));
        }
        else{
            System.out.println("N MUST NOT BE NEGATIVE!");
        }
    }
}
