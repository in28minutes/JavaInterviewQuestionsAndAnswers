package com.in28minutes.java.oops.inheritance.overloading;

public class OverloadingRules {
}

class Foo {
	public void doIt(int number) {
		System.out.println("test");
	}
}

class Bar extends Foo {
	public void doIt(String str) {
		System.out.println("test");
	}
}