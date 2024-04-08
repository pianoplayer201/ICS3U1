import java.util.Scanner;

/*
Program Name: Input_4
Programmer: Ryan Mehrian
Date Created: February 13, 2024
--------------------
The programs prompts the user to enter two words. These words are then outputted
each twice: Once on separate lines, and once on the same line separated by a tab.
 */
public class Input_4 {
    public static void main(String[]args){

        // Declare Variable and create new Scanner object
        String word1, word2;
        Scanner sc = new Scanner(System.in);

        // Prompt user for their words.
        System.out.print("Please enter word #1: ");
        word1 = sc.nextLine();
        System.out.print("Please enter word #2: ");
        word2 = sc.nextLine();

        // Output
        System.out.println(word1 + '\n' + word2);
        System.out.println(word1 + '\t' + word2);

    }
}
