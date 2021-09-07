package librarymanagement.service;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymanagement.model.Book;
import librarymanagement.repository.BookRepository;



@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public Book addBook(Book book) {
		Book searchBook = findBookById(book.getId());
		if(searchBook == null) {
			return bookRepo.save(book);
		}else {
			return null;
		}
		
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	
	public Book findBookById(int id) {
		
		return bookRepo.getBookById(id);
		
		
	}
	
	public List<Book> findAllBooks(){
		return bookRepo.findBooks();
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}

	public void searchBookById(Scanner sc) {
		int idSearch;
		System.out.println("please enter id");
		idSearch=sc.nextInt();
		Book searchedBook1=findBookById(idSearch);
		if(searchedBook1 != null) {
			System.out.println("Details of book having id "+searchedBook1.getId()+" are:");
			System.out.println("Book Name- "+searchedBook1.getName());
			System.out.println("Book Author- "+searchedBook1.getAuthor());
			System.out.println("Book Quantity- "+searchedBook1.getQuantity());
			System.out.println("-----------------------------------------------");
		}else {
			System.out.println("The book for which you are looking for is not present!");
		}
		
	}
	
	public void viewAllBooks() {
		System.out.println("---BOOKS---");
		List<Book> books= findAllBooks();
		for(int i=0;i<books.size();i++) {
			System.out.println("Book id:"+ books.get(i).getId());
			System.out.println("Book name:"+ books.get(i).getName());
			System.out.println("Book author:"+ books.get(i).getAuthor());
			System.out.println("Book quantity:"+ books.get(i).getQuantity());
			System.out.println("-----------------------------------------------");
		}
	}
	
}

