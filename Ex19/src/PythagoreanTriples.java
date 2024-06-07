import java.util.*;
/*
Program: PythagoreanTriples
Programmer: Ryan Mehrian
Date: May 31, 2024
----
This program asks the user to input a positive integer, then find and prints
all the pythagorean triplets whose largest member is not greater than the user
inputted number.
 */
public class PythagoreanTriples {
    public static void main(String[] args) {
        // Declarations
        int n;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        n = sc.nextInt();

        //Output
        System.out.println("Here are the pythagorean triplets below that number:");
        for(int i = n; i > 0; i--){
            for(int j = i; j > 0; j--){
                for(int k = j; k > 0; k--){
                    if(i * i == j * j + k * k){
                        System.out.println(i + "^2 = " + j + "^2 + " + k + "^2");
                    }
                }
            }
        }
    }
}
