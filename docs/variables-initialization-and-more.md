### /com/in28minutes/java/variables/PassingVariablesToMethods.java
```
package com.in28minutes.java.variables;

public class PassingVariablesToMethods {
	public static void main(String[] args) {
		PassingVariablesToMethods ref = new PassingVariablesToMethods();

		int n = 50;
		ref.incrementBy2(n);
		System.out.println("Passing primitive " + n);// Passing primitive 50

		Cricketer cric = new Cricketer();
		cric.runs = 50;
		ref.modifyCricketer(cric);
		System.out.println("Passing reference variable " + cric.runs);// Passing
																		// reference
																		// variable
																		// 150
	}

	void incrementBy2(int number) {
		number = number + 2;
	}

	void modifyCricketer(Cricketer cricketer) {
		cricketer.runs += 100;
	}
}

class Cricketer {
	String name;
	int runs;
}
```
### /com/in28minutes/java/variables/scope/VariablesExample.java
```
package com.in28minutes.java.variables.scope;

public class VariablesExample {
	// RULE 1:Static Variable can be used anywhere in the class.
	static int staticVariable;

	// RULE 2:Member Variable can be used in any non-static method.
	int memberVariable;

	void method1() {
		// RULE 3: method1LocalVariable can be used only in method1.
		int method1LocalVariable;

		memberVariable = 5;// RULE 2
		staticVariable = 5;// RULE 1

		// Some Code
		{
			// RULE 4:blockVariable can be used only in this block.
			int blockVariable;
			// Some Code
		}

		// blockVariable = 5;//COMPILER ERROR - RULE 4
	}

	void method2() {
		// method1LocalVariable = 5; //COMPILER ERROR - RULE3
	}

	static void staticMethod() {
		staticVariable = 5;// RULE 1
		// memberVariable = 5; //COMPILER ERROR - RULE 2
	}
}
```
### /com/in28minutes/java/variables/StaticAndMemberVariables.java
```
package com.in28minutes.java.variables;

public class StaticAndMemberVariables {
	public static void main(String[] args) {
		Actor actor1 = new Actor();
		actor1.name = "ACTOR1";
		// Actor.name //Compiler Error

		// Below statement can be written as actor1.count++
		// But NOT recommended.
		Actor.count++;

		Actor actor2 = new Actor();
		actor2.name = "ACTOR2";

		// Below statement can be written as actor2.count++
		// But NOT recommended.
		Actor.count++;

		System.out.println(actor1.name);// ACTOR1
		System.out.println(actor2.name);// ACTOR2

		// Next 3 statements refer to same variable
		System.out.println(actor1.count);// 2
		System.out.println(actor2.count);// 2
		System.out.println(Actor.count);// 2
	}
}

class Actor {
	// RULE 1 : Member Variables can be accessed
	// only through object references
	String name;

	// RULE 2:Static Variables can be accessed
	// through a.Class Name and b.Object Reference
	// It is NOT recommended to use object reference
	// to refer to static variables.
	static int count;
}
```
### /com/in28minutes/java/variables/VariableInitialization.java
```
package com.in28minutes.java.variables;

//RULE1 :Member/Static variables are alway initialized with 
//default values.Default values for numeric types is 0, 
//floating point types is 0.0, boolean is false, 
//char  is '\u0000' and object reference variable is null.

//RULE2 :Local/block variables are NOT initialized by compiler. 

//RULE3	:If local variables are used before initialization, 
//it would result in Compilation Error

public class VariableInitialization {
	public static void main(String[] args) {
		Player player = new Player();

		// score is an int member variable - default 0
		System.out.println(player.score);// 0 - RULE1

		// name is a member reference variable - default null
		System.out.println(player.name);// null - RULE1

		int local; // not initialized
		// System.out.println(local);//COMPILER ERROR! RULE3

		String value1;// not initialized
		// System.out.println(value1);//COMPILER ERROR! RULE3

		String value2 = null;// initialized
		System.out.println(value2);// null - NO PROBLEM.
	}
}

class Player {
	String name;
	int score;
}
```
