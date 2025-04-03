import java.io.*;
import java.util.Scanner;

public class ChatLogger {

    public static void logMessage(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chatlog.txt", true))) {
            writer.write(message);
            writer.newLine();  // Add a new line after each message
            System.out.println("Message logged to chatlog.txt");
        } catch (IOException e) {
            System.out.println("Error while logging message: " + e.getMessage());
        }
    }

    public static void displayChatLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader("chatlog.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading chat log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulating a chat system
        while (true) {
            System.out.println("Enter message (or 'exit' to stop): ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            // Log the message to the file
            logMessage(message);
        }

        // Display the chat log
        System.out.println("\nChat Log:");
        displayChatLog();
    }
}
