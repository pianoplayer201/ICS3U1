import java.util.Scanner;

/*
Program: Factors
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
Outputs all the factors of an inputted integer.
 */
public class Factors {
    public static void main(String[]args){
        // Declarations
        int multiple;
        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Please enter an integer: ");
        multiple=sc.nextInt();

        // Loop and Output
        System.out.printf("The Following are Factors of %d\n", multiple);
        for(int i = 1; i <= multiple; i++){
            if(multiple % i == 0){
                System.out.println(i);
            }
        }
    }
}
