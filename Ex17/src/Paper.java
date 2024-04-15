/*
Program: Paper
Programmer: Ryan Mehrian
-----
This program calculates the thickness of a large piece of paper halved and stacked n times, along with the area of each
individual sheet of paper.
 */
public class Paper {
    public static void main(String[] args) {
        //Variables
        final double THICKNESS = 0.1;
        double thickness = THICKNESS;
        double area = 8.5 * 11;

        //Output Headers
        System.out.printf("%-6s   %6s   %6s%n", "Sheet", "Thickness", "Area");

        //Loop, Calculations and Output
        for (int i = 1; i <= 10; i++){
            System.out.printf("%-6d   %6.2f   %6.2f\n", i, thickness, area);
            thickness *= 2;
            area /= 2;
        }
    }
}
