import java.io.*;
import java.util.*;

/*
Class: File
Programmer: Ryan Mehrian
Date Created: May 28, 2024
-----
Description:
A class that is meant to handle everything pertaining to writing and reading files.
 */
public class File {
    /*
    Method: readFile
    -----
    Parameters:
    String path - the path of the file to read.
    -----
    Returns:
    String[][] - a 2D array of strings that represents the contents of the file.
     */
    public static String[][] readFile(String path) {
        //Declarations
        String filepath = "";
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = null;
        String[][] data = new String[Battleship.SAVEFILE_LINE_COUNT][Battleship.GRID_SIZE];

        //Try to read the file
        try {
            reader = new BufferedReader(new FileReader(path));
            for (int i = 0; i < Battleship.SAVEFILE_LINE_COUNT; i++) {
                String line = reader.readLine();
                String[] lineData = line.split(",");
                for (int j = 0; j < lineData.length; j++) {
                    data[i][j] = lineData[j];
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return data;
    }
}
