// Assignment 1: Student Class Implementation
import java.util.Scanner;

class Student {
    // Encapsulation: private attributes
    private int rollNo;
    private String name;
    private String course;
    private double marks;

    // Constructor
    public Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("\n--- Student Information ---");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Roll No: ");
        int r = sc.nextInt();
        sc.nextLine(); // consume newline
        
        System.out.print("Enter Name: ");
        String n = sc.nextLine();
        
        System.out.print("Enter Course: ");
        String c = sc.nextLine();
        
        System.out.print("Enter Marks: ");
        double m = sc.nextDouble();
        
        Student s1 = new Student(r, n, c, m);
        s1.displayInfo();
        
        sc.close();
    }
}
