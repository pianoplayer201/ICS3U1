import java.util.*;
/*
Program: AbsValue
Programmer: Ryan Mehrian
Date: April 26, 2024
-----
This program will output the absolute value of the input number.
 */
public class AbsValue {
    public static void main(String[]args){
        //Declarations
        Scanner sc = new Scanner(System.in);

        //Input and Output
        System.out.print("Please enter a number: ");
        System.out.printf("Its absolute value is %d", Math.abs(sc.nextInt()));
    }
}
