package Employee.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Employee.responce.EmployeeAddressResponse;

@FeignClient(name = "varathan",url="http://localhost:9092/employee-app/api")
public interface AddressFeign {
	
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<EmployeeAddressResponse> getEmployeeAddressById(@PathVariable("id") int id);




}
