package Exceptions1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Exceptions1.entity.Students;

@Repository
public interface StrudentsRepo extends JpaRepository<Students, Integer> {

}
