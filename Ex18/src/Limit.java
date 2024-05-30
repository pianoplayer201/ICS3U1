import java.util.Scanner;

/*
Program: Limit
Programmer: Ryan Mehrian
Date: April 15, 2024
-----
Prompts the user for variable n, and then computes the following sum:
1.0/1 + 1.0/2 + 1.0/3 + ... + 1.0/n
 */
public class Limit {
    public static void main(String[]args){
        // Declarations
        double sum = 0;
        int n = 0;
        Scanner sc = new Scanner(System.in);

        // Prompt for n
        System.out.print("Please enter integer n:\nn = ");
        n = sc.nextInt();

        //Calculate Sum
        for(int i = 1; i <= n; i++){
            sum+=1.0/i;
        }

        //Output
        System.out.printf("Sum = %.2f", sum);
    }
}
