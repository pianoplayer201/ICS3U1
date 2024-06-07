/*
Programmer: Ryan Mehrian
Program: TriangleOfNumbers
Date: May 31, 2024
-----
The program outputs a triangle of numbers, with a predetermined height.
 */
public class TriangleOfNumbers{
    public static void main(String[] args) {
        // Declarations
        final int HEIGHT = 5;

        // Loop and Output
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}
