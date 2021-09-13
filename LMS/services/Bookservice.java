package LMS.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LMS.model.Book;
import LMS.repository.Bookrepository;

@Service
@Transactional
public class Bookservice {

    @Autowired
    public Bookrepository bookRepository;

    public List<Book> loadAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book loadBookById(int id) {
        return bookRepository.findById(id).get();
    }
    
    public Book saveBook(Book book) {
        bookRepository.save(book);
        return loadBookById(book.getId());
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
    
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

}