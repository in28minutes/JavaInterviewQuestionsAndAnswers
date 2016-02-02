### /com/in28minutes/java/classmodifiers/defaultaccess/a/AnotherClassInSamePackage.java
```
package com.in28minutes.java.classmodifiers.defaultaccess.a;

public class AnotherClassInSamePackage {
	// DefaultAccessClass and AnotherClassInSamePackage
	// are in same package.
	// So, DefaultAccessClass is visible.
	// An instance of the class can be created.

	DefaultAccessClass defaultAccess;
}
```
### /com/in28minutes/java/classmodifiers/defaultaccess/a/DefaultAccessClass.java
```
package com.in28minutes.java.classmodifiers.defaultaccess.a;

/* No public before class. So this class has default access*/
class DefaultAccessClass {
	// Default access is also called package access
}
```
### /com/in28minutes/java/classmodifiers/defaultaccess/b/ClassInDifferentPackage.java
```
package com.in28minutes.java.classmodifiers.defaultaccess.b;

public class ClassInDifferentPackage {
	// Class DefaultAccessClass and Class ClassInDifferentPackage
	// are in different packages (*.a and *.b)
	// So, DefaultAccessClass is not visible to ClassInDifferentPackage

	// Below line of code will cause compilation error if uncommented
	// DefaultAccessClass defaultAccess; //COMPILE ERROR!!
}
```
