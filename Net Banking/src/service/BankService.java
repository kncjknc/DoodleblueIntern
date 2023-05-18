package InternetBank.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import InternetBank.entity.BankingDetails;
import InternetBank.entity.UsersInfo;
import InternetBank.model.EnquiryClass;
import InternetBank.repository.BankingRepository;

@Service
public class BankingDetailService {

	@Autowired
	private BankingRepository bankingRepository;

	@Autowired
	private UsersInfoService usersInfoService;

	@Autowired
	private ModelMapper modelMapper;

	public BankingDetails createAccount(BankingDetails bankingDetails, String userPassword) {
		LocalDateTime createTime = LocalDateTime.now();
		bankingDetails.setCreationDate(createTime);
		UsersInfo newCustomer = new UsersInfo();
		newCustomer.setClientname(bankingDetails.getCutomerName());
		newCustomer.setPassword(userPassword);
		newCustomer.setRoles("Customer");
		usersInfoService.addUser(newCustomer);
		return bankingRepository.save(bankingDetails);

	}

	public EnquiryClass enquiry(int accNo) {
		BankingDetails customerEnquiry = bankingRepository.findById(accNo).orElse(null);
		EnquiryClass enquiryDetail = modelMapper.map(customerEnquiry, EnquiryClass.class);

		return enquiryDetail;

	}

}
