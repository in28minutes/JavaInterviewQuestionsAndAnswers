package com.in28minutes.java.flow;

public class DoWhileLoopExamples {
	public static void main(String[] args) {
		int count = 0;
		// do while also is used when it is not clear how many times loop has to
		// be executed.
		do {
			System.out.print(count);
			count++;
		} while (count < 5);// while this condn is true, loop is executed.
		// output is 01234

		// Code in do while is executed atleast once.
		count = 5;
		do {
			System.out.print(count);
			count++;
		} while (count < 5);
		// output is 5
	}
}
