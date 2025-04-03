import java.io.*;
import java.util.Scanner;

public class FileBackupAndRecovery {

    public static void backupFile(String sourceFile, String backupFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(backupFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            System.out.println("Backup successful: " + backupFile);

        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    public static void recoverFile(String backupFile, String recoveryFile) {
        try (FileInputStream fis = new FileInputStream(backupFile);
             FileOutputStream fos = new FileOutputStream(recoveryFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            System.out.println("Recovery successful: " + recoveryFile);

        } catch (IOException e) {
            System.out.println("Error during recovery: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name to backup:");
        String sourceFile = scanner.nextLine();

        System.out.println("Enter the backup file name:");
        String backupFile = scanner.nextLine();

        // Create backup
        backupFile(sourceFile, backupFile);

        System.out.println("\nEnter the backup file name to recover:");
        String recoveryFile = scanner.nextLine();

        // Recover the backup
        recoverFile(backupFile, recoveryFile);
    }
}
/*Program 16: File Backup and Recovery System (File Handling, Streams, Serialization)
Approach:
File Handling: We will create backups of a file by reading the content and writing it to another file.

Streams: We will use FileInputStream and FileOutputStream for copying the file contents.

Serialization: We'll use serialization to store the backup information in an object, which will be useful for the recovery process.


Explanation:
backupFile(): This method takes the source file and backup file names as parameters. It reads the content from the source file using FileInputStream, then writes it to the backup file using FileOutputStream.

recoverFile(): This method recovers the content from the backup file and writes it to a new recovery file. It works similarly to the backup process but in reverse.

Main Method: The program asks the user for the source file to back up and the backup file name. After creating a backup, it asks the user for the recovery file name and restores the data from the backup.
*/