package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class IncrementAndDecrementOperators {
	public static void main(String[] args) {
		// Except for a minor difference
		// ++i,i++ is similar to i = i+1
		// --i,i-- is similar to i = i-1
		// ++i is called pre-increment,i++ post increment
		// pre-increment statement returns value after increment
		// post-increment statement returns value before increment
		int i = 25;
		int j = ++i;// i is incremented to 26, assigned to j
		System.out.println(i + " " + j);// 26 26

		i = 25;
		j = i++;// i value(25) is assigned to j, then incremented to 26
		System.out.println(i + " " + j);// 26 25

		i = 25;
		j = --i;// i is decremented to 24, assigned to j
		System.out.println(i + " " + j);// 24 24

		i = 25;
		j = i--;// i value(25) is assigned to j, then decremented to 24
		System.out.println(i + " " + j);// 24 25

		final int k = 100;
		// j=k++;//COMPILER ERROR! Final value cannot be modified

	}
}