import java.util.Scanner;

/*
Program: NumberSum
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
This program adds up n number of integers entered by the user. n is determined by prompt at start.
 */
public class NumberSum {
    public static void main(String[] args) {
        //Declarations
        int sum = 0;
        int input = 1;
        int numOfIntegers = 0;
        Scanner sc = new Scanner(System.in);

        // Prompt # of Ints
        System.out.print("Enter the number of integers you would like to add: ");
        numOfIntegers = sc.nextInt();

        // Input and Processing of Sums
        for(int i = 0; i < numOfIntegers; i++){
            System.out.print("Enter an Integer: ");
            input = sc.nextInt();
            sum+=input;
        }

        //Output
        System.out.printf("Sum is %d" , sum);
    }
}
