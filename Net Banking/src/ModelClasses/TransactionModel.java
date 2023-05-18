package InternetBank.model;

import java.time.LocalDateTime;

public class TransactionModel {

	private int customerId;
	private int accountNo;
	private String name;
	private int deposit;
	private int withdraw;
	private int transferAcc;
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

	public TransactionModel(int customerId, int accountNo, String name, int deposit, int withdraw, int transferAcc,
			LocalDateTime transactionTime) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.name = name;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.transferAcc = transferAcc;
		this.transactionTime = transactionTime;
	}

	public TransactionModel() {
		super();
	}

}
