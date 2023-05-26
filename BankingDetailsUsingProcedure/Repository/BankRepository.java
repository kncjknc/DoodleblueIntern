package InternetBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import InternetBank.entity.BankingDetails;

@Repository
public interface BankingRepository extends JpaRepository<BankingDetails, Integer> {

	@Procedure
	String balEnquiry(int accNo);

	@Procedure
	String bankingDetailss(int num);

	@Query(value = "call proc2(:accNo)", nativeQuery = true)
	String proc2(@Param("accNo") int accNo);

	@Procedure(procedureName = "proc4")
	String proc4(int num);
}
