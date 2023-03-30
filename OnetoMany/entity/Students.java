package CrudQuery.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Students {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String gender;
	private String aadhar;

	public Students() {
		super();
	}

	public Students(int id, String name, String gender, String aadhar) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.aadhar = aadhar;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	@OneToMany(targetEntity = LibraryBook.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "id")
	private List<LibraryBook> libraryBook;

	public List<LibraryBook> getLibraryBook() {
		return libraryBook;
	}

	public void setLibraryBook(List<LibraryBook> libraryBook) {
		this.libraryBook = libraryBook;
	}

}
