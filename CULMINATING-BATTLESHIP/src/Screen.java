import java.util.*;
/*
Program: Screen
Programmer: Ryan Mehrian
Date Created: May 28, 2024
------
Description:
A class that contains everything related to Menus, UI and user interaction.
 */
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

    /*
    Method: clearScreen
    -----
    Description:
    Clears the screen, used to make new frames.
     */
    public static void clearScreen(){
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception e)
        {
            System.out.println("\n\n\n\n\n");
        }

    }

    /*
    Method: mainMenu
    -----
    Returns:
    String - the choice of the user on the main menu.
    -----
    Description:
    Displays the main menu and gets the choice of the user, to load a game, start a new game, read the instructions or exit the game.
     */
    public static int mainMenu(){
        //Declarations
        int choice = 0;
        Scanner input = new Scanner(System.in);

        //Display the menu
        clearScreen();
        System.out.println("MAIN MENU");
        System.out.println("[1]. New Game");
        System.out.println("[2]. Load Game");
        System.out.println("[3]. Instructions");
        System.out.println("[4]. Exit");
        System.out.print(" > ");

        //Get the choice
        try{
            choice = input.nextInt();
            if (choice < 1 || choice > 4){
                System.out.println("Invalid choice. Please enter to try again.");
                choice = mainMenu();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice. Please enter to try again.");
            choice = mainMenu();
        }

        //Return the choice
        return choice;
    }

    /*
    Method: gameBoard
    ----
    Parameters:
    String[][] playerBoard - the player's board to display.
    String[][] playerShots - the player's shots on the enemy.
    String[][] enemyShots - the enemy's shots on the player (to display hit ships)
    -----
    Description:
    Outputs a screen which shows the player their board with ships placed, their shots on the enemy and the enemy's shots on the player.
     */
    public static void gameBoard(String[][] playerBoard, String[][] playerShots, String[][] enemyShots){

        // Declarations
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        System.out.printf("%-15S%s%-15S", "Player Board", SPACING, "Player Shots");
        for(int i = 0; i <= playerBoard.length; i++){
            System.out.printf("%-15S%s%-15S%n", Arrays.toString(playerBoard[i]) + SPACING + Arrays.toString(playerShots[i]));
        }
    }

    /*
    Method: instructions
    -----
    Description:
    Displays the instructions of the game, called from the main menu.
     */
    public static void instructions(){

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
        System.out.println("Good luck!\n \n Press Enter to Continue...");
        sc.nextLine();
    }
}
