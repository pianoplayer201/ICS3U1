/*
Program: OutputPrintf2
Programmer: Ryan Mehrian
Date: February 20, 2024
-----
This program outputs a list of numbers on the left column, and outputs their squares on the right column.
 */
public class OutputPrintf2 {
    public static void main(String[]args){
        System.out.printf("%-13s%7s%n", "Number", "Square");
        for(double i = 1.10; i<1.16; i+=0.01){
            System.out.printf("%-13.2f%7.5f%n", i, i*i);
        }

    }
}
