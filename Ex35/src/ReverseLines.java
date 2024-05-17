import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Program: ReverseLines
Programmer: Ryan Mehrian
Date: May 10, 2024
-----
This program reads a file with a provided number of lines. The program outputs the lines in reverse order.
 */
public class ReverseLines {
    public static void main(String[]args){
        //Declarations
        final String filepath = "reverse.txt";
        String[] fileData;
        BufferedReader reader;

        //Input & Output
        try{
            reader = new BufferedReader(new FileReader(filepath));

            //Initialize Array Length
            fileData = new String[Integer.parseInt(reader.readLine())];

            //Read data to Array
            for(int i = fileData.length-1; i >= 0; i--){
                fileData[i] = reader.readLine();
            }

            //Output
            for(int i = 0; i < fileData.length; i++){
                System.out.println(fileData[i]);
            }

            reader.close();
        }
        catch(IOException e){
            System.out.println(e + "CANNOT READ");
        }

    }
}
