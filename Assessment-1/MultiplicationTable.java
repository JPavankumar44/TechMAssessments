import java.util.Scanner;

public class MultiplicationTable {
    public static void printTableForLoop(int N) {
        System.out.println("Multiplication Table using For Loop:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }
    }

    public static void printTableWhileLoop(int N) {
        System.out.println("\nMultiplication Table using While Loop:");
        int i = 1;
        while (i <= 10) {
            System.out.println(N + " x " + i + " = " + (N * i));
            i++;
        }
    }

    public static void printTableDoWhileLoop(int N) {
        System.out.println("\nMultiplication Table using Do-While Loop:");
        int i = 1;
        do {
            System.out.println(N + " x " + i + " = " + (N * i));
            i++;
        } while (i <= 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int N = scanner.nextInt();

        printTableForLoop(N);
        printTableWhileLoop(N);
        printTableDoWhileLoop(N);

        scanner.close();
    }
}
/*7: Multiplication Table of N Using All Three Loops
Approach:
The user enters an integer N.

Print the multiplication table of N using:

For Loop

While Loop

Do-While Loop*/