package InternetBank.model;

import java.time.LocalDateTime;

public class BankingModel {

	private int accNo;

	private String cutomerName;

	private int currentBal;

	private String branch;

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

	public BankingModel(int accNo, String cutomerName, int currentBal, String branch, LocalDateTime creationDate) {
		super();
		this.accNo = accNo;
		this.cutomerName = cutomerName;
		this.currentBal = currentBal;
		this.branch = branch;
		this.creationDate = creationDate;
	}

	public BankingModel() {
		super();
	}

}
