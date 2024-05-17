import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Program: PrintAllChar
Programmer: Ryan Mehrian
Date: May 6, 2024
-----
This program reads a file, and outputs each character of the file on a separate line.
 */
public class PrintAllChar {
    public static void main(String[]args) {
        //Declarations
        final String filepath = "allChar.txt";
        String input = "";
        BufferedReader reader = null;

        //Input & Output
        try {
            reader = new BufferedReader(new FileReader(filepath));
            while(true){
                input = Character.toString(reader.read());
                if(input.charAt(0)!='\n' && input.charAt(0) != '\r' ){
                    System.out.println(input);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e + "CANNOT READ");
        }
        //End of File
        catch(IllegalArgumentException e){
            try{
                reader.close();
            }
            catch (IOException except){
                
            }
        }
    }
}
