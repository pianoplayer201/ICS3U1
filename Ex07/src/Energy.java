/*
Program: Energy
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
Calculates the amount of energy output from e=mc^2, and indicates how many
standard light bulbs the energy could power.
 */
import java.lang.*;
import java.util.*;
public class Energy{

    public static void main(String[]args){

        //Variables
        Scanner sc = new Scanner(System.in);
        double energy;
        final double lightSpeed = 3*Math.pow(10, 8);

        //Prompts
        System.out.print("Please enter a mass in kg: ");
        energy = sc.nextDouble()*lightSpeed*lightSpeed;
        System.out.println(energy + " joules.");
        System.out.println("You can power " + (energy/360000) + " 100-watt light bulbs for an hour");

    }
}