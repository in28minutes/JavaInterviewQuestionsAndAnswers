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
