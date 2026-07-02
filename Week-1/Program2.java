import java.util.Scanner;

public class GradeEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Grade Evaluation ===");
        System.out.print("Enter your marks out of 100: ");
        double marks = sc.nextDouble();
        
        String grade;
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 50) grade = "D";
        else grade = "F";
        
        System.out.println("Your Grade: " + grade);
        
        if (grade.equals("F"))
            System.out.println("Status: Fail. Try harder next time.");
        else
            System.out.println("Status: Pass");
            
        sc.close();
    }
}
