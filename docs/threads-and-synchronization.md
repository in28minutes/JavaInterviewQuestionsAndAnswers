### /com/in28minutes/java/threads/ThreadDeadlock.java
```
package com.in28minutes.java.threads;

class Resource {
}

class SomeOperation {
	Resource resource1 = new Resource();
	Resource resource2 = new Resource();

	void method1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "is in method1");
		synchronized (resource1) {
			System.out.println(Thread.currentThread().getName()
					+ "is going to sleep");

			Thread.sleep(1000);

			System.out.println(Thread.currentThread().getName()
					+ "is out of sleep and will wait for resource 2");
			synchronized (resource2) {
				// SOME CODE GOES IN HERE
			}
		}
	}

	void method2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "is in method2");
		synchronized (resource2) {
			System.out.println(Thread.currentThread().getName()
					+ "is going to sleep");

			Thread.sleep(1000);

			System.out.println(Thread.currentThread().getName()
					+ "is out of sleep and will wait for resource 1");
			synchronized (resource1) {
				// SOME CODE GOES IN HERE
			}
		}
	}

}

public class ThreadDeadlock implements Runnable {

	SomeOperation operation = new SomeOperation();

	@Override
	public void run() {
		try {
			operation.method1();
			operation.method2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThreadDeadlock r = new ThreadDeadlock();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.start();
		two.start();
	}
}
```
### /com/in28minutes/java/threads/ThreadExamples.java
```
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
```
### /com/in28minutes/java/threads/ThreadExampleSynchronized.java
```
package com.in28minutes.java.threads;

class SpreadSheet {
	int cell1, cell2, cell3;

	int setandGetSum(int a1, int a2, int a3) {
		cell1 = a1;
		sleepForSomeTime();
		cell2 = a2;
		sleepForSomeTime();
		cell3 = a3;
		sleepForSomeTime();
		return cell1 + cell2 + cell3;
	}

	void sleepForSomeTime() {
		try {
			Thread.sleep(10 * (int) (Math.random() * 100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SynchronizedSyntaxExample {
	static int count;
	int instanceValue;

	// others..
	synchronized void synchronizedExample1() {
		// All code goes here..
	}

	void synchronizedExample2() {
		synchronized (this) {
			// All code goes here..
		}
	}

	synchronized static int getCount() {
		return count;
	}

	static int getCount2() {
		synchronized (SynchronizedSyntaxExample.class) {
			return count;
		}
	}

}

public class ThreadExampleSynchronized implements Runnable {

	SpreadSheet spreadSheet = new SpreadSheet();

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.print(spreadSheet.setandGetSum(i, i * 2, i * 3) + " ");
		}
	}

	public static void main(String[] args) {
		ThreadExampleSynchronized r = new ThreadExampleSynchronized();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.start();
		two.start();
		// First UnSynchronized Run
		// 0 3 6 9 12 15 18 18
		// Second UnSynchronized Run
		// 0 1 6 7 12 18 18 18
		// Synchronized Run
		// 0 0 6 6 12 12 18 18

		// A static synchronized method and a non-static synchronized method
		// will not block each other,
	}
}
```
### /com/in28minutes/java/threads/ThreadPriority.java
```
package com.in28minutes.java.threads;

public class ThreadPriority {
	public static void main(String[] args) throws InterruptedException {
		// Each thread in Java is assigned a default Priority 5. This priority
		// can be increased or decreased (Range 1 to 10).
		// If two threads are waiting, the scheduler picks the thread with
		// highest priority to be run. If all threads have equal priority, the
		// scheduler then picks one of them randomly. Design programs so that
		// they don't depend on priority.

		// Consider the thread example declared below:
		class ThreadExample extends Thread {
			public void run() {
				for (int i = 0; i < 1000; i++)
					System.out.println(this.getName() + " Running " + i);
			}
		}

		// Priority of thread can be changed by invoking setPriority method on
		// the thread.
		ThreadExample thread1 = new ThreadExample();
		thread1.setPriority(8);

		// Java also provides predefined constants Thread.MAX_PRIORITY(10),
		// Thread.MIN_PRIORITY(1), Thread.NORM_PRIORITY(5) which can be used to
		// assign priority to a thread.

		// Thread Join method
		// Join method is an instance method on the Thread class. Let's see a
		// small example to understand what join method does.

		// Lets consider the thread's declared below : thread2, thread3, thread4

		ThreadExample thread2 = new ThreadExample();
		ThreadExample thread3 = new ThreadExample();
		ThreadExample thread4 = new ThreadExample();

		// We would want to run thread2 and thread3 in parallel but thread4 can
		// only run when thread3 is finished. This can be achieved using join
		// method. Look at the example code below.
		thread3.start();
		thread2.start();
		thread3.join();// wait for thread 3 to complete
		System.out.println("Thread3 is completed.");
		thread4.start();

		// thread3.join() method call force the execution of main method to stop
		// until thread3 completes execution. After that, thread4.start() method
		// is invoked, putting thread4 into a Runnable State.

		// Overloaded Join method
		// Join method also has an overloaded method accepting time in
		// milliseconds as a parameter.
		thread4.join(2000);
		// In above example, main method thread would wait for 2000 ms or the
		// end of execution of thread4, whichever is minimum.

		// Thread yield method
		// Yield is a static method in the Thread class. It is like a thread
		// saying
		// " I have enough time in the limelight. Can some other thread run next?".
		// A call to yield method changes the state of thread from RUNNING to
		// RUNNABLE. However, the scheduler might pick up the same thread to run
		// again, especially if it is the thread with highest priority.
		// Summary is yield method is a request from a thread to go to Runnable
		// state. However, the scheduler can immediately put the thread back to
		// RUNNING state.

		// Thread sleep method
		// sleep is a static method in Thread class. sleep method can throw a
		// InterruptedException. sleep method causes the thread in execution to
		// go to sleep for specified number of milliseconds.
	}

}
```
### /com/in28minutes/java/threads/ThreadWaitAndNotify.java
```
package com.in28minutes.java.threads;

class Calculator extends Thread {
	long sum;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 1000000; i++) {
				sum += i;
			}
			notify();
		}
	}
}

public class ThreadWaitAndNotify {
	public static void main(String[] args) {
		Calculator thread = new Calculator();
		thread.start();
		synchronized (thread) {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(thread.sum);
	}
}
```
