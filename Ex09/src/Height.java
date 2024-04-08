import java.util.Scanner;

/*
Program: Height
Programmer: Ryan Mehrian
Date Created: February 28, 2023.
----
The program takes a height in inches and outputs it in centimetres.
 */
public class Height {
    public static void main(String[]args){
        final double INCH_TO_CM = 2.54;
        double inputInch;

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter height in inches: ");

        while(!sc.hasNextDouble()){
            System.out.println("Invalid Input! Ensure input only has raw numbers.");
            System.out.print("Please enter height in inches: ");
            sc.nextLine();
        }
        inputInch = sc.nextDouble();

        System.out.println("Your height is " + (inputInch*INCH_TO_CM) + " cm");

    }
}
