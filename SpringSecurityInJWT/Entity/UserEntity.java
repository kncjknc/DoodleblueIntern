package SpringSecurityInJwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo {

	@Id
	private int id;
	private String name;
	private String password;
	private String roles;

	public int getId() {
		return id;
	}

	public UserInfo(int id, String name, String password, String roles) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public UserInfo() {

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

}
