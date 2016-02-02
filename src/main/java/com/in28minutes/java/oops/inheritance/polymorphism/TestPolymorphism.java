package com.in28minutes.java.oops.inheritance.polymorphism;

public class TestPolymorphism {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		System.out.println(animal1.shout()); // Don't Know!

		Animal animal2 = new Dog();

		// Reference variable type => Animal
		// Object referred to => Dog
		// Dog's bark method is called.
		System.out.println(animal2.shout()); // BOW BOW

		// Even though dog has a method run,it cannot be
		// invoked using super class reference variable
		// animal2.run();//COMPILE ERROR
	}
}