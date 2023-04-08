package SpringSecurityInJwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students_tb")
public class Students {

	@Id
	@GeneratedValue
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Students() {
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private String std;

	public Students(int id, String name, String std, String city) {
		super();
		this.id = id;
		this.name = name;
		this.std = std;
		this.city = city;
	}

	private String city;

	public int getId() {
		return id;
	}

}
