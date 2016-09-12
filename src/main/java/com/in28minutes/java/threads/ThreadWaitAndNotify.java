package com.in28minutes.java.threads;

class Calculator extends Thread {
	long sum;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 1000000; i++) {
				sum += i;//499999500000
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
