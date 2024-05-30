import java.util.Scanner;
/*
Program: SquareCube
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
Prompts the user for variable n, and calculates the sum of all perfect squares and
sum of all perfect cubes with roots up to variable n.
 */
public class SquareCube {
    public static void main(String[]args){
        // Declarations
        int sumSquare = 0;
        int sumCube = 0;
        int n = 0;
        Scanner sc = new Scanner(System.in);

        // Prompt for n
        System.out.print("Please enter integer n:\nn = ");
        n = sc.nextInt();

        //Calculate Sum
        for(int i = 1; i <= n; i++){
            sumSquare+=i*i;
            sumCube+=i*i*i;
        }

        //Output
        System.out.printf("Sum of Squares: %d\nSum of Cubes: %d", sumSquare, sumCube);
    }
}
