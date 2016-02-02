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