package com.in28minutes.java.classmodifiers.defaultaccess.b;

public class ClassInDifferentPackage {
	// Class DefaultAccessClass and Class ClassInDifferentPackage
	// are in different packages (*.a and *.b)
	// So, DefaultAccessClass is not visible to ClassInDifferentPackage

	// Below line of code will cause compilation error if uncommented
	// DefaultAccessClass defaultAccess; //COMPILE ERROR!!
}
