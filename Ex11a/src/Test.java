import java.util.Scanner;

/*
Program: Test
Programmer: Ryan Mehrian
Date: March 10, 2024
-----
This program asks the user to input a mark, and evaluates whether the mark
is passing or failing. The program will only accept marks within range
of 0 and 100.
 */
public class Test {
    public static void main(String[] args) {
        //Declarations
        final int UPPER_LIMIT = 100;
        final int LOWER_LIMIT = 0;
        final int PASSING_LIMIT = 50;
        int userMark;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter mark between 1 to 100: ");
        userMark = sc.nextInt();

        //Checks and Output
        if(userMark <= UPPER_LIMIT && userMark >= LOWER_LIMIT){
            if(userMark >= PASSING_LIMIT){
                System.out.println("PASSING GRADE");
            }
            else
                System.out.println("FAILING GRADE");
        }
        else if(userMark > UPPER_LIMIT){
            System.out.println("Mark above MAX range");
        }
        else
            System.out.println("Mark below MIN range");

    }
}