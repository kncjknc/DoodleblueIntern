package EmployeeManageMentSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees_tb")
public class Employees {

	@Id
	private int id;
	private String name;
	private String stack;
	private String empType;
	private int salary;
	private String city;
	private String phNo;

	public Employees(int id, String name, String stack, String empType, int salary, String city, String phNo) {
		super();
		this.id = id;
		this.name = name;
		this.stack = stack;
		this.empType = empType;
		this.salary = salary;
		this.city = city;
		this.phNo = phNo;
	}

	public Employees() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

//	  { "id":5, 
//		  "name":"Bharath", 
//		  "stack":"Flutter", 
//		  "empType":"Permenent",
//	  "salary":56000, 
//	  "city":"Chennai", 
//	  "phNo":"6576465678" }
//	 

}
