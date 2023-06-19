package Exceptions1.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentsRequest {

	@Min(1)
	@Max(1000)
	private int rollNo;
	@NotBlank(message = "Name Column Must Not Be Blank")
	private String name;
	@NotNull(message = "Section Not Valid")
	private char section;
	@NotNull(message = "City Must Not Be Null")
	private String city;
	@Pattern(regexp = "^\\d{10}$", message = "Not Valid Phone Number")
	private String parentNo;
	@Email(message = "Invalid Mail Id")
	private String mail;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public StudentsRequest() {
		super();
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public StudentsRequest(@Min(1) @Max(1000) int rollNo,
			@NotBlank(message = "Name Column Must Not Be Null") String name,
			@NotNull(message = "Section Not Valid") char section,
			@NotNull(message = "City Must Not Be Null") String city,
			@Pattern(regexp = "^\\d{10}$", message = "Not Valid Phone Number") String parentNo,
			@Email(message = "Invalid Mail Id") String mail) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.section = section;
		this.city = city;
		this.parentNo = parentNo;
		this.mail = mail;
	}

}
