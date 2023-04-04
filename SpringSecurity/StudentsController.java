package CrudQueryWithSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CrudQueryWithSecurity.entity.Students;
import CrudQueryWithSecurity.service.StudentsService;

@RestController
public class StudentFileController {

	@Autowired
	private StudentsService service;

	@PostMapping("/addStudent")
	public Students addDetail(@RequestBody Students student) {
		return service.saveDetail(student);
	}

	@PostMapping("/addStudents")
	public List<Students> addDetails(@RequestBody List<Students> students) {
		return service.saveDetails(students);
	}

	@GetMapping("/getStudents")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Students> findAllStudents() {
		return service.getStudents();
	}

	@GetMapping("/student/{id}")
	@PreAuthorize("hasAuthority('ROLE_HR')")
	public Students findStudentsById(@PathVariable int id) {
		return service.getStudentById(id);
	}

	@GetMapping("/students/{name}")
	public Students findStudentsByName(@PathVariable String name) {
		return service.getStudentByName(name);
	}

	@PutMapping("/update")
	public Students updateStudent(@RequestBody Students student) {
		return service.updateStudents(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

	@GetMapping("/getOrderByNames")
	
	public List<Students> getOrderByNames() {
		return service.getOrderByNames();
	}

	@GetMapping("/getDatailsUsingNameorIds/{name}/{id}")
	public List<Students> getDetailUsingNameorId(@PathVariable String name, @PathVariable int id) {
		return service.getDetailUsingNameorId(name, id);
	}

	@GetMapping("/getAllDeailFDromNative")
	public List<Students> getAllDeatilUsingNative() {
		return service.getAllDeatilUsingNative();
	}

	@GetMapping("/getExactValueNativeinName/{name}")
	public List<Students> getExactDeatail(@PathVariable String name) {
		return service.getExactDeatail(name);
	}

	@GetMapping("/findByStdUsingNamedQuery")
	public Students findByStd(String k) {
		return service.findByStd(k);
	}

}
