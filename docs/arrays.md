## Examples
### /com/in28minutes/java/arrays/ArrayExamples.java
```
package com.in28minutes.java.arrays;

import java.util.Arrays;

public class ArrayExamples {
	public static void main(String[] args) {
		// Declare an Array. All below ways are legal.
		int marks[]; // Not Readable
		int[] runs; // Not Readable
		int[] temperatures;// Recommended

		// Declaration of an Array should not include size.
		// int values[5];//Compilation Error!

		// Declaring 2D ArrayExamples
		int[][] matrix1; // Recommended
		int[] matrix2[]; // Legal but not readable. Avoid.

		// Creating an array
		marks = new int[5]; // 5 is size of array

		// Size of an array is mandatory to create an array
		// marks = new int[];//COMPILER ERROR

		// Once An Array is created, its size cannot be changed.

		// Declaring and creating an array in same line
		int marks2[] = new int[5];

		// new Arrays are alway initialized with default values
		System.out.println(marks2[0]);// 0

		// Default Values
		// byte,short,int,long-0
		// float,double-0.0
		// boolean false
		// object-null

		// Assigning values to array
		marks[0] = 25;
		marks[1] = 30;
		marks[2] = 50;
		marks[3] = 10;
		marks[4] = 5;

		// ArrayOnHeap.xls

		// Note : Index of an array runs from 0 to length - 1

		// Declare, Create and Initialize Array on same line
		int marks3[] = { 25, 30, 50, 10, 5 };

		// Leaving additional comma is not a problem
		int marks4[] = { 25, 30, 50, 10, 5, };

		// Default Values in Array
		// numbers - 0 floating point - 0.0 Objects - null

		// Length of an array : Property length
		int length = marks.length;

		// Printing a value from array
		System.out.println(marks[2]);

		// Looping around an array - Enhanced for loop
		for (int mark : marks) {
			System.out.println(mark);
		}

		// Fill array with same default value
		Arrays.fill(marks, 100); // All array values will be 100

		// Access 10th element when array has only length 5
		// Runtime Exception : ArrayIndexOutOfBoundsException
		// System.out.println(marks[10]);

		// String Array: similar to int array.
		String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };

		// Array can contain only values of same type.
		// COMPILE ERROR!!
		// int marks4[] = {10,15.0}; //10 is int 15.0 is float

		// Cross assigment of primitive arrays is ILLEGAL
		int[] ints = new int[5];
		short[] shorts = new short[5];
		// ints = shorts;//COMPILER ERROR
		// ints = (int[])shorts;//COMPILER ERROR

		// 2D Arrays
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };

		int[][] matrixA = new int[5][6];

		// First dimension is necessary to create a 2D Array
		// Best way to visualize a 2D array is as an array of arrays
		// ArrayOnHeap.xls
		matrixA = new int[3][];// FINE
		// matrixA = new int[][5];//COMPILER ERROR
		// matrixA = new int[][];//COMPILER ERROR

		// We can create a ragged 2D Array
		matrixA[0] = new int[3];
		matrixA[0] = new int[4];
		matrixA[0] = new int[5];

		// Above matrix has 2 rows 3 columns.

		// Accessing an element from 2D array:
		System.out.println(matrix[0][0]); // 1
		System.out.println(matrix[1][2]); // 6

		// Looping a 2D array:
		for (int[] array : matrix) {
			for (int number : array) {
				System.out.println(number);
			}
		}

		// Printing a 1D Array
		int marks5[] = { 25, 30, 50, 10, 5 };
		System.out.println(marks5); // [I@6db3f829
		System.out.println(Arrays.toString(marks5));// [25, 30, 50, 10, 5]

		// Printing a 2D Array
		int[][] matrix3 = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(matrix3); // [[I@1d5a0305
		System.out.println(Arrays.toString(matrix3));
		// [[I@6db3f829, [I@42698403]
		System.out.println(Arrays.deepToString(matrix3));
		// [[1, 2, 3], [4, 5, 6]]

		// matrix3[0] is a 1D Array
		System.out.println(matrix3[0]);// [I@86c347
		System.out.println(Arrays.toString(matrix3[0]));// [1, 2, 3]

		// Comparing Arrays
		int[] numbers1 = { 1, 2, 3 };
		int[] numbers2 = { 4, 5, 6 };
		System.out.println(Arrays.equals(numbers1, numbers2)); // false
		int[] numbers3 = { 1, 2, 3 };
		System.out.println(Arrays.equals(numbers1, numbers3)); // true

		// Sorting An Array
		int rollNos[] = { 12, 5, 7, 9 };
		Arrays.sort(rollNos);
		System.out.println(Arrays.toString(rollNos));// [5, 7, 9, 12]

		// Array of Objects(ArrayOnHeap.xls)
		Person[] persons = new Person[3];

		// Creating an array of Persons creates
		// 4 Reference Variables to Person
		// It does not create the Person Objects
		// ArrayOnHeap.xls
		System.out.println(persons[0]);// null

		// to assign objects we would need to create them
		persons[0] = new Person();
		persons[1] = new Person();
		persons[2] = new Person();

		// Other way
		// How may objects are created?
		Person[] personsAgain = { new Person(), new Person(), new Person() };

		// How may objects are created?
		Person[][] persons2D = { { new Person(), new Person(), new Person() },
				{ new Person(), new Person() } };

	}
}

class Person {
	long ssn;
	String name;
}
```
