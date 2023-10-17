
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfSubjects = 0;
        String grade;

        System.out.println("Welcome to the Student Grade Calculator");
        System.out.println("Please enter the number of subjects: ");
        while (true) {
            try {
                numberOfSubjects = input.nextInt();
                if (numberOfSubjects >= 0) {
                    break; // Exit the loop if valid non-negative input is provided
                } else {
                    System.err.println("Invalid input. Please enter a non-negative number of subjects.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid number of subjects.");
                input.nextLine(); // Clear the input buffer
            }
        }

        double obtainedMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            while (true) {
                System.out.println("Enter marks for subject " + i + " out of 100:");
                try {
                    double subjectMarks = input.nextDouble();
                    if (subjectMarks >= 0 && subjectMarks <= 100) {
                        obtainedMarks += subjectMarks; //adding marks obtained in each subject
                        break; // Exit the loop if valid input is provided
                    } else {
                        System.err.println("Invalid input. Marks should be between 0 and 100.");
                    }
                } catch (Exception e) {
                    System.err.println("Invalid input. Please enter a valid number for subject marks.");
                    input.nextLine(); // Clear the input buffer
                }
            }
        }

        double obtainedPercentage = 0; // Initialize to zero
        if (numberOfSubjects > 0) {
            obtainedPercentage = obtainedMarks / numberOfSubjects; //calculating average percentages, but only if numberOfSubjects is greater than zero
        } else {
            System.err.println("Warning: Division by zero. No subjects entered.");
        }

        if (obtainedPercentage >= 90 && obtainedMarks <= 100) {
            grade = "A+";
        } else if (obtainedPercentage >= 75 && obtainedPercentage < 90) {
            grade = "A";
        } else if (obtainedPercentage >= 65 && obtainedPercentage < 75) {
            grade = "B";
        } else if (obtainedPercentage >= 55 && obtainedPercentage < 65) {
            grade = "C";
        } else if (obtainedPercentage >= 45 && obtainedPercentage < 55) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        showData(obtainedMarks, obtainedPercentage, grade);
    }

    public static void showData(double obtainedMarks, double percentage, String grade) {

        System.out.println("Total marks: " + obtainedMarks);
        System.out.println("Average Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }
}
