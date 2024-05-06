import java.io.*;
import java.util.Scanner;

/*
Program: WriteLines
Programmer: RyanMehrian
Date: May 5, 2024
------
Saves 10 lines of user input into file.
 */
public class WriteLines {
    public static void main(String[] args) {
        //Declarations
        final String filepath = "writeLines.txt";
        final int numOfLines = 10;
        String input;

        BufferedWriter writer;
        Scanner sc = new Scanner(System.in);

        //Input and Output
        try {
            writer = new BufferedWriter(new FileWriter(filepath, false));
            for(int i = 0; i < numOfLines; i++){
                System.out.printf("Please enter Line%d: ", i+1);
                writer.write(sc.nextLine() + "\n");
            }
            writer.close();

            System.out.println("Lines Saved Successfully!");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
