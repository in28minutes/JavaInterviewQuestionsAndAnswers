### /com/in28minutes/java/oops/inheritance/EveryClassExtendsObject.java
```
package com.in28minutes.java.oops.inheritance;

//Every Java class extends Object class
public class EveryClassExtendsObject {
	public void testMethod() throws CloneNotSupportedException {
		// toString,hashCode,clone methods are
		// inherited from Object class
		System.out.println(this.toString());
		System.out.println(this.hashCode());
		System.out.println(this.clone());
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		EveryClassExtendsObject example1 = new EveryClassExtendsObject();

		EveryClassExtendsObject example2 = new EveryClassExtendsObject();

		if (example1 instanceof Object) {
			System.out.println("I extend Object");// Will be printed
		}

		// equals method is inherited from Object class
		System.out.println(example1.equals(example2));// false

	}
}
```
### /com/in28minutes/java/oops/inheritance/InheritanceExamples.java
```
package com.in28minutes.java.oops.inheritance;

abstract class Animal {
	String name;

	// cool functionality
	abstract String bark();
}

class Dog extends Animal {
	String bark() {
		return "Bow Bow";
	}
}

class Cat extends Animal {
	String bark() {
		return "Meow Meow";
	}
}

public class InheritanceExamples {
	public static void main(String[] args) {
		Animal animal = new Cat();
		System.out.println(animal.bark());
	}
}
```
### /com/in28minutes/java/oops/inheritance/overloading/OverloadingRules.java
```
package com.in28minutes.java.oops.inheritance.overloading;

public class OverloadingRules {
}

class Foo {
	public void doIt(int number) {
		System.out.println("test");
	}
}

class Bar extends Foo {
	public void doIt(String str) {
		System.out.println("test");
	}
}
```
### /com/in28minutes/java/oops/inheritance/overriding/OverridingRules.java
```
package com.in28minutes.java.oops.inheritance.overriding;

import java.io.FileNotFoundException;

public class OverridingRules {
}

class SuperClass {
	public void publicMethod() throws FileNotFoundException {

	}

	void protectedMethod() {

	}
}

class SubClass {
	// Cannot reduce visibility of SuperClass Method
	// So, only option is public
	// Cannot throw bigger exceptions than Super Class
	public void publicMethod() /* throws IOException */{

	}

	// Can be overridden with public,(default) or protected
	// private would give COMPILE ERROR!
	public void protectedMethod() {

	}

}
```
### /com/in28minutes/java/oops/inheritance/polymorphism/Animal.java
```
package com.in28minutes.java.oops.inheritance.polymorphism;

public class Animal {
	public String shout() {
		return "Don't Know!";
	}
}
```
### /com/in28minutes/java/oops/inheritance/polymorphism/Cat.java
```
package com.in28minutes.java.oops.inheritance.polymorphism;

class Cat extends Animal {
	// This is method overriding.
	// Method shout in Animal is being overridden.

	// Overriding Class cannot reduce visibility of the method.
	// So, shout method cannot be declared as protected.
	public String shout() {
		return "Meow Meow";
	}
}
```
### /com/in28minutes/java/oops/inheritance/polymorphism/Dog.java
```
package com.in28minutes.java.oops.inheritance.polymorphism;

class Dog extends Animal {
	public String shout() {
		return "BOW BOW";
	}

	public void run() {

	}
}
```
### /com/in28minutes/java/oops/inheritance/polymorphism/TestPolymorphism.java
```
package com.in28minutes.java.oops.inheritance.polymorphism;

public class TestPolymorphism {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		System.out.println(animal1.shout()); // Don't Know!

		Animal animal2 = new Dog();

		// Reference variable type => Animal
		// Object referred to => Dog
		// Dog's bark method is called.
		System.out.println(animal2.shout()); // BOW BOW

		// Even though dog has a method run,it cannot be
		// invoked using super class reference variable
		// animal2.run();//COMPILE ERROR
	}
}
```
### /com/in28minutes/java/oops/inheritance/reuse/Actor.java
```
package com.in28minutes.java.oops.inheritance.reuse;

public class Actor {
	public void act() {
		System.out.println("Act");
	};
}
```
### /com/in28minutes/java/oops/inheritance/reuse/Comedian.java
```
package com.in28minutes.java.oops.inheritance.reuse;

//IS-A relationship. Comedian is-a Actor
public class Comedian extends Actor {
	public void performComedy() {
		System.out.println("Comedy");
	};
}
```
### /com/in28minutes/java/oops/inheritance/reuse/Hero.java
```
package com.in28minutes.java.oops.inheritance.reuse;

//IS-A relationship. Hero is-a Actor
public class Hero extends Actor {
	public void fight() {
		System.out.println("fight");
	};
}
```
### /com/in28minutes/java/oops/inheritance/reuse/TestReuse.java
```
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
```
