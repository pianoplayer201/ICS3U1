import java.io.*;
import java.util.Scanner;

/*
Program: WriteChars
Programmer: RyanMehrian
Date: May 5, 2024
------
This program takes an endless stream of user input until the user enters the exit-word "stop".
Then, the program writes all the strings entered by the user into a file, each character on a separate line.
 */
public class WriteChars {
    public static void main(String[]args) {
        //Declarations
        final String FILEPATH = "writeChars.txt";
        String input = "";
        String toFile = "";
        Boolean stop = false;

        BufferedWriter file = null;
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter a string. Enter 'stop' to stop the program: ");
        input = sc.nextLine();
        while(!input.toLowerCase().equals("stop")){
            toFile += input + " ";
            System.out.print("Please enter another string: ");
            input = sc.nextLine();
        }

        //Write to File
        try{
            file = new BufferedWriter(new FileWriter(FILEPATH));

            for(int i = 0; i < toFile.length(); i++){
                file.write(toFile.charAt(i) + "\n");
            }

            file.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
