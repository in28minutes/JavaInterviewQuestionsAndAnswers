### /com/in28minutes/java/others/garbagecollection/GarbageCollectionExamples.java
```
package com.in28minutes.java.others.garbagecollection;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GarbageCollectionExamples {
	void method() {
		Calendar calendar = new GregorianCalendar(2000, 10, 30);
		System.out.println(calendar);
	}
}
```
### /com/in28minutes/java/others/PrintfExamples.java
```
package com.in28minutes.java.others;

public class PrintfExamples {
	public static void main(String[] args) {

		// Let's look at a few examples to quickly understand printf function.
		System.out.printf("%d", 5);// 5
		System.out.printf("My name is %s", "Rithu");// My name is Rithu
		System.out.printf("%s is %d Years old", "Rithu", 5);// Rithu is 5 Years
															// old

		// In the simplest form, string to be formatted starts with % followed
		// by conversion indicator
		// b - boolean c - char d - integer f - floating point s - string.

		// Prints 12 using minimum 5 character spaces.
		System.out.printf("|%5d|", 12); // prints | 12|
		// Prints 1234 using minimum 5 character spaces.
		System.out.printf("|%5d|", 1234); // prints | 1234|
		// In above example 5 is called width specifier.

		// Left Justification can be done by using -
		System.out.printf("|%-5d|", 12); // prints |12 |

		// Using 0 pads the number with 0's
		System.out.printf("%05d", 12); // prints 00012

		// Using , format the number using comma's
		System.out.printf("%,d", 12345); // prints 12,345

		// Using ( prints negative numbers between ( and )
		System.out.printf("%(d", -12345); // prints (12345)
		System.out.printf("%(d", 12345); // prints 12345

		// Using + prints + or - before the number
		System.out.printf("%+d", -12345); // prints -12345
		System.out.printf("%+d", 12345); // prints +12345

		// For floating point numbers, precision can be specified after.
		// Below example uses a precision of 2, so .5678 gets changed to .57
		System.out.printf("%5.2f", 1234.5678); // prints 1234.57

		// An error in specifying would give a RuntimeException
		// In below example a string is passed to %d argument.
		// System.out.printf("%5d","Test");
		// Throws java.util.IllegalFormatConversionException

		// To change the order of printing and passing of arguments, argument
		// index can be used
		System.out.printf("%3$.1f %2$s %1$d", 123, "Test", 123.4); // prints
																	// 123.4
																	// Test 123

		// format method has the same behavior as printf method
		System.out.format("%5.2f", 1234.5678);// prints 1234.57

	}
}
```
### /com/in28minutes/java/others/regularexpressions/RegularExpressionExamples.java
```
package com.in28minutes.java.others.regularexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExamples {
	public static void main(String[] args) {

		// Search for 12 in the string
		regex("12", "122345612");// [0<12>, 7<12>]
		// 012345678

		// Certain characters escaped by \ have special meaning in regular
		// expressions.
		// For example, /s matches a whitespace character.
		// Let us see a few examples below
		// Remember that to represent \ in a string, we should prepend \ to it.
		System.out.println("\\");// prints \ (only one slash)

		// Search for a space character
		regex("\\s", "12 1234 123 ");// [2< >, 7< >, 11< >]
		// 0123456789012

		// Search for a digit
		regex("\\d", "12 12");// [0<1>, 1<2>, 3<1>, 4<2>]
		// 01234

		// Search for a word character (letter, digits or underscore)
		regex("\\w", "ab 12 _");// [0<a>, 1<b>, 3<1>, 4<2>, 6<_>]
		// 0123456

		// Square brackets are used in regular expressions to search for a range
		// of characters
		// Few examples below.

		// look for a,b,c,d,1,2,3,4 =>Note that this does not look for capital
		// A,B,C,D
		regex("[a-d1-4]", "azbkdm 15AB");// [0<a>, 2<b>, 4<d>, 7<1>]
		// 01234567890
		regex("[a-dA-D]", "abyzCD");// [0<a>, 1<b>, 4<C>, 5<D>]
		// 012345

		// + is used in regular expression to look for 1 or more characters. For
		// example a+ looks for 1 or more character a's
		regex("a+", "aaabaayza");// [0<aaa>, 4<aa>, 8<a>]
		// 012345678

		// Look for one or more characters from a to z (only small case)
		regex("[a-z]+", "abcZ2xyzN1yza");// [0<abc>, 5<xyz>, 10<yza>]
		// 0123456789012

		// Regular expressions can be joined together to look for a combination.
		// a+b+ looks 1 or more a's and 1 or more b's next to each other. Notice
		// that only a's or only b's do not match.
		regex("a+b+", "aabcacaabbbcbb");// [0<aab>, 6<aabbb>]

		// * is used in regular expression to look for 0 or more characters.
		// below expression looks for 1 or more a's followed by 0 or more b's
		// followed by 1 or more c's
		// abc => match. ac=> match (since we used * for b). ab => does not
		// match
		regex("a+b*c+", "abcdacdabdbc");// [0<abc>, 4<ac>]

		// ? looks for 0 or 1 characters.
		// a+b*c? looks for 1 or more a's followed by 0 or more b's followed by
		// 0 or 1 c's
		// a => matches. ab => matches. abc=>matches. abcc => does not match
		// (only 0 or 1 c's)
		regex("a+b*c?", "adabdabcdabccd");// [0<a>, 2<ab>, 5<abc>, 9<abc>]

		// ^a looks for anything other than a
		regex("[^a]+", "bcadefazyx");// [0<bc>, 3<def>, 7<zyx>]

		// [^abcd]+a looks for anything which is not a or b or c or d, repeated
		// 0 or more times, followed by a
		regex("[^abcd]+a", "efgazyazyzb");// [0<efga>, 4<zya>]

		// . matches any character
		// a.c looks for a followed by any character followed by c
		// abc => match abbc => no match (. matches 1 character only)
		regex("a.c", "abca ca!cabbc");// [0<abc>, 3<a c>, 6<a!c>]

		// a+ matches a, aa,aaa,aaaa, aaaaa. If you look at the output of the
		// below expression, it matches the biggest only aaaaa.
		// This is called greedy behaviour. similar behavior is shown by *.
		regex("a+", "aaaaab");// [0<aaaaa>]

		// You can make + reluctant (look for smallest match) by appending ?
		regex("a+?", "aaaaab");// [0<a>, 1<a>, 2<a>, 3<a>, 4<a>]

		// Similarly *? is reluctant match for the greedy *

		// If you want to look for characters . or * in a regular expression,
		// then you should escape them.
		// Example : If I want to look for ...(3 dots), we should use \.\.\.
		// To represent \.\.\. as string we should put two \'s instead of 1
		regex("\\.\\.\\.", "...a....b...c");// [0<...>, 4<...>, 9<...>]

		// Discussion about regex function below

		// Discussion about regexUsingScanner
		regexUsingScanner("a+?", "aaaaab");// [a, a, a, a, a]

		// Tokenizing means splitting a string into several sub strings based on
		// delimiters.
		// for example, delimiter ; splits the string ac;bd;def;e into four sub
		// strings ac, bd, def and e.
		// Delimiter can in itself be any of the regular expression(s) we looked
		// at earlier.

		// String.split(regex) function takes regex as an argument

		tokenize("ac;bd;def;e", ";");// [ac, bd, def, e]
		tokenizeUsingScanner("ac;bd;def;e", ";");// [ac, bd, def, e]

		// Scanner has more useful functions other than just looking for a
		// delimiter
		lookForDifferentThingsUsingScanner("true false 12 3 abc true 154");
		// Found Boolean :true
		// Found Boolean :false
		// Found Integer :12
		// Found Integer :3
		// Different thing :abc
		// Found Boolean :true
		// Found Integer :154
	}

	private static void regex(String regex, String string) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		List<String> matches = new ArrayList<String>();
		while (m.find()) {
			matches.add(m.start() + "<" + m.group() + ">");
		}
		System.out.println(matches);

	}

	private static void regexUsingScanner(String regex, String string) {
		Scanner s = new Scanner(string);
		List<String> matches = new ArrayList<String>();

		String token;
		while ((token = s.findInLine(regex)) != null) {
			matches.add(token);
		}
		;
		System.out.println(matches);
	}

	private static void tokenize(String string, String regex) {
		String[] tokens = string.split(regex);
		System.out.println(Arrays.toString(tokens));
	}

	private static void tokenizeUsingScanner(String string, String regex) {
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(regex);
		List<String> matches = new ArrayList<String>();
		while (scanner.hasNext()) {
			matches.add(scanner.next());
		}
		System.out.println(matches);
	}

	private static void lookForDifferentThingsUsingScanner(String string) {
		Scanner scanner = new Scanner(string);
		while (scanner.hasNext()) {
			if (scanner.hasNextBoolean()) {
				System.out.println("Found Boolean :" + scanner.nextBoolean());
			} else if (scanner.hasNextInt()) {
				System.out.println("Found Integer :" + scanner.nextInt());
			} else {
				System.out.println("Different thing :" + scanner.next());
			}
		}
	}

}
```
### /com/in28minutes/java/others/SameType.java
```
package com.in28minutes.java.others;

public class SameType {
}

class SuperClass {

}

class SubClass extends SuperClass {

}

abstract class Abstract {
	abstract SuperClass method1();
}

interface Interface {
	SuperClass method2();
}

class ConcreteClass extends Abstract implements Interface {

	public SubClass method2() {
		return null;
	}

	SubClass method1() {
		return null;
	}

}
```
