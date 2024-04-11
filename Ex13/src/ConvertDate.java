import java.util.Scanner;

/*
Program: ConvertDate
Programmer: Ryan Mehrian
Date: March 28, 2024
-----
This program will prompt the user for an input of a year, a month and a day, and
outputs it in the format of: "Month" "Day", "Year".
 */
public class ConvertDate {
    public static void main(String[] args) {
        //Declarations
        int userMonth, userDay, userYear;
        String outputMonth = null;

        Scanner sc = new Scanner(System.in);

        //Inputs
        System.out.print("Please enter a numeric year: ");
        userYear = sc.nextInt();
        System.out.print("Please enter a numeric month: ");
        userMonth = sc.nextInt();
        System.out.print("Please enter a numeric day: ");
        userDay = sc.nextInt();

        //Checks
        switch (userMonth){
            case 1:
                outputMonth = "January";
                break;
            case 2:
                outputMonth = "February";
                break;
            case 3:
                outputMonth = "March";
                break;
            case 4:
                outputMonth = "April";
                break;
            case 5:
                outputMonth = "May";
                break;
            case 6:
                outputMonth = "June";
                break;
            case 7:
                outputMonth = "July";
                break;
            case 8:
                outputMonth = "August";
                break;
            case 9:
                outputMonth = "September";
                break;
            case 10:
                outputMonth = "October";
                break;
            case 11:
                outputMonth = "November";
                break;
            case 12:
                outputMonth = "December";
                break;
            default:
                outputMonth = "INVALID MONTH";
        }

        //Output
        System.out.printf("%s %d, %d", outputMonth, userDay, userYear);

    }
}
