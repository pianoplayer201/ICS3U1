import java.util.*;
/*
Program: SelfReverse
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program accepts an input list of a user-specified size and assigns them to an array.
The program then rearranges the array to be in reverse order, and outputs the reversed array.
 */
public class SelfReverse {
    public static void main(String[] args) {
        // Declarations
        int temp;
        int listSize;
        int[] list;

        Scanner sc = new Scanner(System.in);

        // Input List Size and INIT Array
        System.out.print("Enter the size of the list: ");
        listSize = sc.nextInt();
        list = new int[listSize];

        // Input Numbers
        System.out.printf("Enter %d numbers: \n", listSize);
        for(int i = 0; i < list.length; i++){
            System.out.print(" > ");
            list[i] = sc.nextInt();
        }

        // Process
        for(int i = 0; i < list.length / 2; i++){
            temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }

        // Output
        System.out.println("\nThe numbers in reverse order are: ");
        for(int i : list){
            System.out.println(i);
        }
    }

}
