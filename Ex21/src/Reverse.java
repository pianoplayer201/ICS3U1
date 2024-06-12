import java.util.*;

/*
Program: Reverse
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program accepts an input list of 10 numbers, then generates an output list
of the numbers in reverse order.
 */
public class Reverse {
    public static void main(String[] args) {
        // Declarations
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

        // Process
        for(int i = 0; i < list1.length; i++){
            list2[i] = list1[list1.length - 1 - i];
        }

        // Output
        System.out.println("\nThe numbers in reverse order are: ");
        for(int i : list2){
            System.out.println(i);
        }
    }
}
