import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Double> marks = new ArrayList<>();
        
        // Using try-with-resources automatically closes the Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of students: ");
            
            // 1. Validate if student count is a valid integer
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter a whole number for students: ");
                sc.next(); // Clear invalid input
            }
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("No students to process.");
                return;
            }

            // 2. Loop to get marks with double validation
            for (int i = 0; i < n; i++) {
                System.out.print("Enter marks for student " + (i + 1) + ": ");
                
                while (!sc.hasNextDouble()) {
                    System.out.print("Invalid mark! Please enter a valid number for student " + (i + 1) + ": ");
                    sc.next(); // Clear invalid input
                }
                
                marks.add(sc.nextDouble());
            }

            // 3. Output results
            double highest = Collections.max(marks);
            double lowest = Collections.min(marks);

            System.out.println("\n--- Results ---");
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks: " + lowest);
            System.out.println("All Marks: " + marks);
        }
    }
}
