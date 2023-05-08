package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;

@RestController
public class StudentFileController {

	@Autowired
	private StudentsService service;

	@PostMapping("/addStudent")
	public Students addDetail(@RequestBody Students student) {
		return service.saveDetail(student);
	}

	
	@GetMapping("/students/{id}")
	public Students findStudentsById(@PathVariable int id) {
		return service.getStudentById(id);
	}

	@PutMapping("/update")
	public Students updateStudent(@RequestBody Students student) {
		return service.updateStudents(student);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	@PatchMapping("/patch/{id}/{name}")
	public Students patchMap(@PathVariable int id,@PathVariable String name) {
		Students student= service.getStudentById(id);
		student.setName(name);
		return student;
	}
	
	@GetMapping("/request/param")
	public Students requestPar(@RequestParam int id) {
		return service.getStudentById(id);
	}
	
	@GetMapping("/requestHead")
	public String requestHead(@RequestHeader String name) {
		//System.out.println(authorization);
		return name;
	}
}
