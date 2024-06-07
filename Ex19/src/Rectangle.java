import java.util.Scanner;

/*
Programmer: Ryan Mehrian
Program: Rectangle
Date: May 31, 2024
-----
This program asks the user for dimensions, then outputs a rectangle of '*' with those dimensions.
 */
public class Rectangle {
    public static void main(String[] args) {
        // Declarations
        final String UNIT = "*";
        int width, height;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter the number of rows of the rectangle: ");
        height = sc.nextInt();
        System.out.print("Please enter the number of columns of the rectangle: ");
        width = sc.nextInt();

        // Loop and Output
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(UNIT);
            }
            System.out.println();
        }
    }
}
