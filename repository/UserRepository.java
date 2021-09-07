package librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import librarymanagement.model.Book;
import librarymanagement.model.User;


public interface UserRepository extends JpaRepository<User,String> {

	@Query(value = "SELECT * FROM user where emailid=?",nativeQuery=true)
	User findByUserId(String emailid);
	
	@Query(value = "SELECT * FROM user where roleid=1",nativeQuery=true)
	List<User> getAllStudents();
}
