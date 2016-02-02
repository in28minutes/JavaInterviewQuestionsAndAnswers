### /com/in28minutes/java/operators/IncrementAndDecrementOperators.java
```
package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class IncrementAndDecrementOperators {
	public static void main(String[] args) {
		// Except for a minor difference
		// ++i,i++ is similar to i = i+1
		// --i,i-- is similar to i = i-1
		// ++i is called pre-increment,i++ post increment
		// pre-increment statement returns value after increment
		// post-increment statement returns value before increment
		int i = 25;
		int j = ++i;// i is incremented to 26, assigned to j
		System.out.println(i + " " + j);// 26 26

		i = 25;
		j = i++;// i value(25) is assigned to j, then incremented to 26
		System.out.println(i + " " + j);// 26 25

		i = 25;
		j = --i;// i is decremented to 24, assigned to j
		System.out.println(i + " " + j);// 24 24

		i = 25;
		j = i--;// i value(25) is assigned to j, then decremented to 24
		System.out.println(i + " " + j);// 24 25

		final int k = 100;
		// j=k++;//COMPILER ERROR! Final value cannot be modified

	}
}
```
### /com/in28minutes/java/operators/InstanceOfExamples.java
```
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
```
### /com/in28minutes/java/operators/LogicalOperators.java
```
package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class LogicalOperators {
	public static void main(String[] args) {
		// Short Circuit And Operator - &&
		// True when both operands are true
		System.out.println(true && true);// true
		System.out.println(true && false);// false
		System.out.println(false && true);// false
		System.out.println(false && false);// false

		// Short Circuit Or Operator - ||
		// True when atleast one of operands are true
		System.out.println(true || true);// true
		System.out.println(true || false);// true
		System.out.println(false || true);// true
		System.out.println(false || false);// false

		// Logical Operators work only with boolean's not number's
		// System.out.println(5 || 6);//COMPILER ERROR

		// Short circuit operators are Lazy.
		// They stop execution the moment result is clear.
		// For &&, if first expression is false,result is false.
		// For ||, if first expression is true, the result is true.
		// In above 2 situations, second expressions are not executed.
		int i = 10;
		System.out.println(true || ++i == 11);// true
		System.out.println(false && ++i == 11);// false

		// i remains 10, as ++i expressions are not executed
		System.out.println(i);// 10

		// Logical Operators &, | are similar to &&, || except
		// that they don't short ciruit. They execute the second
		// expression even if the result is clear.

		int j = 10;
		System.out.println(true | ++j == 11);// true
		System.out.println(false & ++j == 12);// false

		// j becomes 12, as both ++j expressions are executed
		System.out.println(j);// 12

		// Operator exclusive-OR
		// Result is true only if one of the operands is true
		System.out.println(true ^ false);// true
		System.out.println(false ^ true);// true
		System.out.println(true ^ true);// false
		System.out.println(false ^ false);// false

		// Not Operator (!)
		// Result is the negation of the expression
		System.out.println(!false);// true
		System.out.println(!true);// false

	}
}
```
### /com/in28minutes/java/operators/RelationalOperators.java
```
package com.in28minutes.java.operators;

public class RelationalOperators {
	public static void main(String[] args) {
		int number = 7;
		// Always return true or false
		// <, <=, >, >=, ==, and !=

		// greater than operator
		System.out.println(number > 5);// true
		System.out.println(number > 7);// false

		// greater than equal to operator
		System.out.println(number >= 7);// true

		// less than operator
		System.out.println(number < 9);// true
		System.out.println(number < 7);// false

		// less than equal to operator
		System.out.println(number <= 7);// true

		// is equal to operator
		System.out.println(number == 7);// true
		System.out.println(number == 9);// false

		// NOT equal to operator
		System.out.println(number != 9);// true
		System.out.println(number != 7);// false

		// NOTE : single = is assignment operator
		// == is comparison. Below statement uses =.
		System.out.println(number = 7);// 7

		// Equality for Primitives only compares values
		int a = 5;
		int b = 5;

		// compares if they have same value
		System.out.println(a == b);// true

		// Equality for Reference Variables.
		Integer aReference = new Integer(5);
		Integer bReference = new Integer(5);

		// compares if they are refering to the same object
		System.out.println(aReference == bReference);// false

		bReference = aReference;
		// Now both are referring to same object
		System.out.println(aReference == bReference);// true
	}
}
```
### /com/in28minutes/java/operators/StringConcatenationExamples.java
```
package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class StringConcatenationExamples {
	public static void main(String[] args) {
		// RULE1 : Expressions are evaluated from left to right.
		// Except if there are parenthesis.
		// RULE2 : number + number = number
		// RULE3 : number + String = String
		System.out.println(5 + "Test" + 5); // 5Test5
		System.out.println(5 + 5 + "Test"); // 10Test
		System.out.println("5" + 5 + "Test"); // 55Test
		System.out.println("5" + "5" + "25"); // 5525
		System.out.println(5 + 5 + "25"); // 1025
		System.out.println("" + 5 + 5 + "25"); // 5525
		System.out.println(5 + (5 + "25")); // 5525
	}
}
```
### /com/in28minutes/java/operators/TernaryOperator.java
```
package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class TernaryOperator {
	public static void main(String[] args) {
		int age = 18;
		// syntax - booleanCondition?ResultIfTrue:ResultIfFalse;
		System.out.println(age >= 18 ? "Can Vote" : "Cannot Vote");// Can Vote

		age = 15;
		System.out.println(age >= 18 ? "Can Vote" : "Cannot Vote");// Cannot
																	// Vote
	}
}
```
