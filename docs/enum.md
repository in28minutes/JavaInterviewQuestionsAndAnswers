### /com/in28minutes/java/enums/Enum.java
```
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
```
### /com/in28minutes/java/enums/EnumAdvanced.java
```
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
```
### /com/in28minutes/java/enums/EnumAdvanced2.java
```
package com.in28minutes.java.enums;

public class EnumAdvanced2 {

	// Enum with a variable,method and constructor
	enum SeasonCustomized {
		WINTER(1) {
			public int getExpectedMaxTemperature() {
				return 5;
			}
		},
		SPRING(2), SUMMER(3) {
			public int getExpectedMaxTemperature() {
				return 20;
			}
		},
		FALL(4);

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

		public int getExpectedMaxTemperature() {
			return 10;
		}

	};

	public static void main(String[] args) {
		SeasonCustomized season = SeasonCustomized.WINTER;

		System.out.println(season.getExpectedMaxTemperature());// 5

		System.out.println(SeasonCustomized.FALL.getExpectedMaxTemperature());// 10

	}

}
```
