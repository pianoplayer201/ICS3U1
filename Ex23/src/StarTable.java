import java.util.Scanner;

/*
Program: StarTable
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
This program will create a table of '*' characters, based upon user defined dimensions.
 */
public class StarTable {
    public static void main(String[]args){
        //Declarations
        int columns, rows;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter desired number of rows: ");
        rows = sc.nextInt();
        System.out.print("Please enter desired number of columns: ");
        columns = sc.nextInt();

        //Create array based upon inputs.
        String[][] table = new String[rows][columns];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = "*";
            }
        }

        //Output
        for(int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }

    }
}
