package com.in28minutes.java.operators;

public class InstanceOfExamples {
	public static void main(String[] args) {

		// instanceof is used to check if an object is of a particular type.
		SubClass subClass = new SubClass();
		Object subClassObj = new SubClass();

		SubClass2 subClass2 = new SubClass2();
		SomeOtherClass someOtherClass = new SomeOtherClass();

		System.out.println(subClass instanceof SubClass);// true
		System.out.println(subClass instanceof SuperClass);// true
		System.out.println(subClassObj instanceof SuperClass);// true

		System.out.println(subClass2 instanceof SuperClassImplementingInteface);// true

		// Since Super Class implements the interface, this is true
		System.out.println(subClass2 instanceof Interface);// true

		// Compile Error : If the type compared is unrelated
		// System.out.println(subClass
		// instanceof SomeOtherClass);//Compiler Error

		// Object referred by subClassObj(SubClass)-NOT of type SomeOtherClass
		System.out.println(subClassObj instanceof SomeOtherClass);// false

	}
}

class SuperClass {
};

class SubClass extends SuperClass {
};

interface Interface {
};

class SuperClassImplementingInteface implements Interface {
};

class SubClass2 extends SuperClassImplementingInteface {
};

class SomeOtherClass {
};