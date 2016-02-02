package com.in28minutes.java.enums;

public class EnumAdvanced {

	// Enum with a variable,method and constructor
	enum SeasonCustomized {
		WINTER(1), SPRING(2), SUMMER(3), FALL(4);

		// variable
		private int code;

		// method
		public int getCode() {
			return code;
		}

		// Constructor-only private or (default)
		// modifiers are allowed
		SeasonCustomized(int code) {
			this.code = code;
		}

		// Getting value of enum from code
		public static SeasonCustomized valueOf(int code) {
			for (SeasonCustomized season : SeasonCustomized.values()) {
				if (season.getCode() == code)
					return season;
			}
			throw new RuntimeException("value not found");// Just for kicks
		}

		// Using switch statement on an enum
		public int getExpectedMaxTemperature() {
			switch (this) {
			case WINTER:
				return 5;
			case SPRING:
			case FALL:
				return 10;
			case SUMMER:
				return 20;
			}
			return -1;// Dummy since Java does not recognize this is possible :)
		}

	};

	public static void main(String[] args) {
		SeasonCustomized season = SeasonCustomized.WINTER;

		/*
		 * //Enum constructor cannot be invoked directly //Below line would
		 * cause COMPILER ERROR SeasonCustomized season2 = new
		 * SeasonCustomized(1);
		 */

		System.out.println(season.getCode());// 1

		System.out.println(season.getExpectedMaxTemperature());// 5

		System.out.println(SeasonCustomized.valueOf(4));// FALL

	}

}