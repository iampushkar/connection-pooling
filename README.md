# Prototyping Database Connection Pooling using BlockingQueue 

This project benchmarks the performance of database connection pooling using an in-memory H2 database. It compares the execution time of database operations with and without connection pooling, focusing specifically on the overhead associated with establishing and closing connections.

### Introduction

In modern applications, database connection pooling is essential for performance optimization. This project benchmarks the time taken to execute a database operation (simulated using `SELECT 1`) across two scenarios:
1. Without connection pooling (creating and closing a new connection for each operation).
2. With connection pooling (reusing existing connections).

### Requirements

- Java 17 or higher
- Maven (for dependency management)

### Installation

Clone this repository:
```bash
   git clone https://github.com/iampushkar/connection-pooling-benchmark.git
   cd connection-pooling-benchmark
```

### Example Output: 
For 10K Iterations
```
  Time taken without connection pooling: 1142 ms
  Time taken with connection pooling: 13 ms
```

## Benchmarking Results

After running the benchmark for 1 Million iterations, you can find the results displayed in the terminal. Below are sample results for reference:

| Scenario for 1M iterations     | Time Taken (ms)  |
|--------------------------------|------------------|
| Without Pooling                | 27996            |
| With Connection Pooling        | 661              |

