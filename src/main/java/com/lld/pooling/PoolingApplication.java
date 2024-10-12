package com.lld.pooling;

public class PoolingApplication {

	public static void main(String[] args) {
		System.out.println("Prototyping Connection Pooling");
		try {
			Benchmark.benchmarkWithoutPooling();

			ConnectionPool pool = new ConnectionPool();
			Benchmark.benchmarkWithConnectionPooling(pool);
			pool.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
