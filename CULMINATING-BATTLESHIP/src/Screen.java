import java.util.InputMismatchException;
import java.util.Scanner;

/*
Program: Screen
Programmer: Ryan Mehrian
Date Created: May 28, 2024
------
Description:
A class that contains everything related to Menus, UI and user interaction.
 */
public class Screen {
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
    int - the choice of the user on the main menu.
    -----
    Description:
    Displays the main menu and gets the choice of the user, to load a game, start a new game, read the instructions or exit the game.
     */
    public static int mainMenu(){
        //Declarations
        int choice = 0;
        Scanner input = new Scanner(System.in);

        //Display the menu
        System.out.println("Welcome to Battleship!");
        System.out.print("Press enter to continue...");
        input.nextLine();
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
}
