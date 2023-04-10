package EmployeeManageMentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeManageMentSystem.entity.Employees;
import EmployeeManageMentSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employees addEmployee(Employees employee) {

		return employeeRepository.save(employee);

	}

	public List<Employees> addEmployrees(List<Employees> employees) {
		return employeeRepository.saveAll(employees);
	}

	public String deleteById(int id) {
		employeeRepository.deleteById(id);
		return "The Employee Details Deleted Successfully !";
	}

	public Employees updateEmployee(Employees employees) {

		Employees updateData = employeeRepository.findById(employees.getId()).orElse(null);
		updateData.setEmpType(employees.getEmpType());
		updateData.setName(employees.getName());
		updateData.setPhNo(employees.getPhNo());
		updateData.setSalary(employees.getSalary());
		updateData.setStack(employees.getStack());
		updateData.setId(employees.getId());
		updateData.setCity(employees.getCity());

		return updateData;

	}

	public List<Employees> getOrderByNames() {

		return employeeRepository.getOrderByNames();
	}

	public String getByName(String name) {
		return employeeRepository.getByName(name);
	}

	public List<Employees> getEmployees() {
		return employeeRepository.findAll();
	}

}
