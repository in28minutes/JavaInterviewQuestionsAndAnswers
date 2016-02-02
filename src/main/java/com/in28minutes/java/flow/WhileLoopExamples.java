package com.in28minutes.java.flow;

public class WhileLoopExamples {
	public static void main(String[] args) {
		int count = 0;
		// While is used when it is not clear how many times loop has to be
		// executed.
		while (count < 5) {// while this condn is true, loop is executed.
			System.out.print(count);
			count++;
		}// output is 01234

		// Depending on the condition, code in while might not be executed at
		// all.
		count = 5;
		while (count < 5) {// condn is false. So, code in while is not executed.
			System.out.print(count);
			count++;
		}// Nothing is printed to output

	}
}
