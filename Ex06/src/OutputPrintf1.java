/*
Program: OutputPrintf1
Programmer: Ryan Mehrian
Date: February 20, 2024
-----
This program outputs the amount of money in Juanita and Juan's bank accounts.
 */
public class OutputPrintf1{
    public static void main(String[] args){
        System.out.printf("%7s's bank account balance is $%,13.2f.%n" , "Juanita", 23456789.99);
        System.out.printf("%7s's bank account balance is $%,13.2f." , "Juan", 15455.26);

    }
}