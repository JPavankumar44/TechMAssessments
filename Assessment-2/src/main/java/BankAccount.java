class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Default Constructor
    public BankAccount() {
        this("000000", "Unknown", 0.0); // Calls the full constructor with default values
        System.out.println("Default Account Created");
    }

    // Constructor with Account Number & Name
    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0); // Calls the full constructor with zero balance
        System.out.println("Account Created for " + accountHolder);
    }

    // Full Parameterized Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        System.out.println("Account Fully Initialized: " + accountHolder + " | Balance: " + balance);
    }

    // Display Account Details
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(); // Default constructor
        BankAccount acc2 = new BankAccount("123456789", "John Doe"); // Partial constructor
        BankAccount acc3 = new BankAccount("987654321", "Alice Smith", 5000.0); // Full constructor

        System.out.println("\nAccount Details:");
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}
/*1: Constructor Chaining in a Banking System
Approach:
Constructor chaining is used to call one constructor from another within the same class.

In a banking system, we create an account with different levels of initialization:

Default Constructor → Assigns default values.

Parameterized Constructor (Account Number & Name) → Initializes account with user details.

Full Parameterized Constructor (Account Number, Name & Balance) → Sets everything.

Explanation:
Constructor chaining helps reuse initialization logic:

Default constructor → Calls the full constructor with default values.

Partial constructor → Calls the full constructor with zero balance.

Full constructor → Assigns values to all attributes.

Efficient Initialization: Prevents redundant code and ensures that every constructor initializes the object correctly.
*/