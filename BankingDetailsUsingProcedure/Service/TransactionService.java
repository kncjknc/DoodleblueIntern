package InternetBank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import InternetBank.entity.BankingDetails;
import InternetBank.entity.TransactionDetails;
import InternetBank.repository.BankingRepository;
import InternetBank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BankingRepository bankingRepository;
	
	public String transactionCheck(int acc) {
		return transactionRepository.transactionDetailsCheck(acc);
	}


	public String transactionMethod(TransactionDetails transactionDetails) {
		int accNo = transactionDetails.getAccountNo();

		BankingDetails customer = bankingRepository.findById(accNo).orElse(null);

		int minus = transactionDetails.getWithdraw();

		customer.setCurrentBal(customer.getCurrentBal() - minus);

		int transferAcc = transactionDetails.getTransferAcc();

		BankingDetails sameBank = bankingRepository.findById(transferAcc).orElse(null);

		if (sameBank != null) {

			TransactionDetails sameBankCustomeTransfer = new TransactionDetails();

			int transAcc = transactionDetails.getTransferAcc();

			sameBankCustomeTransfer.setAccountNo(transactionDetails.getTransferAcc());
			sameBankCustomeTransfer.setDeposit(transactionDetails.getWithdraw());
			sameBankCustomeTransfer.setName(sameBank.getCutomerName());
			sameBankCustomeTransfer.setTransferAcc(transactionDetails.getAccountNo());
			LocalDateTime tranferTime = LocalDateTime.now();
			sameBankCustomeTransfer.setTransactionTime(tranferTime);
			sameBankCustomeTransfer.setWithdraw(0);
			sameBank.setCurrentBal(sameBank.getCurrentBal() + transactionDetails.getWithdraw());

			transactionRepository.save(transactionDetails);
			transactionRepository.save(sameBankCustomeTransfer);
			return "Send it!";

		}
		return "Not Valid AccNo!";

	}

	public List<TransactionDetails> getTransactionDetail(int accNo) {

		return transactionRepository.getTransactionDetail(accNo);
	}


}
