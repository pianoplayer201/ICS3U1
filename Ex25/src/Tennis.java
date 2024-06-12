import java.util.Scanner;

/*
Program: Tennis
Programmer: Ryan Mehrian
Date: June 6, 2024
----
This program will ask the user to input scores for two tennis players, for 5 sets of games.
The program will then calculate and output the number of sets won by each player, as well as the
ultimate match winner.
 */
public class Tennis {
    public static void main(String[] args) {
        // Declarations
        final int SETS = 5;
        final int P1_INDEX = 0;
        final int P2_INDEX = 1;
        final int SET_WIN_SCORE = 6;
        final int MATCH_WIN_SCORE = 3;
        int player1Wins = 0;
        int player2Wins = 0;
        int[][] scores = new int[2][SETS];

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Please enter Player 1's scores for each set:");
        for(int i = 0; i < SETS; i++){
            System.out.printf(" > Set %d: ", i + 1);
            scores[P1_INDEX][i] = sc.nextInt();
        }
        System.out.println("Please enter Player 2's scores for each set:");
        for(int i = 0; i < SETS; i++){
            System.out.printf(" > Set %d: ", i + 1);
            scores[P2_INDEX][i] = sc.nextInt();
        }

        // Calculate Wins
        for(int i = 0; i < SETS; i++){
            if(scores[P1_INDEX][i] == 6){
                player1Wins++;
            }
            else{
                player2Wins++;
            }
        }

        // Output Winner and # of Wins
        if(player1Wins >= MATCH_WIN_SCORE){
            System.out.println("Player 1 wins the match!");
        }
        else{
            System.out.println("Player 2 wins the match!");
        }
        System.out.printf("Player 1 won %d sets.\n", player1Wins);
        System.out.printf("Player 2 won %d sets.\n", player2Wins);

    }
}
