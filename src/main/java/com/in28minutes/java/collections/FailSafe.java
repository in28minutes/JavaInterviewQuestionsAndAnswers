package com.in28minutes.java.collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafe {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		Iterator<String> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(map.get(iterator.next()));
			map.put("key4", "value4");
		}

	}

}