package com.in28minutes.java.basics;

public class Actor {

	// name is a Member Variable
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// This is called shadowing
		// Local variable or parameter with
		// same name as a member variable
		// this.name refers to member variable
		// name refers to local variable
		this.name = name;
	}

	public static void main(String[] args) {
		// bradPitt & tomCruise are objects or instances
		// of Class Actor
		// Each instance has separate value for the
		// member variable name
		Actor bradPitt = new Actor();
		bradPitt.setName("Brad Pitt");

		Actor tomCruise = new Actor();
		tomCruise.setName("Tom Cruise");
	}
}
