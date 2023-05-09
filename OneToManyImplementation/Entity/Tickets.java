package PassengerVSTickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class Tickets {
	
	@Id
	private int tid;
	private String destination;
	private int ticketCount;
	private int price;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Tickets() {
		super();
	}
	public Tickets(int tid, String destination, int ticketCount, int price) {
		super();
		this.tid = tid;
		this.destination = destination;
		this.ticketCount = ticketCount;
		this.price = price;
	}
	

}
