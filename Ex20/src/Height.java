import java.util.Scanner;

/*
Program: Height
Programmer: Ryan Mehrian
-----
This program will accept inputs of 20 heights and output all heights of that series that are above average.
 */
public class Height {
    public static void main(String[] args) {

        //Declarations
        double[] height = new double[20];
        double sum = 0;
        double average;

        Scanner sc = new Scanner(System.in);

        //Input
        for (int i = 0; i < height.length; i++) {
            System.out.printf("Please enter height #%d in cm: ", i + 1);
            height[i] = sc.nextDouble();
            sum += height[i];
        }

        //Calculation and Final Output
        average = sum/height.length;
        System.out.println("The following heights are above average:");
        for(int i = 0; i < height.length; i ++){
            if (height[i] > average){
                System.out.printf("Height #%d: %.1fcm%n",i + 1, height[i]);

            }
        }

    }
}
