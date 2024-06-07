import java.util.Scanner;
/*
Programmer: Ryan Mehrian
Program: Rectangle
Date: May 31, 2024
-----
This program asks the user for dimensions, then outputs a rectangle of numbers with those dimensions.
 */
public class TableOfNumbers {
    public static void main(String[] args) {
        // Declarations
        int width, height;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Enter X: ");
        height = sc.nextInt();
        System.out.print("Enter Y: ");
        width = sc.nextInt();

        // Loop and Output
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}
