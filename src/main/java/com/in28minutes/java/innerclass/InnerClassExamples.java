
package com.in28minutes.java.innerclass;
class OuterClass {
	private int outerClassInstanceVariable;

	public void exampleMethod() {
		int localVariable;
		final int finalVariable = 5;

		class MethodLocalInnerClass {
			public void method() {
				// Can access class instance variables
				System.out.println(outerClassInstanceVariable);

				// Cannot access method's non-final local variables
				// localVariable = 5;//Compiler Error
				System.out.println(finalVariable);// Final variable is fine..
			}
		}

		// MethodLocalInnerClass can be instantiated only in this method
		MethodLocalInnerClass m1 = new MethodLocalInnerClass();
		m1.method();
	}

	// MethodLocalInnerClass can be instantiated only in the method where it is
	// declared
	// MethodLocalInnerClass m1 = new MethodLocalInnerClass();//COMPILER ERROR

	public static class StaticNestedClass {
		private int staticNestedClassVariable;

		public int getStaticNestedClassVariable() {
			return staticNestedClassVariable;
		}

		public void setStaticNestedClassVariable(int staticNestedClassVariable) {
			this.staticNestedClassVariable = staticNestedClassVariable;
		}

		public void privateVariablesOfOuterClassAreNOTAvailable() {
			// outerClassInstanceVariable = 5; //COMPILE ERROR
		}
	}

	public class InnerClass {
		private int innerClassVariable;

		public int getInnerClassVariable() {
			return innerClassVariable;
		}

		public void setInnerClassVariable(int innerClassVariable) {
			this.innerClassVariable = innerClassVariable;
		}

		public void privateVariablesOfOuterClassAreAvailable() {
			outerClassInstanceVariable = 5; // we can access the value and
											// change it

			System.out.println("Inner class ref is " + this);

			// Accessing outer class reference variable
			System.out.println("Outer class ref is " + OuterClass.this);
		}
	}

	public void createInnerClass() {
		// Just use the inner class name to create it
		InnerClass inner = new InnerClass();
	}

}

public class InnerClassExamples {
	public static void main(String[] args) {
		// Static Nested Class can be created without needing to create its
		// parent. Without creating NestedClassesExample, we created
		// StaticNestedClass
		OuterClass.StaticNestedClass staticNestedClass1 = new OuterClass.StaticNestedClass();
		staticNestedClass1.setStaticNestedClassVariable(5);

		OuterClass.StaticNestedClass staticNestedClass2 = new OuterClass.StaticNestedClass();
		staticNestedClass2.setStaticNestedClassVariable(10);

		// Static Nested Class member variables are not static. They can have
		// different values.
		System.out.println(staticNestedClass1.getStaticNestedClassVariable()); // 5
		System.out.println(staticNestedClass2.getStaticNestedClassVariable()); // 10

		// COMPILER ERROR! You cannot create an inner class on its own.
		// InnerClass innerClass = new InnerClass();
		OuterClass example = new OuterClass();

		// To create an Inner Class you need an instance of Outer Class
		OuterClass.InnerClass innerClass = example.new InnerClass();

	}
}