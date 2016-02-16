#Platform
##Java and Platform Independence
- [Image](images/JavaPlatFormIndependence.png)
- Build once, Run anywhere
- Java is one of the most popular platform  independent  languages.  Once  we  compile  a  java  program  and  build  a  jar,  we  can  run  the  jar  (compiled  java program) in any Operating System where a JVM is installed. 
- What is ByteCode?
- The  executable  instructions  are  different  in  different  operating  systems.  So,  there  are  different  JVM s  for  different  operating  systems.  A  JVM  for  windows  is  different  from  a  JVM  for  mac. 

##JDK vs JVM VS JRE
- [Image](images/jvm-jre-jdk.jpg)
- JVM
  - Virtual machine that run the Java bytecode.
  - Makes java portable.
- JRE
  - JVM + Libraries + Other Components (to run applets and other java applications)
- JDK
  - JRE + Compilers + Debuggers

##Classloaders and Types
- [Image](images/JavaClassLoaders.png)
- A Java program is made up of a number of custom classes (written by programmers like us) and core  classes (which come pre-packaged with Java). When a program is executed, JVM needs to load the  content of all the needed class. JVM uses a ClassLoader to find the classes. 
- System Class Loader : Loads all classes from CLASSPATH 
- Extension Class Loader : Loads all classes from extension directory 
- Bootstrap Class Loader : Loads all the Java core files 
- When JVM needs to find a class, it starts with System Class Loader. If it is not found, it checks with  Extension Class Loader. If it not found, it goes to the Bootstrap Class Loader. If a class is still not found, a  ClassNotFoundException is thrown. 

#Language Basics
##Why do we need Wrapper Classes?
- [Example 1](src/main/java/com/in28minutes/java/wrapper/WrapperExamples.java)
- A wrapper class wraps (encloses) around a data type and gives it an object appearance
- Wrapper: Boolean,Byte,Character,Double,Float,Integer,Long,Short 
- Primitive: boolean,byte,char ,double, float, int , long,short
- Examples of creating wrapper classes are listed below.
  - Integer number = new Integer(55);//int;
  - Integer number2 = new Integer("55");//String
  - Float number3 = new Float(55.0);//double argument  
  - Float number4 = new Float(55.0f);//float argument  
  - Float number5 = new Float("55.0f");//String 
  - Character c1 = new Character('C');//Only char constructor 
  - Boolean b = new Boolean(true); 
- Reasons
  - null is a possible value
  - use it in a Collection
  - Object like creation from other types.. like String

##Are instances of Wrapper Classes Immutable?
- What is Immutability?
- Wrapper classes are final and immutable. 

##What is Auto Boxing?
```
	// Auto Boxing
	Integer ten = 10;//new Integer(10);
	ten++;// allowed. Java does had work behind the screen for us
```
 
- Boxing and new instances - Auto  Boxing  helps  in  saving  memory  by  reusing  already  created  Wrapper  objects.  However  wrapper  classes created using new are not reused. 
```
		// Two wrapper objects created using new are not same object
		Integer nineA = new Integer(9);
		Integer nineB = new Integer(9);
		System.out.println(nineA == nineB);// false
		System.out.println(nineA.equals(nineB));// true

		// Two wrapper objects created using boxing are same object
		Integer nineC = 9;
		Integer nineD = 9;
		System.out.println(nineC == nineD);// true
		System.out.println(nineC.equals(nineD));// true
```

#Strings
##Are String's immutable?
```
		//Strings are immutable
		String str3 = "value1";
		str3.concat("value2");
		System.out.println(str3); //value1
		
		//The result should be assigned to a new reference variable (or same variable) can be reused.
		String concat = str3.concat("value2");
		System.out.println(concat); //value1value2
```

##String vs StringBuffer vs StringBuilder
- Immutability : String
- Thread Safety : String(immutable), StringBuffer
- Performance : StringBuilder (especially when a number of modifications are made.)
- [Example 1](src/main/java/com/in28minutes/java/string/StringBufferBuilderExamples.java)

#OOPS Basics
##Inheritance
- Basics of Inheritance
- Every Class Extends Object - See [Example](src/main/java/com/in28minutes/java/oops/inheritance/EveryClassExtendsObject.java)
- [Example 1](src/main/java/com/in28minutes/java/oops/inheritance/InheritanceExamples.java)
- Reuse Through Inheritance - [TestReuse.java](src/main/java/com/in28minutes/java/oops/inheritance/reuse/TestReuse.java) [Hero.java](src/main/java/com/in28minutes/java/oops/inheritance/reuse/Hero.java) [Actor.java](src/main/java/com/in28minutes/java/oops/inheritance/reuse/Actor.java) [Comedian.java](src/main/java/com/in28minutes/java/oops/inheritance/reuse/Comedian.java)
- Example in Java Api : HashMap & TreeMap extend AbstractMap. 

##Method Overloading
- Java Example
  - Constructors
  - public HashMap(int initialCapacity, float loadFactor)
  - public HashMap() {
  - public HashMap(int initialCapacity)
  - Methods  
  - public boolean addAll(Collection<? extends E> c)
  - public boolean addAll(int index, Collection<? extends E> c)
- [Rules](src/main/java/com/in28minutes/java/oops/inheritance/overloading/OverloadingRules.java)

##Method Overriding
- Java Example
  - HashMap public int size() overrides AbstractMap public int size()
- [Example](src/main/java/com/in28minutes/java/oops/inheritance/overriding/OverridingRules.java)

##Interface
- An interface is a contract: the guy writing the interface says, "hey, I accept things looking that way"
- Interface represents common actions between Multiple Classes.
- Basic Example : [Flyable](src/main/java/com/in28minutes/java/oops/interfaces/Flyable.java)
 [Aeropane](src/main/java/com/in28minutes/java/oops/interfaces/Aeroplane.java) [Bird](src/main/java/com/in28minutes/java/oops/interfaces/Bird.java)
- Example in Java api : Map interface, Collection interface.
- Rules and Examples : [Rules](src/main/java/com/in28minutes/java/oops/interfaces/IntefaceRules.java) [More Examples](src/main/java/com/in28minutes/java/oops/interfaces/InterfaceExamples.java)

##Java and Multiple Inheritance
- Java does not support multiple inheritance.
- However, A class can implement multiple interfaces. But, thats not Multiple inheritance in my book.
- An example of a class in the JDK that implements several interfaces is HashMap, which implements the interfaces Serializable, Cloneable, and Map<K, V>. By reading this list of interfaces, you can infer that an instance of HashMap (regardless of the developer or company who implemented the class) can be cloned, is serializable (which means that it can be converted into a byte stream; see the section Serializable Objects), and has the functionality of a map.

##Abstract Class
- Abstract Class uses Inheritance and hence is an implementation of IS-A relationship between classes.
- If you want to provide common, implemented functionality among all implementations of your component, use an abstract class. Abstract classes allow you to partially implement your class.
- Example - Animal, Cat, Dog
- An example of an abstract class in the JDK is AbstractMap, which is part of the Collections Framework. Its subclasses (which include HashMap, TreeMap, and ConcurrentHashMap) share many methods (including get, put, isEmpty, containsKey, and containsValue) that AbstractMap defines. 
  - example abstract method : public abstract Set<Entry<K,V>> entrySet();
- [Another Example - Spring AbstractController] (https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/mvc/AbstractController.java)
- [More Details](docs/abstract-class.md)

##Abstract Class vs Interface
- Real Difference - Apple vs Orange
- Syntactical Differences
  - Methods and members of an abstract class can have any visibility.  All methods of an interface must be  public.
  - A concrete child class of an Abstract Class must define all the abstract methods. An Abstract child class can have abstract methods. An interface extending another interface need not provide default implementation for methods inherited from the parent interface. 
  - A child class can only extend a single class. An interface can extend multiple interfaces. A class can implement multiple interfaces.
  - A child class can define abstract methods with the same or less restrictive visibility, whereas a class implementing an interface must define all interface methods as public

##Polymorphism
- [Polymorphism](docs/inheritance-and-polymorphism.md)

##Abstraction
- Base of all programming
- Example:
  - Consider simple statement : a = b + c;
  - Add two values stored in two memory locations and store it into a third memory location.
  - Actual operation involves registers, instruction sets, program counters etc. High level language we use abstracts those complex details.

##Encapsulation
- [Example](src/main/java/com/in28minutes/java/oops/encapsulation/EncapsulationExample.java)

##Inner Class
- [Example](src/main/java/com/in28minutes/java/innerclass/InnerClassExamples.java)
- [Example](src/main/java/com/in28minutes/java/innerclass/AnonymousClass.java)

#Access and Non Access Modifiers

##Final Modifier
- [Final Class](src/main/java/com/in28minutes/java/classmodifiers/nonaccess/finalclass/FinalClass.java)
- Final Class examples : String, Integer, Double and other wrapper classes
- [Final Member Variable](src/main/java/com/in28minutes/java/membermodifiers/nonaccess/FinalMemberModifiersExample.java)
- Final Variable example : java.lang.Math.PI
- Final Method example : java.lang.Math.PI

##Member Access Modifiers
- [Examples](src/main/java/com/in28minutes/java/membermodifiers/access)

##Class Access Modifiers
- [Examples](src/main/java/com/in28minutes/java/classmodifiers/)
- public - Accessible from everywhere.
- private and protected cannot be used on a class. 

##Static Modifier
- [Example](src/main/java/com/in28minutes/java/membermodifiers/nonaccess/StaticModifierExamples.java)
- Examples in Java Api : Methods in Math class.

#Constructors

##Constructors
- [Example](src/main/java/com/in28minutes/java/object/constructors/ConstructorExamples.java)
- Examples in Java Api : HashMap has 2 constructors

##Static Initializers
- [Example](src/main/java/com/in28minutes/java/initializers/InitializerExamples.java)

#Collections

##Why do we need Collections?
- Arrays are not resizable.
- Java Collections Framework allows you to use the right data structure, because one size does not fit all.
- Java Collections Framework provides the correct abstractions, List, Map, Set

##Hierarchy of Collection Interface?
- [Hierarchy](src/main/java/com/in28minutes/java/collections/CollectionHierarchy.java)

##List
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##Map
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##Set
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##List vs Map vs Set
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##Comparing Objects in Collections
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##Collection Keywords : 
- Hash - No Order is Maintained
- Tree - Collection is Sorted
- Linked - Insertion Order Maintained
- Set - No Duplicates

##HashSet vs TreeSet vs LinkedHashSet
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##TreeMap vs HashMap
- [All Collections Examples](src/main/java/com/in28minutes/java/collections/examples/CollectionExamples.java)

##Concurrency in Collections
- Synchronized collections are implemented using synchronized methods and synchronized blocks. Only one thread can executing any of the synchronized code at a given point in time. This places severe restrictions on the concurrency of threads – thereby affecting performance of the application. All the pre Java 5 synchronized collections (HashTable & Vector, for example) use this approach. Post Java 5, collections using new approaches to synchronization are available in Java. These are called concurrent collections. More details below.
- When many threads are expected to access a given collection, a ConcurrentHashMap is normally preferable to a synchronized HashMap, and a ConcurrentSkipListMap is normally preferable to a synchronized TreeMap. A CopyOnWriteArrayList is preferable to a synchronized ArrayList when the expected number of reads and traversals greatly outnumber the number of updates to a list.
- Copy on Write
  - All values in collection are stored in an internal immutable (not-changeable) array. A new array is created if there is any modification to the collection. 
  - Read operations are not synchronized. Only write operations are synchronized.
  - Copy on Write approach is used in scenarios where reads greatly out number write’s on a collection. CopyOnWriteArrayList & CopyOnWriteArraySet are implementations of this approach. Copy on Write collections are typically used in Subject – Observer scenarios, where the observers very rarely change. Most frequent operations would be iterating around the observers and notifying them.
  - Example : CopyOnWriteArrayList : public boolean add(E e)
- Locks
  - CopyOnWriteArrayList : final ReentrantLock lock = this.lock; 
  - When 10 methods are declared as synchronized, only one of them is executed by any of the threads at any point in time.  This has severe performance impact.  
  - Another new approach introduced in Java 5 is to use lock and unlock methods. Lock and unlock methods are used to divide methods into different blocks and help enhance concurrency. The 10 methods can be divided into different blocks, which can be synchronized based on different variables.

##Concurrent Modification & Fail Safe vs Fail Fast
- Concurrent Modification : Changes made to collection when one or more threads are iterating over it.
- Fail Fast : Throws Concurrent Modification Exception if there are Concurrent Modifications
- Fail Safe : Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data structure. 
- Fail Safe is efficient when traversal operations vastly outnumber mutations
- [FailFast](src/main/java/com/in28minutes/java/collections/FailFast.java)
- [FailSafe](src/main/java/com/in28minutes/java/collections/FailSafe.java)

##Atomic Operations
- Atomic Access Java Tutorial states “In programming, an atomic action is one that effectively happens all at once. An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen at all. No side effects of an atomic action are visible until the action is complete”.
- Let’s assume we are writing a multi threaded program. Let’s create an int variable i.  Even a small operation, like i++ (increment), is not thread safe. i++ operation involves three steps.
  - Read the value which is currently stored in i 
  - Add one to it (atomic operation). 
  - Store it in i
- In a multi-threaded environment, there can be unexpected results. For example, if thread1 is reading the value (step 1) and immediately after thread2 stores the value (step 3).
- To prevent these, Java provides atomic operations. Atomic operations are performed as a single unit without interference from other threads ensuring data consistency. 
- A good example is AtomicInteger. To increment a value of AtomicInteger, we use the  incrementAndGet() method. Java ensures this operation is Atomic.

##Why do we use Generics?
- Generics are used to create Generic Classes and Generic methods which can work with different Types(Classes).
- [Example 1](src/main/java/com/in28minutes/java/generics/GenericsExamples.java)

##What are the restrictions that can be enforced on Generics?
- [Example 2](src/main/java/com/in28minutes/java/generics/GenericsExamples2.java)
- [Example 3](src/main/java/com/in28minutes/java/generics/GenericsExamples3.java)

#Exception Handling in Java

## Basics
- [Example 1](src/main/java/com/in28minutes/java/exceptionhandling/ExceptionHandlingExample1.java)

## Finally and when is code in finally not executed?
- [Example 2](src/main/java/com/in28minutes/java/exceptionhandling/ExceptionHandlingExample2.java)

## New Exception Handling Features
- TODO - Code Examples

## Hierarchy of Exception Related Classes
- [Example 1](src/main/java/com/in28minutes/java/exceptionhandling/ExceptionHandlingExample1.java)
- [Example 2](src/main/java/com/in28minutes/java/exceptionhandling/ExceptionHandlingExample2.java)

## When do you use Custom Exception?
- When you want to define your own exceptions TODO

## When do you use a Checked Exception?
- When the calling method can do something about the exception being thrown TODO
- In Spring, Most exceptions are unchecked.

#Threads

##Need for Threads.
- [Basic Example](src/main/java/com/in28minutes/java/threads/ThreadExamples.java)

##Different States of a Thread
- [Basic Example](src/main/java/com/in28minutes/java/threads/ThreadExamples.java)

##Synchronization and Join Methods
- [Synchronized Example](src/main/java/com/in28minutes/java/threads/ThreadExampleSynchronized.java)
- [Wait and Notify](src/main/java/com/in28minutes/java/threads/ThreadWaitAndNotify.java)
- [Deadlock Example](src/main/java/com/in28minutes/java/threads/ThreadDeadlock.java)

##Executor Service
- TODO

#Advanced OOPS

##Coupling
- See [More about OOPS](docs/oops-advanced.md)

##Cohesion
- [More about OOPS](docs/oops-advanced.md)

##Solid Principles
- TODO

##Object class
- TODO ObjectExamples.java missing

##toString method
- [Example](src/main/java/com/in28minutes/java/object/ToStringExamples.java)

##hashCode method
- [Example](src/main/java/com/in28minutes/java/object/EqualsHashCodeExamples.java)
- HashCode's are used in hashing to decide which group (or bucket) an object should be placed into. A group of object's might share the same hashcode.
- The implementation of hashcode decides effectiveness of Hashing. A good hashing function evenly distributes object's into different groups (or buckets).
- A good hashCode method should have the following properties 
  - If obj1.equals(obj2) is true, then obj1.hashCode() should be equal to obj2.hashCode()
  - obj.hashCode() should return the same value when run multiple times, if values of obj used in
equals() have not changed.
  - If obj1.equals(obj2) is false, it is NOT required that obj1.hashCode() is not equal to
obj2.hashCode(). Two unequal objects MIGHT have the same hashCode.

##equals method
- [Example](src/main/java/com/in28minutes/java/object/EqualsHashCodeExamples.java)
- Any equals implementation should satisfy these properties:
  - Reflexive. For any reference value x, x.equals(x) returns true.
  - Symmetric. For any reference values x and y, x.equals(y) should return true if and only ify.equals(x) returns true.
  - Transitive. For any reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
  - Consistent. For any reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, if no information used in equals is modified.
  - For any non-null reference value x, x.equals(null) should return false.

#Java New Features

##New Features in Java 5
- TODO

##New Features in Java 6
- TODO

##New Features in Java 7
- TODO

##New Features in Java 8
- TODO

#Miscellaneous

##Annotations
- TODO

##Examples of Design Patterns used in Java

###Some Creational patterns
- Factory method
  - java.util.Calendar#getInstance()
  - java.nio.charset.Charset#forName()
- Prototype
  - java.lang.Object#clone()
- Singleton 
  - java.lang.Runtime#getRuntime()
  - java.lang.System#getSecurityManager()

###Some Structural patterns
- Adapter
  - java.util.Arrays#asList()
  - javax.xml.bind.annotation.adapters.XmlAdapter#marshal() and #unmarshal()

- Decorator 
  - All subclasses of java.io.InputStream, OutputStream etc.
  - java.util.Collections : synchronizedXXX() and unmodifiableXXX() methods.

- Flyweight
  - java.lang.Integer#valueOf(int) (also on other Wrapper classes)

###Behavioral patterns
- Chain of responsibility 
  - javax.servlet.Filter#doFilter()
  - Exception Handling

- Command 
  - java.lang.Runnable

- Iterator
  - All implementations of java.util.Iterator

- Strategy (recognizeable by behavioral methods in an abstract/interface type which invokes a method in an implementation of a different abstract/interface type which has been passed-in as method argument into the strategy implementation)
  - java.util.Comparator#compare(), executed by among others Collections#sort().

- Template method (recognizeable by behavioral methods which already have a "default" behaviour definied by an abstract type)
  - All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.

##Reflection
- TODO

##Assert
- [Example](src/main/java/com/in28minutes/java/others/assertexample/AssertExamples.java)

##Garbage Collection and finalize
- Programmer has no control (other than finalize request and System.gc call - both of which are bad practices)
- This is a big change from C++
- [Example](src/main/java/com/in28minutes/java/others/garbagecollection/GarbageCollectionExamples.java)

##Which datatype should we use for financial calculations?
- TODO

##What is a Marker Interface?
- TODO

##Need for Serialization
- [Example 1](src/main/java/com/in28minutes/java/serialization/SerializationExamples.java)
- [Example 2](src/main/java/com/in28minutes/java/serialization/SerializationExamples2.java)
- [Example 3](src/main/java/com/in28minutes/java/serialization/SerializationExamples3.java)

##Why do we need an Enum?
- [Basic Examples](src/main/java/com/in28minutes/java/enums/Enum.java)
- [Advanced Examples 1](src/main/java/com/in28minutes/java/enums/EnumAdvanced.java)
- [Advanced Examples 2](src/main/java/com/in28minutes/java/enums/EnumAdvanced2.java)

##What are variable arguments?
- [Example](src/main/java/com/in28minutes/java/varargs/VariableArgumentExamples.java)

##Cloning - Deep vs Shallow
- TODO

##Stream
- TODO

##Lambda Expressions
- TODO

## 20 Puzzles to Test Yourselves
- TODO


#Others
 - [Basics of Objects and Classes](docs/basics-class-object.md)
 - [Arrays](docs/arrays.md)
 - [Variables - including initialization](docs/variables-initialization-and-more.md)
 - [Operators](docs/operators.md)
 - [Control Flow - If, Switch, for and while](docs/control-flow-if-switch-for-while)
 - [Files](docs/file-io.md)

#Frameworks
- [Web Application Basics](https://github.com/in28minutes/BasicWebServletsIn28Minutes)
- [Spring](https://github.com/in28minutes/SpringIn28Minutes)
- [Spring MVC](https://github.com/in28minutes/SpringMvcStepByStep)
- [Struts](https://github.com/in28minutes/Struts2StepByStep)
- [Java EE Design Patterns](https://github.com/in28minutes/Java-EE-Design-Patterns)
- [JPA/Hibernate](https://github.com/in28minutes/HibernateJPAStepByStep)
