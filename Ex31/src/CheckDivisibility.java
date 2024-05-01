/*
Program: CheckDivisibility
Programmer: Ryan Mehrian
Date: May 1, 2024
-----
This program checks if num1 is divisible by num2.
 */
public class CheckDivisibility {
    public static void main(String[]args){
        //Declarations
        final int num1 = 12, num2 = 3;

        //Output
        System.out.printf("%d and %d divisible?: %B", num1,num2, evenlyDivisible(num1,num2));
    }

    /*
    Method: evenlyDivisible
    ----
    Parameters:
    int dividend: Number to be divided by divisor.
    int divisor: Number to divide the dividend.
    -----
    Returns:
    boolean - Whether the dividend can be evenly divided by divisor.
    -----
    Checks to see if dividend is evenly divisible by the divisor.
     */
    public static boolean evenlyDivisible(int dividend, int divisor){
        //Declarations
        boolean canDivide;

        if(dividend % divisor == 0){
            canDivide = true;
        }
        else
            canDivide = false;

        return canDivide;
    }
}
