### /com/in28minutes/java/serialization/SerializationExamples.java
```
package com.in28minutes.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Rectangle implements Serializable {
	public Rectangle(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
		area = length * breadth;
	}

	int length;
	int breadth;
	transient int area;

	private void writeObject(ObjectOutputStream os) throws IOException {
		// Do whatever java does usually when serialization is called
		os.defaultWriteObject();
	}

	private void readObject(ObjectInputStream is) throws IOException,
			ClassNotFoundException {
		// Do whatever java does usually when de-serialization is called
		is.defaultReadObject();
		// In addition, calculate area also
		area = this.length * this.breadth;
	}
}

public class SerializationExamples {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// Serialization helps us to save and retrieve the state of an object.
		// Serialization => Convert object state to some internal object
		// representation.
		// De-Serialization => The reverse. Convert internal representation to
		// object.
		// Two important methods
		// ObjectOutputStream.writeObject() // serialize and write to file
		// ObjectInputStream.readObject() // read from file and deserialize

		// To serialize an object it should implement Serializable interface
		// class Rectangle implements Serializable

		// Serializing an object
		FileOutputStream fileStream = new FileOutputStream("Rectangle.ser");
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		objectStream.writeObject(new Rectangle(5, 6));
		objectStream.close();

		// Deserializing an object
		FileInputStream fileInputStream = new FileInputStream("Rectangle.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(
				fileInputStream);
		Rectangle rectangle = (Rectangle) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(rectangle.length);// 5
		System.out.println(rectangle.breadth);// 6
		System.out.println(rectangle.area);// 30
	}
}
```
### /com/in28minutes/java/serialization/SerializationExamples2.java
```
package com.in28minutes.java.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class House implements Serializable {
	public House(int number) {
		super();
		this.number = number;
	}

	Wall wall;
	int number;
}

class Wall implements Serializable {
	int length;
	int breadth;
	int color;
}

public class SerializationExamples2 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fileStream = new FileOutputStream("House.ser");
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		House house = new House(10);
		house.wall = new Wall();
		// Exception in thread "main" java.io.NotSerializableException:
		// com.rithus.serialization.Wall
		objectStream.writeObject(house);
		objectStream.close();
	}
}
```
### /com/in28minutes/java/serialization/SerializationExamples3.java
```
package com.in28minutes.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Actor {
	String name;

	Actor() {
		name = "Default";
	}
}

class Hero extends Actor implements Serializable {
	String danceType;

	Hero() {
		danceType = "Default";
	}
}

public class SerializationExamples3 {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FileOutputStream fileStream = new FileOutputStream("Hero.ser");
		ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

		Hero hero = new Hero();
		hero.danceType = "Ganganam";
		hero.name = "Hero1";

		// Before -> DanceType :Ganganam Name:Hero1
		System.out.println("Before -> DanceType :" + hero.danceType + " Name:"
				+ hero.name);
		// Exception in thread "main" java.io.NotSerializableException:
		// com.rithus.serialization.Wall
		objectStream.writeObject(hero);
		objectStream.close();

		FileInputStream fileInputStream = new FileInputStream("Hero.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(
				fileInputStream);
		hero = (Hero) objectInputStream.readObject();
		objectInputStream.close();

		// When subclass is serializable and superclass is not, the state of
		// subclass variables is retained. However, for the super class,
		// initialization
		// constructors and initializers are run again.
		// After -> DanceType :Ganganam Name:Default
		System.out.println("After -> DanceType :" + hero.danceType + " Name:"
				+ hero.name);
	}
}
```
