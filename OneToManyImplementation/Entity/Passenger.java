package PassengerVSTickets.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
@ToString
public class Passengers {
	
	@Id
	@GeneratedValue
	private int pid;
	private String name;
	private int age;
	private String mail;
	
	@OneToMany(targetEntity = Tickets.class,cascade = CascadeType.ALL)
	@JoinColumn(name="p_fk",referencedColumnName="pid")
	private List<Tickets> tickets;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Tickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}

	public Passengers(int pid, String name, int age, String mail, List<Tickets> tickets) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.mail = mail;
		this.tickets = tickets;
	}

	public Passengers() {
		super();
	}

}
