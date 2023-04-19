package Employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import Employee.entity.Employee;
import Employee.fiegn.AddressFeign;
import Employee.repository.EmployeeRepository;
import Employee.responce.EmployeeAddressResponse;
import Employee.responce.EmployeeResponce;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressFeign addressFeign;

//	private RestTemplate restTemplate;


	public EmployeeResponce getEmployee(int id) {

		Employee employee = employeeRepository.findById(id).orElse(null);
		EmployeeResponce employeeResponce = modelMapper.map(employee, EmployeeResponce.class);

		ResponseEntity< EmployeeAddressResponse > response = addressFeign.getEmployeeAddressById(id);
		
		EmployeeAddressResponse addressResponse = response.getBody();
	

		employeeResponce.setEmployeeAddressResponse(addressResponse);
		return employeeResponce;
	}

}
