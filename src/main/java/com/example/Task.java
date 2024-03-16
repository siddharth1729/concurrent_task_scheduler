package com.example;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a task that can be executed concurrently.
 */
public class Task implements Runnable {
    private static final Logger logger = Logger.getLogger(Task.class.getName());

    private final int taskId; // Unique identifier for the task
    private final long executionTime; // Execution time in milliseconds

    /**
     * Constructs a new Task with the given taskId and executionTime.
     * 
     * @param taskId        The unique identifier for the task.
     * @param executionTime The time it takes for the task to complete execution (in
     *                      milliseconds).
     */
    public Task(int taskId, long executionTime) {
        this.taskId = taskId;
        this.executionTime = executionTime;
    }

    /**
     * The run method that defines the task's execution logic.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        // Log task start time
        logger.log(Level.INFO, "Task {0} started execution at {1}", new Object[] { taskId, new Date(startTime) });

        try {
            // Simulate task execution
            Thread.sleep(executionTime);
        } catch (InterruptedException e) {
            // Log if task execution is interrupted
            logger.log(Level.WARNING, "Task {0} execution interrupted: {1}", new Object[] { taskId, e.getMessage() });
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        long endTime = System.currentTimeMillis();
        long executionDuration = endTime - startTime;

        // Log task completion time and execution duration
        logger.log(Level.INFO, "Task {0} completed execution at {1}, Time taken: {2} milliseconds\n\n",
                new Object[] { taskId, new Date(endTime), executionDuration });
    }
}
