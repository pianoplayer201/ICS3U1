/*
Program: Unicode
Programmer: Ryan Mehrian
Date: April 1, 2024
----
This program will output a table showing all unicode characters from 1 to 212, along with their values.
 */
public class Unicode {
    public static void main(String[] args) {
        //Declarations
        int count = 0;

        //Table Header
        System.out.printf("%-6s    %-9s\n", "Unicode", "Character");

        //Loop and Table output
        do{
            count++;
            System.out.printf("%6d    %9c%n", count, (char) count);
        }while(count < 212);
    }
}
