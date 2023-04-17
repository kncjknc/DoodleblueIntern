package Employee_address.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_adress")
public class EmployeeAddress {

	@Id
	@Column(name = "addressID")
	private int addressID;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
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

	public EmployeeAddress(int addressID, String street, String city) {

		this.addressID = addressID;
		this.street = street;
		this.city = city;
	}

	public EmployeeAddress() {

	}

}
