import java.lang.reflect.Array;
import java.util.Scanner;

/*
Program: Numbers
Programmer: Ryan Mehrian
Date: May 31, 2024
-----
This program will do the following:
a. Declare an array of 6 doubles
b. read in a list of values from the user
c. print the values in reverse order
d. add 10% to each value in the array
e. print all the values that are over 50
(I would've written it in my own words, but this program looks to have no discernible purpose).
 */
public class Numbers {
    public static void main(String[] args) {
        //Declarations
        double[] numbers = new double[6];
        Scanner sc = new Scanner(System.in);

        //Input
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Please enter number #%d: ", i +1);
            numbers[i] = sc.nextDouble();
        }

        //Output In Reverse
        System.out.println("The numbers in reverse order are:");
        for (int i = numbers.length; i > 0; i--){
            System.out.println(numbers[i-1]);
        }
        //Add 10 Percent
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i] + (numbers[i] * 0.1);
        }
        //Over 50
        System.out.println("The numbers over 50 after +10% are:");
        for(double i : numbers){
            if (i > 50){
                System.out.println(i);
            }
        }
    }
}
