import java.util.Scanner;

/*
Program: SameSum
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program accepts an input list of 10 numbers, then generates an output list
of the numbers that need to be added to reach 25 for each entry.
 */
public class SameSum {
    public static void main(String[] args) {
        // Declarations
        final int TARGET = 25;
        final int LIST_SIZE = 10;
        int[] list1 = new int[LIST_SIZE];
        int[] list2 = new int[LIST_SIZE];

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.printf("Enter %d numbers: \n", LIST_SIZE);
        for(int i = 0; i < list1.length; i++){
            System.out.print(" > ");
            list1[i] = sc.nextInt();
        }

        // Process and Output
        for(int i = 0; i < list1.length; i++){
            list2[i] = TARGET - list1[i];
            System.out.println("The number " + list1[i] + " needs " + list2[i] + " to reach " + TARGET);
        }
    }
}
