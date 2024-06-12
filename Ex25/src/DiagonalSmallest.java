import java.util.Scanner;

/*
Program: DiagonalSmallest
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program will accept an input of 16 integers in a 4x4 grid, and output the smallest value
in the two diagonals of the grid.
 */
public class DiagonalSmallest {
    public static void main(String[] args) {
        // Declarations
        final int ROWS = 4;
        final int COLUMNS = 4;
        int[][] numbers = new int[ROWS][COLUMNS];
        int smallest = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.printf("Enter %d integers in the 2D array: \n", ROWS * COLUMNS);
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                System.out.printf(" > [%d][%d]: ", i, j);
                numbers[i][j] = sc.nextInt();
            }
        }

        // Search for Smallest
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                if(i == j){
                    if(numbers[i][j] < smallest){
                        smallest = numbers[i][j];
                    }
                }
                else if(i + j == ROWS - 1){
                    if(numbers[i][j] < smallest){
                        smallest = numbers[i][j];
                    }
                }
            }
        }

        // Output
        System.out.println("The smallest value in the two diagonals is: " + smallest);
    }
}
