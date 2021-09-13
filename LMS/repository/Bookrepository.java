package LMS.repository;


import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import LMS.model.Book;

//@Repository
public interface Bookrepository extends JpaRepository<Book, Integer> {

}
 
