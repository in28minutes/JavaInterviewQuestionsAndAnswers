package com.in28minutes.java.object;

class Animal {

	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
	}

	String name;
	String type;
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", type=" + type + "]";
	}	
}

public class ToStringExamples {
	public static void main(String[] args) {
		Animal animal = new Animal("Tommy", "Dog");
		System.out.println(animal);// Animal [name=Tommy, type=Dog]
	}
}
