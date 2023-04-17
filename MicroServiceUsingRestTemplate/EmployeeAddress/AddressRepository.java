package Employee_address.repository;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Employee_address.entity.EmployeeAddress;

@Repository
public interface EmployeeAddressRepo extends JpaRepository<EmployeeAddress, Integer> {

	@Query(value = " select * from varathan11.employee_adress ea join varathan11.employee e on e.id = ea.findId where ea.addressID=:employeeid", nativeQuery = true)
	EmployeeAddress getEmployeejoin(@Param("employeeid") int employeeid);
}
