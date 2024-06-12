/*
Program: Array2DOddEven
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program will accept input of 9 integers in a 3x3 2D array, and output each row and/or column that is all odd, or all even.
 */
import java.util.Scanner;
public class Array2DOddEven {
    public static void main(String[] args) {
        // Declarations
        final int ROWS = 3;
        final int COLUMNS = 3;
        int[][] numbers = new int[ROWS][COLUMNS];
        int odd = 0;
        int even = 0;

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.printf("Enter %d integers in the 2D array: \n", ROWS * COLUMNS);
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                System.out.printf(" > [%d][%d]: ", i, j);
                numbers[i][j] = sc.nextInt();
            }
        }

        // Output
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                if(numbers[i][j] % 2 == 0){
                    even++;
                } else {
                    odd++;
                }
            }
            if(odd == COLUMNS){
                System.out.printf("Row %d is all odd.\n", i);
            }
            else if(even == COLUMNS){
                System.out.printf("Row %d is all even.\n", i);
            }
        }

        for (int i = 0; i < COLUMNS; i++){
            for (int j = 0; j < ROWS; j++){
                if(numbers[j][i] % 2 == 0){
                    even++;
                } else {
                    odd++;
                }
            }
            if(odd == ROWS){
                System.out.printf("Column %d is all odd.\n", i);
            }
            else if(even == ROWS){
                System.out.printf("Column %d is all even.\n", i);
            }
        }

    }
}
