import java.util.Scanner;
/*
Program: Pass
Programmer: Ryan Mehrian
Date: March 28, 2024
-----
The program will prompt the user to solve a random math equation with random integers
operators. The program will tell the user if their response is correct or not.
 */
public class Pass {
    public static void main(String[] args) {
        //Declarations
        final int INT_1 = (int) (Math.random()*100);
        final int INT_2 = (int) (Math.random()*100);
        double answer = 0;
        int userAnswer;

        Scanner sc = new Scanner(System.in);

        //Randomize Operator and Input prompt.
        switch ((int)(Math.random()*4)){
            case 0:
                answer = INT_1 + INT_2;
                System.out.printf("What is the answer to %d + %d?\n> ", INT_1, INT_2);
                break;
            case 1:
                answer = INT_1 - INT_2;
                System.out.printf("What is the answer to %d - %d?\n> ", INT_1, INT_2);
                break;
            case 2:
                answer = INT_1 * INT_2;
                System.out.printf("What is the answer to %d * %d?\n> ", INT_1, INT_2);
                break;
            case 3:
                answer = INT_1 / (double)INT_2;
                System.out.printf("What is the answer to %d / %d?\n> ", INT_1, INT_2);
                break;
            default:
                System.out.print("ERROR: INVALID OPERATOR CHOICE. BUGFIX!");
                break;
                
        }
        userAnswer = sc.nextInt();

        //Check to see if userAnswer == ANSWER, then output result
        if (userAnswer == answer)
            System.out.println("Correct! :)");
        else
            System.out.println("Incorrect! :(");
    }
}
