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
