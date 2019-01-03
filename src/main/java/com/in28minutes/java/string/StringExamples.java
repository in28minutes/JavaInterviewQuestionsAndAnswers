package com.in28minutes.java.string;

public class StringExamples {
	public static void main(String[] args) {
		// Strings are immutable
		String str3 = "value1";
		str3.concat("value2");
		System.out.println(str3); // value1

		// The result should be assigned to a new reference variable (or same
		// variable) can be reused.
		String concat = str3.concat("value2");
		System.out.println(concat); // value1value2

		// String on Heap.xls
		// A String value once created, cannot be changed.
		// If a method is invoked on string object, it returns a new object and
		// will not modify the original object.

		// All strings literals are stored in "String constant pool".
		// If compiler finds a String literal,it checks if it exists in the
		// pool.
		// If it exists, it is reused.

		// 1 string object (created on the pool) and 1 reference variable
		String str1 = "value";

		// However, if new operator is used to create string object,
		// the new object is created on the heap

		// Following piece of code create 2 objects
		// 1. String Literal "value" - created in the "String constant pool"
		// 2. String Object - created on the heap
		String str2 = new String("value");

		// String methods
		String str = "abcdefghijk";
		// 01234567890

		// char charAt(int paramInt)
		System.out.println(str.charAt(2)); // prints a char - c

		// String concat(String paramString)
		System.out.println(str.concat("lmn"));// abcdefghijklmn

		System.out.println("ABC".equalsIgnoreCase("abc"));// true
		System.out.println("ABCDEFGH".length());// 8

		// String replace(char paramChar1, char paramChar2)
		System.out.println("012301230123".replace('0', '4'));// 412341234123

		// String replace(CharSequence paramCharSequence1, CharSequence
		// paramCharSequence2)
		System.out.println("012301230123".replace("01", "45"));// 452345234523

		// All characters from index paramInt
		// String substring(int paramInt)
		System.out.println("abcdefghij".substring(3)); // defghij
		// 0123456789

		// All characters from index 3 to 6
		System.out.println("abcdefghij".substring(3, 7)); // defg
		// 0123456789

		System.out.println("ABCDEFGHIJ".toLowerCase()); // abcdefghij

		System.out.println("abcdefghij".toUpperCase()); // ABCDEFGHIJ

		System.out.println("abcdefghij".toString()); // abcdefghij

		// trim removes leading and trailings spaces
		System.out.println(" abcd  ".trim()); // abcd
	}
}
