package CrudQuery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CrudQuery.Entity.LibraryBook;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Integer> {

}
