/*
Program: TwoLargest
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program takes a randomly generated array of 10 numbers, and writes the two largest
numbers in the array to the console.
 */
public class TwoLargest {
    public static void main(String[] args) {

        // Declarations
        int[] numbers = new int[10];
        int largest = 0;
        int secondLargest = 0;

        // Process
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
            if (numbers[i] > largest) {
                secondLargest = largest;
                largest = numbers[i];
            } else if (numbers[i] > secondLargest) {
                secondLargest = numbers[i];
            }
        }

        // Output
        System.out.println("The two largest numbers are: " + largest + " and " + secondLargest);
    }
}
