package com.in28minutes.java.oops.inheritance.polymorphism;

class Cat extends Animal {
	// This is method overriding.
	// Method shout in Animal is being overridden.

	// Overriding Class cannot reduce visibility of the method.
	// So, shout method cannot be declared as protected.
	public String shout() {
		return "Meow Meow";
	}
}
