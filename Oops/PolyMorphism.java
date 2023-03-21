// PolyMorphism

// PolyMorphism means many forms
// Inheritance lets us inherit attributes and methods from another class. 
//Ploymorphism uses methods to perform differnt tasks


// Compile Time PolyMorphism


package PolyMorphism1;

public class Compile_TimePoly {

	public static void main(String[] args) {
		

		Compile_TimePoly ct = new Compile_TimePoly();

		System.out.println(ct.add(10, 10));
		System.out.println(ct.add(10, 20, 15));
		System.out.println(ct.add(10, 50));

	}

	int add(int a, int b) {

		return a + b;

	}

	int add(int a, short b, int c) {

		return a + b + c;

	}

	int add(int a, int b, int c) {
		return a + b + c;
	}

}


// Next RunTime Polymorphism


package PolyMorphism1;

public class India {

	public static void main(String[] args) {

		India in = new India();
		in.holiDays();
		in.capital();

	}

	void holiDays() {
		System.out.println("Holy Functions");
		System.out.println("And Diwali");
	}

	void tradinalDress() {
		System.out.println("Kurtaa");

	}

	void capital() {

		System.out.println("New Delhi");

	}

}


// Override Class


package PolyMorphism1;

public class Tamil_Nadu extends India {

	public static void main(String[] args) {
		Tamil_Nadu tn = new Tamil_Nadu();
		tn.holiDays();
		tn.tradinalDress();
		tn.capital();

	}

	void holiDays() {
		System.out.println("Pongal Functions");
		System.out.println("And Diwali");

	}

	void tradinalDress() {
		System.out.println("Vesti Shirt");

	}

	void capital() {
		System.out.println("New Delhi");

	}

}



