/**
* Class: Enemy
* Programmer: Ryan Mehrian
* Date Created: May 28, 2024
* -----
* Description:
* A class that contains all Enemy AI Logic
 */
import java.util.*;
public class Enemy {
    /**
     * Method: enemyPlaceShips
     * -----
     * Parameters:
     * String[][] enemyBoard - the board to place the ships on.
     * int shipInfo[][] - a 2D array that contains all ship information.
     * int shipIndex - the index of the ship to place (determined in Battleship.newGame()).
     * -----
     * Description:
     * The logic for the enemy to place its ships. The enemy interacts with Battleship.placeShip() to place its ships,
     * in a similar manner to the player. The enemy places its ships randomly. This method is called by Battleship.newGame().
     * in a loop, which decides which ship the AI will try to place next. This method is called once for each ship.
     */
    public static void enemyPlaceShips(String[][] enemyBoard, int shipInfo[][], int shipIndex) {
        // Declarations
        int x = 0;
        int y = 0;
        int direction = 0;
        boolean valid = false;

        Random randomizer = new Random();

        // Try to place the ship
        while (!valid) {
            // Generate random coordinates
            x = randomizer.nextInt(Battleship.GRID_SIZE);
            y = randomizer.nextInt(Battleship.GRID_SIZE);
            direction = randomizer.nextInt(2);

            // Check if the ship can be placed
            valid = Battleship.placeShip(enemyBoard, shipInfo, shipIndex, x, y, direction);
        }
    }

    /**
    * Method: enemyTurn
    * -----
    * Parameters:
    * String[][] playerBoard - the player's board.
    * String[][] enemyShots - the enemy's shots.
    * String[][] shipInfo - a 2D array that contains all ship information.
    * boolean easyMode - a boolean that determines if the enemy is in easy mode.
    * -----
     * Returns:
     * boolean - returns true if the enemy hit a ship, false if the enemy missed.
     * -----
    * Description:
    * The logic for the enemy to take its turn. The enemy interacts with Battleship.hitShip() and Battleship.checkValidShot() to take its turn.
    * When easy mode is enabled, the enemy will take random shots. When easy mode is disabled, the enemy will take
    * shots in a more strategic manner. This method is called once per turn.
     */
    public static boolean enemyTurn(String[][] playerBoard, String[][] enemyShots, int[][] shipInfo, boolean easyMode) {
        // Declarations
        int x = 0;
        int y = 0;
        boolean valid = false;
        boolean hit = false;

        Random randomizer = new Random();

        // Try to take a shot (EASY MODE)
        if(easyMode){

            // Determine COORDS (literally random lol)
            do{
                x = randomizer.nextInt(Battleship.GRID_SIZE);
                y = randomizer.nextInt(Battleship.GRID_SIZE);
                valid = Battleship.checkValidShot(enemyShots, x, y);
            } while(!valid);

            // GO hit!
            Battleship.hitShip(playerBoard, enemyShots, shipInfo, x, y, false);
        }
        else{
            // NORMAL MODE NOT YET IMPLEMENTED
            while(true){
                System.out.println("NORMAL MODE NOT YET IMPLEMENTED!");
                // normalAILogic();
            }
        }

        // Check if hit
        if(playerBoard[x][y].equals(Screen.HIT)){
            hit = true;
        }

        return hit;
    }
}
