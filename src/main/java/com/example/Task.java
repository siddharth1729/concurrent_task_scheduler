package com.example;

/**
 * Represents a task that can be executed concurrently.
 */
public class Task implements Runnable {
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
        try {
            // Simulate task execution
            System.out.println("Task " + taskId + " started execution.");
            Thread.sleep(executionTime); // Simulate task execution time
            System.out.println("Task " + taskId + " completed execution.");
        } catch (InterruptedException e) {
            // Handle interrupted exception if task execution is interrupted
            System.err.println("Task execution interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
