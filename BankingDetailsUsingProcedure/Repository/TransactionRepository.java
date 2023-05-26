package InternetBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import InternetBank.entity.TransactionDetails;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM internetbanking.transaction_details where account_no =:accNo")
	List<TransactionDetails> getTransactionDetail(int accNo);

	@Procedure
	String transactionDetailsCheck(int acc);

}
