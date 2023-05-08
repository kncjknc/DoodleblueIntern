package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Students;
import com.example.demo.repositary.StudentsRepositary;

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


	public String deleteStudent(int id) {
		repository.deleteById(id);
		return "Student Details Dissmis !";
	}


	public Students updateStudents(Students student) {
		Students exisitingStudent = repository.findById(student.getId()).orElse(null);
		exisitingStudent.setName(student.getName());
		exisitingStudent.setCity(student.getCity());
		exisitingStudent.setStd(student.getStd());
		return repository.save(exisitingStudent);
	}

}
