package com.in28minutes.java.files;

import java.io.Console;
import java.io.IOException;

public class ConsoleExamples {
	public static void main(String[] args) throws IOException {

		// Console is used to read input from keyboard and write output
		// This can be easily run from command prompt

		// Console console = new Console(); //COMPILER ERROR
		Console console = System.console();
		console.printf("Enter a Line of Text");

		String text = console.readLine();
		console.printf("Enter a Password");

		// Doesn't show what is being entered
		char[] password = console.readPassword();

		console.format("\nEntered Text is %s", text);
	}
}
