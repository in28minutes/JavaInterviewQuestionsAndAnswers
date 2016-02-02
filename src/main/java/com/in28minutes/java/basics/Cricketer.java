package com.in28minutes.java.basics;

public class Cricketer {
	String name;
	int odiRuns;
	int testRuns;
	int t20Runs;

	public int totalRuns() {
		int totalRuns = odiRuns + testRuns + t20Runs;
		return totalRuns;
	}
}
