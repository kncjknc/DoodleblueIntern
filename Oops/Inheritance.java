 // Inheritance
	
// An object of one class behaving as an object of another class too.
	
// Button Phone is Parent Class

package Inheritance;

public class Button_Phone {

	String sim = "Airtel";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Button_Phone nokia = new Button_Phone();
		nokia.call();
		Button_Phone karbonn = new Button_Phone();
		karbonn.simSlat();

	}

	void call() {

		System.out.println("Voice Call Only Available");

	}

	void simSlat() {

		System.out.println("Only One Slat Available" + sim);

	}

	void ringtone() {
		System.out.println("Default Ringtone");
	}

}

// Smart_phone class is a Child Class

package Inheritance;

public class Smart_Phone extends Button_Phone {

	String sim2 = "Vi";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Smart_Phone vivo = new Smart_Phone();

		vivo.call();
		vivo.ringtone();
		vivo.simSlat();

		Smart_Phone oppo = new Smart_Phone();

		oppo.screen();

	}

	void call() {

		super.call();

		System.out.print("Calls Video Call ");

		System.out.println("  Group Call");

	}

	void simSlat() {
		System.out.println("Sim " + super.sim + " and " + sim2);
	}

	void ringtone() {
		System.out.println("Ringtones  We Added New Ringtone ");
	}

	void screen() {
		System.out.print("Screen  Touch Screen");
		System.out.println("Video Game Facilities");
	}

}

// The End Of Single Inheritance 

// Start the Multilevel Inheritance

package Inheritance;

public class Tabl extends Smart_Phone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tabl macTab = new Tabl();

		macTab.call();
		macTab.ringtone();
		macTab.simSlat();

	}

	void screen() {
		System.out.println("Screen is Very Big");
	}

}

------------------------------------------------------------------------------------------------------------------

// Hierarchical Inheritance
	
// Parent Of Hierarchical
	
package Inheritance;

public class Mess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Making Food");

	}

}

// First Child


package Inheritance;

public class Veg extends Mess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Only Vegtables food should be Provided");

	}

}

// Second Child

package Inheritance;

public class NonVeg extends Mess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Serves Veg and NonVeg Foods");

	}

}


// Multiple and Hybrid Inheritance is Supported through interface only. 
