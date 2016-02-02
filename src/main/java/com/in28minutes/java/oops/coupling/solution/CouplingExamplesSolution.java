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
