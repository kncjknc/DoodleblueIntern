package InternetBank.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import InternetBank.entity.BankingDetails;
import InternetBank.model.EnquiryClass;
import InternetBank.repository.BankingRepository;

@Service
public class BankingDetailService {

	@Autowired
	private BankingRepository bankingRepository;
	
	public String getProcDetail(int acc) {

		return bankingRepository.balEnquiry(acc);
	}

	public String bankingDetailssUsingProc(int accNo) {
		return bankingRepository.bankingDetailss(accNo);
	}


	public BankingDetails createAccount(BankingDetails bankingDetails) {
		LocalDateTime createTime = LocalDateTime.now();
		bankingDetails.setCreationDate(createTime);
		return bankingRepository.save(bankingDetails);

	}

	public EnquiryClass enquiry(int accNo) {
		BankingDetails customerEnquiry = bankingRepository.findById(accNo).orElse(null);
		EnquiryClass enquiryDetail = new EnquiryClass();
		enquiryDetail.setName(customerEnquiry.getCutomerName());
		enquiryDetail.setYourCurrBal(customerEnquiry.getCurrentBal());
		enquiryDetail.setBranch(customerEnquiry.getBranch());

		return enquiryDetail;

	}


}
