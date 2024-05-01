/*
Program: Welcome
Programmer: Ryan Mehrian
Date: April 25, 2024
-----
This program contains a method that will greet a visitor, and let them know what # visitor they are.
 */
public class Welcome {
    public static void main(String[] args) {
        //Declarations
        final int visitorNum = 4;
        final String visitorName = "Bobby";

        //Print
        System.out.println(welcomeMessage(visitorName, visitorNum));
    }

    /*
    Method: welcomeMessage
    ------
    Returns:
    String - A welcome message for a visitor.
    ------
    Parameters:
    String name - Name of the visitor
    int visitorNum - Number of visitor
    ----
    Generates a welcome message for a visitor based on their name and visitor number.
     */
    public static String welcomeMessage(String name, int visitorNum){
        String message = "Welcome " + name + "! You are visitor number " + (visitorNum) + ".";
        return message;
    }
}
