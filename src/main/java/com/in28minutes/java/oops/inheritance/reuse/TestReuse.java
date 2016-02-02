package com.in28minutes.java.oops.inheritance.reuse;

public class TestReuse {
	public static void main(String[] args) {
		Hero hero = new Hero();
		// act method inherited from Actor
		hero.act();// Act
		hero.fight();// fight

		Comedian comedian = new Comedian();
		// act method inherited from Actor
		comedian.act();// Act
		comedian.performComedy();// Comedy

		// Super class reference variable can hold
		// an object of sub class
		Actor actor1 = new Comedian();
		Actor actor2 = new Hero();

		// Object is super class of all java classes
		Object object = new Hero();
	}
}