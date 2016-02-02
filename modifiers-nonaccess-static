### /com/in28minutes/java/membermodifiers/nonaccess/StaticModifierExamples.java
```
package com.in28minutes.java.membermodifiers.nonaccess;

class Cricketer {
	private static int count;

	public Cricketer() {
		count++;
	}

	static int getCount() {
		return count;
	}
}

class Animal {
	static void StaticMethod() {
		System.out.println("Animal Static Method");
	}
}

class Dog extends Animal {
	static void StaticMethod() {
		System.out.println("Dog Static Method");
	}
}

public class StaticModifierExamples {
	private static int staticVariable;
	private int instanceVariable;

	public static void staticMethod() {
		// instance variables are not accessible in static methods
		// instanceVariable = 10; //COMPILER ERROR

		// Also, this Keyword is not accessible.this refers to object.
		// static methods are class methods

		// static variables are accessible in static methods
		staticVariable = 10;
	}

	public void instanceMethod() {
		// static and instance variables are accessible in instance methods
		instanceVariable = 10;
		staticVariable = 10;
	}

	public static void main(String[] args) {
		// static int i =5; //COMPILER ERROR
		StaticModifierExamples example = new StaticModifierExamples();

		// instance variables and methods are only accessible through object
		// references
		example.instanceVariable = 10;
		example.instanceMethod();
		// StaticModifierExamples.instanceVariable = 10;//COMPILER ERROR
		// StaticModifierExamples.instanceMethod();//COMPILER ERROR

		// static variables and methods are accessible through object references
		// and Class Name.
		example.staticVariable = 10;
		example.staticMethod();
		StaticModifierExamples.staticVariable = 10;
		StaticModifierExamples.staticMethod();

		// It is always recommended to use Class Name to access a static
		// variable or method.
		// This is because static methods are class level methods. It is not
		// appropriate
		// to use instance references to call static methods (even though it
		// compiles and works).

		Cricketer cricketer1 = new Cricketer();
		Cricketer cricketer2 = new Cricketer();
		Cricketer cricketer3 = new Cricketer();
		Cricketer cricketer4 = new Cricketer();

		System.out.println(Cricketer.getCount());// 4

		Animal animal = new Dog();
		animal.StaticMethod();// Animal Static Method

	}
}
```
