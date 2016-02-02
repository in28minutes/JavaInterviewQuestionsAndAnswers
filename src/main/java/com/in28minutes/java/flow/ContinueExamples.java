package com.in28minutes.java.flow;

public class ContinueExamples {
	public static void main(String[] args) {
		// Continue statement skips rest of the statements in the loop
		// and starts next iteration
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i);
		}
		// Output is 012346789
		// Not that the output does not contain 5

		System.out.println();

		// Continue can be used in a while also
		int i = 0;
		while (i < 10) {
			i++;
			if (i == 5) {
				continue;
			}
			System.out.print(i);
		}
		// Output is 1234678910
		// Not that the output does not contain 5

		System.out.println();

		// Continue statement takes execution to next iteration of inner most
		// loop
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue;// skips to next iteration of k loop
				}
				System.out.print(j + "" + k);
			}
		}
		// Output is 000102030406070809101112131416171819
		// Not that the output does not contain 05,15

		System.out.println();

		// To get out of an outer for loop, label's need to be used
		outer: for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue outer;// skips to next iteration of j loop
				}
				System.out.print(j + "" + k);
			}
		}
		// Output is 00010203041011121314
		// Not that the output does not contain anything after 05 and also 15
	}
}
