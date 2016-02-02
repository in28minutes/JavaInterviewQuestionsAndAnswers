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
