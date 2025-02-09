/**
* Class: Enemy
* Programmer: Ryan Mehrian
* Date Created: May 28, 2024
* -----
* Description:
* A class that contains all Enemy AI Logic
 */
import java.util.*;
import java.awt.Point;
public class Enemy {

    // Constants (Directions)
    public static final int UP_DIR = 0;
    public static final int DOWN_DIR = 1;
    public static final int LEFT_DIR = 2;
    public static final int RIGHT_DIR = 3;
    public static final int NO_DIR = -1;

    // Mr.Skuja, ideally these values would have been in an enemy object, but I didn't want to
    // implement object-oriented programming 2 days before the project is due.

    // Protected Variables to keep track of the AI's state across turns, which would be reset otherwise if they were local variables in enemyTurn().
    static protected ArrayList<Point > futureShots = new ArrayList<Point>(); // Arraylist to store future shots for NORMAL AI
    static protected int direction = NO_DIR; // Direction of the last hit for NORMAL AI. Starts with NO_DIR if random shot was taken.
    static protected Point shipDetectHit = new Point(-1, -1); // Point to store the first hit an AI makes on a ship, to then have the AI go in each direction based on that point.


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
    public static void enemyPlaceShips(String[][] enemyBoard, int[][] shipInfo, int shipIndex) {
        // Declarations
        int x = 0;
        int y = 0;
        int placeDirection = NO_DIR;
        boolean valid = false;
        Random randomizer = new Random();

        // Try to place the ship
        while (!valid) {
            // Generate random coordinates
            x = randomizer.nextInt(Battleship.GRID_SIZE);
            y = randomizer.nextInt(Battleship.GRID_SIZE);
            placeDirection = randomizer.nextInt(2);

            // Check if the ship can be placed
            valid = Battleship.placeShip(enemyBoard, shipInfo, shipIndex, x, y, placeDirection);
        }
    }

    /**
    * Method: enemyTurn
    * -----
    * Parameters:
    * String[][] playerBoard - the player's board.
    * String[][] enemyShots - the enemy's shots.
    * String[][] shipInfo - a 2D array that contains all ship information for the player, to manipulate when enemy hits.
    * boolean easyMode - a boolean that determines if the enemy is in easy mode.
    * -----
    * Returns:
    * boolean - returns true if the enemy hit a ship, false if the enemy missed. Isn't necessary, but could be useful for future implementations.
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

        // Declarations for Normal AI
        boolean sunk = false; // Boolean to determine if a ship was sunk, used to reset shotlist for NORMAL AI.
        int[][] shipInfoBeforeHit = new int[shipInfo.length][shipInfo[0].length]; // A Clone of the shipInfo array before the hit, to then compare later to see if a ship was sunk.

        // Clone the shipInfo array using for loops and System.arraycopy
        for(int i = 0; i < shipInfo.length; i++){
            System.arraycopy(shipInfo[i], 0, shipInfoBeforeHit[i], 0, shipInfo[0].length);
        }

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
        // Take a shot (NORMAL MODE)
        else{

            // If the AI has no logic for next shots, generate a random shot
            if(futureShots.isEmpty() || direction == NO_DIR){
                do{
                    x = randomizer.nextInt(Battleship.GRID_SIZE);
                    y = randomizer.nextInt(Battleship.GRID_SIZE);
                    valid = Battleship.checkValidShot(enemyShots, x, y);
                } while(!valid);
            }
            else{
                // Take a shot from the future shots
                Point shot = futureShots.getFirst();
                x = shot.x;
                y = shot.y;
                futureShots.removeFirst();
            }

            // GO hit
            Battleship.hitShip(playerBoard, enemyShots, shipInfo, x, y, false);
        }

        // Check if hit
        if(playerBoard[y][x].equals(Screen.HIT)){
            hit = true;
        }

        // Recalculate AI Logic (only if easy mode is disabled)
        if(!easyMode){
            // Compare the count of the two shipInfo arrays to determine if a ship was sunk
            for(int i = 0; i < shipInfo.length; i++){
                if(shipInfo[i][Battleship.SHIP_SUNK_INDEX] != shipInfoBeforeHit[i][Battleship.SHIP_SUNK_INDEX]){
                    sunk = true;
                }
            }

            // Call the normalAILogic method to determine the next shot, while also updating the direction variable.
            direction = normalAILogic(enemyShots, futureShots, x, y, direction, hit, sunk);
        }

        return hit;
    }

    /**
     * Method: normalAILogic
     * -----
     * Parameters:
     * String[][] enemyShots - the enemy's shots, used to check if the next shot is valid.
     * ArrayList(Point) futureShots - an arraylist that contains all future shots for the enemy to take.
     * int x - the x coordinate of the last hit, to then decide future hits if needed.
     * int y - the y coordinate of the last hit, to then decide future hits if needed.
     * int direction - the direction of the last hit, to then decide which direction to check next.
     * boolean hit - a boolean that determines if the last shot was a hit.
     * boolean sunk - a boolean that determines if the last shot sunk a ship.
     * -----
     * Returns:
     * int - the direction that the AI is going to hit next.
     * ----
     * Description:
     * The logic for the enemy creating a list of where to shoot in normal mode. The enemy will take shots in a more strategic manner.
     * The ai will take shots in a random manner until it detects a hit on a ship.
     * Then, the enemy will shoot to the up, down, right and left of the last hit until it hits a ship.
     * It will then go in the direction of the hit until it misses, and then go in the opposite direction until it misses,
     * and then up until it misses, and then down until it misses. It will break out of the loop when the detected ship is sunk.
     * THIS SEQUENCE OF SHOTS IS STORED IN THE futureShots ARRAYLIST, and is used in the enemyTurn() method.
     * This method also checks if the direction the AI wants to shoot is valid, and if not, it will change the direction.
     */
    public static int normalAILogic(String[][] enemyShots, ArrayList<Point> futureShots, int x, int y, int direction, boolean hit, boolean sunk){
        // Declarations
        final Point UP_POINT = new Point(0, -1);
        final Point DOWN_POINT = new Point(0, 1);
        final Point LEFT_POINT = new Point(-1, 0);
        final Point RIGHT_POINT = new Point(1, 0);
        Point shot = new Point(x, y);

        // Check to see if this is the first time the AI has hit this ship, and if so, set the direction to UP and record where the first shot was.
        if((futureShots.isEmpty() && hit && !sunk && direction == NO_DIR)){
            direction = UP_DIR;
            shipDetectHit = new Point(x, y);
            shot = new Point(shipDetectHit.x, shipDetectHit.y);
        }

        // If a ship is sunk, reset the AI to random.
        if(sunk){
            futureShots.clear();
            futureShots.trimToSize();
            direction = NO_DIR;
        }

        // MR.SKUJA NOTE: I'm aware that this is not a good if block. I would've used else-ifs, but I needed to ensure
        // that the AI would still execute the code in a situation where the shot isn't valid and the AI must change direction.
        // I could've just copy pasted the code a lot of times but that would've resulted in a lot of repeated code and ultimately
        // resulted in more checks than the current implementation.


        // Direction Logic: If the AI is going up, check if the last shot was a hit or miss. If hit, check if enemy can continue going up and do so.
        // If the AI can't go up anymore, change the direction to down. The ai continues this logic for all directions in the order Up, Down, Left, Right
        // The values of hit and shot are updated during a change of direction to ensure the AI checks from the first hit point.
        else if(direction != NO_DIR){
            if(direction == UP_DIR){
                if(hit && Battleship.checkValidShot(enemyShots, shot.x, shot.y + UP_POINT.y)){;
                    shot.translate(UP_POINT.x, UP_POINT.y);
                    futureShots.add(new Point(shot.x, shot.y));
                    direction = UP_DIR;
                }
                else{
                    direction = DOWN_DIR;
                    shot = new Point(shipDetectHit.x, shipDetectHit.y);
                    hit = true;
                }
            }
            if(direction == DOWN_DIR) {
                if (hit && Battleship.checkValidShot(enemyShots, shot.x, shot.y + DOWN_POINT.y)) {
                    shot.translate(DOWN_POINT.x, DOWN_POINT.y);
                    futureShots.add(new Point(shot.x, shot.y));
                    direction = DOWN_DIR;
                } else {
                    direction = LEFT_DIR;
                    shot = new Point(shipDetectHit.x, shipDetectHit.y);
                    hit = true;
                }
            }
            if(direction == LEFT_DIR){
                if(hit && Battleship.checkValidShot(enemyShots, shot.x + LEFT_POINT.x, shot.y)){
                    shot.translate(LEFT_POINT.x, LEFT_POINT.y);
                    futureShots.add(new Point(shot.x, shot.y));
                    direction = LEFT_DIR;
                }
                else{
                    direction = RIGHT_DIR;
                    shot = new Point(shipDetectHit.x, shipDetectHit.y);
                    hit = true;
                }
            }
            if(direction == RIGHT_DIR){
                if(hit && Battleship.checkValidShot(enemyShots, shot.x + RIGHT_POINT.x, shot.y)){
                    shot.translate(RIGHT_POINT.x, RIGHT_POINT.y);
                    futureShots.add(new Point(shot.x, shot.y));
                    direction = RIGHT_DIR;
                }
                else{
                    direction = NO_DIR;
                }
            }
        }


        // Return the resulting direction
        return direction;
    }
}
