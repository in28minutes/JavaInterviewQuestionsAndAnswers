package com.in28minutes.java.others;

public class PrintfExamples {
	public static void main(String[] args) {

		// Let's look at a few examples to quickly understand printf function.
		System.out.printf("%d", 5);// 5
		System.out.printf("My name is %s", "Rithu");// My name is Rithu
		System.out.printf("%s is %d Years old", "Rithu", 5);// Rithu is 5 Years
															// old

		// In the simplest form, string to be formatted starts with % followed
		// by conversion indicator
		// b - boolean c - char d - integer f - floating point s - string.

		// Prints 12 using minimum 5 character spaces.
		System.out.printf("|%5d|", 12); // prints | 12|
		// Prints 1234 using minimum 5 character spaces.
		System.out.printf("|%5d|", 1234); // prints | 1234|
		// In above example 5 is called width specifier.

		// Left Justification can be done by using -
		System.out.printf("|%-5d|", 12); // prints |12 |

		// Using 0 pads the number with 0's
		System.out.printf("%05d", 12); // prints 00012

		// Using , format the number using comma's
		System.out.printf("%,d", 12345); // prints 12,345

		// Using ( prints negative numbers between ( and )
		System.out.printf("%(d", -12345); // prints (12345)
		System.out.printf("%(d", 12345); // prints 12345

		// Using + prints + or - before the number
		System.out.printf("%+d", -12345); // prints -12345
		System.out.printf("%+d", 12345); // prints +12345

		// For floating point numbers, precision can be specified after.
		// Below example uses a precision of 2, so .5678 gets changed to .57
		System.out.printf("%5.2f", 1234.5678); // prints 1234.57

		// An error in specifying would give a RuntimeException
		// In below example a string is passed to %d argument.
		// System.out.printf("%5d","Test");
		// Throws java.util.IllegalFormatConversionException

		// To change the order of printing and passing of arguments, argument
		// index can be used
		System.out.printf("%3$.1f %2$s %1$d", 123, "Test", 123.4); // prints
																	// 123.4
																	// Test 123

		// format method has the same behavior as printf method
		System.out.format("%5.2f", 1234.5678);// prints 1234.57

	}
}
