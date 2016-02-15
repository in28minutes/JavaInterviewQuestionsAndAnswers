#Platform
Java and Platform Independence
- [Image](JavaInterviewQuestionsAndAnswers/images/JavaPlatFormIndependence.png)
- Build once, Run anywhere
- Java is one of the most popular platform  independent  languages.  Once  we  compile  a  java  program  and  build  a  jar,  we  can  run  the  jar  (compiled  java program) in any Operating System U where a JVM is installed. 
- JVM, ByteCode
- TODO JavaPlatFormIndependence.png
- The  executable  instructions  are  different  in  different  operating  systems.  So,  there  are  different  JVM s  for  different  operating  systems.  A  JVM  for  windows  is  different  from  a  JVM  for  mac. 
JDK vs JVM VS JRE
- See jvm-jre-jdk.jpg
- JVM
  - Virtual machine that run the Java bytecode.
  - Makes java portable.
- JRE
  - JVM + Libraries + Other Components (to run applets and other java applications)
- JDK
  - JRE + Compilers + Debuggers

Classloaders and Types
- TODO JavaClassLoaders.png
- A Java program is made up of a number of custom classes (written by programmers like us) and core  classes (which come preUpackaged with Java). When a program is executed, JVM needs to load the  content of all the needed class. JVM uses a ClassLoader to find the classes. 
- System Class Loader U Loads all classes from CLASSPATH 
- Extension Class Loader U Loads all classes from extension directory 
- Bootstrap Class Loader U Loads all the Java core files 
- When JVM needs to find a class, it starts with System Class Loader. If it is not found, it checks with  Extension Class Loader. If it not found, it goes to the Bootstrap Class Loader. If a class is still not found, a  ClassNotFoundException is thrown. 

Why do we need Wrapper Classes?
- See TODO WrapperExamples.java
- A wrapper class wraps (encloses) around a data type and gives it an object appearance
- Wrapper: Boolean,Byte,Character,Double,Float,Integer,Long,Short 
- Primitive: boolean,byte,char ,double, float, int , long,short
- Reasons
  - null is a possible value
  - use it in a Collection
  - Object like creation from other types.. like String

Are instances of Wrapper Classes Immutable?
- Wrapper classes are final and immutable. 
- Examples of creating wrapper classes are listed below.
  - Integer number = new Integer(55);//int;
  - Integer number2 = new Integer("55");//String
  - Float number3 = new Float(55.0);//double argument  
  - Float number4 = new Float(55.0f);//float argument  Float number5 = new Float("55.0f");//String 
  - Character c1 = new Character('C');//Only char constructor 
  - Boolean b = new Boolean(true); 

What is Auto Boxing?
```
	// Auto Boxing
	Integer ten = 10;//new Integer(10);
	ten++;// allowed. Java does had work behind the screen for us
```
Boxing and new instances 
Auto  Boxing  helps  in  saving  memory  by  reusing  already  created  Wrapper  objects.  However  wrapper  classes created using new are not reused. 
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
Immutability of Strings
```
		//Strings are immutable
		String str3 = "value1";
		str3.concat("value2");
		System.out.println(str3); //value1
		
		//The result should be assigned to a new reference variable (or same variable) can be reused.
		String concat = str3.concat("value2");
		System.out.println(concat); //value1value2
```

String vs StringBuffer vs StringBuilder
- String is Immutable
- StringBuilder is not synchronized
- Performance
- see TODO StringBufferBuilderExamples.java

#OOPS Basics
Inheritance
- EveryClassExtendsObject
- See InheritanceExamples
- See [Inheritance and Polymorphism](docs/inheritance-and-polymorphism.md)
- src/main/java/com/in28minutes/java/oops/inheritance/reuse
Method OverLoading
- src/main/java/com/in28minutes/java/oops/inheritance/overloading
Method OverRiding
- src/main/java/com/in28minutes/java/oops/inheritance/overriding
Interface
- [Interfaces](docs/interfaces.md)
- /src/main/java/com/in28minutes/java/oops/interfaces
Java and Multiple Inheritance
Abstract Class
- [Abstract Class](docs/abstract-class.md)
Abstract Class vs Interface
- TODO
Polymorphism
- [Polymorphism](docs/inheritance-and-polymorphism.md)
Abstraction
Encapsulation
- See EncapsulationExample.java
Inner Class
- See /src/main/java/com/in28minutes/java/innerclass/InnerClassExamples.java
- See /JavaInterviewGuide/src/main/java/com/in28minutes/java/innerclass/AnonymousClass.java
Final Modifier
- See FinalClass.java
- See FinalMemberModifiersExample.java
Member Access Modifiers
- See Package com.in28minutes.java.membermodifiers.access
Class Access Modifiers
- See Package com.in28minutes.java.classmodifiers.defaultaccess
Static Modifier
- See StaticModifierExamples.java
Constructors
- See ConstructorExamples.java
Static Initializers
- See InitializerExamples.java

Why do we need Collections?
- Arrays are static in Size.
Hierarchy of Collection Interface?
- CollectionHierarchy.java
List
- See CollectionExamples.java for all examples
Map
Set
List vs Map vs Set
Comparing Objects in Collections
Collection Keywords : 
Hash - No Order is Maintained
Tree - Collection is Sorted
Linked - Insertion Order Maintained
Set - No Duplicates
HashSet vs TreeSet vs LinkedHashSet
TreeMap vs HashMap

Concurrency in Collections
- Synchronized collections are implemented using synchronized methods and synchronized blocks. Only one thread can executing any of the synchronized code at a given point in time. This places severe restrictions on the concurrency of threads – thereby affecting performance of the application. All the pre Java 5 synchronized collections (HashTable & Vector, for example) use this approach. Post Java 5, collections using new approaches to synchronization are available in Java. These are called concurrent collections. More details below.
- Copy on Write
  - All values in collection are stored in an internal immutable (not-changeable) array. A new array is created if there is any modification to the collection. 
  - Read operations are not synchronized. Only write operations are synchronized.
  - Copy on Write approach is used in scenarios where reads greatly out number write’s on a collection. CopyOnWriteArrayList & CopyOnWriteArraySet are implementations of this approach. Copy on Write collections are typically used in Subject – Observer scenarios, where the observers very rarely change. Most frequent operations would be iterating around the observers and notifying them.
- Compare and Swap
  - Compare and Swap is one of the new approaches (Java 5) introduced in java to handle synchronization.  In traditional approach, a method which modifies a member variable used by multiple threads is completely synchronized – to prevent other threads accessing stale value.  
  - In compare and swap approach, instead of synchronizing entire method, the value of the member variable before calculation is cached. After the calculation, the cached value is compared with the current value of member variable. If the value is not modified, the calculated result is stored into the member variable. If another thread has modified the value, then the calculation can be performed again. Or skipped – as the need might be.
  - ConcurrentLinkedQueue uses this approach. 
- Locks
  - When 10 methods are declared as synchronized, only one of them is executed by any of the threads at any point in time.  This has severe performance impact.  
  - Another new approach introduced in Java 5 is to use lock and unlock methods. Lock and unlock methods are used to divide methods into different blocks and help enhance concurrency. The 10 methods can be divided into different blocks, which can be synchronized based on different variables.

Fail Safe vs Fail Fast
  - Fail Fast Iterators throw a ConcurrentModificationException if there is a modification to the underlying collection is modified. This was the default behavior of the synchronized collections of pre Java 5 age.
  - Fail Safe Iterators do not throw exceptions even when there are changes in the collection. This is the default behavior of the concurrent collections, introduced since Java 5.

Atomic Operations
- Atomic Access Java Tutorial states “In programming, an atomic action is one that effectively happens all at once. An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen at all. No side effects of an atomic action are visible until the action is complete”.
- Let’s assume we are writing a multi threaded program. Let’s create an int variable i.  Even a small operation, like i++ (increment), is not thread safe. i++ operation involves three steps.
  - Read the value which is currently stored in i 
  - Add one to it (atomic operation). 
  - Store it in i
- In a multi-threaded environment, there can be unexpected results. For example, if thread1 is reading the value (step 1) and immediately after thread2 stores the value (step 3).
- To prevent these, Java provides atomic operations. Atomic operations are performed as a single unit without interference from other threads ensuring data consistency. 
- A good example is AtomicInteger. To increment a value of AtomicInteger, we use the  incrementAndGet() method. Java ensures this operation is Atomic.

Why do we use Generics?
- Generics are used to create Generic Classes and Generic methods which can work with different Types(Classes).
- See GenericsExamples,GenericsExamples2 and GenericsExamples3 in com.in28minutes.java.generics
What are the restrictions that can be enforced on Generics?
- See GenericsExamples,GenericsExamples2 and GenericsExamples3 in com.in28minutes.java.generics

Exception Handling in Java
- See [Exception Handling](docs/exception-handling.md)
Finally and when is code in finally not executed?
New Exception Handling Features
Puzzles on Exception Handling
Hierarchy of Exception Related Classes
When do you use Custom Exception?
When do you use a Checked Exception?

Need for Threads.
-- See five examples in com.in28minutes.java.threads
Different States of a Thread
Synchronization and Join Methods
Executor Service

Coupling
- See [More about OOPS](docs/oops-advanced.md)
Cohesion
- [More about OOPS](docs/oops-advanced.md)
Solid Principles
Object class
- see ObjectExamples.java
toString method
- See TODO ToStringExamples.java
hashCode method
- See TODO EqualsHashCodeExamples.java
HashCode's are used in hashing to decide which group (or bucket) an object should be placed into. A group of object's might share the same hashcode.
- See TODO EqualsHashCodeExamples.java 
- The implementation of hash code decides effectiveness of Hashing. A good hashing function evenly distributes object's into different groups (or buckets).
- A good hashCode method should have the following properties 
  - If obj1.equals(obj2) is true, then obj1.hashCode() should be equal to obj2.hashCode()
  - obj.hashCode() should return the same value when run multiple times, if values of obj used in
equals() have not changed.
  - If obj1.equals(obj2) is false, it is NOT required that obj1.hashCode() is not equal to
obj2.hashCode(). Two unequal objects MIGHT have the same hashCode.

equals method
- See TODO EqualsHashCodeExamples.java 
- Any equals implementation should satisfy these properties:
  - Reflexive. For any reference value x, x.equals(x) returns true.
  - Symmetric. For any reference values x and y, x.equals(y) should return true if and only ify.equals(x) returns true.
  - Transitive. For any reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true.
  - Consistent. For any reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, if no information used in equals is modified.
  - For any non-null reference value x, x.equals(null) should return false.

New Features in Java 5
New Features in Java 6
New Features in Java 7
New Features in Java 8
Annotations
Examples of Design Patterns used in Java
Reflection
Assert
Garbage Collection and finalize
Which datatype should we use for financial calculations?
What is a Market Interface?
Need for Serialization

Why do we need an Enum?
- Refer 3 Files enum\Enum.java, enum\Advanced.java, enum\Advanced2.java 
What are variable arguments?
Cloning - Deep vs Shallow
Stream
Lambda Expressions

What is JavaDoc?
What is Unit Testing?
What is Continuous Integration?
What is Maven?


#Java Topics
 - [Abstract Class](docs/abstract-class.md)
 - [Arrays](docs/arrays.md)

#Java Interview Questions and Answers

##Basics 
 - [Basics of Objects and Classes](docs/basics-class-object.md)
 - [Variables - including initialization](docs/variables-initialization-and-more.md)
 - [Operators](docs/operators.md)
 - [Control Flow - If, Switch, for and while](docs/control-flow-if-switch-for-while)
 - [Enum](docs/enum.md)
 - [Exception Handling](docs/exception-handling.md)
 - [Files](docs/file-io.md)
 - [Generics](docs/generics.md)
 - [Inheritance and Polymorphism](docs/inheritance-and-polymorphism.md)
 - [Initializers](docs/initializers.md)
 - [Inner Classes](docs/inner-class.md)
 - [String, String Buffer and String Builder](docs/string-and-string-buffer-builder.md)
 - [Wrapper classes](docs/wrapper-classes.md)
 - [Arrays](docs/arrays.md)

##Access and Non Access Modifiers
 - [Class Access Modifiers - Default, Public, Private and Protected](docs/modifiers-class-access.md)
 - [Member Access Modifiers](docs/modifiers-members-access.md)
 - [Final Modifier](docs/modifiers-nonaccess-final.md)
 - [Static Modifier](docs/modifiers-nonaccess-static)

##OOPS
 - [Object and its Methods](docs/object-methods.md)
 - [Inheritance and Polymorphism](docs/inheritance-and-polymorphism.md)
 - [Abstract Class](docs/abstract-class.md)
 - [Interfaces](docs/interfaces.md)
 - [Constructors](docs/constructors.md)
 - [Initializers](docs/initializers.md)
 - [More about OOPS](docs/oops-advanced.md)
 - [Inner Classes](docs/inner-class.md)
 
##Advanced Stuff
 - [Collections](docs/collections.md)
 - [Enum](docs/enum.md)
 - [Exception Handling](docs/exception-handling.md)
 - [Files](docs/file-io.md)
 - [Generics](docs/generics.md)
 - [Variable Arguments](docs/variable-arguments.md)
 - [Assert](docs/others-assert.md)
 - [Date and Calendar](docs/others-date-calendar.md)
 - [Serialization](docs/serialization.md)
 - [Threads and Synchronization](docs/threads-and-synchronization.md)
 - [Others](docs/others.md)

#Frameworks
- [Web Application Basics](https://github.com/in28minutes/BasicWebServletsIn28Minutes)
- [Spring](https://github.com/in28minutes/SpringIn28Minutes)
- [Spring MVC](https://github.com/in28minutes/SpringMvcStepByStep)
- [Struts](https://github.com/in28minutes/Struts2StepByStep)
- [Java EE Design Patterns](https://github.com/in28minutes/Java-EE-Design-Patterns)
- [JPA/Hibernate](https://github.com/in28minutes/HibernateJPAStepByStep)
