import java.util.Scanner;

public class Gradecalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants
        int totalSubjects = 5; // Assuming there are 5 subjects
        int maxMarksPerSubject = 100;
        char[] gradeScale = {'A', 'B', 'C', 'D', 'E', 'F'};
        double[] gradeBoundaries = {90, 80, 70, 60, 50, 0};

        // Input marks for each subject
        System.out.println("Enter marks obtained (out of 100) in each subject:");
        int totalMarks = 0;
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        // Calculate total marks and average percentage
        double averagePercentage = (double) totalMarks / (totalSubjects * maxMarksPerSubject) * 100;

        // Calculate grade
        char grade = calculateGrade(averagePercentage, gradeScale, gradeBoundaries);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static char calculateGrade(double percentage, char[] gradeScale, double[] gradeBoundaries) {
        for (int i = 0; i < gradeBoundaries.length; i++) {
            if (percentage >= gradeBoundaries[i]) {
                return gradeScale[i];
            }
        }
        return 'F'; // If percentage is below the lowest boundary, assign grade F
    }
}
