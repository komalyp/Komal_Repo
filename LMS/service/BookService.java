package lms.service;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.model.Book;
import lms.repository.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	public BookRepository bookRepository;

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

	public Book findBookById(int id) {

		return bookRepository.getBookById(id);

	}

	public Book searchBook(int id) {

		 return findBookById(id);
	}
}