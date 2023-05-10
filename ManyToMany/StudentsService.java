package Studens.Course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Studens.Course.entity.Students;
import Studens.Course.repository.StudentsRepo;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepo studentsRepo;

	public Students save(Students students) {
		
		return studentsRepo.save(students);
	}

	public List<Students> findAll() {
		
		return studentsRepo.findAll();
	}

	public Students findById(int id) {
		
		return studentsRepo.findById(id).orElse(null);
	}

	public Students findByNameContaining(String namee) {
		
		return studentsRepo.findByNameContaining(namee);
	}
	
	

}
