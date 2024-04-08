import java.util.Scanner;

/*
Program Name: Alive
Programmer: Ryan Mehrian
Date Created: February 13, 2023
--------------
This program calculates the number of days the user has been alive,
and the number of hours the user has slept, under the assumption they
have slept 8 hours per night and that there are 365 days in a year,
and 30 days in a month
 */
public class Alive {
    public static void main(String[] args){
        int birthYear;
        int birthMonth;
        int birthDay;
        int presentYear;
        int presentMonth;
        int presentDay;
        int daysAlive;
        int hoursSlept;

        Scanner sc = new Scanner(System.in);

        // Input Birth Date
        System.out.println("Enter your birthdate:");
        System.out.print("Year:  ");
        birthYear = sc.nextInt();
        System.out.print("Month:  ");
        birthMonth = sc.nextInt();
        System.out.print("Day:  ");
        birthDay  = sc.nextInt();

        // Input Current Date
        System.out.println("Enter today's date:");
        System.out.print("Year: ");
        presentYear = sc.nextInt();
        System.out.print("Month: ");
        presentMonth = sc.nextInt();
        System.out.print("Day: ");
        presentDay = sc.nextInt();

        // Calculations
        daysAlive = (presentDay-birthDay) + (presentMonth-birthMonth)*30 + (presentYear-birthYear)*365;
        hoursSlept = daysAlive*8;

        // Output
        System.out.printf("You have been alive for %d days.%n", daysAlive);
        System.out.printf("You have slept %d hours.", hoursSlept);


    }
}
