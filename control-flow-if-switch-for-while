### /com/in28minutes/java/flow/BreakExamples.java
```
package com.in28minutes.java.flow;

public class BreakExamples {
	public static void main(String[] args) {
		// Break statement breaks out of the loop
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			if (i == 5) {
				break;
			}
		}
		// Output is 012345

		// Break can be used in a while also
		int i = 0;
		while (i < 10) {
			System.out.print(i);
			if (i == 5) {
				break;
			}
			i++;
		}
		// Output is 012345

		System.out.println();

		// Break statement takes execution out of inner most loop
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(j + "" + k);
				if (k == 5) {
					break;// Takes out of loop using k
				}
			}
		}
		// Output is 000102030405101112131415

		System.out.println();

		// To get out of an outer for loop, label's need to be used
		outer: for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(j + "" + k);
				if (k == 5) {
					break outer;// Takes out of loop using j
				}
			}
		}
		// Output is 000102030405
	}
}
```
### /com/in28minutes/java/flow/ContinueExamples.java
```
package com.in28minutes.java.flow;

public class ContinueExamples {
	public static void main(String[] args) {
		// Continue statement skips rest of the statements in the loop
		// and starts next iteration
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i);
		}
		// Output is 012346789
		// Not that the output does not contain 5

		System.out.println();

		// Continue can be used in a while also
		int i = 0;
		while (i < 10) {
			i++;
			if (i == 5) {
				continue;
			}
			System.out.print(i);
		}
		// Output is 1234678910
		// Not that the output does not contain 5

		System.out.println();

		// Continue statement takes execution to next iteration of inner most
		// loop
		for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue;// skips to next iteration of k loop
				}
				System.out.print(j + "" + k);
			}
		}
		// Output is 000102030406070809101112131416171819
		// Not that the output does not contain 05,15

		System.out.println();

		// To get out of an outer for loop, label's need to be used
		outer: for (int j = 0; j < 2; j++) {
			for (int k = 0; k < 10; k++) {
				if (k == 5) {
					continue outer;// skips to next iteration of j loop
				}
				System.out.print(j + "" + k);
			}
		}
		// Output is 00010203041011121314
		// Not that the output does not contain anything after 05 and also 15
	}
}
```
### /com/in28minutes/java/flow/DoWhileLoopExamples.java
```
package com.in28minutes.java.flow;

public class DoWhileLoopExamples {
	public static void main(String[] args) {
		int count = 0;
		// do while also is used when it is not clear how many times loop has to
		// be executed.
		do {
			System.out.print(count);
			count++;
		} while (count < 5);// while this condn is true, loop is executed.
		// output is 01234

		// Code in do while is executed atleast once.
		count = 5;
		do {
			System.out.print(count);
			count++;
		} while (count < 5);
		// output is 5
	}
}
```
### /com/in28minutes/java/flow/ForLoopExample.java
```
package com.in28minutes.java.flow;

public class ForLoopExample {
	public static void main(String[] args) {
		// Example of a For Loop
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		// Output is 0123456789

		// For loop statement has 3 parts
		// Initialization => int i=0
		// Condition => i<10
		// Operation (Increment or Decrement usually) => i++

		// There can be multiple statements in Initialization
		// or Operation seperated by commas
		for (int i = 0, j = 0; i < 10; i++, j--) {
			System.out.print(j);
		}
		// Output is 0-1-2-3-4-5-6-7-8-9

		// Enhanced For Loop
		int[] numbers = { 1, 2, 3, 4, 5 };

		for (int number : numbers) {
			System.out.print(number);
		}
		// Output is 12345

		// Any of 3 parts in a for can be empty
		for (;;) {
			System.out.print("I will be looping for ever..");
		}
		// Result : Infinite loop

	}
}
```
### /com/in28minutes/java/flow/IfElseExamples.java
```
package com.in28minutes.java.flow;

public class IfElseExamples {
	public static void main(String[] args) {

		// Code inside If is executed only if the condition is true
		if (true) {
			System.out.println("Will be printed");
		}

		// Statement inside this condition is not executed
		if (false) {
			System.out.println("Will NOT be printed");// Not executed
		}

		// Lets look at an example
		int x = 5;

		if (x == 5) {
			System.out.println("x is 5");// executed since x==5 is true
		}

		x = 6;
		if (x == 5) {
			System.out.println("x is 5");// Not executed since x==5 is false
		}

		// If Else
		// If condition is true code in if is executed, else code in else is
		// executed

		int y = 10;

		if (y == 10) {
			System.out.println("Y is 10");// executed-condn y==10 is true
		} else {
			System.out.println("Y is Not 10");
		}

		y = 11;

		if (y == 10) {
			System.out.println("Y is 10");// NOT executed
		} else {
			System.out.println("Y is Not 10");// executed-condn y==10 is false
		}

		// Nested else if
		// The code in the first if condition that is true is executed.
		// If none of the if conditions are true, then code in else is executed.
		int z = 15;
		if (z == 10) {
			System.out.println("Z is 10");// NOT executed
		} else if (z == 12) {
			System.out.println("Z is 12");// NOT executed
		} else if (z == 15) {
			System.out.println("Z is 15");// executed. Rest of the if else are
											// skipped.
		} else {
			System.out.println("Z is Something Else.");// NOT executed
		}

		z = 18;
		if (z == 10) {
			System.out.println("Z is 10");// NOT executed
		} else if (z == 12) {
			System.out.println("Z is 12");// NOT executed
		} else if (z == 15) {
			System.out.println("Z is 15");// NOT executed
		} else {
			System.out.println("Z is Something Else.");// executed
		}

		// Be very careful with formatting
		int number = 5;
		if (number < 0) // condn is false. So the line in if is not executed.
			number = number + 10; // Not executed
		number++; // This statement is not part of if
		System.out.println(number);// prints 6

		// Guess the output
		int k = 15;
		if (k > 20) {
			System.out.println(1);
		} else if (k > 10) {
			System.out.println(2);
		} else if (k < 20) {
			System.out.println(3);
		} else {
			System.out.println(4);
		}
		// Output is 2. Once a condition in nested-if-else is true the rest of
		// the code is not executed.

		// Guess the output
		int l = 15;

		if (l < 20)
			System.out.println("l<20");
		if (l > 20)
			System.out.println("l>20");
		else
			System.out.println("Who am I?");
		// Output is "l<20" followed by "Who am I?" on next line.
		// else belong to the last if before it unless brackets ({}) are used.

		// Guess the output
		int m = 15;

		if (m > 20)
			if (m < 20)
				System.out.println("m>20");
			else
				System.out.println("Who am I?");
		// Nothing is printed to output. Above code is similar to code below
		if (m > 20) {// Condn is false. So, code in if is not executed
			if (m < 20)
				System.out.println("m>20");
			else
				System.out.println("Who am I?");
		}

		int x1 = 0;
		// Condition in if should always be boolean
		// if(x1) {} //COMPILER ERROR
		// if(x1=0) {}//COMPILER ERROR. Using = instead of ==

		boolean isTrue = false;
		if (isTrue == true) {
			System.out.println("TRUE TRUE");// Will not be printed
		}
		if (isTrue = true) {
			System.out.println("TRUE");// Will be printed.
		}
		// Condition is isTrue=true. This is assignment. Returns true. So, code
		// in if is executed.
	}
}
```
### /com/in28minutes/java/flow/SwitchExamples.java
```
package com.in28minutes.java.flow;

public class SwitchExamples {
	public static void main(String[] args) {
		int number = 2;
		// Output of below switch is 2.
		// The case which is matched is executed.
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		default:
			System.out.println("Default");
			break;
		}

		// Notice that there is not break after each case.
		// If there is no break, then all the case's until we find break are
		// executed.
		number = 2;
		switch (number) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		default:
			System.out.println("Default");
		}
		// Output of above switch is 2 3 Default on separate lines.

		// Notice that there is not break after case 2. So, it fall through
		// to case 3. Prints the statement. After that, the break statement
		// takes the execution out of the switch.
		number = 2;
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
		case 3:
			System.out.println("Number is 2 or 3");
			break;
		default:
			System.out.println("Default");
			break;
		}
		// Output of above switch is Number is 2 or 3.

		// default is executed if none of the case's match
		number = 10;
		switch (number) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		default:
			System.out.println("Default");
			break;
		}
		// Output of above is Default

		// default doesn't need to be the last case in an switch.
		number = 10;
		switch (number) {
		default:
			System.out.println("Default");
			break;
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}
		// Output of above is Default
		// No change in Result

		// Switch can be used only with char, byte, short, int or enum
		long l = 15;
		/*
		 * switch(l){//COMPILER ERROR. Not allowed. }
		 */

		// Case value should be a compile time constant.
		number = 10;
		switch (number) {
		// case number>5://COMPILER ERROR. Cannot have a condition
		// case number://COMPILER ERROR. Should be constant.
		}

	}
}
```
### /com/in28minutes/java/flow/WhileLoopExamples.java
```
package com.in28minutes.java.flow;

public class WhileLoopExamples {
	public static void main(String[] args) {
		int count = 0;
		// While is used when it is not clear how many times loop has to be
		// executed.
		while (count < 5) {// while this condn is true, loop is executed.
			System.out.print(count);
			count++;
		}// output is 01234

		// Depending on the condition, code in while might not be executed at
		// all.
		count = 5;
		while (count < 5) {// condn is false. So, code in while is not executed.
			System.out.print(count);
			count++;
		}// Nothing is printed to output

	}
}
```