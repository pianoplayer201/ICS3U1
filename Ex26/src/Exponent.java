import java.util.*;

/*
Program: Exponent
Programmer: Ryan Mehrian
Date: April 26, 2024
-----
This program will accept inputs for a base and an exponent, and output the result of the base to the power of the exponent.
 */
public class Exponent {
    public static void main(String[]args){
        //Declarations
        int base, exponent, result;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a base: ");
        base = sc.nextInt();
        System.out.print("Please enter an exponent: ");
        exponent = sc.nextInt();

        //Calc and Output
        System.out.printf("%d ^ %d = %.1f" , base, exponent, Math.pow(base, exponent));

    }
}
