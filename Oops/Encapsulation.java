// Encapsulation

// A class variables are hidden from other classes and can only accessed by the methods. We can achive data security.

package Enacpsul;

public class Bank {

	private int minBalance = 500;
	private int maxTransaction = 50000;

	String name;
	long mobNo;
	String city;

	public static void main(String[] args) {

		Bank manager = new Bank();
		// manager.maxTransaction=10;

	}

	public void setDeatails(String name, long mobNo, String city) {

		this.name = name;
		this.mobNo = mobNo;
		this.city = city;
	}

	int getMinBalance() {
		return this.minBalance;
	}

	int getMaxTransaction() {
		return this.maxTransaction;
	}

}
// Cutomer Class

package Enacpsul;

public class Cutomer extends Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cutomer raju = new Cutomer();

		raju.setDeatails("Raju", 876543234, "chennai");

		System.out.print("Max Transaction  " + raju.getMaxTransaction() + "  Min Balance  " + raju.getMinBalance());

		Cutomer ajith = new Cutomer();

		ajith.setDeatails("Ajith", 10324521, "ECR");

	}

}
