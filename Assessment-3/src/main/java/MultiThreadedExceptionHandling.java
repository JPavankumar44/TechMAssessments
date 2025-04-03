class TaskThread extends Thread {
    private int num1, num2;

    // Constructor to initialize the task
    public TaskThread(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        try {
            // Simulate a task that could throw an exception (e.g., division by zero)
            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero exception
            System.out.println("Error in thread " + Thread.currentThread().getName() + ": Division by zero!");
        } catch (Exception e) {
            // Handle any other exception
            System.out.println("Error in thread " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }
}

public class MultiThreadedExceptionHandling {
    public static void main(String[] args) {
        // Create multiple threads with different tasks
        TaskThread thread1 = new TaskThread(10, 2); // valid division
        TaskThread thread2 = new TaskThread(10, 0); // division by zero (exception)
        TaskThread thread3 = new TaskThread(10, 5); // valid division

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
/* Multi-Threaded Exception Handling
Approach:
Multi-threading involves running multiple threads concurrently. Exception handling in multi-threaded applications needs to account for exceptions thrown in different threads.

In this example, we will simulate a scenario where multiple threads are performing operations, and we will handle any exceptions that arise from these threads.

Each thread will perform a task (e.g., performing a division) that may throw an exception, and we'll handle these exceptions using try-catch blocks within each thread.

Explanation:
TaskThread Class:

This is a subclass of Thread that performs a division operation in its run() method. If a division by zero occurs, it catches the ArithmeticException.

Exception Handling:

Inside each thread's run() method, we handle potential exceptions using a try-catch block. If a division by zero occurs, we catch it and print a message indicating the error.

Multi-threading:

We create and start three threads, each performing a task that may throw an exception.

Thread Safety:

Each thread is independent, and we handle exceptions within the thread itself to ensure no thread crashes the entire program.


*/