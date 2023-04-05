package CrudQueryWithSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CrudQueryWithSecurity.entity.Students;
import CrudQueryWithSecurity.repository.StudentsRepositary;

@Service
public class StudentsService {

	@Autowired
	private StudentsRepositary repository;

	public Students saveDetail(Students student) {
		return repository.save(student);
	}

	public List<Students> saveDetails(List<Students> students) {
		return repository.saveAll(students);
	}

	public List<Students> getStudents() {
		return repository.findAll();
	}

	public Students getStudentById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Students getStudentByName(String name) {
		return repository.findByName(name);
	}

	public String deleteStudent(int id) {
		repository.deleteById(id);
		return "Student Details Dissmis !";
	}

	public List<Students> getOrderByNames() {
		return repository.getOrderByNames();
	}

	public List<Students> getDetailUsingNameorId(String name, int id) {
		return repository.getDetailUsingNameorId(name, id);
	}

	public List<Students> getAllDeatilUsingNative() {
		return repository.getAllDeatilUsingNative();
	}

	public List<Students> getExactDeatail(String k) {
		return repository.getExactDeatail(k);
	}

	// Named Query Define

	public Students findByStd(String s) {
		return repository.findByStd(s);
	}

	public Students updateStudents(Students student) {
		Students exisitingStudent = repository.findById(student.getId()).orElse(null);
		exisitingStudent.setName(student.getName());
		exisitingStudent.setCity(student.getCity());
		exisitingStudent.setStd(student.getStd());
		return repository.save(exisitingStudent);
	}

}
