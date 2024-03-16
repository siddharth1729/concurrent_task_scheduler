package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TaskScheduler class manages the scheduling and execution of tasks using a
 * thread pool.
 */
public class TaskScheduler {
    private static final Logger logger = Logger.getLogger(TaskScheduler.class.getName());

    private final ExecutorService executor; // ExecutorService for task execution

    /**
     * Constructs a TaskScheduler with the specified poolSize.
     * 
     * @param poolSize The number of threads in the thread pool.
     */
    public TaskScheduler(int poolSize) {
        executor = Executors.newFixedThreadPool(poolSize); // Create a fixed thread pool
    }

    /**
     * Schedules a task for execution by the thread pool.
     * 
     * @param task The task to be scheduled for execution.
     */
    public void scheduleTask(Task task) {
        executor.execute(() -> {
            try {
                task.run(); // Execute the task
            } catch (Exception e) {
                // Log any exceptions that occur during task execution
                logger.log(Level.SEVERE, "Error executing task: {0}", e.getMessage());
            }
        });
    }

    /**
     * Shuts down the task scheduler and the associated thread pool.
     */
    public void shutdown() {
        executor.shutdown(); // Shutdown the executor service
    }

    /**
     * Main method to demonstrate the usage of the TaskScheduler class.
     * 
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler(5); // Create a TaskScheduler with a pool size of 5 threads

        // Schedule tasks
        for (int i = 1; i <= 10; i++) {
            Task task = new Task(i, i * 1000); // Create a new Task with ID and execution time
            taskScheduler.scheduleTask(task); // Schedule the task for execution
        }

        // Shutdown the scheduler after all tasks are scheduled
        taskScheduler.shutdown();
    }
}
