### /com/in28minutes/java/basics/Actor.java
```
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
```
### /com/in28minutes/java/basics/Cricketer.java
```
package com.in28minutes.java.basics;

public class Cricketer {
	String name;
	int odiRuns;
	int testRuns;
	int t20Runs;

	public int totalRuns() {
		int totalRuns = odiRuns + testRuns + t20Runs;
		return totalRuns;
	}
}
```
### /com/in28minutes/java/basics/CricketScorer.java
```
package com.in28minutes.java.basics;

public class CricketScorer {
	// Instance Variables - constitute the state of an object
	private int score;

	// Behavior - all the methods that are part of the class
	// An object of this type has behavior based on the
	// methods four, six and getScore
	public void four() {
		score = score + 4;
	}

	public void six() {
		score = score + 6;
	}

	public int getScore() {
		return score;
	}

	public static void main(String[] args) {
		CricketScorer scorer = new CricketScorer();
		scorer.six();
		// State of scorer is (score => 6)
		scorer.four();
		// State of scorer is (score => 10)
		System.out.println(scorer.getScore());
	}
}
```
