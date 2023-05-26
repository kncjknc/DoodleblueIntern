package InternetBank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TransactionDetails")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId", nullable = false)
	private int customerId;

	@Column(name = "accountNo", nullable = false)
	private int accountNo;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "deposit", nullable = false)
	private int deposit;

	@Column(name = "withdraw", nullable = false)
	private int withdraw;

	@Column(name = "transferAcc", nullable = false)
	private int transferAcc;

	@Column(name = "transactionTime", nullable = false)
	private LocalDateTime transactionTime;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getTransferAcc() {
		return transferAcc;
	}

	public void setTransferAcc(int transferAcc) {
		this.transferAcc = transferAcc;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public TransactionDetails(int customerId, int accountNo, String name, int deposit, int withdraw, int transferAcc,
			LocalDateTime transactionTime) {
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.name = name;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.transferAcc = transferAcc;
		this.transactionTime = transactionTime;
	}

	public TransactionDetails() {
	}

}
