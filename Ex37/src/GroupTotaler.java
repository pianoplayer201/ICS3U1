import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Program: GroupTotaler
Programmer: Ryan Mehrian
Date: May 10, 2024
-----
This program reads a file that contains groups of numbers, and outputs the sum of the groups.
 */
public class GroupTotaler {
    public static void main(String[]args){
        //Declarations
        final String filepath = "input.txt";
        int sum = 0;
        boolean firstInput = true;
        String input = "";
        BufferedReader fileIn = null;

        //Initalized Input
        try{
            fileIn = new BufferedReader(new FileReader(filepath));
        }
        catch(IOException e){
            System.out.println(e + " CANNOT READ");
        }

        //Processes & Output
        while(input!=null){
            try{
                //Accepting Input
                input = fileIn.readLine();

                //Adding to Sum
                if (input!= null){
                    sum += Integer.parseInt(input);
                }
            }
            //Header detected not Integer
            catch(NumberFormatException e){
                //Only output sum if there were preceding number inputs.
                if(!firstInput){
                    System.out.printf("Sum = %d\n\n", sum);
                }
                else{
                    firstInput = false;
                }

                System.out.println(input);

            }
            catch(IOException e){
                System.out.println(e + " CANNOT READ FILE");
            }
        }

        //Final Output after last group has been added
        if(!firstInput){
            System.out.printf("Sum = %d\n\n", sum);
        }

    }

}
