/*
Program: TimesTable
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
This program will output a 12 by 12 times table.
 */
public class TimesTable {
    public static void main(String[] args) {
        //Declarataions
        final int columns = 12, rows = 12;
        int[][] table = new int[rows + 1][columns + 1];

        //Assignment and Output
        for(int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                if (i == 0 && j == 0){
                    table[i][j] = 0;
                }
                else if (i == 0){
                    table[i][j] = j;
                }
                else if (j == 0){
                    table[i][j] = i;
                }
                else
                    table[i][j] = i * j;
            }

            //Output
            System.out.printf("%-4d".repeat(rows+1) + "%n", table[i][0], table[i][1], table[i][2], table[i][3], table[i][4]
            , table[i][5], table[i][6], table[i][7], table[i][8], table[i][9],table[i][10], table[i][11], table[i][12]);
        }
    }
}
