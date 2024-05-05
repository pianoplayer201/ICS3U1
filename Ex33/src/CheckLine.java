import java.awt.*;
import java.util.Scanner;

/*
Program: CheckLine
Programmer: Ryan Mehrian
Date: May 5, 2024
-----
This program prompts the user for the coordinates of two lines.
The program outputs whether these two lines are the same length, perpendicular and/or parallel.
 */
public class CheckLine {
    public static void main(String[] args) {
        //Declarations
        int x1A, x2A, y1A, y2A, x1B, x2B, y1B, y2B;
        boolean isEqualLength = false, isParallel = false , isPerpendicular = false;

        Scanner sc = new Scanner(System.in);

        //Input Line A
        System.out.println("Please enter the two coordinates of line A");
        System.out.print("Vertex 1 x-value: ");
        x1A = sc.nextInt();
        System.out.print("Vertex 1 y-value: ");
        y1A = sc.nextInt();
        System.out.print("\nVertex 2 x-value: ");
        x2A = sc.nextInt();
        System.out.print("Vertex 2 y-value: ");
        y2A = sc.nextInt();

        //Input Line B
        System.out.println("\nPlease enter the two coordinates of line B");
        System.out.print("Vertex 1 x-value: ");
        x1B = sc.nextInt();
        System.out.print("Vertex 1 y-value: ");
        y1B = sc.nextInt();
        System.out.print("\nVertex 2 x-value: ");
        x2B = sc.nextInt();
        System.out.print("Vertex 2 y-value: ");
        y2B = sc.nextInt();

        //Calculate Equal Length
        if(Line.length(x1A,y1A, x2A, y2A) == Line.length(x1B, y1B, x2A, y2B)){
            isEqualLength = true;
        }

        //Calculate Parallel or Perpendicular
        if(Line.slope(x1A,y1A, x2A, y2A) == Line.slope(x1B, y1B, x2A, y2B)){
            isParallel = true;
        }
        else if(Line.slope(x1A,y1A, x2A, y2A) == -1 * Math.pow(Line.slope(x1B, y1B, x2A, y2B),-1)){
            isPerpendicular = true;
        }

        //Output
        System.out.println("\nResults:");

        //Output Length
        if(isEqualLength){
            System.out.println("The lines are of equal length.");
        }
        else
            System.out.println("The lines are not of equal length.");

        //Output Slope
        if(isParallel){
            System.out.println("The lines are parallel to each other.");
        }
        else if (isPerpendicular){
            System.out.println("The lines are perpendicular to each other.");
        }
        else
            System.out.println("The lines are neither perpendicular nor parallel.");



    }
}
