package com.in28minutes.java.others.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateExamples {
	public static void main(String[] args) throws ParseException {
		// Important points about Date
		// Date is no longer the class Java recommends for storing and
		// manipulating date and time. Most of methods in Date are deprecated.
		// Use Calendar class instead.
		// Date internally represents date-time as number of milliseconds (a
		// long value) since 1st Jan 1970.

		// Creating Date Object
		Date now = new Date();
		System.out.println(now.getTime());

		// Manipulating Date Object
		Date date = new Date();

		// Increase time by 6 hrs
		date.setTime(date.getTime() + 6 * 60 * 60 * 1000);
		System.out.println(date);

		// Decrease time by 6 hrs
		date = new Date();
		date.setTime(date.getTime() - 6 * 60 * 60 * 1000);
		System.out.println(date);

		// Formatting Dates
		System.out.println(DateFormat.getInstance().format(date));// 10/16/12
																	// 5:18 AM

		// Formatting Dates with a locale
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL,
				new Locale("it", "IT")).format(date));// marted� 16 ottobre 2012

		System.out.println(DateFormat.getDateInstance(DateFormat.FULL,
				Locale.ITALIAN).format(date));// marted� 16 ottobre 2012

		// This uses default locale US
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(
				date));// Tuesday, October 16, 2012

		System.out.println(DateFormat.getDateInstance().format(date));// Oct 16,
																		// 2012
		System.out.println(DateFormat.getDateInstance(DateFormat.SHORT).format(
				date));// 10/16/12
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM)
				.format(date));// Oct 16, 2012

		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(
				date));// October 16, 2012

		// Formatting Dates Using SimpleDateFormat
		System.out.println(new SimpleDateFormat("yy-MM-dd").format(date));// 12-10-16
		System.out.println(new SimpleDateFormat("yy-MMM-dd").format(date));// 12-Oct-16
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));// 2012-10-16

		// Parse Dates using DateFormat
		Date date2 = DateFormat.getDateInstance(DateFormat.SHORT).parse(
				"10/16/12");
		System.out.println(date2);// Tue Oct 16 00:00:00 GMT+05:30 2012

		// Creating Dates using SimpleDateFormat
		Date date1 = new SimpleDateFormat("yy-MM-dd").parse("12-10-16");
		System.out.println(date1);// Tue Oct 16 00:00:00 GMT+05:30 2012

		// Print the country of locale
		Locale defaultLocale = Locale.getDefault();

		System.out.println(defaultLocale.getDisplayCountry());// United States
		System.out.println(defaultLocale.getDisplayLanguage());// English
	}
}
