package com.in28minutes.java.threads;

public class ThreadExamples {
	public static void main(String[] args) {
		// Why do we need threads?
		// How can we create and run Threads in Java?
		// What is Thread synchronization?

		// Assume a Cricket Statistics Application
		// Let's say the steps are
		// 1. Download and Store Bowling Statistics => 15 Minutes
		// 2. Download and Store Batting Statistics => 15 Minutes
		// 3. Download and Store Fielding Statistics => 5 Minutes
		// 4. Merge and Analyze => 25 Minutes

		// Steps 1, 2 and 3 are independant and can be run in parallel to make
		// them faster.
		// If run separately, they take 35 (15 + 15 + 5) minutes.
		// If run in parallel, (if you are lucky) they might complete in 20
		// minutes.

		// To be able to run different steps in parallel, we make use of
		// Threads.

		// Look at the Java code below
		downloadAndStoreBattingStatistics();
		downloadAndStoreBowlingStatistics();
		downloadAndStoreFieldingStatistics();

		mergeAndAnalyze();

		// downloadAndStoreBowlingStatistics starts only after
		// downloadAndStoreBattingStatistics completes execution.
		// downloadAndStoreFieldingStatistics starts only after
		// downloadAndStoreBowlingStatistics completes execution.

		// What if I want to run them in parallel without waiting for the others
		// to complete?
		// This is where Threads come into picture.

		// Creating a Thread - Method 1
		// Extending Thread class
		// Note : You cannot extend any other class.
		class BattingStatisticsThread extends Thread {
			// run method without parameters
			public void run() {
				for (int i = 0; i < 1000; i++)
					System.out.println("Running Batting Statistics " + i);
			}
		}

		// Creating a Thread - Method 2
		// Implementing Runnable interface
		// Note : You cannot extend any other class.
		class BowlingStatisticsThread implements Runnable {
			// run method without parameters
			public void run() {
				for (int i = 0; i < 1000; i++)
					System.out.println("Running Bowling Statistics " + i);
			}
		}

		// Starting or Running a Thread
		// When using inheritance. Create an object and call start method.
		BattingStatisticsThread battingThread1 = new BattingStatisticsThread();
		battingThread1.start();

		// When implementing RunnableInterface.
		// Create an object, then a Thread object having implementation of
		// interface as constructor argument
		// and call start method on thread object.
		BowlingStatisticsThread battingInterfaceImpl = new BowlingStatisticsThread();
		Thread battingThread2 = new Thread(battingInterfaceImpl);
		battingThread2.start();

	}

	private static void mergeAndAnalyze() {
		// TODO Auto-generated method stub

	}

	private static void downloadAndStoreBattingStatistics() {
		// TODO Auto-generated method stub

	}

	private static void downloadAndStoreFieldingStatistics() {
		// TODO Auto-generated method stub

	}

	private static void downloadAndStoreBowlingStatistics() {
		// TODO Auto-generated method stub

	}
}
