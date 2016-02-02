### /com/in28minutes/java/collections/CollectionHierarchy.java
```
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
```
### /com/in28minutes/java/collections/examples/CollectionExamples.java
```
package com.in28minutes.java.collections.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

class Cricketer implements Comparable<Cricketer> {
	int runs;
	String name;

	public Cricketer(String name, int runs) {
		super();
		this.name = name;
		this.runs = runs;
	}

	@Override
	public String toString() {
		return name + " " + runs;
	}

	// compareTo takes an argument of the same type of the class
	// compareTo returns -1 if this < that
	// 1 if this > that
	// 0 if this = that
	@Override
	public int compareTo(Cricketer that) {
		if (this.runs > that.runs) {
			return 1;
		}
		if (this.runs < that.runs) {
			return -1;
		}
		return 0;
	}

}

class DescendingSorter implements Comparator<Cricketer> {

	// compareTo returns -1 if cricketer1 < cricketer2
	// 1 if cricketer1 > cricketer2
	// 0 if cricketer1 = cricketer2

	// Since we want to sort in descending order,
	// we should return -1 when runs are more
	@Override
	public int compare(Cricketer cricketer1, Cricketer cricketer2) {
		if (cricketer1.runs > cricketer2.runs) {
			return -1;
		}
		if (cricketer1.runs < cricketer2.runs) {
			return 1;
		}
		return 0;
	}

}

public class CollectionExamples {
	public static void main(String[] args) {
		// Collections can only hold Objects - not primitives.
		List<Integer> integers = new ArrayList<Integer>();

		// code like below is permitted because of auto boxing
		integers.add(5);// new Integer(5)
		// 5 is auto boxed into Integer object and stored in ArrayList

		int i;

		int a[] = { 1, 2, 3, 4, 5 }; // group of elements
		// Arrays

		// ArrayList
		List<String> batsmen = new ArrayList<String>();

		// adds at the end of list
		batsmen.add("Sachin");// [Sachin]

		// adds at the end of list
		batsmen.add("Dravid");// [Sachin, Dravid]
								// 0 1

		// adds at the index 0
		batsmen.add(0, "Ganguly");// [Ganguly, Sachin, Dravid]

		// List allows duplicates - Sachin is present in the list twice
		batsmen.add("Sachin");// [ Ganguly, Sachin, Dravid, Sachin]
								// 0 1 2 3

		System.out.println(batsmen.size());// 4
		System.out.println(batsmen.contains("Dravid"));// true

		// Iterating around a list
		Iterator<String> arraylistIterator = batsmen.iterator();
		while (arraylistIterator.hasNext()) {
			String str = arraylistIterator.next();
			System.out.println(str);// Prints the 4 names in the list on
									// separate lines.
		}

		// indexOf function - returns index of element if element is found.
		// Negative number otherwise.
		// example1 - value is present
		System.out.println(batsmen.indexOf("Dravid"));// 2
		// example2 - value is not present
		System.out.println(batsmen.indexOf("Bradman"));// -1

		// get function - get value at index
		System.out.println(batsmen.get(1));// Sachin

		// remove function - two variations

		// Using the object as parameter
		// Dravid is removed from the list
		batsmen.remove("Dravid");// [Ganguly, Sachin, Sachin]

		// Using index as argument.
		// Object at index 1 (Sachin) is removed
		batsmen.remove(1);// [Ganguly, Sachin]

		// Sorting Collections
		List<String> numbers = new ArrayList<String>();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		numbers.add("four");
		System.out.println(numbers);// [one, two, three, four]

		// Strings - By Default - are sorted alphabetically
		Collections.sort(numbers);

		System.out.println(numbers);// [four, one, three, two]

		List<Cricketer> cricketers = new ArrayList<Cricketer>();
		cricketers.add(new Cricketer("Bradman", 9996));
		cricketers.add(new Cricketer("Sachin", 14000));
		cricketers.add(new Cricketer("Dravid", 12000));
		cricketers.add(new Cricketer("Ponting", 11000));
		System.out.println(cricketers);
		// [Bradman 9996, Sachin 14000, Dravid 12000, Ponting 11000]

		// Cricketer class does not implement Comparable Interface
		// Collections.sort(cricketers); //COMPILER ERROR

		// We were able to sort numbers because String class implements
		// Comparable

		// Lets make the Cricketer class implement the Comparable Interface
		Collections.sort(cricketers);
		System.out.println(cricketers);
		// [Bradman 9996, Ponting 11000, Dravid 12000, Sachin 14000]

		// Other option to sort collections is by creating a class which
		// implements Comparator class

		Collections.sort(cricketers, new DescendingSorter());
		System.out.println(cricketers);
		// [Sachin 14000, Dravid 12000, Ponting 11000, Bradman 9996]

		// Convert List to Array
		// There are two ways
		// 1. user toArray(String) function. Example below.
		// This creates an array of String's
		List<String> numbers1 = new ArrayList<String>();
		numbers1.add("one");
		numbers1.add("two");
		numbers1.add("three");
		numbers1.add("four");
		String[] numbers1Array = new String[numbers1.size()];
		numbers1Array = numbers1.toArray(numbers1Array);
		System.out.println(Arrays.toString(numbers1Array));
		// prints [one, two, three, four]

		// 1. user toArray() function. Example below.
		// This creates an array of Objects.
		Object[] numbers1ObjArray = numbers1.toArray();
		System.out.println(Arrays.toString(numbers1ObjArray));
		// [one, two, three, four]

		// Convert Array to List
		String values[] = { "value1", "value2", "value3" };
		List<String> valuesList = Arrays.asList(values);
		System.out.println(valuesList);// [value1, value2, value3]

		// Sets
		// Sets do not allow duplicates
		// Lets look at HashSet first. HashSet does not support any ordering.
		Set<String> hashset = new HashSet<String>();

		hashset.add("Sachin");
		System.out.println(hashset);// [Sachin]

		hashset.add("Dravid");
		System.out.println(hashset);// [Sachin, Dravid]

		// Sachin is Duplicate. So will not be added. returns false.
		hashset.add("Sachin");// returns false since element is not added
		System.out.println(hashset);// [Sachin, Dravid]

		// Lets look at TreeSet next. TreeSet stores objects in Sorted Order.
		Set<String> treeSet = new TreeSet<String>();

		treeSet.add("Sachin");
		System.out.println(treeSet);// [Sachin]

		// Notice that the list is sorted after inserting Dravid
		// Alphabetical order
		treeSet.add("Dravid");
		System.out.println(treeSet);// [Dravid, Sachin]

		// Notice that the list is sorted after inserting Ganguly
		treeSet.add("Ganguly");
		System.out.println(treeSet);// [Dravid, Ganguly, Sachin]

		// Sachin is Duplicate. So will not be added. returns false.
		treeSet.add("Sachin");// returns false since element is not added
		System.out.println(treeSet);// [Dravid, Ganguly, Sachin]

		// Objects that are inserted into a TreeSet should be comparable

		// Maps
		// HashMap
		Map<String, Cricketer> hashmap = new Hashtable<String, Cricketer>();

		hashmap.put("sachin", new Cricketer("Sachin", 14000));

		hashmap.put("dravid", new Cricketer("Dravid", 12000));

		hashmap.put("ponting", new Cricketer("Ponting", 11500));

		hashmap.put("bradman", new Cricketer("Bradman", 9996));

		// get method gets the value of the matching key
		System.out.println(hashmap.get("ponting"));// Ponting 11500

		// if key is not found, returns null
		System.out.println(hashmap.get("lara"));// null

		// If existing key is reused, it would replace the value with the new
		// value passed in
		// In the example below, an entry with key "ponting" is already present.
		// Runs are updated to 11800.
		hashmap.put("ponting", new Cricketer("Ponting", 11800));

		// gets the recently updated value
		System.out.println(hashmap.get("ponting"));// Ponting 11800

		// TreeMap - stores keys in sorted order
		Map<String, Cricketer> treemap = new TreeMap<String, Cricketer>();
		treemap.put("sachin", new Cricketer("Sachin", 14000));
		System.out.println(treemap);
		// {sachin=Sachin 14000}

		treemap.put("dravid", new Cricketer("Dravid", 12000));
		System.out.println(treemap);
		// {dravid=Dravid 12000, sachin=Sachin 14000}

		treemap.put("ponting", new Cricketer("Ponting", 11500));
		System.out.println(treemap);
		// {dravid=Dravid 12000, ponting=Ponting 11500, sachin=Sachin 14000}

		treemap.put("bradman", new Cricketer("Bradman", 9996));
		System.out.println(treemap);
		// {bradman=Bradman 9996, dravid=Dravid 12000, ponting=Ponting 11500,
		// sachin=Sachin 14000}

		// NavigableSet interface
		// Two classes implement them - TreeSet and TreeMap

		// Let's look at an example with TreeSet
		TreeSet<Integer> numbersTreeSet = new TreeSet<Integer>();
		numbersTreeSet.add(55);
		numbersTreeSet.add(25);
		numbersTreeSet.add(35);
		numbersTreeSet.add(5);
		numbersTreeSet.add(45);

		// Find the highest number which is lower than 25
		System.out.println(numbersTreeSet.lower(25));// 5

		// Find the highest number which is lower than or equal to 25
		System.out.println(numbersTreeSet.floor(25));// 25

		// Find the lowest number higher than 25
		System.out.println(numbersTreeSet.higher(25));// 35

		// Find the lowest number higher than or equal to 25
		System.out.println(numbersTreeSet.ceiling(25));// 25

		// Let's look at an example with TreeMap
		TreeMap<Integer, Cricketer> numbersTreeMap = new TreeMap<Integer, Cricketer>();
		numbersTreeMap.put(55, new Cricketer("Sachin", 14000));
		numbersTreeMap.put(25, new Cricketer("Dravid", 12000));
		numbersTreeMap.put(35, new Cricketer("Ponting", 12000));
		numbersTreeMap.put(5, new Cricketer("Bradman", 9996));
		numbersTreeMap.put(45, new Cricketer("Lara", 10000));

		// Find the highest key which is lower than 25
		System.out.println(numbersTreeMap.lowerKey(25));// 5

		// Find the highest key which is lower than or equal to 25
		System.out.println(numbersTreeMap.floorKey(25));// 25

		// Find the lowest key higher than 25 [5,25,35,45,55]
		System.out.println(numbersTreeMap.higherKey(25));// 35

		// Find the lowest key higher than or equal to 25
		System.out.println(numbersTreeMap.ceilingKey(25));// 25

		// TreeMap and TreeSet additional methods

		TreeSet<Integer> treeSetOrig = new TreeSet<Integer>();
		treeSetOrig.add(55);
		treeSetOrig.add(25);
		treeSetOrig.add(35);
		treeSetOrig.add(5);

		System.out.println(treeSetOrig);// [5, 25, 35, 55]
		// descendingSet method returns the tree set in reverse order
		TreeSet<Integer> treeSetDesc = (TreeSet<Integer>) treeSetOrig
				.descendingSet();
		System.out.println(treeSetDesc);// [55, 35, 25, 5]

		// pollFirst returns the first element and
		// removes it from the set
		System.out.println(treeSetOrig);// [5, 25, 35, 55]
		System.out.println(treeSetOrig.pollFirst());// 5
		System.out.println(treeSetOrig);// [25, 35, 55]
		// In above example element 5 is removed from the set and also removed
		// from the tree set.

		// pollLast returns the last element and
		// removes it from the set
		System.out.println(treeSetOrig);// [25, 35, 55]
		System.out.println(treeSetOrig.pollLast());// 55
		System.out.println(treeSetOrig);// [25, 35]

		TreeMap<Integer, Cricketer> treeMapOrig = new TreeMap<Integer, Cricketer>();
		treeMapOrig.put(55, new Cricketer("Sachin", 14000));
		treeMapOrig.put(25, new Cricketer("Dravid", 12000));
		treeMapOrig.put(5, new Cricketer("Bradman", 9996));
		treeMapOrig.put(45, new Cricketer("Lara", 10000));

		System.out.println(treeMapOrig);
		// {5=Bradman 9996, 25=Dravid 12000, 45=Lara 10000, 55=Sachin 14000}

		// descendingMap method returns the tree set in reverse order
		NavigableMap<Integer, Cricketer> treeMapDesc = treeMapOrig
				.descendingMap();
		System.out.println(treeMapDesc);
		// {55=Sachin 14000, 45=Lara 10000, 25=Dravid 12000, 5=Bradman 9996}

		// pollFirstEntry returns the first entry in the map and
		// removes it from the map
		System.out.println(treeMapOrig);
		// {5=Bradman 9996, 25=Dravid 12000, 45=Lara 10000, 55=Sachin 14000}
		System.out.println(treeMapOrig.pollFirstEntry());// 5=Bradman 9996
		System.out.println(treeMapOrig);
		// {25=Dravid 12000, 45=Lara 10000, 55=Sachin 14000}
		// In above example element 5 is removed from the set and also removed
		// from the tree set.

		// pollLastEntry returns the last entry from the map and
		// removes it from the map
		System.out.println(treeMapOrig);
		// {25=Dravid 12000, 45=Lara 10000, 55=Sachin 14000}
		System.out.println(treeMapOrig.pollLastEntry());// 55=Sachin 14000
		System.out.println(treeMapOrig);
		// {25=Dravid 12000, 45=Lara 10000}

		// subSet,headSet,tailSet Methods in TreeSet
		TreeSet<Integer> exampleTreeSet = new TreeSet<Integer>();
		exampleTreeSet.add(55);
		exampleTreeSet.add(25);
		exampleTreeSet.add(105);
		exampleTreeSet.add(35);
		exampleTreeSet.add(5);

		System.out.println(exampleTreeSet);// [5, 25, 35, 55, 105]

		// All the three methods - subSet,headSet,tailSet - are inclusive with
		// Lower Limit and NOT inclusive with higher limit.

		// Get sub set with values >=25 and <55
		SortedSet<Integer> subTreeSet = exampleTreeSet.subSet(25, 55);
		System.out.println(subTreeSet);// [25, 35]
		// In the sub set, Lower Limit inclusive - 25 included. Higher limit not
		// inclusive - 55 excluded.

		// Get sub set with values <55
		SortedSet<Integer> headTreeSet = exampleTreeSet.headSet(55);
		System.out.println(headTreeSet);// [5, 25, 35]
		// In the sub set, Higher limit not inclusive - 55 excluded.

		// Get sub set with values >=35
		SortedSet<Integer> tailTreeSet = exampleTreeSet.tailSet(35);
		System.out.println(tailTreeSet);// [35, 55, 105]
		// In the sub set, Lower limit inclusive - 35 included.

		// Get sub set with value >=25 and <=55 (both inclusive parameters -
		// true)
		SortedSet<Integer> subTreeSetIncl = exampleTreeSet.subSet(25, true, 55,
				true);
		System.out.println(subTreeSetIncl);// [25, 35, 55]

		// Get sub set with value >25 and <55 (both inclusive parameters -
		// false)
		SortedSet<Integer> subTreeSetNotIncl = exampleTreeSet.subSet(25, false,
				55, false);
		System.out.println(subTreeSetNotIncl);// [35]

		// Get sub set with values <=55. Inclusive set to true.
		SortedSet<Integer> headTreeSetIncl = exampleTreeSet.headSet(55, true);
		System.out.println(headTreeSetIncl);// [5, 25, 35, 55]

		// Get sub set with values >35. Inclusive set to false.
		SortedSet<Integer> tailTreeSetNotIncl = exampleTreeSet.tailSet(35,
				false);
		System.out.println(tailTreeSetNotIncl);// [55, 105]

		// All the sub set methods - subSet,headSet,tailSet - return dynamic sub
		// sets.
		// When original set is modified (addition or deletion), corresponding
		// changes
		// can affect the sub sets as well (if

		System.out.println(exampleTreeSet);// [5, 25, 35, 55, 105]
		System.out.println(subTreeSet);// [25, 35]
		System.out.println(headTreeSet);// [5, 25, 35]
		System.out.println(tailTreeSet);// [35, 55, 105]

		// Let's now insert a value 30 into the exampleTreeSet.
		// Remember that subTreeSet,headTreeSet,tailTreeSet are sub sets of
		// exampleTreeSet

		exampleTreeSet.add(30);

		System.out.println(exampleTreeSet);// [5, 25, 30, 35, 55, 105]
		System.out.println(subTreeSet);// [25, 30, 35]
		System.out.println(headTreeSet);// [5, 30, 25, 35]
		System.out.println(tailTreeSet);// [35, 55, 105]

		// 30 is in the range of subTreeSet and headTreeSet.
		// So, it is printed as part of exampleTreeSet, subTreeSet and
		// headTreeSet.

		// Lets now add 65 to the set
		exampleTreeSet.add(65);

		System.out.println(exampleTreeSet);// [5, 25, 30, 35, 55, 65, 105]
		System.out.println(subTreeSet);// [25, 30, 35]
		System.out.println(headTreeSet);// [5, 30, 25, 35]
		System.out.println(tailTreeSet);// [35, 55, 65, 105]

		// 65 is printed as part of exampleTreeSet and tailTreeSet.

		// Key thing to remember is that all the sub sets are dynamic. If you
		// modify the original set,
		// the sub set might be affected.

		// Methods similar to subSet,headSet,tailSet (of TreeSet) are available
		// in TreeMap as well.
		// They are called subMap, headMap, tailMap.
		// They have the similar signatures and results as the corresponding
		// TreeSet Methods.
		// They are inclusive with Lower Limit and NOT inclusive with higher
		// limit - unless the (optional) inclusive flag is passed.
		// The resultant sub map's are dynamic. If original map get modified,
		// the sub map might be affected as well.

		TreeMap<Integer, Cricketer> exampleTreeMap = new TreeMap<Integer, Cricketer>();
		exampleTreeMap.put(55, new Cricketer("Sachin", 14000));
		exampleTreeMap.put(25, new Cricketer("Dravid", 12000));
		exampleTreeMap.put(5, new Cricketer("Bradman", 9996));
		exampleTreeMap.put(45, new Cricketer("Lara", 10000));

		// Lower limit (5) inclusive, Uppper Limit(25) NOT inclusive
		System.out.println(exampleTreeMap.subMap(5, 25));// {5=Bradman 9996}

		System.out.println(exampleTreeMap.headMap(30));
		// {5=Bradman 9996, 25=Dravid 12000}

		System.out.println(exampleTreeMap.tailMap(25));
		// {25=Dravid 12000, 45=Lara 10000, 55=Sachin 14000}

		// PriorityQueue
		// Using default constructor - uses natural ordering of numbers
		// Smaller numbers have higher priority
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		// Adding an element into priority queue - offer method
		priorityQueue.offer(24);
		priorityQueue.offer(15);
		priorityQueue.offer(9);
		priorityQueue.offer(45);

		System.out.println(priorityQueue);// [9, 24, 15, 45]

		// peek method get the element with highest priority.
		System.out.println(priorityQueue.peek());// 9
		// peek method does not change the queue
		System.out.println(priorityQueue);// [9, 24, 15, 45]

		// poll method gets the element with highest priority.
		System.out.println(priorityQueue.poll());// 9
		// peek method removes the highest priority element from the queue.
		System.out.println(priorityQueue);// [24, 15, 45]

		// This comparator gives high priority to the biggest number.
		Comparator reverseComparator = new Comparator<Integer>() {
			public int compare(Integer paramT1, Integer paramT2) {
				return paramT2 - paramT1;
			}

		};

		// We can create priority queue using a comparator class i.e. custom
		// defined priority
		PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<Integer>(
				20, reverseComparator);

		priorityQueueDesc.offer(24);
		priorityQueueDesc.offer(15);
		priorityQueueDesc.offer(9);
		priorityQueueDesc.offer(45);

		// 45 is the largest element. Our custom comparator gives priority to
		// highest number.
		System.out.println(priorityQueueDesc.peek());// 45

		// Collections static methods
		// static int binarySearch(List, key)
		// static int binarySearch(List, key, Comparator)
		// static void reverse(List)//Reverse the order of elements in a List.
		// static Comparator reverseOrder();//Return a Comparator that sorts the
		// reverse of the collection�s current sort sequence.
		// static void sort(List)
		// static void sort(List, Comparator)
	}
}
```
