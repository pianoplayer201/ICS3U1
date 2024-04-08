import java.util.Scanner;
/*
Program: TimeConversion
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
Program will ask the user for number of dollars spent over their last month
in various categories, and will generate the percent value of their budget which
they are spending in each category.
 */
public class Spending {
    public static void main(String[]args){
        // Variable
        Scanner sc = new Scanner(System.in);
        double food;
        double clothing;
        double entertainment;
        double rent;
        double totalBudget;

        // Input
        System.out.println("Enter the amount spent last month in the following categories:");
        System.out.print("Food: $");
        food = sc.nextDouble();
        System.out.print("Clothing: $");
        clothing = sc.nextDouble();
        System.out.print("Entertainment: $");
        entertainment = sc.nextDouble();
        System.out.print("Rent: $");
        rent = sc.nextDouble();
        totalBudget = food + clothing + entertainment + rent;
        totalBudget = totalBudget/100;

        //Output
        System.out.printf("\n%-15s %s\n", "Category", "Budget");
        System.out.printf("%-15s %.2f%%\n", "Food", food/totalBudget);
        System.out.printf("%-15s %.2f%%\n", "Clothing", clothing/totalBudget);
        System.out.printf("%-15s %.2f%%\n", "Entertainment", entertainment/totalBudget);
        System.out.printf("%-15s %.2f%%\n", "Rent", rent/totalBudget);



    }
}
