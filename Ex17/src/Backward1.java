/*
Program: Backward1
Programmer: Ryan Mehrian
Date: April 19, 2024
-----
This program outputs numbers down from 100 to 5 in increments of 5.
 */
public class Backward1 {
    public static void main(String[] args) {
        //Variables
        final int START = 100;
        final int END = 5;

        //Loop and Output
        for (int i = START; i >= END; i -= 5) {
            System.out.println(i);
        }
    }
}
