package EmployeeManageMentSystem.repository;

import org.springframework.stereotype.Repository;

import EmployeeManageMentSystem.entity.Employees;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

	@Query("SELECT e from Employees e order by e.name")
	List<Employees> getOrderByNames();

	String getByName(String name);

}
