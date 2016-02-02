### /com/in28minutes/java/generics/GenericsExamples.java
```
package com.in28minutes.java.generics;

import java.util.ArrayList;

public class GenericsExamples {

	static ArrayList multiplyNumbersBy2(ArrayList numbers) {
		ArrayList result = new ArrayList();

		for (int i = 0; i < numbers.size(); i++) {
			// TYPE CAST is required
			int value = (Integer) numbers.get(i);
			result.add(value * 2);
		}

		return result;
	}

	static void addElement(ArrayList something) {
		something.add(new String("String"));
	}

	public static void main(String[] args) {

		// Older code - Before Java 5
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(6);

		// javac gives warning because multiplyNumbersBy2(ArrayList) is invoked
		// with a Specific ArrayList<Integer>
		// and in the method multiplyNumbersBy2 an element is added to ArrayList
		// com/rithus/generics/GenericsExamples.java uses unchecked or unsafe
		// operations.
		// Recompile with -Xlint:unchecked for details.

		System.out.println(multiplyNumbersBy2(numbers));// [10, 12]

		// javac gives warning because addElement(ArrayList) is invoked with a
		// Specific ArrayList<Integer>
		// and in the method addElement, an element is added to the list.
		// com/rithus/generics/GenericsExamples.java uses unchecked or unsafe
		// operations.
		addElement(numbers);

		// Throws runtime exception - java.lang.ClassCastException
		System.out.println(multiplyNumbersBy2(numbers));

		// New code - After

	}

	// javac -Xlint:unchecked com/rithus/generics/GenericsExamples.java
	// com/rithus/generics/GenericsExamples.java:14: warning: [unchecked]
	// unchecked call to add(E) as a member of the raw type java.util.ArrayList
	// result.add(value * 2);
	// ^
	// com/rithus/generics/GenericsExamples.java:21: warning: [unchecked]
	// unchecked call to add(E) as a member of the raw type java.util.ArrayList
	// something.add(new String("String"));
	// ^
	// 2 warnings

}
```
### /com/in28minutes/java/generics/GenericsExamples2.java
```
package com.in28minutes.java.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

public class GenericsExamples2 {

	static void doSomethingArray(Animal[] animals) {
		// do Something with Animals
	}

	static void doSomethingList(List<Animal> animals) {
		// do Something with Animals
	}

	static void doSomethingListModified(List<? extends Animal> animals) {
		// Adding an element into a list declared with ? is prohibited.

		// animals.add(new Animal());//COMPILER ERROR!
		// animals.add(new Dog());//COMPILER ERROR!
	}

	static void doSomethingListModifiedSuper(List<? super Dog> animals) {
		// Adding an element into a list declared with ? is prohibited.
		// animals.add(new Animal());//COMPILER ERROR!
		// animals.add(new Dog());//COMPILER ERROR!
	}

	/* even for interfaces extends keyword should be used */
	static void doSomethingListInterface(List<? extends Serializable> animals) {
		// Adding an element into a list declared with ? is prohibited.

		// animals.add(new Animal());//COMPILER ERROR!
		// animals.add(new Dog());//COMPILER ERROR!
	}

	public static void main(String[] args) {
		Animal[] animalsArray = { new Animal(), new Dog() };
		Dog[] dogsArray = { new Dog(), new Dog() };

		List<Animal> animalsList = Arrays.asList(animalsArray);
		List<Dog> dogsList = Arrays.asList(dogsArray);

		// Array method can be called with Animal[] or Dog[]
		doSomethingArray(animalsArray);
		doSomethingArray(dogsArray);

		// List method works with List<Animal>
		// Gives compilation error with List<Dog>.
		doSomethingList(animalsList);
		// List<Dog> not compatible with List<Animal>
		// doSomethingList(dogsList);//COMPILER ERROR

		// Method declared with List<? extends Animal> compiles
		// with both List<Animal> and List<Dog>
		doSomethingListModified(animalsList);
		doSomethingListModified(dogsList);

		// Method declared with List<? super Dog> compiles
		// with both List<Animal> and List<Dog>
		// List of any super class of Dog is fine.
		// List of any Subclass of Dog is not valid parameter.
		doSomethingListModifiedSuper(animalsList);
		doSomethingListModifiedSuper(dogsList);

		// A method declared with List<Object> can only be called with a List
		// declared with type Object. None of the other classes are valid.
		// A method declared with List<?> can be called with a List of any type.
		// A method declared with List<? extends Object> can be called with a
		// List of any type - since all classes are sub classes of Object.

		// ? can only be used in Declaring a type. Cannot be used as part of
		// definition.
		List<? extends Animal> listAnimals = new ArrayList<Dog>(); // COMPILES
		// List<?> genericList = new ArrayList<? extends Animal>(); //COMPILER
		// ERROR
	}

}
```
### /com/in28minutes/java/generics/GenericsExamples3.java
```
package com.in28minutes.java.generics;

import java.util.List;

class MyList {
	private List<String> values;

	void add(String value) {
		values.add(value);
	}

	void remove(String value) {
		values.remove(value);
	}
}

class MyListGeneric<T> {
	private List<T> values;

	void add(T value) {
		values.add(value);
	}

	void remove(T value) {
		values.remove(value);
	}

	T get(int index) {
		return values.get(index);
	}
}

class MyListRestricted<T extends Number> {
	private List<T> values;

	void add(T value) {
		values.add(value);
	}

	void remove(T value) {
		values.remove(value);
	}

	T get(int index) {
		return values.get(index);
	}
}

public class GenericsExamples3 {

	static <X extends Number> X doSomething(X number) {
		X result = number;
		// do something with result
		return result;
	}

	public static void main(String[] args) {

		// MyList can be used to store a list of Strings only.
		MyList myList = new MyList();
		myList.add("Value 1");
		myList.add("Value 2");

		// If I would want to create MyList accepting Integer's, I would need to
		// create a new Class.

		// Solution to this Problem is generics.
		// Replace String with T and create a new class MyListGeneric.

		// Note the declaration of the class "class MyListGeneric<T>".
		// Instead of T, We can use any valid identifier(ofcourse the same
		// identifier everywhere)

		// If a generic is declared as part of class declaration, it can be used
		// any where a type can be used in a class - method (return type or
		// argument), member variable etc.

		// Now the MyListGeneric class can be used to create a list of Integers
		// or a list of Strings
		MyListGeneric<String> myListString = new MyListGeneric<String>();
		myListString.add("Value 1");
		myListString.add("Value 2");

		MyListGeneric<Integer> myListInteger = new MyListGeneric<Integer>();
		myListInteger.add(1);
		myListInteger.add(2);

		// In MyListGeneric, Type P is defined as part of class declaration. Any
		// Java Type can be used a type for this class.
		// If we would want to restrict the types allowed for a Generic Type, we
		// can use a Generic Restriction

		// In declaration of the class, we specified a constraint
		// "T extends Number"
		// class MyListRestricted<T extends Number>
		// Now, we can use the class MyListRestricted with any class extending
		// Number - Float, Integer, Double etc.

		// String not valid substitute for constraint "T extends Number"
		// MyListRestricted<String> restrictedStringList =
		// new MyListRestricted<String>();//COMPILER ERROR
		MyListRestricted<Integer> restrictedListInteger = new MyListRestricted<Integer>();
		restrictedListInteger.add(1);
		restrictedListInteger.add(2);

		// A generic type can be declared as part of method declaration as well.
		// Then the generic type can be used anywhere in the method (return
		// type, parameter type, local or block variable type)
		Integer i = 5;
		Integer k = doSomething(i);
	}
}
```
