package InternetBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import InternetBank.entity.UsersInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UsersInfo, Integer> {

	Optional<UsersInfo> findByClientname(String username);

}
