import java.io.*;

/*
Program: StudentMarks
Programmer: Ryan Mehrian
Date: May 29, 2024
-----
This program reads 10 student's marks on 5 tests from marks.txt, and then writes to result.txt
the following information:
- The average mark for each student
- The highest marking student
- The average mark for each test
 */
public class StudentMarks {
    public static void main(String[]args){
        //Declarations
        final String FILEPATH = "marks.txt";
        int NUM_OF_STUDENTS;
        int NUM_OF_TESTS;
        double[][] marks;
        BufferedReader read;

        //Read and Write
        try{
            //Read
            read = new BufferedReader(new FileReader(FILEPATH));
            NUM_OF_STUDENTS = Integer.parseInt(read.readLine());
            NUM_OF_TESTS = Integer.parseInt(read.readLine());

            //Initialize marks array
            marks = new double[NUM_OF_STUDENTS][NUM_OF_TESTS];

            for(int i = 0; i < NUM_OF_STUDENTS; i++){
                String[] line = read.readLine().split(" ");
                for(int j = 0; j < NUM_OF_TESTS; j++){
                    marks[i][j] = Double.parseDouble(line[j]);
                }
            }
            read.close();
            writeToFile(marks);

        } catch(IOException e){
            System.out.println(e);
        } catch(NumberFormatException e){
            System.out.println("File is not formatted correctly.");
        }
    }

    public static void writeToFile(double[][] marks) throws IOException {
        //Declarations
        BufferedWriter write = new BufferedWriter(new FileWriter("result.txt"));
        double[] studentAverage = new double[marks.length];
        int highestMarkingStudent = -1;
        double highestMark = -1;
        double testAverage = 0;


        //Find Student Average
        for(int i = 0; i < marks.length; i++){
            for(int j = 0; j < marks[i].length; j++){
                studentAverage[i] += marks[i][j];
            }
            studentAverage[i] /= marks[i].length;
            write.write(String.format("Student #%d Average: %.2f%%\n", i+1, studentAverage[i]));
        }

        //Highest Marking Student
        for(int i = 0; i < studentAverage.length; i++){
            if(studentAverage[i] > highestMark){
                highestMarkingStudent = i+1;
                highestMark = studentAverage[i];
            }
        }
        write.write(String.format("Highest Marking Student: #%d\nHighest Grade: %.2f%%\n", highestMarkingStudent, highestMark));

        //Average of Each Test
        for(int i = 0; i < marks[0].length; i++){
            for(int j = 0; j < marks.length; j++){
                testAverage += marks[j][i];
            }
            testAverage /= marks.length;
            write.write(String.format("Test #%d Average: %.2f%%\n", i+1, testAverage));
        }
        write.close();


    }
}
