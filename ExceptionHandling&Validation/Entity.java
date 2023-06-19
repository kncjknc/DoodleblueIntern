package Exceptions1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stdentsDa")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
	private String name;
	private char section;
	private String city;
	private String parentNo;
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

	public Students() {
		super();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Students(int rollNo, String name, char section, String city, String parentNo, String mail) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.section = section;
		this.city = city;
		this.parentNo = parentNo;
		this.mail = mail;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

}
