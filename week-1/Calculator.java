import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Simple Calculator ===");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        System.out.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide");
        System.out.print("Enter choice 1/2/3/4: ");
        int choice = sc.nextInt();
        
        double result = 0;
        switch(choice) {
            case 1: result = num1 + num2; break;
            case 2: result = num1 - num2; break;
            case 3: result = num1 * num2; break;
            case 4: 
                if(num2 != 0) result = num1 / num2;
                else { System.out.println("Error: Cannot divide by zero"); return; }
                break;
            default: System.out.println("Invalid Input"); return;
        }
        System.out.println("Result: " + result);
        sc.close();
    }
}
