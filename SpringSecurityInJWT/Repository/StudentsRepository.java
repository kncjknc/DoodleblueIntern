package SpringSecurityInJwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import SpringSecurityInJwt.entity.Students;

@Repository
public interface StudentsRepositary extends JpaRepository<Students, Integer> {

	Students findByName(String name);

	Students findByStd(String std);

	@Query("SELECT s from Students s order by s.name")
	List<Students> getOrderByNames();

	@Query("SELECT s from Students s where s.name=:e or s.id=:f ")
	List<Students> getDetailUsingNameorId(@Param("e") String name, @Param("f") int sid);

	@Query(value = "SELECT * FROM varathan1.students_tb", nativeQuery = true)
	List<Students> getAllDeatilUsingNative();

	@Query(value = "SELECT * FROM varathan1.students_tb where name=:s", nativeQuery = true)
	List<Students> getExactDeatail(String s);

}
