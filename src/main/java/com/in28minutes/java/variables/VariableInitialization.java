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