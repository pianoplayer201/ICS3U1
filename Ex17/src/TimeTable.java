import java.util.*;
/*
Program: TimeTable
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
Program outputs a times table that goes up to the square of inputted number.
 */
public class TimeTable {
    public static void main(String[]args){
        //Declarations
        int numOfRows;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a positive integer to generate a times-table: ");
        numOfRows = sc.nextInt();

        //Output
        for(int i = 1; i <= numOfRows; i++){
            System.out.printf("%d X %d = %d\n", numOfRows, i, i*numOfRows);
        }
    }
}
