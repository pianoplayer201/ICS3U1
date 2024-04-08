import java.util.*;
/*
Program: SortThreeNumbers
Programmer: Ryan Mehrian
Date: March 18, 2023
----
This program takes an input of 3 numbers, and outputs them
from least to greatest. The program will only accept positive integers greater than 0.
 */
public class SortThreeNumbers {
    public static void main(String[] args) {
        //Declarations
        int num1, num2, num3;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.println("Enter positive whole numbers");
        System.out.print("Number 1 > ");
        num1 = sc.nextInt();
        System.out.print("Number 2 > ");
        num2 = sc.nextInt();
        System.out.print("Number 3 > ");
        num3 = sc.nextInt();

        //Checks and Output
        if(num1 <= 0 || num2 <= 0 || num3 <= 0){
            System.out.println("Error, invalid inputs. Only enter positive whole numbers!");
        }
        else{
            if(num1 > num2 && num1 > num3){
                if(num2 > num3)
                    System.out.println(num3 + " " + num2 + " " + num1);
                else
                    System.out.println(num2 + " " + num3 + " " + num1);
            }
            else if(num2 > num1 && num2 > num3){
                if(num1 > num3){
                    System.out.println(num3 + " " + num1 + " " + num2);
                }
                else
                    System.out.println(num1 + " " + num3 + " " + num2);
            }
            else
                if(num2 > num1){
                    System.out.println(num1 + " " + num2 + " " + num3);
                }
                else
                    System.out.println(num2 + " " + num1 + " " + num3);
        }
    }
}
