### /com/in28minutes/java/varargs/VariableArgumentExamples.java
```
package com.in28minutes.java.varargs;

//Variable Arguments allow calling a method with different number of parameters.
//Lets look at a basic example:
public class VariableArgumentExamples {

	// int(type) followed ... (three dot's) is syntax of a variable argument.
	public int sum(int... numbers) {
		// inside the method a variable argument is similar to an array.
		// number can be treated as if it is declared as int[] numbers;
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	public static void main(String[] args) {
		VariableArgumentExamples example = new VariableArgumentExamples();
		// 3 Arguments
		System.out.println(example.sum(1, 4, 5));// 10
		// 4 Arguments
		System.out.println(example.sum(1, 4, 5, 20));// 30
		// 0 Arguments
		System.out.println(example.sum());// 0
	}

	// Variable Argument should be always the last parameter (or only parameter)
	// of a method.
	// Below example gives a compilation error
	/*
	 * public int sum(int... numbers, float value) {//COMPILER ERROR }
	 */

	// Even a class can be used a variable argument. In the example below, bark
	// method
	// is overloaded with a variable argument method.
	class Animal {
		void bark() {
			System.out.println("Bark");
		}

		void bark(Animal... animals) {
			for (Animal animal : animals) {
				animal.bark();
			}
		}
	}

}
```
