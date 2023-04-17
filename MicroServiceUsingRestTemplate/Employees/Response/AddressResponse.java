package Employee.responce;

public class EmployeeAddressResponse {

	private int addressID;

	private String street;

	private String city;

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public EmployeeAddressResponse(int addressID, String street, String city) {

		this.addressID = addressID;
		this.street = street;
		this.city = city;
	}

	public EmployeeAddressResponse() {

	}

}
