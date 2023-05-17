package InternetBank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Banking_Details")
public class BankingDetails {

	@Id
	@Column(name = "accNo", nullable = false)
	private int accNo;

	@Column(name = "cutomerName", nullable = false)
	private String cutomerName;

	@Column(name = "currentBal", nullable = false)
	private int currentBal;

	@Column(name = "branch", nullable = false)
	private String branch;

	@Column(name = "creationDate", nullable = false)
	// @JsonProperty("creationDate")
	private LocalDateTime creationDate;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCutomerName() {
		return cutomerName;
	}

	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}

	public int getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(int currentBal) {
		this.currentBal = currentBal;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public BankingDetails(int accNo, String cutomerName, int currentBal, String branch, LocalDateTime creationDate) {
		super();
		this.accNo = accNo;
		this.cutomerName = cutomerName;
		this.currentBal = currentBal;
		this.branch = branch;
		this.creationDate = creationDate;
	}

	public BankingDetails() {
		super();
		System.out.println("Inside BankEntity");

	}

}
