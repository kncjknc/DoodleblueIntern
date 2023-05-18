package InternetBank.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import InternetBank.entity.BankingDetails;
import InternetBank.entity.TransactionDetails;
import InternetBank.model.BankingModel;
import InternetBank.model.EnquiryClass;
import InternetBank.model.TransactionModel;
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

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/CreateAcc/{userPassword}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public BankingDetails createAcc(@RequestBody BankingModel bankingModel, @PathVariable String userPassword) {

		BankingDetails bankingDetails = modelMapper.map(bankingModel, BankingDetails.class);

		return bankingDetailService.createAccount(bankingDetails, userPassword);
	}

	@PostMapping("/letsTransaction")
	@PreAuthorize("hasAnyAuthority('Customer','ROLE_ADMIN')")
	public String transaction(@RequestBody TransactionModel transactionModel) {

		TransactionDetails transactionDetails = modelMapper.map(transactionModel, TransactionDetails.class);

		BankingDetails customer = bankingRepository.findById(transactionDetails.getAccountNo()).orElse(null);

		if (transactionDetails.getWithdraw() < customer.getCurrentBal()) {

			return transactionService.transactionMethod(transactionDetails);
		} else {
			return "insufficient Balance";
		}
	}

	@GetMapping("/BalanceEnquiry/{accNo}")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<EnquiryClass> balanceEnquiry(@PathVariable int accNo) {
		EnquiryClass enquiry = bankingDetailService.enquiry(accNo);
		return ResponseEntity.status(HttpStatus.OK).body(enquiry);
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
