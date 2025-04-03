class UserAccount {
    // Private variables (Encapsulation)
    private String username;
    private String password;
    private String email;

    // Constructor
    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Setter for Username (if needed to update)
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for Password (You can add encryption for real applications)
    public String getPassword() {
        return password;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for Email
    public String getEmail() {
        return email;
    }

    // Setter for Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display User Account details (for debugging or display purposes)
    public void displayAccountInfo() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
    }

    public static void main(String[] args) {
        // Create user account with encapsulated details
        UserAccount user1 = new UserAccount("john_doe", "securePassword123", "john.doe@email.com");

        // Access data through getters
        System.out.println("User Details (before modification):");
        user1.displayAccountInfo();

        // Modify data through setters
        user1.setUsername("john_new");
        user1.setPassword("newPassword456");

        // Access updated data
        System.out.println("\nUser Details (after modification):");
        user1.displayAccountInfo();
    }
}
/*2: Secure User Data with Encapsulation
Approach:
Encapsulation is one of the fundamental principles of Object-Oriented Programming (OOP). It is the technique of bundling the data (attributes) and methods (functions) that operate on the data into a single unit (class).

Private access modifiers restrict direct access to the fields, and public methods (getters and setters) are used to access and modify these fields.

This ensures data security by providing controlled access to sensitive data (like user credentials).

Explanation:
Private Variables: The username, password, and email fields are private, ensuring no direct access from outside the class.

Getters and Setters: These public methods are used to access and modify the values of the private fields.

Security: You can add encryption for password handling, but here it's kept simple for demonstration.

Flexibility: Users can change their information through setters, but the fields remain protected from outside direct modification.

*/