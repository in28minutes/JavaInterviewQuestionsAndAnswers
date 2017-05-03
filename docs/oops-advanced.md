### /com/in28minutes/java/oops/cohesion/problem/CohesionExampleProblem.java
```
package com.in28minutes.java.oops.cohesion.problem;

//Cohesion is a measure of how related the responsibilities of a class are.
//This class is downloading from internet, parsing data and storing data to database.
//The responsibilities of this class are not really related. This is not cohesive class.
class DownloadAndStore {
	void downloadFromInternet() {

	}

	void parseData() {

	}

	void storeIntoDatabase() {

	}

	void doEverything() {
		downloadFromInternet();
		parseData();
		storeIntoDatabase();
	}
}

public class CohesionExampleProblem {

}
```
### /com/in28minutes/java/oops/cohesion/solution/CohesionExampleSolution.java
```
package com.in28minutes.java.oops.cohesion.solution;

//This is a better way of approaching the problem. Different classes have their
//own responsibilities.

class InternetDownloader {
	public void downloadFromInternet() {

	}
}

class DataParser {
	public void parseData(String content) {
	}
}

class DatabaseStorer {
	public void storeIntoDatabase(String data) {
	}
}

class DownloadAndStore {
	void doEverything() {
		new InternetDownloader().downloadFromInternet();
		new DataParser().parseData("");
		new DatabaseStorer().storeIntoDatabase("");
	}
}

public class CohesionExampleSolution {

}
```
### /com/in28minutes/java/oops/coupling/problem/CouplingExamplesProblem.java
```
package com.in28minutes.java.oops.coupling.problem;

//Coupling is a measure of how much a class is dependent on other classes. 
//There should minimal dependencies between classes.
//Consider the example below:

class ShoppingCartEntry {
	public float price;
	public int quantity;
}

class ShoppingCart {
	public ShoppingCartEntry[] items;
}

class Order {
	private ShoppingCart cart;
	private float salesTax;

	public Order(ShoppingCart cart, float salesTax) {
		this.cart = cart;
		this.salesTax = salesTax;
	}

	// This method know the internal details of ShoppingCartEntry and
	// ShoppingCart classes. If there is any change in any of those
	// classes, this method also needs to change.
	public float orderTotalPrice() {
		float cartTotalPrice = 0;
		for (int i = 0; i < cart.items.length; i++) {
			cartTotalPrice += cart.items[i].price * cart.items[i].quantity;
		}
		cartTotalPrice += cartTotalPrice * salesTax;
		return cartTotalPrice;
	}
}

public class CouplingExamplesProblem {

}
```
### /com/in28minutes/java/oops/coupling/solution/CouplingExamplesSolution.java
```
package com.in28minutes.java.oops.coupling.solution;

class ShoppingCartEntry {
	float pricedummy;
	int quantity;

	public float getTotalPrice() {
		return pricedummy * quantity;
	}
}

class CartContents {
	ShoppingCartEntry[] items;

	public float getTotalPrice() {
		float totalPrice = 0;
		for (ShoppingCartEntry item : items) {
			totalPrice += item.getTotalPrice();
		}
		return totalPrice;
	}
}

class Order {
	private CartContents cart;
	private float salesTax;

	public Order(CartContents cart, float salesTax) {
		this.cart = cart;
		this.salesTax = salesTax;
	}

	public float totalPrice() {
		return cart.getTotalPrice() * (1.0f + salesTax);
	}
}

public class CouplingExamplesSolution {

}
```
### /com/in28minutes/java/oops/encapsulation/EncapsulationExample.java
```
package com.in28minutes.java.oops.encapsulation;

class CricketScorer {
	private int score = 0;

	public int getScore() {
		return score;
	}

	public void addRuns(int score) {
		this.score = this.score + score;
	}

	public void six() {
		addRuns(6);
	}

	public void four() {
		addRuns(4);
	}

	public void single() {
		addRuns(1);
	}

	public void printScore() {
		System.out.println("Score : " + score);
	}

}

public class EncapsulationExample {
	public static void main(String[] args) {
		CricketScorer scorer = new CricketScorer();
		scorer.four();
		scorer.four();
		scorer.single();
		scorer.six();
		scorer.six();
		scorer.six();
		scorer.printScore();
	}
}
```
