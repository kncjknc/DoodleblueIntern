package EmployeeManageMentSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users_tb")
public class UsersInfo {

	@Id
	private int id;
	private String username;
	private String password;
	private String roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public UsersInfo(int id, String username, String password, String roles) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public UsersInfo() {

	}

}
