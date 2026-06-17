// Practice 10: ATM Simulation
// Demonstrates encapsulation using a private balance field.

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        // Do not allow an account to start with a negative balance.
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        // These checks protect the account from invalid transactions.
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount);
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);

        System.out.println("Starting balance: Rs. " + account.getBalance());
        account.withdraw(1200);   // normal withdrawal
        account.withdraw(-100);   // invalid amount
        account.withdraw(10000);  // more than available balance
        account.deposit(800);
        System.out.println("Final balance: Rs. " + account.getBalance());
    }
}
