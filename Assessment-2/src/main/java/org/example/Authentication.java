package org.example;

class Authentication {

    // Inner Class for User Credentials
    private class UserCredentials {
        private String username;
        private String password;

        // Constructor
        public UserCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Method to validate the credentials
        public boolean validateCredentials() {
            return username.equals("admin") && password.equals("password123");
        }
    }

    // Method to login, using inner class for credential validation
    public void login(String username, String password) {
        // Creating an instance of the inner class
        UserCredentials user = new UserCredentials(username, password);

        // Validate the credentials
        if (user.validateCredentials()) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Credentials. Please try again.");
        }
    }

    public static void main(String[] args) {
        Authentication auth = new Authentication();

        // Attempt to login with valid credentials
        auth.login("admin", "password123");

        // Attempt to login with invalid credentials
        auth.login("user", "wrongpassword");
    }
}

/*Explanation:
Inner Class UserCredentials:

This class holds the username and password and contains a method validateCredentials() to check if the credentials are correct.

Outer Class Authentication:

This class has a login() method that creates an instance of UserCredentials (the inner class) to validate login credentials.

Encapsulation: The UserCredentials class is only used internally within the Authentication class, ensuring security and better organization.*/
