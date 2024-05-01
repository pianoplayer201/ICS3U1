/*
Program: SoundAlarm
Programmer: Ryan Mehrian
Date: May 1, 2024
----
The program outputs the message "Alarm!" n times, with n being determined by user input.
 */
public class SoundAlarm {
    public static void main(String[] args) {
        //Declarations
        final int numOfAlarms = 5;

        //Method call & Print
        alarm(numOfAlarms);
    }

    /*
    Method: alarm
    ----
    Parameters:
    int n - The number of times to print Alarm
    ---
    Prints the message "Alarm!" n times.
     */
    public static void alarm(int n){
        for(int i = 0; i < n; i ++){
            System.out.println("Alarm!");
        }
    }
}
