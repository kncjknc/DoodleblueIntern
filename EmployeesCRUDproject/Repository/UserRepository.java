package EmployeeManageMentSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeManageMentSystem.entity.UsersInfo;

@Repository
public interface UserRepository extends JpaRepository<UsersInfo, Integer> {

	Optional<UsersInfo> findByusername(String username);

}
