import java.util.*;

public class Account {
    private int accNo;
    private int pin;
    private String name;
    private double balance;
    private ArrayList<String> history;

    public Account(int accNo, int pin, String name, double balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
        this.history = new ArrayList<>();
        history.add("Account Created with Initial Balance: Rs. " + balance);
    }

    public int getAccNo() { return accNo; }
    public boolean checkPin(int p) { return this.pin == p; }
    public double getBalance() { return balance; }
    public ArrayList<String> getHistory() { return history; }

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited: + Rs. " + amount);
        System.out.println("Deposit Successful! New Balance: Rs. " + balance);
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            history.add("Withdrawn: - Rs. " + amount);
            System.out.println("Withdrawal Successful! New Balance: Rs. " + balance);
        }
    }

    public String fileMeLikho() {
        return accNo + "," + pin + "," + name + "," + balance;
    }
}