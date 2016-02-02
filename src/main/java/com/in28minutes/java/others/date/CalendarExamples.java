package com.in28minutes.java.others.date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExamples {
	public static void main(String[] args) {
		// Calendar is abstract
		// Calendar calendar = new Calendar(); //COMPILER ERROR

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DATE, 24);
		calendar.set(Calendar.MONTH, 8);// 8 - September
		calendar.set(Calendar.YEAR, 2010);

		// Get information about 24th September 2010
		System.out.println(calendar.get(Calendar.YEAR));// 2010
		System.out.println(calendar.get(Calendar.MONTH));// 8
		System.out.println(calendar.get(Calendar.DATE));// 24
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));// 4
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));// 39
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));// 267
		System.out.println(calendar.getFirstDayOfWeek());// 1 -> Calendar.SUNDAY

		// Add/Manipulate date
		calendar.add(Calendar.DATE, 5);
		System.out.println(calendar.getTime());// Wed Sep 29 2010
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime());// Fri Oct 29 2010
		calendar.add(Calendar.YEAR, 2);
		System.out.println(calendar.getTime());// Mon Oct 29 2012

		// Roll method will only the change the value being modified.
		// YEAR remains unaffected when MONTH is changed for instance.
		calendar.roll(Calendar.MONTH, 5);
		System.out.println(calendar.getTime());// Mon Mar 29 2012

		// Other way of creating calendar
		Calendar gregorianCalendar = new GregorianCalendar(2011, 7, 15);

		// Formatting Calendar
		// Done by getting the date using calendar.getTime() and
		// using the usual formatting of dates.
		System.out.println(DateFormat.getInstance().format(calendar.getTime()));// 3/29/12
																				// 11:39
																				// AM

	}

}
