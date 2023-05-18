package InternetBank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsersInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(name = "clientname")
	private String clientname;

	@Column(name = "password")
	private String password;

	@Column(name = "roles")
	private String roles;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public UsersInfo(int uid, String clientname, String password, String roles) {
		super();
		this.uid = uid;
		this.clientname = clientname;
		this.password = password;
		this.roles = roles;
	}

	public UsersInfo() {
		super();
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

}
