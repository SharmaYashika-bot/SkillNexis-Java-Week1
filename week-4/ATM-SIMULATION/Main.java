import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();
    static final String FILE = "accounts.txt";
    static Account currentUser = null;

    public static void main(String[] args) {
        fileSePadho();

        while(true) {
            if(currentUser == null) {
                loginMenu();
            } else {
                atmMenu();
            }
        }
    }

    static void loginMenu() {
        System.out.println("\n========== WELCOME TO XYZ BANK ATM ==========");
        System.out.println("1. Login");
        System.out.println("2. Create New Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        if(ch == 1) login();
        else if(ch == 2) newAccount();
        else if(ch == 3) {
            fileMeLikho();
            System.out.println("Thank you for using XYZ Bank ATM!");
            System.exit(0);
        } else {
            System.out.println("Invalid Choice!");
        }
    }

    static void atmMenu() {
        System.out.println("\n========== ATM MENU - Account: " + currentUser.getAccNo() + " ==========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Transaction History");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        if(ch == 1) {
            System.out.println("Current Balance: Rs. " + currentUser.getBalance());
        } else if(ch == 2) {
            System.out.print("Enter amount to deposit: Rs. ");
            currentUser.deposit(sc.nextDouble());
        } else if(ch == 3) {
            System.out.print("Enter amount to withdraw: Rs. ");
            currentUser.withdraw(sc.nextDouble());
        } else if(ch == 4) {
            System.out.println("--- Transaction History ---");
            for(String s : currentUser.getHistory()) {
                System.out.println(s);
            }
        } else if(ch == 5) {
            currentUser = null;
            System.out.println("Logout successful!");
        } else {
            System.out.println("Invalid Choice!");
        }
    }

    static void login() {
        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        for(Account a : accounts) {
            if(a.getAccNo() == acc && a.checkPin(pin)) {
                currentUser = a;
                System.out.println("Login Successful!");
                return;
            }
        }
        System.out.println("Invalid Account Number or PIN!");
    }

    static void newAccount() {
        System.out.print("Enter New Account Number: ");
        int acc = sc.nextInt();
        System.out.print("Set PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: Rs. ");
        double bal = sc.nextDouble();

        accounts.add(new Account(acc, pin, name, bal));
        System.out.println("Account Created Successfully!");
    }

    static void fileMeLikho() {
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for(Account a : accounts) {
                pw.println(a.fileMeLikho());
            }
        } catch(Exception e) {
            System.out.println("Error saving data!");
        }
    }

    static void fileSePadho() {
        File f = new File(FILE);
        if(!f.exists()) return;
        try(Scanner fileSc = new Scanner(f)) {
            while(fileSc.hasNextLine()) {
                String[] d = fileSc.nextLine().split(",");
                accounts.add(new Account(
                    Integer.parseInt(d[0]),
                    Integer.parseInt(d[1]),
                    d[2],
                    Double.parseDouble(d[3])
                ));
            }
        } catch(Exception e) {
            System.out.println("Error loading data!");
        }
    }
}