import java.util.Scanner;

/*
Program: Array1DOddEven
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program will accept input of 10 integers, and output if the 10 integers are all odd, all even, or neither.
 */
public class Array1DOddEven {
    public static void main(String[] args) {
        // Declarations
        final int SIZE = 10;
        int[] numbers = new int[SIZE];
        int odd = 0;
        int even = 0;

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.printf("Enter %d integers: \n", SIZE);
        for(int i = 0; i < SIZE; i++){
            System.out.print(" > ");
            numbers[i] = sc.nextInt();
        }

        // Count Odd and Integer
        for(int i = 0; i < SIZE; i++){
            if(numbers[i] % 2 == 0){
                even++;
            } else {
                odd++;
            }
        }

        // Output
        if(odd == SIZE){
            System.out.println("All numbers are odd.");
        }
        else if(even == SIZE){
            System.out.println("All numbers are even.");
        }
        else {
            System.out.println("Neither all odd or all even.");
        }

    }
}
