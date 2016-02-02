
### /com/in28minutes/java/membermodifiers/access/different/SubClassInDifferentPackage.java
```
package com.in28minutes.java.membermodifiers.access.different;

import com.in28minutes.java.membermodifiers.access.ExampleClass;

public class SubClassInDifferentPackage extends ExampleClass {

	void subClassMethod() {
		publicVariable = 5;
		publicMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// privateVariable=5; //COMPILE ERROR
		// privateMethod();

		protectedVariable = 5;
		protectedMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// defaultVariable = 5; //COMPILE ERROR
		// defaultMethod();
	}
}
```
### /com/in28minutes/java/membermodifiers/access/different/TestClassInDifferentPackage.java
```
package com.in28minutes.java.membermodifiers.access.different;

import com.in28minutes.java.membermodifiers.access.ExampleClass;

public class TestClassInDifferentPackage {
	public static void main(String[] args) {
		ExampleClass example = new ExampleClass();

		example.publicVariable = 5;
		example.publicMethod();

		// privateVariable,privateMethod are not visible
		// Below Lines, uncommented, would give compiler error
		// example.privateVariable=5; //COMPILE ERROR
		// example.privateMethod();//COMPILE ERROR

		// protectedVariable,protectedMethod are not visible
		// Below Lines, uncommented, would give compiler error
		// example.protectedVariable = 5; //COMPILE ERROR
		// example.protectedMethod();//COMPILE ERROR

		// defaultVariable,defaultMethod are not visible
		// Below Lines, uncommented, would give compiler error
		// example.defaultVariable = 5;//COMPILE ERROR
		// example.defaultMethod();//COMPILE ERROR
	}
}
```
### /com/in28minutes/java/membermodifiers/access/ExampleClass.java
```
package com.in28minutes.java.membermodifiers.access;

public class ExampleClass {
	int defaultVariable;
	public int publicVariable;
	private int privateVariable;
	protected int protectedVariable;

	void defaultMethod() {
		privateVariable = 5;
	}

	public void publicMethod() {

	}

	private void privateMethod() {

	}

	protected void protectedMethod() {

	}
}
```
### /com/in28minutes/java/membermodifiers/access/SubClassInSamePackage.java
```
package com.in28minutes.java.membermodifiers.access;

public class SubClassInSamePackage extends ExampleClass {

	void subClassMethod() {
		publicVariable = 5;
		publicMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// privateVariable=5; //COMPILE ERROR
		// privateMethod();

		protectedVariable = 5;
		protectedMethod();

		defaultVariable = 5;
		defaultMethod();
	}
}
```
### /com/in28minutes/java/membermodifiers/access/TestClassInSamePackage.java
```
package com.in28minutes.java.membermodifiers.access;

public class TestClassInSamePackage {
	public static void main(String[] args) {
		ExampleClass example = new ExampleClass();

		example.publicVariable = 5;
		example.publicMethod();

		// privateVariable is not visible
		// Below Line, uncommented, would give compiler error
		// example.privateVariable=5; //COMPILE ERROR
		// example.privateMethod();

		example.protectedVariable = 5;
		example.protectedMethod();

		example.defaultVariable = 5;
		example.defaultMethod();
	}
}
```
