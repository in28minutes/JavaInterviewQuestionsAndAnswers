package com.in28minutes.java.enums;

//Enum can be declared outside a class
enum SeasonOutsideClass {
	WINTER, SPRING, SUMMER, FALL
};

public class Enum {
	// Enum can be declared inside a class
	enum Season {
		WINTER, SPRING, SUMMER, FALL
	};

	public static void main(String[] args) {
		/*
		 * //Uncommenting gives compilation error //enum cannot be created in a
		 * method enum InsideMethodNotAllowed { WINTER, SPRING, SUMMER, FALL };
		 */

		// Converting String to Enum
		Season season = Season.valueOf("FALL");

		// Converting Enum to String
		System.out.println(season.name());// FALL

		// Default ordinals of enum
		// By default java assigns ordinals in order
		System.out.println(Season.WINTER.ordinal());// 0
		System.out.println(Season.SPRING.ordinal());// 1
		System.out.println(Season.SUMMER.ordinal());// 2
		System.out.println(Season.FALL.ordinal());// 3

		// Looping an enum => We use method values
		for (Season season1 : Season.values()) {
			System.out.println(season1.name());
			// WINTER SPRING SUMMER FALL (separate lines)
		}

		// Comparing two Enums
		Season season1 = Season.FALL;
		Season season2 = Season.FALL;
		System.out.println(season1 == season2);// true
		System.out.println(season1.equals(season2));// true
	}
}