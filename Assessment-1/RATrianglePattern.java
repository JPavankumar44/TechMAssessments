public class RATrianglePattern {
        public static void main(String[] args) {
            int n = 5; // Number of rows in the pattern

            for (int i = 1; i <= n; i++) { // Outer loop for rows
                for (int j = 1; j <= i; j++) { // Inner loop for columns
                    System.out.print("* "); // Print star with space
                }
                System.out.println(); // Move to the next line
            }
        }
    }

