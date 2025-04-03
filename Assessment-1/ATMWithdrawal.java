import java.util.Scanner;

public class ATMWithdrawal {
    public static void withdrawAmount(int amount, int balance) {
        if (amount % 100 != 0) {
            System.out.println("Invalid amount! Enter multiples of 100.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        int[] notes = {2000, 500, 200, 100};
        int[] count = new int[notes.length];

        int remaining = amount;

        for (int i = 0; i < notes.length; i++) {
            if (remaining >= notes[i]) {
                count[i] = remaining / notes[i]; // Number of notes of this denomination
                remaining %= notes[i]; // Remaining amount after using these notes
            }
        }

        System.out.println("Dispensed notes:");
        for (int i = 0; i < notes.length; i++) {
            if (count[i] > 0) {
                System.out.println(notes[i] + " x " + count[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your balance: ");
        int balance = scanner.nextInt();

        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        withdrawAmount(amount, balance);

        scanner.close();
    }
}
/*6: Custom ATM Withdrawal Function
Approach:
Input: User enters the amount to withdraw.

Check Validity:

Amount must be a multiple of 100 (common ATM constraint).

Ensure sufficient balance.

Dispense Notes:

Use the highest denomination first (2000, 500, 200, 100).

Minimize the number of notes.

*/