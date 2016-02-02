package com.in28minutes.java.oops.inheritance;

//Every Java class extends Object class
public class EveryClassExtendsObject {
	public void testMethod() throws CloneNotSupportedException {
		// toString,hashCode,clone methods are
		// inherited from Object class
		System.out.println(this.toString());
		System.out.println(this.hashCode());
		System.out.println(this.clone());
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		EveryClassExtendsObject example1 = new EveryClassExtendsObject();

		EveryClassExtendsObject example2 = new EveryClassExtendsObject();

		if (example1 instanceof Object) {
			System.out.println("I extend Object");// Will be printed
		}

		// equals method is inherited from Object class
		System.out.println(example1.equals(example2));// false

	}
}
