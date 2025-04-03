import java.util.concurrent.*;

class ParallelTask implements Runnable {
    private String taskName;
    private CountDownLatch latch;

    public ParallelTask(String taskName, CountDownLatch latch) {
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(taskName + " started.");
            Thread.sleep((long) (Math.random() * 1000)); // Simulate task duration
            System.out.println(taskName + " completed.");
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        } finally {
            latch.countDown();  // Decrease the count of the latch
        }
    }
}

public class CountdownTimerForParallelTasks {
    public static void main(String[] args) throws InterruptedException {
        int numTasks = 5; // Number of parallel tasks
        CountDownLatch latch = new CountDownLatch(numTasks); // Latch initialized to 5 tasks

        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a pool of 3 threads

        // Create and submit tasks
        for (int i = 1; i <= numTasks; i++) {
            executor.submit(new ParallelTask("Task " + i, latch));
        }

        // Wait for all tasks to complete
        latch.await();  // This will block until the count reaches 0
        System.out.println("All tasks are completed. Main thread proceeding...");

        executor.shutdown(); // Shutdown the executor
    }
}
/*Countdown Timer for Parallel Task Execution (CountDownLatch, ExecutorService)
Approach & Explanation:
CountDownLatch: This will be used to ensure that the main thread waits for all parallel tasks to complete before proceeding. The CountDownLatch will be initialized with a count equal to the number of parallel tasks (e.g., threads or tasks). Each task will call countDown() when it finishes, and the main thread will call await() to wait until all tasks have finished.

ExecutorService: We will use an ExecutorService to manage a pool of threads that execute tasks concurrently. This allows us to control the execution of tasks and also manage their completion with a latch.

Explanation:
ParallelTask Class: Implements the Runnable interface and simulates a task that takes a random amount of time to complete. After each task finishes, it calls latch.countDown() to decrease the latch count.

CountdownTimerForParallelTasks Class: This class uses an ExecutorService to manage a pool of threads. We submit tasks for execution, and the main thread waits for all tasks to finish using latch.await(). The CountDownLatch ensures that the main thread doesn’t proceed until all parallel tasks are complete.

CountDownLatch: We initialize the latch with the number of tasks, and each task calls countDown() to notify that it has completed. The main thread waits for the latch to count down to 0 before it proceeds.
*/