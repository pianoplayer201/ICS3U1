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
}
