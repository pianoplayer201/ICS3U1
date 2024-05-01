import java.util.Scanner;

/*
Program: Divide17
Programmer: Ryan Mehrian
Date: May 1, 2024
-----
This program accepts two user inputted integers. The program concatenates these two
integers and then divides the result by 17.
 */
public class Divide17 {
    public static void main(String[] args) {
        //Declarations
        final int DIVISOR = 17;
        String input1, input2;
        int numerator;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a positive integer: ");
        input1 = sc.nextLine();
        System.out.print("Please enter a second positive integer: ");
        input2 = sc.nextLine();

        //Concatenation, Calculation and Output
        numerator = Integer.parseInt(input1 + input2);
        System.out.printf("%s & %s --> %d\n", input1 , input2, numerator);
        System.out.printf("%d / %d = %.2f", numerator, DIVISOR, (double)numerator/DIVISOR);
    }
}
