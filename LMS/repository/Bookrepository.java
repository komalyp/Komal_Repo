package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query(value = "SELECT * FROM book where id=?", nativeQuery = true)
	Book getBookById(int id);

}
