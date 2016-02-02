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
