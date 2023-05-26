package InternetBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import InternetBank.entity.BankingDetails;
import InternetBank.entity.TransactionDetails;
import InternetBank.model.EnquiryClass;
import InternetBank.repository.BankingRepository;
import InternetBank.service.BankingDetailService;
import InternetBank.service.TransactionService;

@RestController

public class BankController {

	@Autowired
	private BankingDetailService bankingDetailService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private BankingRepository bankingRepository;
	
	
	@GetMapping("/getEnquiryUsingProc/{acNo}")
	public String getDetail(@PathVariable int acNo) {
		return bankingDetailService.getProcDetail(acNo);
	}

	@GetMapping("/getTransactionListUsingProc/{accNo}")
	public String getTransactionListInProc(@PathVariable int accNo) {
		return transactionService.transactionCheck(accNo);
	}

	@GetMapping("/getBankingDetailInProc/{accNo}")
	public String bankingDetailssUsingProc(@PathVariable int accNo) {
		return bankingDetailService.bankingDetailssUsingProc(accNo);
	}


	@PostMapping("/CreateAcc")
	public BankingDetails createAcc(@RequestBody BankingDetails bankingDetails) {
		return bankingDetailService.createAccount(bankingDetails);
	}

	@PostMapping("/letsTransaction")
	public String transaction(@RequestBody TransactionDetails transactionDetails) {

		BankingDetails customer = bankingRepository.findById(transactionDetails.getAccountNo()).orElse(null);

		if (transactionDetails.getWithdraw() < customer.getCurrentBal()) {

			transactionService.transactionMethod(transactionDetails);

			return "Sent it !";
		} else {
			return "insufficient Balance";
		}
	}

	@GetMapping("/BalanceEnquiry/{accNo}")
	public EnquiryClass balanceEnquiry(@PathVariable int accNo) {
		return bankingDetailService.enquiry(accNo);
	}

	@GetMapping("/getTransactionDetails/{accNo}")
	public List<TransactionDetails> transactionHistory(@PathVariable int accNo) {
		return transactionService.getTransactionDetail(accNo);
	}

	@PatchMapping("/deposit/{ac}/{amount}")
	public String deposit(@PathVariable int ac, @PathVariable int amount) {
		BankingDetails update = bankingRepository.findById(ac).orElse(null);
		update.setCurrentBal(amount + update.getCurrentBal());
		bankingRepository.save(update);
		return "Transaction Completed!";
	}


}
