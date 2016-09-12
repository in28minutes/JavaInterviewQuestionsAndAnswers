package com.in28minutes.java.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

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

//�����������������������������������
//LIST,  RELATED INTERFACES AND CLASSES
//�����������������������������������

//LIST OF THINGS
//Cares about which position each object is in
//Elements can be added in by specifying position - where should it be added in
//If element is added without specifying position - it is added at the end
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

//�����������������������������������
//SET RELATED INTERFACES AND CLASSES
//�����������������������������������

// Unique things only - Does not allow duplication.
// If obj1.equals(obj2) then only one of them can be in the Set.
interface Set<E> extends Collection<E> {

}

//Main difference between Set and SortedSet is - an implementation of SortedSet interface 
//maintains its elements in a sorted order.  Set interface does not guarantee any Order.
interface SortedSet<E> extends Set<E> {

	SortedSet<E> subSet(E fromElement, E toElement);

	SortedSet<E> headSet(E toElement);

	SortedSet<E> tailSet(E fromElement);

	E first();

	E last();

}

//A SortedSet extended with navigation methods reporting closest matches for given search targets.
interface NavigableSet<E> extends SortedSet<E> {
	E lower(E e);

	E floor(E e);

	E ceiling(E e);

	E higher(E e);

	E pollFirst();

	E pollLast();
}

// Order of Insertion : A, X , B
// Possible Order of Storing : X, A ,B
class HashSet /* implements Set */{
	// unordered, unsorted - iterates in random order
	// uses hashCode()
}

// Order of Insertion :A, X, B
// Order of Storing : A, X, B
class LinkedHashSet /* implements Set */{
	// ordered - iterates in order of insertion
	// unsorted
	// uses hashCode()
}

// Order of Insertion :A,C,B
// Order of Storing : A,B,C
class TreeSet /* implements Set,NavigableSet */{
	// 3,5,7
	// sorted - natural order
	// implements NavigableSet
}

//�����������������������������������
//QUEUE  RELATED INTERFACES AND CLASSES
//�����������������������������������
// Arranged in order of processing - A to-do list for example
// Queue interface extends Collection. So, it supports all Collection Methods.
interface Queue<E> extends Collection<E> {

	//Inserts the specified element into this queue
	//Throws exception in case of failure
	boolean add(E paramE);

	//Inserts the specified element into this queue
	//Returns false in case of failure
	boolean offer(E paramE);

	//Retrieves and removes the head of this queue.
	//Throws Exception if Queue is empty
	E remove();

	//Retrieves and removes the head of this queue.
	//returns null if Queue is empty
	E poll();

	E element();

	E peek();
}

//A linear collection that supports element insertion and removal at both ends
interface Deque<E> extends Queue<E> {
	void addFirst(E e);

	void addLast(E e);

	boolean offerFirst(E e);

	boolean offerLast(E e);

	E removeFirst();

	E removeLast();

	E pollFirst();

	E pollLast();

	E getFirst();

	E getLast();

	E peekFirst();

	E peekLast();

	boolean removeFirstOccurrence(Object o);

	boolean removeLastOccurrence(Object o);

}

//A Queue that additionally supports operations that wait for 
//the queue to become non-empty when retrieving an
//element, and wait for space to become available in the queue when
//storing an element.
interface BlockingQueue<E> extends Queue<E> {
	//Same as in Queue Interface
	//Inserts the specified element into queue IMMEDIATELY 
	//Throws exception in case of failure	
	boolean add(E e);

	//Same as in Queue Interface
	//Inserts the specified element into queue IMMEDIATELY 
	//Returns false in case of failure	
	boolean offer(E e); //Same as in Queue Interface

	//Inserts the specified element into this queue, waiting 
	//if necessary for space to become available.
	void put(E e) throws InterruptedException;

	//waiting up to the specified wait time
	boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException;

	//waits until element becomes available
	E take() throws InterruptedException;

	//waits for specified time and returns null if time expires
	E poll(long timeout, TimeUnit unit) throws InterruptedException;

	int remainingCapacity();

	boolean remove(Object o);

	public boolean contains(Object o);

	int drainTo(Collection<? super E> c);

	int drainTo(Collection<? super E> c, int maxElements);
}

//The elements of the priority queue are ordered 
//according to their natural ordering
class PriorityQueue /* implements Queue */{
	// sorted - natural order

}

class ArrayDeque /*implements Deque*/{

}

class ArrayBlockingQueue /*implements BlockingQueue*/{
	//uses Array - optionally-bounded
}

class LinkedBlockingQueue /*implements BlockingQueue*/{
	//uses Linked List - optionally-bounded
	
	//Linked queues typically have higher throughput than array-based queues but
	//less predictable performance in most concurrent applications.
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

// A Map that orders based on the keys. Comparator can be provided at
// map creation time
interface SortedMap<K, V> extends Map<K, V> {
	Comparator<? super K> comparator();

	SortedMap<K, V> subMap(K fromKey, K toKey);

	SortedMap<K, V> headMap(K toKey);

	SortedMap<K, V> tailMap(K fromKey);

	K firstKey();

	K lastKey();
}

//A SortedMap extended with navigation methods reporting closest matches for given search targets.
interface NavigableMap<K, V> extends SortedMap<K, V> {
	Map.Entry<K, V> lowerEntry(K key);

	K lowerKey(K key);

	Map.Entry<K, V> floorEntry(K key);

	K floorKey(K key);

	Map.Entry<K, V> ceilingEntry(K key);

	K ceilingKey(K key);

	Map.Entry<K, V> higherEntry(K key);

	K higherKey(K key);

	Map.Entry<K, V> firstEntry();

	Map.Entry<K, V> lastEntry();

	Map.Entry<K, V> pollFirstEntry();

	Map.Entry<K, V> pollLastEntry();

	NavigableMap<K, V> descendingMap();

	NavigableSet<K> navigableKeySet();

	NavigableSet<K> descendingKeySet();
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
