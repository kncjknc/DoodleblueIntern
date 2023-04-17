package Employee_address.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee_address.entity.EmployeeAddress;
import Employee_address.repository.EmployeeAddressRepo;
import Employee_address.response.EmployeeAddressResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeAddressRepo employeeAddressRepo;

	@Autowired
	private ModelMapper modelMapper;

	public EmployeeAddressResponse getEmployeeAddressById(int id) {

		EmployeeAddress employeeEntity = employeeAddressRepo.findById(id).orElse(null);

		EmployeeAddressResponse response = modelMapper.map(employeeEntity, EmployeeAddressResponse.class);

		return response;

	}

	public EmployeeAddressResponse getEmployeejoin(int employeeid) {
		EmployeeAddress employeeEntity = employeeAddressRepo.getEmployeejoin(employeeid);

		EmployeeAddressResponse response = modelMapper.map(employeeEntity, EmployeeAddressResponse.class);

		return response;

	}

}
