package InternetBank.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	public String transactionMethod(TransactionDetails transactionDetails) {

		BankingDetails customer = bankingRepository.findById(transactionDetails.getAccountNo()).orElse(null);

		customer.setCurrentBal(customer.getCurrentBal() - transactionDetails.getWithdraw());

		BankingDetails sameBank = bankingRepository.findById(transactionDetails.getTransferAcc()).orElse(null);

		if (sameBank != null) {

			TransactionDetails sameBankCustomeTransfer = new TransactionDetails();
			// sameBankCustomeTransfer.setCustomerId(10);
			sameBankCustomeTransfer.setAccountNo(transactionDetails.getTransferAcc());
			sameBankCustomeTransfer.setDeposit(transactionDetails.getWithdraw());
			sameBankCustomeTransfer.setName(sameBank.getCutomerName());
			sameBankCustomeTransfer.setTransferAcc(transactionDetails.getAccountNo());
			LocalDateTime tranferTime = LocalDateTime.now();
			sameBankCustomeTransfer.setTransactionTime(tranferTime);
			sameBankCustomeTransfer.setWithdraw(0);
			sameBank.setCurrentBal(sameBank.getCurrentBal() + transactionDetails.getWithdraw());

			ArrayList<TransactionDetails> transList = new ArrayList<TransactionDetails>();
			transList.add(transactionDetails);
			transList.add(sameBankCustomeTransfer);

			transactionRepository.saveAll(transList);
		}
		if (sameBank == null) {

			transactionRepository.save(transactionDetails);
		}

		return "Send it!";

	}

	public List<TransactionDetails> getTransactionDetail(int accNo) {

		// TransactionModel transactionModel= modelMapper.map(transactionDetails,
		// TransactionModel.class);

		return transactionRepository.getTransactionDetail(accNo);
	}

}
