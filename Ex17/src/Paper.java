/*
Program: Paper
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
This program calculates the thickness of a large piece of paper halved and stacked 40 times, along with the area of each
individual sheet of paper.
 */
public class Paper {
    public static void main(String[] args) {
        //Variables
        final double START_THICKNESS_MM = 0.090;
        final double START_AREA_CM2 = 100.0;
        final int NUM_OF_HALVINGS = 40;
        double thickness = START_THICKNESS_MM;
        double area = START_AREA_CM2;

        //Loop, Calculations
        for (int i = 1; i <= NUM_OF_HALVINGS; i++){
            thickness *= 2;
            area /= 2;
        }

        //Output
        System.out.printf("After being halved and stacked %d times, the thickness of the paper is %emm and its area is %2ecm^2", NUM_OF_HALVINGS, thickness, area);
    }
}
