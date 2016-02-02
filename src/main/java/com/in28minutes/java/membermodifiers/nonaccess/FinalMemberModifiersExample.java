package com.in28minutes.java.membermodifiers.nonaccess;

public class FinalMemberModifiersExample {
	final int FINAL_VALUE = 5;

	final void finalMethod() {
		// final value cannot be modified
		// Below line, uncommented, causes compilation Error
		// FINAL_VALUE = 6;//COMPILER ERROR
	}

	void testMethod(final int finalArgument) {
		// final argument cannot be modified
		// Below line, uncommented, causes compilation Error
		// finalArgument = 5;//COMPILER ERROR
	}
}

class SubClass extends FinalMemberModifiersExample {
	// final method cannot be over-riddent
	// Below method, uncommented, causes compilation Error
	/*
	 * final void finalMethod(){
	 * 
	 * }
	 */
}