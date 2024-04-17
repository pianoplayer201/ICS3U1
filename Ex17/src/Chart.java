/*
Program: Chart
Programmer: Ryan Mehrian
-----
This program outputs a chart of numbers from 5 to 40, along with their squares and cubes.
 */
public class Chart {
    public static void main(String[]args){
        //Output Headers
        System.out.printf("%-6s   %6s   %6s%n", "Number", "Square", "Cube");

        //Loops, Calculations and Output
        for (int i = 5; i <= 40; i += 5){
            System.out.printf("%-6d   %6d   %6d\n", i, i*i, i*i*i);
        }
    }
}
