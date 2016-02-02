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
