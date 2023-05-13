package Studens.Course.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Studens.Course.entity.Students;

import Studens.Course.repository.StudentsRepo;
import Studens.Course.service.StudentsService;

@RestController
public class StudentsCourse {

	private StudentsService studentsService;

	private StudentsRepo studentsRepo;

	public StudentsCourse(StudentsService studentsService, StudentsRepo studentsRepo) {
		this.studentsService = studentsService;
		this.studentsRepo = studentsRepo;
	}

	@PostMapping("/postStudent")
	public Students saveStudentsandCourse(@RequestBody Students student) {

		return studentsService.save(student);
	}

	@PostMapping("/postStudents")
	public List<Students> saveAllStudentsandCourse(@RequestBody List<Students> students) {

		return studentsService.saveAll(students);
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

	@PutMapping("/update/{id}")
	public Students updateStudent(@RequestBody Students student, @PathVariable int id) {
		return studentsService.updateStudents(student, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentsService.deleteStudent(id);
	}

	@GetMapping("/getOrderByNames")
	public List<Students> getOrderByNames() {
		return studentsService.getOrderByNames();
	}

	@PatchMapping("/patchMap/{id}/{std}")
	public Students updateUsingPatchMapping(@PathVariable int id, @PathVariable String std) {
		Students student = studentsRepo.findById(id).orElse(null);
		student.setStd(std);
		return student;

	}

}
