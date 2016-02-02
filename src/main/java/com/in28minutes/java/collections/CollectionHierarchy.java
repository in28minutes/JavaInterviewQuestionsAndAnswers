package com.in28minutes.java.collections;

import java.util.Iterator;
import java.util.ListIterator;

//Java COLLECTION INTERVIEW QUESTIONS
//�����������������������������������

//Java Collection Framework Interview Questions
//�����������������������������������
//Basic interfaces of Java Collections Framework?
//Can you give a basic overview of collection framework?
//Generics in Collections Framework?
//What is Collections Class?

//Java List Interface Interview Questions
//�����������������������������������
//What are similarities and difference between ArrayList and Vector?
//What is difference between Array and ArrayList?
//What is difference between ArrayList and LinkedList?

//Java Map Interface Interview Questions
//�����������������������������������
// Does Map implement Collection interface? Why?
// What is difference between HashMap and Hashtable?
// How to decide between HashMap and TreeMap?

// Java Set Interface Interview Questions
//�����������������������������������
// What is the difference between a Set and a List
// What is the difference between a HashSet and a TreeSet

interface Collection<E> extends Iterable<E> {
	int size();

	boolean isEmpty();

	boolean contains(Object paramObject);

	Iterator<E> iterator();

	Object[] toArray();

	boolean add(E paramE);

	boolean remove(Object paramObject);

	boolean containsAll(Collection<?> paramCollection);

	boolean addAll(Collection<? extends E> paramCollection);

	boolean removeAll(Collection<?> paramCollection);

	boolean retainAll(Collection<?> paramCollection);

	void clear();

	boolean equals(Object paramObject);

	int hashCode();
}

// Unique things only - Does not allow duplication.
// If obj1.equals(obj2) then only one of them can be in the Set.
interface Set<E> extends Collection<E> {

}

// A, X , B
// X, A ,B
class HashSet /* implements Set */{
	// unordered, unsorted - iterates in random order
	// uses hashCode()
}

// A, X, B
// A, X, B
class LinkedHashSet /* implements Set */{
	// ordered - iterates in order of insertion
	// unsorted
	// uses hashCode()
}

// A,C,B
// A,B,C
class TreeSet /* implements Set,NavigableSet */{
	// 3,5,7
	// sorted - natural order
	// implements NavigableSet
}

// LIST OF THINGS
// Cares about which position each object is in
// Elements can be added in by specifying position - where should it be added in
// If element is added without specifying position - it is added at the end
interface List<E> extends Collection<E> {

	// [1,2,3,4]
	// batsman - "Sachin", "Kohli" , "Ponting", "Lara", "Kohli"
	// 0 1 2 3 4
	// batsman.remove(1);
	// bastman.get(2);
	// bastman.set(2,"Ponting"))
	//
	boolean addAll(int paramInt, Collection<? extends E> paramCollection);

	E get(int position);

	E set(int position, E paramE);

	void add(int position, E paramE);

	E remove(int paramInt);

	int indexOf(Object paramObject);

	int lastIndexOf(Object paramObject);

	ListIterator<E> listIterator();

	ListIterator<E> listIterator(int paramInt);

	List<E> subList(int paramInt1, int paramInt2);
}

class ArrayList /* implements List<E>, RandomAccess */{
	// implements RandomAccess, a marker interface, meaning it support fast -
	// almost constant time - access
	// Insertion and Deletion are slower compared to LinkedList
}

class Vector /* implements List<E>, RandomAccess */{
	// Thread Safe - Synchronized Methods
	// implements RandomAccess, a marker interface, meaning it support fast -
	// almost constant time - access
}

class LinkedList /* implements List<E>, Queue */{
	// Elements are doubly linked - forward and backword - to one another
	// Ideal choice to implement Stack or Queue
	// Iteration is slower than ArrayList
	// Fast Insertion and Deletion
	// Implements Queue interface also. So, supports methods like peek(), poll()
	// and remove()
}

// Arranged in order of processing - A to-do list for example
// Queue interface extends Collection. So, it supports all Collection Methods.
interface Queue<E> extends Collection<E> {
	boolean add(E paramE);

	boolean offer(E paramE);

	E remove();

	E poll();

	E element();

	E peek();
}

class PriorityQueue /* implements Queue */{
	// sorted - natural order
	//

}

// A,C,A,C,E,C,M,D,H,A

// {("A",5),("C",2)}

// "A","B","C"

// {["key1",value1],["key2",value2],["key3",value3]}

// Things with unique identifier
// Key - Value Pair
interface Map<K, V> {
	int size();

	boolean isEmpty();

	boolean containsKey(Object paramObject);

	boolean containsValue(Object paramObject);

	V get(Object key);

	V put(K key, V value);

	V remove(Object key);

	void putAll(Map<? extends K, ? extends V> paramMap);

	void clear();

	Set<K> keySet();

	Collection<V> values();

	Set<Entry<K, V>> entrySet();

	boolean equals(Object paramObject);

	int hashCode();

	public static abstract interface Entry<K, V> {
		K getKey();

		V getValue();

		V setValue(V paramV);

		boolean equals(Object paramObject);

		int hashCode();
	}
}

class HashMap /* implements Map */{
	// unsorted, unordered
	// key's hashCode() is used
}

class Hashtable /* implements Map */{
	// Synchronized - Thread Safe - version of HashMap
	// unsorted, unordered
	// key's hashCode() is used
	// HashMap allows a key with null value. Hashtable doesn't.
}

class LinkedHashMap /* implements Map */{
	// insertion order is maintained (optionally can maintain access order as
	// well)
	// slower insertion and deletion
	// faster iteration
}

// A,C,B
// A,B,C
class TreeMap /* implements Map,NavigableMap */{
	// sorted order is maintained
	// implements NavigableMap
}

public class CollectionHierarchy {
}
