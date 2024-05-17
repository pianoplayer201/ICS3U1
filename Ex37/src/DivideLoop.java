import java.util.InputMismatchException;
import java.util.Scanner;
/*
Program: DivideLoop
Programmer: Ryan Mehrian
Date: May 9, 2024
-----
This program continually asks the user for numbers to divide, outputting the results.
The program quits when the user enters 'Q', 'q', or any other input that starts with q.
 */
public class DivideLoop {
    public static void main(String[]args){
        //Declarations
        int numerator, divisor;
        String input = "";
        boolean quit = false;

        Scanner sc = new Scanner(System.in);

        //Main Program Loop
        do{
            try{
                System.out.print("Enter the numerator: ");
                input = sc.nextLine();
                numerator = Integer.parseInt(input);
                System.out.print("Enter the divisor: ");
                input = sc.nextLine();
                divisor = Integer.parseInt(input);

                //Divide and Output
                if(Double.isInfinite(divide(numerator, divisor))){
                    System.out.println("Cannot divide by 0.");
                }
                else{
                    System.out.printf("%d divided by %d is about %.2f\n\n",  numerator, divisor, divide(numerator,divisor));
                }
            }
            catch(NumberFormatException e){
                if(input.charAt(0) == 'Q' || input.charAt(0) == 'q'){
                    System.out.println("Exiting program...");
                    quit = true;
                }
                else{
                    System.out.println("You entered bad data!\nPlease try again.\n");
                }
            }
        }while(!quit);

        sc.close();
    }

    /*
    Method: divide
    -----
    Parameters
    int numerator - The number being divided
    int divisor - The number that divides the numerator
    -----
    Returns
    double quotient - The answer to the division.
    ----
    Divides a user provided numerator and divisor.
     */
    public static double divide(int numerator, int divisor){
        double quotient = (double)numerator/divisor;
        return quotient;
    }
}
