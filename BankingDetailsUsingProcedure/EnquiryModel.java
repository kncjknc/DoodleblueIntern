package InternetBank.model;

public class EnquiryClass {

	private String Name;

	private String Branch;

	private int YourCurrBal;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public int getYourCurrBal() {
		return YourCurrBal;
	}

	public void setYourCurrBal(int yourCurrBal) {
		YourCurrBal = yourCurrBal;
	}

	public EnquiryClass(String name, String branch, int yourCurrBal) {
		super();
		Name = name;
		Branch = branch;
		YourCurrBal = yourCurrBal;
	}

	public EnquiryClass() {
		super();
	}

}
