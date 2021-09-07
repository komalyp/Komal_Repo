package librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import librarymanagement.model.Book;
import librarymanagement.model.BookOrder;

public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {

	@Query(value="select * from bookOrder where orderid=?",nativeQuery=true)
	BookOrder findOrderById(int id);
	
	@Query(value="select bookid from bookOrder where orderid=?",nativeQuery=true)
	int findBookId(int orderId);
}
