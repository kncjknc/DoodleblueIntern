package Studens.Course.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Studens.Course.entity.Students;

import Studens.Course.repository.StudentsRepo;
import Studens.Course.service.StudentsService;

@RestController
public class StudentsCourse {


	private StudentsService studentsService;

	public StudentsCourse(StudentsService studentsService) {
		
		this.studentsService = studentsService;
	}

	@PostMapping("/postStudent")
	public Students saveStudentsandCourse(@RequestBody Students students) {

		return studentsService.save(students);
	}

	@GetMapping("/getStudents")
	public List<Students> getAllStudent() {
		return studentsService.findAll();
	}

	@GetMapping("/getById/{id}")
	public Students getStudentById(@PathVariable int id) {
		return studentsService.findById(id);
	}

	@GetMapping("/find/{namee}")
	public Students findStudentsContainingByName(@PathVariable("namee") String namee) {
		return studentsService.findByNameContaining(namee);
	}

}
