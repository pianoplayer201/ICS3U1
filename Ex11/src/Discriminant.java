import java.util.Scanner;
/*
Program: Discriminant
Programmer: Ryan Mehrian
Date: March 6, 2023
----
The program asks the user for values A, B, and C, and then calculates
the number of roots using the discriminant.
 */
public class Discriminant {
    public static void main(String[] args) {
        //Declaration
        double a;
        double b;
        double c;
        double discriminantValue;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.println("To Calculate the number of roots...");
        System.out.print("Please enter A: ");
        a = sc.nextDouble();
        System.out.print("Please enter B: ");
        b = sc.nextDouble();
        System.out.print("Please enter C: ");
        c = sc.nextDouble();

        //Calculation and Checks and Output
        discriminantValue = b*b - (4*a*c);
        if(discriminantValue>0){
            System.out.println("Two Roots");
        }
        else if(discriminantValue<0){
            System.out.println("No Roots");
        }
        else
            System.out.println("One Root");

    }
}
