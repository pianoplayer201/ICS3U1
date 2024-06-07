import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Program: StarTable
Programmer: Ryan Mehrian
Date: May 5, 2024
------
This program outputs a 12x12 table fo * to the file star.txt
 */
public class StarTable {
    public static void main(String[]args) {
        //Declarations
        final String FILEPATH = "star.txt";
        String[][] table;
        int width, height;
        BufferedWriter write;
        Scanner sc = new Scanner(System.in);

        try {
            //Input
            System.out.print("Please enter the width of the table: ");
            width = sc.nextInt();
            System.out.print("Please enter the height of the table: ");
            height = sc.nextInt();

            //Init
            table = new String[height][width];
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    table[i][j] = "*";
                    }
            }

            //Write
            write = new BufferedWriter(new FileWriter(FILEPATH));
            for(String[] i : table){
                for(String j : i){
                    write.write(j + " ");
                }
                write.write("\n");
            }
            write.close();

        } catch (IOException e) {
            System.out.println(e);
        } catch(InputMismatchException e){
            System.out.println("INVALID NUMBER.");
        }
    }
}
