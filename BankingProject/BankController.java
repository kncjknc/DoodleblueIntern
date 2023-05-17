package InternetBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PostMapping("/CreateAcc/{userPassword}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public BankingDetails createAcc(@RequestBody BankingDetails bankingDetails, @PathVariable String userPassword) {
		return bankingDetailService.createAccount(bankingDetails, userPassword);
	}

	@PostMapping("/letsTransaction")
	@PreAuthorize("hasAnyAuthority('Customer','ROLE_ADMIN')")
	public String transaction(@RequestBody TransactionDetails transactionDetails) {

		BankingDetails customer = bankingRepository.findById(transactionDetails.getAccountNo()).orElse(null);

		if (transactionDetails.getWithdraw() < customer.getCurrentBal()) {

			return transactionService.transactionMethod(transactionDetails);
		} else {
			return "insufficient Balance";
		}
	}

	@GetMapping("/BalanceEnquiry/{accNo}")
	@PreAuthorize("hasAuthority('Customer')")
	public EnquiryClass balanceEnquiry(@PathVariable int accNo) {
		return bankingDetailService.enquiry(accNo);
	}

	@GetMapping("/getTransactionDetails/{accNo}")
	@PreAuthorize("hasAnyAuthority('Customer','ROLE_ADMIN')")
	public List<TransactionDetails> transactionHistory(@PathVariable int accNo) {
		return transactionService.getTransactionDetail(accNo);
	}

	@PatchMapping("/deposit/{ac}/{amount}")
	// @PreAuthorize("hasAnyRole('Customer')")
	@PreAuthorize("hasAnyAuthority('Customer','ROLE_ADMIN')")
	public String deposit(@PathVariable int ac, @PathVariable int amount) {
		BankingDetails update = bankingRepository.findById(ac).orElse(null);
		update.setCurrentBal(amount + update.getCurrentBal());
		bankingRepository.save(update);
		return "Transaction Completed!";
	}

}
