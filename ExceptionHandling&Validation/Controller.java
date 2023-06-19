package Exceptions1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Exceptions1.Exceptionss.StudentNotFound;
import Exceptions1.entity.Students;
import Exceptions1.request.StudentsRequest;
import Exceptions1.service.StudentsService;
import jakarta.validation.Valid;

@RestController
public class StudentsController {

	@Autowired
	private StudentsService studentsService;

	@PostMapping("/postStudents")
	public Students putStudents(@RequestBody @Valid StudentsRequest studentsRequest) {
		return studentsService.putStudents(studentsRequest);
	}

	@GetMapping("/getStudent/{id}")
	public Students getStudent(@PathVariable int id) throws StudentNotFound {
		return studentsService.getStud(id);
	}
}
