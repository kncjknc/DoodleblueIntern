package Exceptions1.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions1.Exceptionss.StudentNotFound;
import Exceptions1.entity.Students;
import Exceptions1.repo.StrudentsRepo;
import Exceptions1.request.StudentsRequest;

@Service
public class StudentsService {

	@Autowired
	private StrudentsRepo repo;

	@Autowired
	private ModelMapper modelMapper;

	public Students putStudents(StudentsRequest studentsRequest) {

		Students student = modelMapper.map(studentsRequest, Students.class);

		return repo.save(student);
	}

	public Students getStud(int id) throws StudentNotFound {

		Students student = repo.findById(id).orElse(null);

		if (student != null) {
			return repo.findById(id).orElse(null);
		} else {
			throw new StudentNotFound("Student Not Found On This Id " + id);
		}
	}

}
