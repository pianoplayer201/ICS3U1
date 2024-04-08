/*
Program: TimeConversion
Programmer: Ryan Mehrian
Date Created: 2/23/2024
----
Program will take user time in minutes, and format it in an hour:minute manner,
similar to that of a digital clock.
 */
import java.util.*;
public class TimeConversion {
    public static void main(String[] args){
        // Variables
        int userInputMinutes;
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Please enter time in minutes: ");
        userInputMinutes = sc.nextInt();

        // Output
        System.out.print(userInputMinutes + " minutes can be expressed as ");
        System.out.printf("%d:%02d", userInputMinutes/60, userInputMinutes%60);
    }
}
