package CrudQuery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CrudQuery.Entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
