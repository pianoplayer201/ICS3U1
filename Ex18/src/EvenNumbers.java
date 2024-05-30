import java.util.Scanner;

/*
Program: EvenNumbers
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
This program continuously prompts the user for integers, and stops when non positive
integers are entered. The program then outputs the number of even numbers entered.
 */
public class EvenNumbers {
    public static void main(String[] args) {
        //Declarations
        int numOfEven = 0;
        int input = 1;
        Scanner sc = new Scanner(System.in);

        //Input and Processing
        do{
            if(input % 2 == 0){
                numOfEven += 1;
            }
            System.out.print("Enter an Integer: ");
            input = sc.nextInt();

        }while(input >= 0);

        //Output
        System.out.printf("You have entered %d even numbers." , numOfEven);
    }
}
