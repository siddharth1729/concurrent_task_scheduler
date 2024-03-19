# Concurrent Task Scheduler

This project implements a Concurrent Task Scheduler in Java, which optimizes the execution of a large number of independent tasks across multiple processing units. The scheduler efficiently allocates resources, manages task dependencies, and handles concurrent execution without causing data races or deadlocks.

## Features

- Task scheduling with concurrent execution.
- Thread pool management for efficient resource allocation.
- Simulated task execution with configurable execution times.
- Graceful shutdown of the task scheduler.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or higher.
- Apache Maven for building and managing dependencies.

### Installation

1. Clone the repository:

```bash
   git clone https://github.com/siddharth1729/concurrent_task_scheduler.git
```

Navigate to the project directory:

```bash
cd concurrent_task_scheduler
```

### Compile and build the project using Maven

```bash

mvn clean package
```

### Run the Task Scheduler application

```bash

java -jar target/concurrent_taskscheduler-1.0-SNAPSHOT.jar
```
