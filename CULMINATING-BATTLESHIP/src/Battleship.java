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
    //CONSTANTS
    final public static int SAVEFILE_LINE_COUNT = 44;
    final public static int GRID_SIZE = 10;

    public static void main(String[]args){

        //Game Variables
        boolean quit = false;
        int menuChoice = 0;
        String[][] playerBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyBoard = new String[GRID_SIZE][GRID_SIZE];
        String[][] playerShots = new String[GRID_SIZE][GRID_SIZE];
        String[][] enemyShots = new String[GRID_SIZE][GRID_SIZE];

        //Other Object Declarations
        Scanner sc = new Scanner(System.in);

        //MAIN LOOP
        while(!quit){
            //MAIN MENU
            menuChoice = Screen.mainMenu();
            if (menuChoice == 1){
                //New Game
                //newGame();
            }else if (menuChoice == 2){
                //Load Game
                //loadGame();
            }else if (menuChoice == 3){
                //Instructions
                //instructions();
            }else if (menuChoice == 4){
                //Exit
                System.out.println("QUITTING");
                quit = true;
            }
        }
    }

    public static String[][] loadGame(String[][] playerBoard, String[][] enemyBoard, String[][] playerShots, String[][] enemyShots){
        //Declarations
        String path = "";
        Screen.clearScreen();

        return playerBoard;
    }
}
