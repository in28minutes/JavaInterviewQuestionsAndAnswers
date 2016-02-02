package com.in28minutes.java.flow;

public class SwitchExamples {
	public static void main(String[] args) {
		int number = 2;
		// Output of below switch is 2.
		// The case which is matched is executed.
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		default:
			System.out.println("Default");
			break;
		}

		// Notice that there is not break after each case.
		// If there is no break, then all the case's until we find break are
		// executed.
		number = 2;
		switch (number) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		default:
			System.out.println("Default");
		}
		// Output of above switch is 2 3 Default on separate lines.

		// Notice that there is not break after case 2. So, it fall through
		// to case 3. Prints the statement. After that, the break statement
		// takes the execution out of the switch.
		number = 2;
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
		case 3:
			System.out.println("Number is 2 or 3");
			break;
		default:
			System.out.println("Default");
			break;
		}
		// Output of above switch is Number is 2 or 3.

		// default is executed if none of the case's match
		number = 10;
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		default:
			System.out.println("Default");
			break;
		}
		// Output of above is Default

		// default doesn't need to be the last case in an switch.
		number = 10;
		switch (number) {
		default:
			System.out.println("Default");
			break;
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}
		// Output of above is Default
		// No change in Result

		// Switch can be used only with char, byte, short, int or enum
		long l = 15;
		/*
		 * switch(l){//COMPILER ERROR. Not allowed. }
		 */

		// Case value should be a compile time constant.
		number = 10;
		switch (number) {
		// case number>5://COMPILER ERROR. Cannot have a condition
		// case number://COMPILER ERROR. Should be constant.
		}

	}
}
