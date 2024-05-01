
/*
Program: CalculateSum
Programmer: Ryan Mehrian
Date: May 1, 2024
-----
This program finds the sum of all numbers within a range of two provided integers.
 */
public class CalculateSum {
    public static void main(String[] args) {
        //Declarations
        final int START = 4, END = 10;

        //Call Method and print sum.
        System.out.println("The sum of all the numbers in the range is " + sumRange(START, END));
    }

    /*
    Method: SumRange
    ------
    Parameters:
    int rangeStart - Lower limit of range.
    int rangeEnd - Upper limit of range.
    ------
    Returns:
    int - The sum of all the numbers within range.
    -----
    CALCULATES THE SUM OF ALL NUMBERS WITHIN A PROVIDED RANGE (INCLUSIVELY)
     */
    public static int sumRange(int rangeStart, int rangeEnd){

        int range = rangeEnd - rangeStart;
        int sum = 0;

        //Check for Invalid Range, else calulate sum
        if(range < 0){
            sum = 0;
            System.out.println("INVALID RANGE: Range is negative.");
        }
        else{
            for(int i = 0; i <= range; i++){
                sum += rangeStart + i;
            }
        }
        return sum;
    }
}
