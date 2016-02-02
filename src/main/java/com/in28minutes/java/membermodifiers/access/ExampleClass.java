package com.in28minutes.java.membermodifiers.access;

public class ExampleClass {
	int defaultVariable;
	public int publicVariable;
	private int privateVariable;
	protected int protectedVariable;

	void defaultMethod() {
		privateVariable = 5;
	}

	public void publicMethod() {

	}

	private void privateMethod() {

	}

	protected void protectedMethod() {

	}
}