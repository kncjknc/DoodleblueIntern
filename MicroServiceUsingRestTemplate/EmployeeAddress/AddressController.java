package Employee_address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Employee_address.response.EmployeeAddressResponse;
import Employee_address.service.EmployeeService;

@RestController
public class EmployeeAddressController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAddress/{id}")
	public ResponseEntity<EmployeeAddressResponse> getEmployeeAddressById(@PathVariable("id") int id) {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeAddressById(id));

	}

	@GetMapping("/getJoin/{employeeid}")
	public ResponseEntity<EmployeeAddressResponse> getEmployeejoin(@PathVariable("employeeid") int employeeid) {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeejoin(employeeid));

	}

}
