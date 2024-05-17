import javax.swing.*;
import java.util.Scanner;

/*
Program: Alphabets
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
This program counts the number of alphabetical characters the user has entered,
up until they input a non-alphabetical character.
The program keeps track of number of UPPER case, lower case and vowel characters.
 */
public class Alphabets {
    public static void main(String[] args) {
        //Declarations
        final Character[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int numOfVowels = 0;
        int numOfUpCase = 0;
        int numOfLowCase = 0;
        Character letter;

        Scanner sc = new Scanner(System.in);

        //Input
        do{
            System.out.print("Enter a letter: ");
            letter = sc.nextLine().charAt(0);

            //Check if Character
            if(Character.isAlphabetic(letter)){
                //Check Case
                if(Character.isUpperCase(letter)){
                    numOfUpCase += 1;
                }
                else{
                    numOfLowCase += 1;
                }

                //Check Vowels
                for(int i = 0; i < VOWELS.length; i++){
                    if(letter == VOWELS[i]){
                        numOfVowels += 1;
                    }
                }
            }
            //Output
            else{
                System.out.printf("\nYou have entered %d Upper Case Letters\n", numOfUpCase);
                System.out.printf("You have entered %d Lower Case Letters\n", numOfLowCase);
                System.out.printf("You have entered %d Vowels\n", numOfVowels);
            }

        }while(Character.isAlphabetic(letter));
    }
}
