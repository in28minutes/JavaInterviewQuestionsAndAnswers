package com.in28minutes.java.exceptionhandling;

//PLEASE GIVE ME A BREAK ON CODING STANDARDS
class Amount {
	public Amount(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	String currency;
	int amount;// Should ideally use BigDecimal
}

class CurrenciesDoNotMatchException extends RuntimeException {
}

class AmountAdder {
	static Amount addAmounts(Amount amount1, Amount amount2) {
		if (!amount1.currency.equals(amount2.currency)) {
			throw new CurrenciesDoNotMatchException();
		}
		return new Amount(amount1.currency, amount1.amount + amount2.amount);
	}
}

public class ExceptionHandlingExample2 {
	public static void main(String[] args) {
		try {
			AmountAdder.addAmounts(new Amount("RUPEE", 5), new Amount("RUPEE",
					5));
			String string = null;
			string.toString();
		} catch (CurrenciesDoNotMatchException e) {
			System.out.println("Handled CurrenciesDoNotMatchException");
		}
	}
}