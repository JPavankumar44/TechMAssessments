class ATM {
    private double balance;

    // Constructor to initialize ATM with a balance
    public ATM(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money with nested try-catch
    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }
            try {
                if (amount > balance) {
                    throw new InsufficientFundsException("Insufficient funds in your account.");
                }
                // If all conditions are met, withdraw the amount
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: $" + balance);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class ATMTransactionSimulation {
    public static void main(String[] args) {
        ATM atm = new ATM(500); // Initialize ATM with a balance of $500

        // Simulate various withdrawals
        atm.withdraw(200);  // Valid withdrawal
        atm.withdraw(600);  // Insufficient funds
        atm.withdraw(0);    // Invalid amount
    }
}
/*Program 8: Nested Try-Catch: ATM Simulation
Approach:
Nested Try-Catch: Sometimes you may need multiple layers of exception handling within the same method. This can be useful when you want to handle different exceptions at different levels.

In this ATM simulation, we will simulate withdrawing money from an ATM. We will use nested try-catch blocks to handle specific exceptions such as:

Invalid account balance.

Invalid amount input.
Explanation:
ATM Class:

This class has a balance field, a constructor to initialize it, and a withdraw() method that simulates a withdrawal process.

Nested Try-Catch:

The withdraw() method has a nested try-catch block. The outer try block handles invalid amounts (e.g., negative values), while the inner try block handles insufficient funds during withdrawal.

Custom Exception:

The InsufficientFundsException class is a custom exception to handle cases where the withdrawal amount exceeds the account balance.

Simulation:

We simulate three withdrawals: a valid one, an insufficient funds scenario, and an invalid amount input.
*/