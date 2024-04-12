import java.util.Scanner;

/*
Program: Tip
Programmer: Ryan Mehrian
Date: March 28, 2024
-----
The program will ask the user to input their letter grade for their ICS course.
The program will respond with a different study tip for each letter grade.
 */
public class Tip {
    public static void main(String[]args){
        //Declarations
        String letterGrade;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter your letter grade in ICS: ");
        letterGrade = sc.nextLine();

        //Output
        System.out.println("TIP:");
        switch (letterGrade){
            case "A":
                System.out.println("You're doing great, just get good sleep before tests!");
                break;
            case "B":
                System.out.println("Not bad! Try doing the optional exercises posted on Brightspace.");
                break;
            case "C":
                System.out.println("If you'd like to improve your mark, try catching up on exercises and review content before tests.");
                break;
            case "D":
                System.out.println("Pay attention during Lessons, and keep up with exercises!");
                break;
            case "F":
                System.out.println("Talk with your teacher, and see if you can redo any tests to raise your grade.");
                break;
            default:
                System.out.println("ERROR: INVALID LETTER GRADE");
        }
    }
}
