/*
Class: Line
Programmer: Ryan Mehrian
Date: May 5, 2024
-----
Contains methods which calculate different properties of lines.
 */
public class Line {
    /*
    Method: length
    -----
    Parameters:
    int x1 - X-Coords of start point of line
    int y1 - Y-Coords of start point of line
    int x2 - X-Coords of end point of line
    int y2 - Y-Coords of end point of line.
    ----
    Returns:
    double length - The length of the line from the two points.
    -----
    Calculates the length of a line.
     */
    public static double length(int x1, int y1, int x2, int y2){
        //Calculation
        double length = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));

        //Return
        return length;
    }

    /*
    Method: slope
    -----
    Parameters:
    int x1 - X-Coords of start point of line
    int y1 - Y-Coords of start point of line
    int x2 - X-Coords of end point of line
    int y2 - Y-Coords of end point of line.
    ----
    Returns:
    double m - The slope of the line.
    -----
    Calculates the slope of a line.
     */
    public static double slope(int x1, int y1, int x2, int y2){
        //Calculation
        double m = (double)(y2 - y1) / (x2) - (x1);

        //Return
        return m;
    }
}
