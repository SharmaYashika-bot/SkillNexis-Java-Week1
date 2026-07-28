import java.util.Scanner;

public class BankManagement {
    static double balance = 0;
    static Scanner sc = new Scanner(System.in);
    
    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount");
        }
    }
    
    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Invalid amount");
        } else {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        }
    }
    
    public static void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Deposit \n2. Withdraw \n3. Check Balance \n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1: deposit(); break;
                case 2: withdraw(); break;
                case 3: checkBalance(); break;
                case 4: 
                    System.out.println("Thank you for using our bank!");
                    sc.close();
                    return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
