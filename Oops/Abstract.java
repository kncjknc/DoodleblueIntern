// Abstrac 

// abstract keyword is a non access modifier, used for classes and methods.
//Restricted class that cannot be used to create objects

// abstract class

package Abstraction;

public abstract class Parent {

	String home = "ECR Beach House";

	int bankBal = 10000;

	abstract void emi();

	abstract void carLoan();

	void homeLoan() {
		System.out.println("Home Loan is Over");

	}

}


// child extends class

 package Abstraction;

public class Child extends Parent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child raj = new Child();

		System.out.println(raj.home);
		System.out.println(raj.bankBal);

		raj.emi();
		raj.carLoan();

	}

	void emi() {
		System.out.println("I will settele this emi");

	}

	void carLoan() {
		System.out.println("I will settele this car Loan");

	}

}

// Now we can see 100% abstract it's called as Interface


package Abstraction;

public interface Organization_Rule {

	int salary = 10000;

	String hike = "Yearly Once";

	void leave();

	void dressCode();

	void hairStyle();

}

// implement class


package Abstraction;

public class Employee implements Organization_Rule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(salary);

		// salary=20000 Can't be modified

		Employee varathan = new Employee();
		varathan.dressCode();
		varathan.leave();

	}

	public void dressCode() {
		System.out.println("Formal Pink Blue Red");

	}

	public void hairStyle() {
		System.out.println("Military Cut French Beard");

	}

	public void leave() {
		System.out.println("Maximum 3Days");

	}

}

