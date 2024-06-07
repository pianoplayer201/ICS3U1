import java.util.*;

/*
Program: Marks
Programmer: Ryan Mehrian
Date: May 31, 2024
-----
This program will ask the user for 4 marks, attached to 4 names.
The user will then be asked to enter a mark, and the program will output the name associated with that mark.
 */
public class Marks {
    public static void main(String[] args) {
        // Declarations
        final int STUDENT_COUNT = 4;
        int numOfMatches = 0;
        String searchMark;
        Scanner sc = new Scanner(System.in);
        String[] names = new String[STUDENT_COUNT];
        String[] marks = new String[STUDENT_COUNT];

        // Input
        for (int i = 0; i < STUDENT_COUNT; i++) {
            System.out.printf("Please enter the name of student #%d: ", i + 1);
            names[i] = sc.nextLine();
            System.out.printf("Please enter the mark of student #%d: ", i + 1);
            marks[i] = String.valueOf(sc.nextDouble());
            sc.nextLine();
        }

        // Prompt for mark search
        System.out.print("Please enter a mark to search for: ");
        searchMark = String.valueOf(sc.nextDouble());

        // Search for Mark and Output
        System.out.println("The following students have the mark " + searchMark + ":");
        for (int i = 0; i < STUDENT_COUNT; i++) {
            if (marks[i].equals(searchMark)) {
                System.out.println(names[i]);
                numOfMatches++;
            }
        }

        //Tell user if no users got mark
        if(numOfMatches <= 0){
            System.out.println("No students have that mark!");
        }
    }
}
