package Studens.Course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Studens.Course.entity.Students;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

	@Query(nativeQuery = true, value = "Select * from onetomany.students_tb s join onetomany.course_tb c on s.sid=c.cid where s.name=:namee")
	Students findByNameContaining(@Param("namee") String namee);

	@Query(nativeQuery = true,value="Select * from onetomany.students_tb s join onetomany.course_tb c on s.sid=c.cid order by s.name")
	List<Students> getOrderByName();

}
