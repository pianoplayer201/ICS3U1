/**
* Program: Battleship
* Programmer: Ryan Mehrian
* Date Created: May 28, 2024
* ------
* Description:
* The game, with all its player logic and main gameplay loop.
 */

import java.io.IOException;
import java.util.*;

public class Battleship {
    // CONSTANTS
    final public static int GRID_SIZE = 10;
    final public static String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

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
    final public static int HORIZONTAL_DIRECTION = 0;
    final public static int VERTICAL_DIRECTION = 1;

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
        boolean easyMode = true;
        int menuChoice = 0;
        String[][] playerBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] playerShots = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyShots = new String[GRID_SIZE][GRID_SIZE];

        // Initialize Ship Info defaults
        int[][] shipInfo = new int[5][3];
        int[][] shipInfoEnemy;

        // Initialize all the boards to be empty to start with.
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                playerBoard[i][j] = Screen.EMPTY;
                enemyBoard[i][j] = Screen.EMPTY;
                playerShots[i][j] = Screen.EMPTY;
                enemyShots[i][j] = Screen.EMPTY;
            }
        }

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
        shipInfoEnemy = shipInfo.clone();


        // Startup Message
        System.out.println("Welcome to Battleship!");
        Screen.enterPrompt();

        //MAIN LOOP
        while(!quit){
            //MAIN MENU
            menuChoice = Screen.mainMenu();
            if (menuChoice == 1){
                //New Game
                newGame(playerBoard, enemyBoard, playerShots, enemyShots, shipInfo, shipInfoEnemy);
            }else if (menuChoice == 2){
                //Load Game
                loadGame(playerBoard, enemyBoard, playerShots, enemyShots, shipInfo, shipInfoEnemy);
            }else if (menuChoice == 3) {
                //Instructions
                Screen.instructions();
            }
            else if (menuChoice == 4){
                //Difficulty Change
                easyMode = Screen.difficultyMenu(easyMode);
            }
            else if (menuChoice == 5){
                //Exit
                System.out.println("QUITTING");
                quit = true;
            }
        }
    }

    /**
    * Method: loadGame
    * -----
    * Parameters:
    * String[][] playerBoard - the player's board to load.
    * String[][] enemyBoard - the enemy's board to load.
    * String[][] playerShots - the player's shots to load.
    * String[][] enemyShots - the enemy's shots to load.
    * int[][] shipInfo - the ship information to load.
    * int[][] shipInfoEnemy - the enemy's ship information to load.
    * -----
    * Description:
    * Prompts the user for a file path, then uses File.readFile to load the player's data. This method formats it into
    * respective arrays.
     */
    public static void loadGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots, int[][]shipInfo, int[][] shipInfoEnemy){
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

        // Count Instances of Ship on Boards : PLAYER
        for(String[] i: playerBoard){
            for(String j : i){
                if(j.equals(Screen.DESTROYER)){
                    shipInfo[DESTROYER_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.CRUISER)){
                    shipInfo[CRUISER_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.SUBMARINE)){
                    shipInfo[SUBMARINE_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.BATTLESHIP)){
                    shipInfo[BATTLESHIP_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.CARRIER)){
                    shipInfo[CARRIER_INDEX][SHIP_HIT_INDEX]++;
                }
            }
        }

        // Count Instances of Ship on Boards : ENEMY
        for(String[] i: enemyBoard){
            for(String j : i){
                if(j.equals(Screen.DESTROYER)){
                    shipInfoEnemy[DESTROYER_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.CRUISER)){
                    shipInfoEnemy[CRUISER_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.SUBMARINE)){
                    shipInfoEnemy[SUBMARINE_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals(Screen.BATTLESHIP)){
                    shipInfoEnemy[BATTLESHIP_INDEX][SHIP_HIT_INDEX]++;
                }
                else if(j.equals( Screen.CARRIER)){
                    shipInfoEnemy[CARRIER_INDEX][SHIP_HIT_INDEX]++;
                }
            }
        }

        // Compare Hit counts to Ship Size to determine if ship is sunk
        for(int i = 0; i < NUM_OF_SHIPS; i++){
            if(shipInfo[i][SHIP_HIT_INDEX] == shipInfo[i][SHIP_SIZE_INDEX]){
                shipInfo[i][SHIP_SUNK_INDEX] = IS_SUNK;
            }
            if(shipInfoEnemy[i][SHIP_HIT_INDEX] == shipInfoEnemy[i][SHIP_SIZE_INDEX]){
                shipInfoEnemy[i][SHIP_SUNK_INDEX] = IS_SUNK;
            }
        }

        if(!valid){
            return;
        }
        else{
            System.out.println("LOADING...");
            Screen.gameBoard(playerBoard, playerShots);
        }
    }

    /**
    * Method: saveGame
    * -----
    * Parameters:
    * String[][] playerBoard - the player's board to save.
    * String[][] enemyBoard - the enemy's board to save.
    * String[][] playerShots - the player's shots to save.
    * String[][] enemyShots - the enemy's shots to save.
    * -----
    * Description:
    * Prompts the user for a file path, then uses File.writeFile to save the player's data.
     */
    public static void saveGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots){
        // Declarations
        String path = "";
        Scanner sc = new Scanner(System.in);

        // Output Screen, Get Path and Write File
        Screen.clearScreen();
        System.out.println("Enter the filename you want to save to (.txt included): ");
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

    /**
    * Method: newGame
    * -----
    * Parameters:
    * String[][] playerBoard - the player's board to manipulate.
    * String[][] enemyBoard - the enemy's board to manipulate.
    * String[][] playerShots - the player's shots to manipulate.
    * String[][] enemyShots - the enemy's shots to manipulate.
    * int[][] shipInfo - the ship information to manipulate.
    * int[][] shipInfoEnemy - the enemy's ship information to manipulate.
    * -----
    * Description:
    * Controls the flow of a new game, including ship placement.
     */
    public static void newGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots, int[][] shipInfo, int[][] shipInfoEnemy){
        // Declarations


        // Place Player Ships
        for(int i = 0; i < NUM_OF_SHIPS; i++){
            Screen.placePrompt(playerBoard, playerShots, shipInfo, i);
        }
    }


    /**
    * method: placeShip
    * -----
    * Parameters:
    * String[][] board - the board to place the ship on (player or enemy).
    * int[][] shipInfo - the ship information to manipulate (player or enemy).
    * int shipIndex - the index of the ship in the shipInfo array (Destroyer, Battleship, ETC.)
    * int x - the x coordinates of the ship.
    * int y - the y coordinates of the ship.
    * int direction - the direction of the ship (0 for horizontal, 1 for vertical).
    * -----
    * Returns:
    * boolean - true if the ship was placed successfully, false if not.
    * -----
    * Description:
    * Takes in coordinates (0 indexed) and places the ship on the board. If the ship is placed successfully, the method returns true.
     */
    public static boolean placeShip(String[][] board, int[][] shipInfo, int shipIndex, int x, int y, int direction){
        // Declarations
        boolean valid = true;
        int shipSize = shipInfo[shipIndex][SHIP_SIZE_INDEX];
        int shipX = x;
        int shipY = y;

        // Check if ship can be placed horizontally
        if(direction == HORIZONTAL_DIRECTION){
            if (shipX + shipSize > GRID_SIZE){
                valid = false;
            }
            else{
                for(int i = 0; i < shipSize; i++){
                    if(board[shipY][shipX+i].equals(Screen.EMPTY)){
                        valid = true;
                    }
                    else{
                        valid = false;
                        break;
                    }
                }
            }
        }
        // Check if ship can be placed vertically
        else{
            if (shipY + shipSize > GRID_SIZE){
                valid = false;
            }
            else{
                for(int i = 0; i < shipSize; i++){
                    if(board[shipY + i][shipX].equals(Screen.EMPTY)){
                        valid = true;
                    }
                    else{
                        valid = false;
                        break;
                    }
                }
            }
        }

        // Check if Place Valid, then Place Ship
        if (valid){
            // Vertical Place
            if(direction == VERTICAL_DIRECTION){
                for(int i = 0; i < shipSize; i++){
                    board[shipY+i][shipX] = indexShipLetter(shipIndex, false);
                }
            }
            // Horizontal Place
            else{
                for(int i = 0; i < shipSize; i++){
                    board[shipY][shipX+i] = indexShipLetter(shipIndex, false);
                }
            }
        }

        return valid;
    }

    /**
    * Method: indexShipLetter
    * -----
    * Parameters:
    * int ship - the ship to get the string of.
     *  boolean fullName - whether or not to return the full name of the ship.
    * -----
    * Returns:
    * String - the String of the ship.
    * -----
    * Because I'm dumb and decided not to use enums for the ships, I have to use this method to get the string of the ship based on an index.
     */
    public static String indexShipLetter(int ship, boolean fullName) {
        String index = "";
        switch (ship) {
            case DESTROYER_INDEX:
                index = fullName ? "Destroyer" : Screen.DESTROYER;
                break;
            case CRUISER_INDEX:
                index = fullName ? "Cruiser" : Screen.CRUISER;
                break;
            case SUBMARINE_INDEX:
                index = fullName ? "Submarine" : Screen.SUBMARINE;
                break;
            case BATTLESHIP_INDEX:
                index = fullName ? "Battleship" : Screen.BATTLESHIP;
                break;
            case CARRIER_INDEX:
                index = fullName ? "Carrier" : Screen.CARRIER;
                break;
            default:
                break;
        }
        return index;
    }

    /**
     * Method: mapLetterCoordsToIndex
     * -----
     * Parameters:
     * String coordinates - the alphanumeric coordinates to map to an index.
     * -----
     * Returns:
     * int - the 0-indexed equivalent of the letter coords.
     * -----
     * This method takes in alphanumeric x value, and maps it to a 0-indexed integer based upon LETTERS array.
     * If cannot find the index, returns -1.
     */
    public static int mapLetterCoordsToIndex(String coordinates) {

        // Declarations
        int index = -1;

        // Loop through LETTERS array to find the index of the coordinates
        for (int i = 0; i < LETTERS.length; i++) {
            if (LETTERS[i].equals(coordinates)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
