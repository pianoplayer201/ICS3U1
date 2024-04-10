import java.util.Scanner;

/*
Program: Delivery
Programmer: Ryan Mehrian
Date: March 18, 2023
----
This program asks the user for the weight and dimensions of a package, and outputs whether the package is eligible
for delivery and the cost for delivery if it is eligible.
 */
public class Delivery {
    public static void main(String[] args) {
        //Variable Declaration
        final int MAX_CM3 = 100000;
        final int WEIGHT_BRACKET1 = 5;
        final int WEIGHT_BRACKET2 = 12;
        final int WEIGHT_BRACKET3 = 20;
        final int WEIGHT_BRACKET4 = 27;
        final double PRICE_BRACKET1 = 3.00;
        final double PRICE_BRACKET2 = 3.50;
        final double PRICE_BRACKET3 = 4.00;
        final double PRICE_BRACKET4 = 4.50;
        double weight, length, width, height, price = 0;

        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Please enter package weight (kg): ");
        weight = sc.nextDouble();
        System.out.print("Please enter package width (cm): ");
        width = sc.nextDouble();
        System.out.print("Please enter package height (cm): ");
        height = sc.nextDouble();
        System.out.print("Please enter package length (cm): ");
        length = sc.nextDouble();

        //Checks and Outputs
        if(weight > WEIGHT_BRACKET4){
            System.out.println("Too Heavy");
        }
        else if(length*height*width > MAX_CM3){
            System.out.println("Too Large");
        }
        else{
            if(weight <= WEIGHT_BRACKET1)
                price = PRICE_BRACKET1*weight;
            else if(weight <= WEIGHT_BRACKET2)
                price = PRICE_BRACKET2*weight;
            else if(weight <= WEIGHT_BRACKET3)
                price = PRICE_BRACKET3*weight;
            else
                price = PRICE_BRACKET4*weight;

            System.out.printf("$%.2f", price);

        }
    }
}
