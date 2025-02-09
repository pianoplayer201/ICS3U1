/**
* Program: Battleship
* Programmer: Ryan Mehrian
* Date Created: May 28, 2024
* ------
* Description:
* The game, with all its player logic and main gameplay loop. This class is the main class that controls the flow of the game.
* ------------------
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
    final public static int SHIP_VALUE_COUNT = 5;
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

    // Win/Lose Indexes
    final public static int PLAYER_WIN = 0;
    final public static int PLAYER_LOSE = 1;


    public static void main(String[] args) {

        // Game Variables
        boolean quitProgram = false;
        boolean quitGame = false;
        boolean easyMode = true;
        boolean loadGameSuccess = false;
        int menuChoice = 0;
        String[][] playerBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] playerShots = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyShots = new String[GRID_SIZE][GRID_SIZE];

        // Initialize Ship Info defaults
        int[][] shipInfoPlayer = new int[NUM_OF_SHIPS][SHIP_VALUE_COUNT];
        int[][] shipInfoEnemy = new int [NUM_OF_SHIPS][SHIP_VALUE_COUNT];

        // Initialize all the boards to be empty to start with.
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                playerBoard[i][j] = Screen.EMPTY;
                enemyBoard[i][j] = Screen.EMPTY;
                playerShots[i][j] = Screen.EMPTY;
                enemyShots[i][j] = Screen.EMPTY;
            }
        }

        for (int i = 0; i < NUM_OF_SHIPS; i++) {

            //Set ships as not sunk, and not hit
            shipInfoPlayer[i][SHIP_SUNK_INDEX] = NOT_SUNK;
            shipInfoPlayer[i][SHIP_HIT_INDEX] = 0;

            //Set ship size
            if (i == DESTROYER_INDEX) {
                shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((DESTROYER_SIZE));
            } else if (i == CRUISER_INDEX) {
                shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((CRUISER_SIZE));
            } else if (i == SUBMARINE_INDEX) {
                shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((SUBMARINE_SIZE));
            } else if (i == BATTLESHIP_INDEX) {
                shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((BATTLESHIP_SIZE));
            } else {
                shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((CARRIER_SIZE));
            }

        }

        // Clone the player's ship info to the enemy's ship info using for loop
        for (int i = 0; i < NUM_OF_SHIPS; i++) {
            shipInfoEnemy[i][SHIP_SIZE_INDEX] = shipInfoPlayer[i][SHIP_SIZE_INDEX];
            shipInfoEnemy[i][SHIP_SUNK_INDEX] = shipInfoPlayer[i][SHIP_SUNK_INDEX];
            shipInfoEnemy[i][SHIP_HIT_INDEX] = shipInfoPlayer[i][SHIP_HIT_INDEX];
        }


        // Startup Message
        System.out.println("Welcome to Battleship!");
        Screen.enterPrompt();

        //MAIN LOOP
        while (!quitProgram) {

            // Reset Game Variables
            quitGame = false;

            // Initialize all the boards to be empty to start with.
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    playerBoard[i][j] = Screen.EMPTY;
                    enemyBoard[i][j] = Screen.EMPTY;
                    playerShots[i][j] = Screen.EMPTY;
                    enemyShots[i][j] = Screen.EMPTY;
                }
            }

            for (int i = 0; i < NUM_OF_SHIPS; i++) {

                //Set ships as not sunk, and not hit
                shipInfoPlayer[i][SHIP_SUNK_INDEX] = NOT_SUNK;
                shipInfoPlayer[i][SHIP_HIT_INDEX] = 0;

                //Set ship size
                if (i == DESTROYER_INDEX) {
                    shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((DESTROYER_SIZE));
                } else if (i == CRUISER_INDEX) {
                    shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((CRUISER_SIZE));
                } else if (i == SUBMARINE_INDEX) {
                    shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((SUBMARINE_SIZE));
                } else if (i == BATTLESHIP_INDEX) {
                    shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((BATTLESHIP_SIZE));
                } else {
                    shipInfoPlayer[i][SHIP_SIZE_INDEX] = ((CARRIER_SIZE));
                }

            }

            // Clone the player's ship info to the enemy's ship info using for loop
            for (int i = 0; i < NUM_OF_SHIPS; i++) {
                shipInfoEnemy[i][SHIP_SIZE_INDEX] = shipInfoPlayer[i][SHIP_SIZE_INDEX];
                shipInfoEnemy[i][SHIP_SUNK_INDEX] = shipInfoPlayer[i][SHIP_SUNK_INDEX];
                shipInfoEnemy[i][SHIP_HIT_INDEX] = shipInfoPlayer[i][SHIP_HIT_INDEX];
            }

            //MAIN MENU
            menuChoice = Screen.mainMenu();
            if (menuChoice == 1) {
                //New Game
                newGame(playerBoard, enemyBoard, playerShots, enemyShots, shipInfoPlayer, shipInfoEnemy);

                // Turn Loops
                while (!quitGame)
                    quitGame = turnSequence(playerBoard, enemyBoard, playerShots, enemyShots, shipInfoPlayer, shipInfoEnemy, easyMode);

            } else if (menuChoice == 2) {
                //Load Game & Turn Loops
                loadGameSuccess = loadGame(playerBoard, enemyBoard, playerShots, enemyShots, shipInfoPlayer, shipInfoEnemy);
                while (!quitGame && loadGameSuccess)
                    quitGame = turnSequence(playerBoard, enemyBoard, playerShots, enemyShots, shipInfoPlayer, shipInfoEnemy, easyMode);

            } else if (menuChoice == 3) {
                //Instructions
                Screen.instructions();
            } else if (menuChoice == 4) {
                //Difficulty Change
                easyMode = Screen.difficultyMenu(easyMode);
            } else if (menuChoice == 5) {
                //Exit
                System.out.println("QUITTING");
                quitProgram = true;
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
     * Returns:
     * boolean - true if the game was loaded successfully, false if not.
     * -----
     * Description:
     * Prompts the user for a file path, then uses File.readFile to load the player's data. This method formats it into
     * respective arrays. If the file is invalid, the method returns false.
     */
    public static boolean loadGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots, int[][] shipInfo, int[][] shipInfoEnemy) {
        // Declarations
        String path = "";
        String[][] data = new String[File.FILE_LINE_COUNT][GRID_SIZE];
        boolean valid = false;
        boolean success = false;

        Scanner sc = Screen.scannerDeclare();

        // Output Screen, Get Path and Read File
        Screen.clearScreen();
        System.out.println("Enter the path of the save file (file extension included): ");
        System.out.print(" > ");
        path = sc.nextLine();

        try {
            data = File.readFile(path);
            valid = true;
        } catch (IOException e) {
            System.out.println("Invalid File. Please try again.");
            valid = false;
            Screen.enterPrompt();
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            Screen.enterPrompt();
            valid = false;
        }

        if(valid){
            // Format Read File Data
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    playerBoard[i][j] = data[PLAYER_BOARD_INDEX + i][j];
                    enemyBoard[i][j] = data[ENEMY_BOARD_INDEX + i][j];
                    playerShots[i][j] = data[PLAYER_SHOTS_INDEX + i][j];
                    enemyShots[i][j] = data[ENEMY_SHOTS_INDEX + i][j];
                }
            }

            // Set All Ships hit count to their size for initalization (will then reduce to actual hits in following loops)
            for (int i = 0; i < NUM_OF_SHIPS; i++) {
                shipInfo[i][SHIP_HIT_INDEX] = shipInfo[i][SHIP_SIZE_INDEX];
                shipInfo[i][SHIP_SUNK_INDEX] = NOT_SUNK;
                shipInfoEnemy[i][SHIP_HIT_INDEX] = shipInfoEnemy[i][SHIP_SIZE_INDEX];
                shipInfoEnemy[i][SHIP_SUNK_INDEX] = NOT_SUNK;
            }

            // Count Instances of Ship on Boards : PLAYER
            for (String[] i : playerBoard) {
                for (String j : i) {
                    if (j.equals(Screen.DESTROYER)) {
                        shipInfo[DESTROYER_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.CRUISER)) {
                        shipInfo[CRUISER_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.SUBMARINE)) {
                        shipInfo[SUBMARINE_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.BATTLESHIP)) {
                        shipInfo[BATTLESHIP_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.CARRIER)) {
                        shipInfo[CARRIER_INDEX][SHIP_HIT_INDEX]--;
                    }

                }
            }

            // Count Instances of Ship on Boards : ENEMY
            for (String[] i : enemyBoard) {
                for (String j : i) {
                    if (j.equals(Screen.DESTROYER)) {
                        shipInfoEnemy[DESTROYER_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.CRUISER)) {
                        shipInfoEnemy[CRUISER_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.SUBMARINE)) {
                        shipInfoEnemy[SUBMARINE_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.BATTLESHIP)) {
                        shipInfoEnemy[BATTLESHIP_INDEX][SHIP_HIT_INDEX]--;
                    } else if (j.equals(Screen.CARRIER)) {
                        shipInfoEnemy[CARRIER_INDEX][SHIP_HIT_INDEX]--;
                    }
                }
            }
        }




        // Compare Hit counts to Ship Size to determine if ship is sunk
        for (int i = 0; i < NUM_OF_SHIPS; i++) {
            if (shipInfo[i][SHIP_HIT_INDEX] == shipInfo[i][SHIP_SIZE_INDEX]) {
                shipInfo[i][SHIP_SUNK_INDEX] = IS_SUNK;
            }
            if (shipInfoEnemy[i][SHIP_HIT_INDEX] == shipInfoEnemy[i][SHIP_SIZE_INDEX]) {
                shipInfoEnemy[i][SHIP_SUNK_INDEX] = IS_SUNK;
            }
        }

        if (!valid) {
            success = false;
        } else {
            System.out.println("\nSAVE LOADED");
            success = true;
            Screen.enterPrompt();
        }

        return success;
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
        Scanner sc = Screen.scannerDeclare();

        // Output Screen, Get Path and Write File
        Screen.clearScreen();
        System.out.println("Enter the filename you want to save to (file extension included): ");
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
    * Controls the initialization of a new game, including ship placement.
     */
    public static void newGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots, int[][] shipInfo, int[][] shipInfoEnemy){
        // Declarations


        // Place Player Ships and Enemy Ships
        for(int i = 0; i < NUM_OF_SHIPS; i++){
            Enemy.enemyPlaceShips(enemyBoard, shipInfoEnemy, i);
            Screen.placePrompt(playerBoard, playerShots, shipInfo, i);
        }
    }

    /**
     * Method: turnSequence
     * -----
     * Parameters:
     * String[][] playerBoard - the player's board to manipulate.
     * String[][] enemyBoard - the enemy's board to manipulate.
     * String[][] playerShots - the player's shots to manipulate.
     * String[][] enemyShots - the enemy's shots to manipulate.
     * int[][] shipInfoPlayer - the ship information to manipulate for player.
     * int[][] shipInfoEnemy - the enemy's ship information to manipulate.
     * boolean easyMode - whether the game is in easy mode.
     * -----
     * Returns:
     * boolean - true if the game is over, false if not.
     * -----
     * Description:
     * Controls the flow of one turn, including player and enemy turn. Is called by main() in a while loop.
     */
    public static boolean turnSequence(String[][] playerBoard, String[][] enemyBoard, String[][]playerShots, String[][] enemyShots, int[][] shipInfoPlayer, int[][] shipInfoEnemy, boolean easyMode){
        // Declarations
        boolean gameOver = false;
        int hitStatus = 0;

        // Player Turn (Call Screen.playerTurn, give it enemy ship info to manipulate)
        hitStatus = Screen.playerTurn(playerBoard, enemyBoard, playerShots, shipInfoEnemy, shipInfoPlayer, enemyShots);
        if(hitStatus == -1){
            gameOver = true;
            Screen.loseScreen(playerBoard, enemyBoard);
        }
        // Check if Player Won
        else if(checkWinLoss(shipInfoPlayer, shipInfoEnemy) == PLAYER_WIN){
            gameOver = true;
            Screen.winScreen();
        }

        // Enemy Turn (Call Enemy.enemyTurn, give it player ship info to manipulate)
        if(!gameOver){
            Enemy.enemyTurn(playerBoard, enemyShots, shipInfoPlayer, easyMode);
        }

        // Check if enemy won (player lost)
        if(checkWinLoss(shipInfoPlayer, shipInfoEnemy) == PLAYER_LOSE){
            gameOver = true;
            Screen.loseScreen(playerBoard, enemyBoard);
        }

        // Return if game is over
        return gameOver;
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
                    board[shipY+i][shipX] = indexShipAsString(shipIndex, false);
                }
            }
            // Horizontal Place
            else{
                for(int i = 0; i < shipSize; i++){
                    board[shipY][shipX+i] = indexShipAsString(shipIndex, false);
                }
            }
        }

        return valid;
    }

    /**
    * Method: indexShipAsString
    * -----
    * Parameters:
    * int ship - the ship to get the string of.
    *  boolean fullName - whether to return the full name of the ship.
    * -----
    * Returns:
    * String - the String of the ship.
    * -----
    * Because I'm dumb and decided not to use enums for the ships, I have to use this method to get the string of the ship based on an index.
     */
    public static String indexShipAsString(int ship, boolean fullName) {
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
            }
        }
        return index;
    }

    /**
     * Method: hitShip
     * -----
     * Parameters:
     * String[][] shipBoard - the board to hit the ship on.
     * String[][] shotBoard - the board to mark the shot on.
     * int[][] shipInfo - the ship information to manipulate.
     * int x - the x coordinates of the shot (in number format, not alphabetical).
     * int y - the y coordinates of the shot.
     * boolean isPlayer - whether the player is the one shooting, used to determine the message given.
     * -----
     * Returns:
     * int - If the shot was a hit, returns the index of the ship that was hit. If the shot was a miss, returns -1, if the shot was invalid, returns -2.
     * -----
     * Description:
     * Takes in coordinates (0 indexed) and marks the shot on the shot board. If the shot was a hit, the method returns the index of the ship that was hit.
     * Calls checkValidShot to determine if the shot is valid.
     * Also outputs sunk messages.
     */
    public static int hitShip(String[][] shipBoard, String[][] shotBoard, int[][] shipInfo, int x, int y, boolean isPlayer) {

        // Declarations
        final int IS_MISS = -1;
        final int IS_INVALID = -2;
        int hitShipIndex = -2;

        // Check if the shot is valid
        if(checkValidShot(shotBoard, x, y)){

            // Check if the shot is a hit or miss, and change shotBoard, shipInfo, and shipBoard accordingly.
            if(shipBoard[y][x].equals(Screen.EMPTY)){

                shotBoard[y][x] = Screen.MISS;
                shipBoard[y][x] = Screen.MISS;
                hitShipIndex = IS_MISS;

                // If Enemy, output message saying the location of shot and miss. If player, do same
                if(isPlayer){
                    Screen.divider();
                    System.out.printf("You missed at %s, %d\n", LETTERS[x], y +1);
                    Screen.enterPrompt();
                }
                else{
                    Screen.gameBoard(shipBoard, shotBoard, true);
                    System.out.printf("Enemy missed at %s, %d\n", LETTERS[x], y +1);
                    Screen.enterPrompt();
                }
            }
            else{
                hitShipIndex = indexShipInteger(shipBoard[y][x]);
                shipInfo[hitShipIndex][SHIP_HIT_INDEX]++;

                shotBoard[y][x] = Screen.HIT;
                shipBoard[y][x] = Screen.HIT;

                // Give hit messages (player can see which ship was hit on their board, but player cannot see which ship was hit on enemy's board)
                if (isPlayer) {
                    System.out.println("You hit one of your enemy's ships!");
                }
                else {
                    Screen.gameBoard(shipBoard, shotBoard, true);
                    System.out.printf("The enemy hit your %s at %s, %d!\n", indexShipAsString(hitShipIndex, true), LETTERS[x], y + 1);
                    Screen.scannerDeclare();
                }

                // Check if Sunk now
                if (shipInfo[hitShipIndex][SHIP_HIT_INDEX] == shipInfo[hitShipIndex][SHIP_SIZE_INDEX]) {

                    shipInfo[hitShipIndex][SHIP_SUNK_INDEX] = IS_SUNK;
                    // Sink messages
                    if (isPlayer) {
                        Screen.divider();
                        System.out.println("You sunk the enemy's " + indexShipAsString(hitShipIndex, true) + "!");
                    } else {
                        Screen.divider();
                        System.out.println("The enemy sunk your " + indexShipAsString(hitShipIndex, true) + "!");
                        Screen.scannerDeclare();
                    }
                }

                Screen.enterPrompt();
            }
        }
        else{
            hitShipIndex = IS_INVALID;
        }

        return hitShipIndex;
    }

    /**
     * Method: checkValidShot
     * -----
     * Parameters:
     * String[][] shotBoard - the board to check if the shot is valid on.
     * int x - the x coordinates of the shot (in number format, not alphabetical).
     * int y - the y coordinates of the shot.
     * -----
     * Returns:
     * boolean - true if the shot is valid, false if not.
     * -----
     * Description:
     * Takes in coordinates (0 indexed) and checks if the shot is valid. If the shot is valid, the method returns true.
     * This method is called during the hitShip method.
     */
    public static boolean checkValidShot(String[][] shotBoard, int x, int y) {

        // Declarations
        boolean isValid = false;

        // Check if shot is valid
        try{
            if (!shotBoard[y][x].equals(Screen.HIT) && !shotBoard[y][x].equals(Screen.MISS)){
                isValid = true;
            }
        }
        // Check if the shot is even on the board!
        catch (ArrayIndexOutOfBoundsException e) {
            isValid = false;
        }

        return isValid;
    }

    /**
     * Method: indexShipInteger
     * -----
     * Parameters:
     * String ship - the ship to get the index of.
     * -----
     * Returns:
     * int - the index of the ship.
     * -----
     * Description:
     * Takes in a string of the ship, and returns the index of the ship in the shipInfo array.
     */
    public static int indexShipInteger(String ship) {
        int index = -1;
        if (ship.equals(Screen.DESTROYER)) {
            index = DESTROYER_INDEX;
        } else if (ship.equals(Screen.CRUISER)) {
            index = CRUISER_INDEX;
        } else if (ship.equals(Screen.SUBMARINE)) {
            index = SUBMARINE_INDEX;
        } else if (ship.equals(Screen.BATTLESHIP)) {
            index = BATTLESHIP_INDEX;
        } else if (ship.equals(Screen.CARRIER)) {
            index = CARRIER_INDEX;
        }
        return index;
    }

    /**
     * Method: checkWinLoss
     * -----
     * Parameters:
     * int[][] shipInfoPlayer - the ship information to check if the game is over, and if player has won.
     * int[][] shipInfoEnemy - the enemy's ship information to check if the game is over, and if the enemy has won.
     * -----
     * Returns:
     * int - 0 if player has won, 1 if player has lost, -1 if game is not over.
     * -----
     * Description:
     * Checks to see if either the player or the enemy has won, by comparing the other player's number of ships sunk to the total number of ships.
     */
    public static int checkWinLoss(int[][] shipInfoPlayer, int[][] shipInfoEnemy){
        // Declarations
        int winLoss = -1;
        int playerLost = 0;
        int enemyLost = 0;

        // Count Enemy Sunk Ships
        for(int[] i : shipInfoEnemy){
            if(i[SHIP_SUNK_INDEX] == IS_SUNK){
                enemyLost++;
            }
        }

        // Count Player Sunk Ships
        for(int[] i : shipInfoPlayer){
            if(i[SHIP_SUNK_INDEX] == IS_SUNK){
                playerLost++;
            }
        }

        // Check if anyone won
        if(playerLost >= NUM_OF_SHIPS){
            winLoss = PLAYER_LOSE;
        }
        else if(enemyLost >= NUM_OF_SHIPS){
            winLoss = PLAYER_WIN;
        }
        else{
            winLoss = -1;
        }

        // Return Win/Loss
        return winLoss;

    }
}
