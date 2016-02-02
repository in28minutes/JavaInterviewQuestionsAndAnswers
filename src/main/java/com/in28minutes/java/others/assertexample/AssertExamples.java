package com.in28minutes.java.others.assertexample;

public class AssertExamples {
	// Assertions are introduced in Java 1.4. They enable you to validate
	// assumptions.
	// If an assert fails (i.e. returns false), AssertionError is thrown (if
	// assertions are enabled).

	// assert is a keyword in java since 1.4. Before 1.4, assert can be used as
	// identifier.
	// To compile code using 1.3 you can use the command below
	// javac -source 1.3 OldCode.java => assert can be used as identifier
	// with -source 1.4,1.5,5,1.6,6 => assert cannot be used as identifier

	// assertions can easily be enabled and disabled.

	// assertions are disabled by default.

	// Enable assertions : java -ea com.rithus.AssertExamples
	// (OR) java -enableassertions com.rithus.AssertExamples

	// Disable assertions : java -da com.rithus.AssertExamples
	// (OR) java -disableassertions com.rithus.AssertExamples

	// Selectively enable assertions in a package only
	// java -ea:com.rithus

	// Selectively enable assertions in a package and its subpackages only
	// java -ea:com.rithus...

	// Enable assertions including system classes
	// java -ea -esa

	// Basic assert is shown in the example below
	private int computerSimpleInterest(int principal, float interest, int years) {
		assert (principal > 0);
		return 100;
	}

	// If needed debugging information can be added to an assert.
	// Look at the example below.
	private int computeCompoundInterest(int principal, float interest, int years) {
		// condition is always boolean
		// second parameter can be anything that converts to a String.
		assert (principal > 0) : "principal is " + principal;
		return 100;
	}

	public static void main(String[] args) {
		AssertExamples examples = new AssertExamples();
		System.out.println(examples.computerSimpleInterest(-1000, 1.0f, 5));
	}

	// Assertions should not be used to validate input data to a public method
	// or command line argument.
	// IllegalArgumentException would be a better option.

	// In public method, only use assertions to check for cases which are never
	// supposed to happen.
}
