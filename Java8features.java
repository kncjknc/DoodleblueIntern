// Functionala Interface
package Java8Features;

@FunctionalInterface
public interface Inter {

	static int i = 0;
	int j = 10;

	void test();

}

// Used in Class


public class Lambda_Expression {

	int m = 10;
	static int k = 11;

	public static void main(String[] args) {

		Lambda_Expression le = new Lambda_Expression();

		int f = 20;
		// Inter in = new Lambda_Expression();

		Inter in = () -> {
			int s = 0;
			System.out.println("Hi" + Inter.i + " " + Inter.j + " " + Lambda_Expression.k);
			System.out.println(le.m + " " + f);
		};

		in.test();

	}

	/*
	 * public void test() { -----> this is very old method before java 8 version
	 * 
	 * }
	 */

}

// Now we can goto the java8 Features


package Java8Features;

@FunctionalInterface
interface MethodInter {
	void add(int a, int b);
}

class ImplentClass {

	ImplentClass(int a, int b) {
		System.out.println(a + b);
	}

	void mul(int a, int b) {
		System.out.println(a + b);
	}

}

public class MethodRefference {

	public static void main(String[] args) {

		// MethodInter in =ImplentClass::mul;
		// in::add(10, 20); ---> static method Refferences

		// ImplentClass in = new ImplentClass();
		// MethodInter mi = in::mul; -----> Non static method References
		// mi.add(20, 30);

		// MethodInter mi = ImplentClass::new; -----> Constroctor Refreces

	}

}


// Stream Api


package Java8Features;

import java.util.*;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ls = new ArrayList();

		ls.add(10);
		ls.add(20);
		ls.add(30);

		Stream<Integer> stream = ls.stream();

		stream.filter(n -> n > 10).forEach(m -> System.out.println(m));

	}

}

