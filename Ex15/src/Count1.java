/*
Program: Count1
Programmer: Ryan Mehrian
Date: April 1, 2024
----
This program counts down from 100 to 1 by 2's.
 */
public class Count1 {
    public static void main(String[] args) {
        //Declarations
        int counter = 100;
        //Do-While loop and Output
        do{
            System.out.println(counter);
            counter-=2;
        }while (counter >= 1);
    }
}
