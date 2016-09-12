import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LambdaExpressionsTest {

	@Test
	public void sumOfOddNumbers_Usual() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		int sum = 0;
		for (int number : numbers)
			if (number % 2 != 0)
				sum += number;
		assertEquals(11, sum);
	}

	@Test
	public void sumOfOddNumbers_FunctionalProgrammingExample() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);

		int sum = numbers.stream() // Create Stream
				.filter(number -> (number % 2 != 0)) // Intermediate Operation
				.reduce(0, Integer::sum); // Terminal Operation

		// number -> (number % 2 != 0) => Lambda Expression
		// Integer::sum => Method Reference
		// What is Functional Interface

		assertEquals(11, sum);
	}

	@Test
	public void lambdaExpression_predicate() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		numbers.stream()
				.filter((number) -> (number % 2 != 0)) //Predicate
				.forEach(number -> System.out.print(number)); //Consumer
		// 137
	}

	static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}
