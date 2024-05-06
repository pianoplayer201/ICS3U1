import java.io.*;

/*
Program: PrintLines
Programmer: Ryan Mehrian
Date: May 5, 2024
-----
This program reads the file and outputs the data read.
 */
public class PrintLines {
    public static void main(String[]args){
        //Declarations
        final String filepath = "line.txt";
        String output = "";
        BufferedReader reader = null;

        //Reader and Output
        try{
            reader = new BufferedReader(new FileReader(filepath));

            do {
                System.out.println(output);
                output = reader.readLine();
            }while (output!=null);

            reader.close();
        }
        catch (IOException e){
            System.out.println(e);
        }

    }

}
