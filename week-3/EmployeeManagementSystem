import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static final String FILE_NAME = "employees.txt";
    static Scanner sc = new Scanner(System.in);

    public static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine())!= null) {
                String[] data = line.split(",");
                employees.add(new Employee(
                    Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3])
                ));
            }
        } catch (IOException e) {
            // File may not exist on first run
        }
    }

    public static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees) {
                bw.write(emp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, dept, salary));
            saveData();
            System.out.println("Employee added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data type.");
            sc.nextLine(); // clear buffer
        }
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        System.out.println("\nID\tName\tDepartment\tSalary");
        System.out.println("----------------------------------------");
        for (Employee emp : employees) {
            System.out.println(emp.id + "\t" + emp.name + "\t" + emp.department + "\t" + emp.salary);
        }
    }

    public static void main(String[] args) {
        loadData();
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: displayEmployees(); break;
                    case 3: System.out.println("Exiting... Data saved"); sc.close(); return;
                    default: System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }
    }
}
