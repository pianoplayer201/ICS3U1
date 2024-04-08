import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

/*
Program: Temperature
Programmer: Ryan Mehrian
Date: March 10, 2024
-----
This program asks the user to enter a temperature, and outputs
a message rating it in words (hot, cold, etc.)
 */
public class Temperature {
    public static void main(String[]args){
        //Declarations
        double temperature;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a temperature in degrees Celsius: ");
        temperature = sc.nextDouble();

        //Checks and Output
        if(temperature < -18)
            System.out.println("Very Cold");
        else if (temperature < 0)
            System.out.println("Cold");
        else if (temperature == 0)
            System.out.println("Freezing Point of Water");
        else if (temperature <= 10)
            System.out.println("Very Cool");
        else if (temperature <= 20)
            System.out.println("Moderate");
        else if (temperature <=30)
            System.out.println("Warm");
        else if (temperature<=40)
            System.out.println("Hot");
        else if (temperature<100)
            System.out.println("Extremely Hot");
        else
            System.out.println("Boiling Point of Water");
    }
}
