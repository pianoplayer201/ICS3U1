import java.io.IOException;
import java.util.*;
/*
Program: Battleship
Programmer: Ryan Mehrian
Date Created: May 28, 2024
------
Description:
The game, with all its player logic and main gameplay loop.
 */
public class Battleship {
    // CONSTANTS
    final public static int GRID_SIZE = 10;
    final public static int PLAYER_BOARD_INDEX = 1;
    final public static int ENEMY_BOARD_INDEX = 12;
    final public static int PLAYER_SHOTS_INDEX = 23;
    final public static int ENEMY_SHOTS_INDEX = 34;

    // INITIAL SHIP SIZE AND COUNT
    final public static int DESTROYER_SIZE = 2;
    final public static int CRUISER_SIZE = 3;
    final public static int SUBMARINE_SIZE = 3;
    final public static int BATTLESHIP_SIZE = 4;
    final public static int CARRIER_SIZE = 5;
    final public static int NUM_OF_SHIPS = 5;

    // INDEX for SHIP Information
        // First Layer of 2D Array
    final public static int DESTROYER_INDEX = 0;
    final public static int CRUISER_INDEX = 1;
    final public static int SUBMARINE_INDEX = 2;
    final public static int BATTLESHIP_INDEX = 3;
    final public static int CARRIER_INDEX = 4;
        // Second Layer of 2D Array
    final public static int IS_SUNK = 0;
    final public static int NOT_SUNK = 1;
    final public static int SHIP_SUNK_INDEX = 2;
    final public static int SHIP_HIT_INDEX = 1; // Counts the number of hits on a ship, to then determine if it shoudl be sunk.
    final public static int SHIP_SIZE_INDEX = 0;


    public static void main(String[]args){

        // Game Variables
        boolean quit = false;
        int menuChoice = 0;
        String[][] playerBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] playerShots = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyShots = new String[GRID_SIZE][GRID_SIZE];

        // Initialize Ship Info defaults
        int[][] shipInfo = new int[5][3];
        for(int i = 0; i < NUM_OF_SHIPS; i++){

            //Set ships as not sunk, and not hit
            shipInfo[i][SHIP_SUNK_INDEX] = NOT_SUNK;
            shipInfo[i][SHIP_HIT_INDEX] = 0;

            //Set ship size
            if (i == DESTROYER_INDEX) {
                shipInfo[i][SHIP_SIZE_INDEX] = ((DESTROYER_SIZE));
            }
            else if (i == CRUISER_INDEX) {
                shipInfo[i][SHIP_SIZE_INDEX] = ((CRUISER_SIZE));
            }
            else if (i == SUBMARINE_INDEX) {
                shipInfo[i][SHIP_SIZE_INDEX] = ((SUBMARINE_SIZE));
            }
            else if (i == BATTLESHIP_INDEX) {
                shipInfo[i][SHIP_SIZE_INDEX] = ((BATTLESHIP_SIZE));
            }
            else{
                shipInfo[i][SHIP_SIZE_INDEX] = ((CARRIER_SIZE));
            }

        }

        //Other Object Declarations
        Scanner sc = new Scanner(System.in);

        //MAIN LOOP
        System.out.println("Welcome to Battleship!");
        System.out.print("Press enter to continue...");
        sc.nextLine();
        while(!quit){
            //MAIN MENU
            menuChoice = Screen.mainMenu();
            if (menuChoice == 1){
                //New Game
                //newGame();
            }else if (menuChoice == 2){
                //Load Game
                loadGame(playerBoard, enemyBoard, playerShots, enemyShots);
            }else if (menuChoice == 3){
                //Instructions
                Screen.instructions();
            }else if (menuChoice == 4){
                //Exit
                System.out.println("QUITTING");
                quit = true;
            }
        }
    }

    /*
    Method: loadGame
    -----
    Parameters:
    String[][] playerBoard - the player's board to load.
    String[][] enemyBoard - the enemy's board to load.
    String[][] playerShots - the player's shots to load.
    String[][] enemyShots - the enemy's shots to load.
    -----
    Description:
    Prompts the user for a file path, then uses File.readFile to load the player's data. This method formats it into
    respective arrays.
     */
    public static void loadGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots){
        // Declarations
        String path = "";
        String[][] data = new String[File.FILE_LINE_COUNT][GRID_SIZE];
        boolean valid = false;

        Scanner sc = new Scanner(System.in);

        // Output Screen, Get Path and Read File
        Screen.clearScreen();
        System.out.println("Enter the path of the save file (.txt included): ");
        System.out.print(" > ");
        path = sc.nextLine();

        try{
            data = File.readFile(path);
            valid = true;
        } catch(IOException e){
            System.out.println("Invalid File. Please try again.");
            valid = false;
        } catch (Exception e){
            System.out.println("An error occurred. Please try again.");
            valid = false;
        }


        // Format Read File Data
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                playerBoard[i][j] = data[PLAYER_BOARD_INDEX+i][j];
                enemyBoard[i][j] = data[ENEMY_BOARD_INDEX+i][j];
                playerShots[i][j] = data[PLAYER_SHOTS_INDEX+i][j];
                enemyShots[i][j] = data[ENEMY_SHOTS_INDEX+i][j];
            }
        }

        if(!valid){
            return;
        }
        else{
            System.out.println("LOADING...");
            Screen.gameBoard(playerBoard, playerShots, enemyShots);
        }
    }

    /*
    Method: saveGame
    -----
    Parameters:
    String[][] playerBoard - the player's board to save.
    String[][] enemyBoard - the enemy's board to save.
    String[][] playerShots - the player's shots to save.
    String[][] enemyShots - the enemy's shots to save.
    -----
    Description:
    Prompts the user for a file path, then uses File.writeFile to save the player's data.
     */
    public static void saveGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots){
        // Declarations
        String path = "";
        Scanner sc = new Scanner(System.in);

        // Output Screen, Get Path and Write File
        Screen.clearScreen();
        System.out.println("Enter the path of the save file (.txt included): ");
        System.out.print(" > ");
        path = sc.nextLine();

        // Try to write to the file
        try{
            File.writeFile(path, playerBoard, enemyBoard, playerShots, enemyShots);
            System.out.println("SAVE SUCCESSFUL!");
        }catch(IOException e){
            System.out.println("An error occurred. Please try again.");
        }
    }

    /*

     */
}
