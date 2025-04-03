class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized method to ensure atomic operations
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance to withdraw: " + amount);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class BankTransaction implements Runnable {
    private BankAccount account;
    private boolean isDeposit;
    private int amount;

    public BankTransaction(BankAccount account, boolean isDeposit, int amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of 1000
        Thread transaction1 = new Thread(new BankTransaction(account, true, 500)); // Deposit 500
        Thread transaction2 = new Thread(new BankTransaction(account, false, 700)); // Withdraw 700
        Thread transaction3 = new Thread(new BankTransaction(account, false, 200)); // Withdraw 200
        Thread transaction4 = new Thread(new BankTransaction(account, true, 300)); // Deposit 300

        transaction1.start();
        transaction2.start();
        transaction3.start();
        transaction4.start();
    }
}
/*Bank Transaction System (Threads, Synchronization, Deadlock Prevention)
Approach & Explanation:
Threads: We'll create multiple threads to simulate multiple bank transactions occurring concurrently. Each thread will represent a transaction.

Synchronization: We'll use synchronization to ensure that the balance of the bank account is updated safely when multiple threads attempt to access it at the same time.

Deadlock Prevention: Deadlock can occur if two threads are trying to lock resources in a conflicting order. To prevent this, we ensure that locks are acquired in a consistent order to avoid circular dependencies between threads.

We'll simulate a bank account with deposit and withdrawal operations. If two threads (representing transactions) try to access the same account balance at the same time, the synchronization mechanism will ensure that only one transaction is performed at a time. We'll also prevent deadlock by ensuring the order of lock acquisition is consistent.

Explanation:
BankAccount Class: The class has a balance field that stores the current balance. The deposit() and withdraw() methods are synchronized to ensure that only one thread can modify the balance at a time.

BankTransaction Class: Implements the Runnable interface, which will simulate either a deposit or withdrawal operation on the bank account.

BankTransactionSystem Class: This class starts multiple threads simulating transactions. Each transaction thread either deposits or withdraws a specified amount from the account.

Synchronization: We use synchronized methods to prevent race conditions when two threads attempt to access the balance at the same time.

Deadlock Prevention: We avoid complex lock acquisition patterns to minimize the chances of a deadlock scenario.

*/