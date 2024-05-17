import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Program: AddNumbers
Programmer: Ryan Mehrian
Date: May 6, 2024
-----
This program takes input from file, adding all the integers stored on file and outputting them.
 */
public class AddNumbers {
    public static void main(String[] args) {
        //Declarations
        final String filepath = "numbers.txt";
        int sum = 0;
        BufferedReader fileIn = null;

        //Read File and Add
        try{
            fileIn = new BufferedReader(new FileReader(filepath));
            while(true){
                sum += Integer.parseInt(fileIn.readLine());
            }
        }
        catch(IOException e){
            System.out.println(e + "CANNOT READ");
        }
        //Reach end of File
        catch(NumberFormatException exitProgram){
            //Close Reader
            try{
                fileIn.close();
            }
            catch(IOException e){

            }
            System.out.printf("The sum of all the numbers are: %d", sum);
        }
    }
}
