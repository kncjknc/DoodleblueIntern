package InternetBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import InternetBank.entity.BankingDetails;

@Repository
public interface BankingRepository extends JpaRepository<BankingDetails, Integer> {

}
