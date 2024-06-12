/**
* Class: Screen
* Programmer: Ryan Mehrian
* Date Created: May 28, 2024
* ------
* Description:
* A class that contains everything related to Menus, UI and user interaction.
 */

import java.util.*;

public class Screen {

    // BOARD INDICATOR CONSTANTS
    final public static String HIT = "X";
    final public static String MISS = "O";
    final public static String EMPTY = "-";
    final public static String DESTROYER = "D";
    final public static String CRUISER = "C";
    final public static String SUBMARINE = "S";
    final public static String BATTLESHIP = "B";
    final public static String CARRIER = "A";

    //SPACING BETWEEN BOARDS
    final public static String SPACING = "     ";

    /**
     * Method: clearScreen
     * -----
     * Description:
     * Clears the screen, used to make new frames.
     */
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(16));
        }

    }

    /**
     * Method: mainMenu
     * -----
     * Returns:
     * String - the choice of the user on the main menu.
     * -----
     * Description:
     * Displays the main menu and gets the choice of the user, to load a game, start a new game, read the instructions or exit the game.
     */
    public static int mainMenu() {
        //Declarations
        int choice = 0;
        Scanner input = new Scanner(System.in);

        //Display the menu
        clearScreen();
        System.out.println("MAIN MENU");
        System.out.println("[1]. New Game");
        System.out.println("[2]. Load Game");
        System.out.println("[3]. Instructions");
        System.out.println("[4]. Change Difficulty");
        System.out.println("[5]. Exit");
        System.out.print(" > ");

        //Get the choice
        try {
            choice = input.nextInt();
            if (choice < 1 || choice > 5) {
                divider();
                System.out.println("Invalid choice. Please enter to try again.");
                choice = mainMenu();
            }
        } catch (InputMismatchException e) {
            divider();
            System.out.println("Invalid choice. Please enter to try again.");
            choice = mainMenu();
        }

        //Return the choice
        return choice;
    }

    /**
     * Method: gameBoard
     * ----
     * Parameters:
     * String[][] playerBoard - the player's board to display.
     * String[][] playerShots - the player's shots on the enemy.
     * -----
     * Description:
     * Outputs a screen which shows the player their board with ships placed, their shots on the enemy and the enemy's shots on the player.
     */
    public static void gameBoard(String[][] playerBoard, String[][] playerShots) {

        // Declarations


        // Clear Screen
        clearScreen();

        // Output
        divider();
        System.out.printf("%23S%s%23S\n", "Player Board", SPACING, "Player Shots");
        System.out.printf("%23s%s%23s\n", Arrays.toString(Battleship.LETTERS).replace(",", ""), SPACING, Arrays.toString(Battleship.LETTERS).replace(",", ""));
        for (int i = 0; i < playerBoard.length; i++) {
            System.out.printf("%2d%21S%s%2d%21S\n", i + 1, Arrays.toString(playerBoard[i]).replace(",", ""), SPACING, i + 1, Arrays.toString(playerShots[i]).replace(",", ""));
        }
        divider();
    }


    /**
     * Method: instructions
     * -----
     * Description:
     * Displays the instructions of the game, called from the main menu.
     */
    public static void instructions() {

        // Declaration
        Scanner sc = new Scanner(System.in);
        // Output
        clearScreen();
        System.out.println("INSTRUCTIONS");
        System.out.println("Battleship is a game where you place your ships on a 10x10 grid and try to sink the enemy's ships.");
        System.out.println("The ships in the game are as follows:");
        System.out.println("Carrier (A) - 5 spaces");
        System.out.println("Battleship (B) - 4 spaces");
        System.out.println("Submarine (S) - 3 spaces");
        System.out.println("Cruiser (C) - 3 spaces");
        System.out.println("Destroyer (D) - 2 spaces");
        System.out.println("You and the enemy will take turns firing shots at each other's boards.");
        System.out.println("If you hit a ship, it will be marked with an X. If you miss, it will be marked with an O.");
        System.out.println("Empty spaces are marked with a -. These have nothing on them, and have never been hit.");
        System.out.println("The game ends when all of one player's ships are sunk.");
        System.out.println("NOTE: Placing ships on the board always places them starting from the top left corner of the ship (ship goes to the right if horizontal, and down if vertical)");
        System.out.println("Good luck!");
        enterPrompt();
        sc.nextLine();
    }

    /**
     * method: difficultyMenu
     * -----
     * Parameters:
     * boolean currentDifficulty - the current difficulty of the game.
     * ------
     * Returns:
     * boolean - the new difficulty of the game.
     * -----
     * Description:
     * Displays the difficulty menu, which asks the player if they want to change their difficulty or not.
     */
    public static boolean difficultyMenu(boolean currentDifficulty) {
        //  Declarations
        boolean easyMode = currentDifficulty;
        int choice = 0;
        Scanner input = new Scanner(System.in);

        //Display the menu
        clearScreen();
        System.out.println("DIFFICULTY MENU");

        if (easyMode) {
            System.out.println("Current Mode: Easy");
            System.out.println("[1]. Change to Hard");
            System.out.println("[2]. Keep Easy Mode");
        } else {
            System.out.println("Current Mode: Hard");
            System.out.println("[1]. Change to Easy");
            System.out.println("[2]. Keep Hard Mode");
        }
        System.out.print(" > ");

        //Get the choice
        try {
            choice = input.nextInt();
            input.nextLine();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid Option, No Changes made!");
            } else if (choice == 1) {
                easyMode = !easyMode;
                System.out.println("Difficulty Changed!");
            } else {
                System.out.println("No Changes made!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Option, No Changes made!");
        }

        enterPrompt();

        //Return the choice
        return easyMode;
    }

    /**
     * Method: placePrompt
     * -----
     * Parameters:
     * String[][] playerBoard - the player's board to display.
     * String[][] playerShots - the player's shots on the enemy, used to allow the calling of gameBoard().
     * int[][] shipInfo - the information of the ship to place.
     * int shipIndex - the index of the ship in the shipInfo array (Destroyer, Battleship, ETC.)
     * -----
     * Description:
     * A prompt called by Battleship.newGame() to ask the player where they want to place a given ship. The index
     * is used to determine which ship is being placed, which is determined when called (in a loop). The method
     * calls Battleship.placeShip() to attempt to place the ship on the board. If placeShip() returns false, this method
     * will loop, prompting the player again for an alphanumeric x value, a y value, and a direction.
     */
    public static void placePrompt(String[][] playerBoard, String[][] playerShots, int[][] shipInfo, int shipIndex) {
        // Declarations
        Scanner sc = new Scanner(System.in);
        String input = "";
        int x = 0;
        int y = 0;
        int direction = 0;
        boolean placed = false;

        // Loop until placed
        while (!placed) {
            // Output Board
            enterPrompt();
            gameBoard(playerBoard, playerShots);

            // Input Process
            System.out.println("Place your " + Battleship.indexShipLetter(shipIndex, true) + " (" + shipInfo[shipIndex][Battleship.SHIP_SIZE_INDEX] + " spaces)");
            divider();

            // Get the x coordinate with validation.
            System.out.print("Enter the x coordinate (A-J): ");
            input = sc.nextLine().toUpperCase();

            // Map x to an integer based on constant array LETTERS
            x = Battleship.mapLetterCoordsToIndex(input);
            if (x == -1) {
                divider();
                System.out.println("Invalid x coordinate. Please try again.");
                continue;
            }

            // Get the y coordinate with validation.
            System.out.print("Enter the y coordinate (1-10): ");
            try {
                y = sc.nextInt() - 1;
                sc.nextLine();
                if (y < 0 || y > 9) {
                    divider();
                    System.out.println("Invalid y coordinate. Please try again.");
                    continue;
                }

            } catch (InputMismatchException e) {
                divider();
                System.out.println("Invalid y coordinate. Please try again.");
                continue;
            }

            // Get the direction with validation.
            System.out.print("Enter the direction (H for horizontal, V for vertical): ");
            input = sc.nextLine().toUpperCase();
            if (input.equals("H")) {
                direction = Battleship.HORIZONTAL_DIRECTION;
            } else if (input.equals("V")) {
                direction = Battleship.VERTICAL_DIRECTION;
            } else {
                divider();
                System.out.println("Invalid direction. Please try again.");
                continue;
            }

            // Place the ship
            placed = Battleship.placeShip(playerBoard, shipInfo, shipIndex, x, y, direction);
            if (placed!=true) {
                divider();
                System.out.println("Invalid placement, ship does not fit. Please try again.");
            }
            else{
                divider();
                System.out.println("Ship placed successfully!");
            }

        }

    }

    /*
    * Method: enterPrompt
    * -----
    * Description:
    * A simple prompt that asks the user to continue. Used to pause the game and wait for the user to press enter, and to assess the situation.
     */
    public static void enterPrompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        divider();
        System.out.println("Press Enter to Continue...");
        sc.nextLine();
    }

    /*
    * Method: divider
    * -----
    * Description:
    * A simple divider that separates the game board from the console, and other elements for cleanliness.
     */
    public static void divider() {
        System.out.println("----------------------------------------------------");
    }
}