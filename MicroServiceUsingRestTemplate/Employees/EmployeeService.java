package Employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import Employee.entity.Employee;
import Employee.repository.EmployeeRepository;
import Employee.responce.EmployeeAddressResponse;
import Employee.responce.EmployeeResponce;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	private RestTemplate restTemplate;

	public EmployeeService(@Value("${addressService.base.url}") String baseUrl, RestTemplateBuilder builder) {

		this.restTemplate = builder.rootUri(baseUrl).build();
	}

	public EmployeeResponce getEmployee(int id) {

		Employee employee = employeeRepository.findById(id).orElse(null);
		EmployeeResponce employeeResponce = modelMapper.map(employee, EmployeeResponce.class);

		EmployeeAddressResponse response = restTemplate.getForObject("/getAddress/{id}", EmployeeAddressResponse.class,
				id);

		employeeResponce.setEmployeeAddressResponse(response);
		return employeeResponce;
	}

}
