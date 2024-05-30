import java.io.*;

/*
Program: TimeTable
Programmer: Ryan Mehrian
Date: May 5, 2024
------
This program outputs a 12x12 times table to the file timetable.txt
 */
public class TimeTable {
    public static void main(String[]args) {
        //Declarations
        final String FILEPATH = "timetable.txt";
        final int WIDTH = 12;
        final int HEIGHT = 12;
        BufferedWriter write;
        StringBuilder output = new StringBuilder();

        //Create Times Table String
        try {
            write = new BufferedWriter(new FileWriter(FILEPATH));
            for (int i = 0; i <= HEIGHT; i++) {
                output.append("\n");
                for (int j = 0; j <= WIDTH; j++) {
                    if(i == 0){
                        output.append(String.format("%-4d", j * 1));
                    }
                    else if(j == 0){
                        output.append(String.format("%-4d", i * 1));
                    }
                    else{
                        output.append(String.format("%-4d", i * j));
                    }
                }
            }
            write.write(output.toString());
            write.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
