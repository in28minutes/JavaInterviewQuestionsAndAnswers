package com.in28minutes.java.flow;

public class BreakExamples {
	public static void main(String[] args) {
		// Break statement breaks out of the loop
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			if (i == 5) {
				break;
			}
		}
		// Output is 012345

		// Break can be used in a while also
		int i = 0;
		while (i < 10) {
			System.out.print(i);
			if (i == 5) {
				break;
			}
			i++;
		}
		// Output is 012345

		System.out.println();

		// Break statement takes execution out of inner most loop
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(j + "" + k);
				if (k == 5) {
					break;// Takes out of loop using k
				}
			}
		}
		// Output is 000102030405101112131415

		System.out.println();

		// To get out of an outer for loop, label's need to be used
		outer: for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(j + "" + k);
				if (k == 5) {
					break outer;// Takes out of loop using j
				}
			}
		}
		// Output is 000102030405
	}
}
