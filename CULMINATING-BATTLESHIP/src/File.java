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

    // CONSTANTS
    final public static int FILE_LINE_COUNT = 44;

    /*
    Method: readFile
    -----
    Parameters:
    String path - the path of the file to read.
    -----
    Returns:
    String[][] - a 2D array of strings that represents the contents of the file.
    -----
    Description:
    Reads a file and returns its contents as a 2D array of strings.
     */
    public static String[][] readFile(String path) throws IOException{
        //Declarations
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = null;
        String[][] data = new String[FILE_LINE_COUNT][Battleship.GRID_SIZE];

        //Try to read the file
        reader = new BufferedReader(new FileReader(path));

        for (int i = 0; i < FILE_LINE_COUNT; i++) {

            for (int j = 0; j < Battleship.GRID_SIZE; j++) {
                data[i][j] = String.valueOf((char)reader.read());
            }
            reader.readLine();

        }

        return data;
    }

    /*
    Method: writeFile
    -----
    Parameters:
    String path - the path of the file to write to.
    String[][] playerBoard - the player's board to write to the file.
    String[][] enemyBoard - the enemy's board to write to the file.
    String[][] playerShots - the player's shots to write to the file.
    String[][] enemyShots - the enemy's shots to write to the file.
    -----
    Description:
    Writes the player's board, enemy's board, player's shots and enemy's shots to a file using the proper format.
     */
    public static void writeFile(String path, String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots) throws IOException{
        // Declarations
        BufferedWriter writer = null;

        //Try to write to the file
        writer = new BufferedWriter(new FileWriter(path));

        // Write the player board
        writer.write("Player ships:\n");
        for (int i = 0; i < Battleship.GRID_SIZE; i++) {
            for (int j = 0; j < Battleship.GRID_SIZE; j++) {
                writer.write(playerBoard[i][j]);
            }
            writer.newLine();
        }

        // Write the enemy board
        writer.write("CPU ships:\n");
        for (int i = 0; i < Battleship.GRID_SIZE; i++) {
            for (int j = 0; j < Battleship.GRID_SIZE; j++) {
                writer.write(enemyBoard[i][j]);
            }
            writer.newLine();
        }

        // Write the player shots
        writer.write("Player shots:\n");
        for (int i = 0; i < Battleship.GRID_SIZE; i++) {
            for (int j = 0; j < Battleship.GRID_SIZE; j++) {
                writer.write(playerShots[i][j]);
            }
            writer.newLine();
        }

        // Write the enemy shots
        writer.write("CPU shots:\n");
        for (int i = 0; i < Battleship.GRID_SIZE; i++) {
            for (int j = 0; j < Battleship.GRID_SIZE; j++) {
                writer.write(enemyShots[i][j]);
            }
            writer.newLine();
        }

        // Close the writer
        writer.close();
    }
}
