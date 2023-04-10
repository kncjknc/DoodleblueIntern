package EmployeeManageMentSystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EmployeeManageMentSystem.entity.Employees;
import EmployeeManageMentSystem.service.EmployeeService;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeeService employeeService;

	Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@PostMapping("/addEmployee")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employees addEmployee(@RequestBody Employees employee) {
		logger.info("addEmployee");
		return employeeService.addEmployee(employee);
	}

	@PostMapping("/addEmployees")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Employees> addEmployees(@RequestBody List<Employees> employees) {
		return employeeService.addEmployrees(employees);
	}

	@GetMapping("/getAllEmployees")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Employees> getEmployees() {
		logger.warn("getAllEmployees");
		return employeeService.getEmployees();
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deleteByid(@PathVariable int id) {
		return employeeService.deleteById(id);

	}

	@GetMapping("/Employee/{name}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getByName(@PathVariable String name) {
		return employeeService.getByName(name);

	}

	@PostMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employees updateEmployee(@RequestBody Employees employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/OrderByNames")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Employees> getOrderByNames() {
		return employeeService.getOrderByNames();
	}

}
