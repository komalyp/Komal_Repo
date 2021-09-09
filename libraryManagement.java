package librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import librarymanagement.model.Book;
import librarymanagement.model.BookOrder;
import librarymanagement.model.Role;
import librarymanagement.model.User;
import librarymanagement.service.BookOrderService;
import librarymanagement.service.BookService;
//import librarymanagement.service.RoleService;
import librarymanagement.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class libraryManagement implements CommandLineRunner {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private RoleService roleService;
	
	@Autowired
	private BookOrderService bookOrderService;
	
	public static void main(String[] args) {
		SpringApplication.run(libraryManagement.class, args);

	}
	
	
	@Override
    public void run(String... args) throws Exception {
      //  LOG.info("EXECUTING : command line runner");
		Scanner sc = new Scanner(System.in);
		int usertype ;
	 	int searchChoice;
	 	
	 	 System.out.println("********************Welcome to the Library Management System!********************");
        
	 	 do 
		 {
			 System.out.println("              \nPlease Select USER TYPE to Access Library Syetem:               ");
			 System.out.println("              \n Enter 1 for ADMIN \n Enter 2 for USER  \n Enter 3 for Exit            ");
			 usertype = sc.nextInt();
			 switch(usertype)
			 {
			 	case 1:
				 	System.out.println("You are in Admin Mode");
					
				    int c;
				    System.out.println("              *** WELCOME ADMIN ***               ");
			  	  	System.out.println("              *** You Can Access Library System ***               ");
			  	  	do
			  	  	{ 
				  	  	System.out.println("Hi Admin! Please enter the appropriate choice from the menu below.");
				  	    System.out.println("Enter 1 to ADD Book");
				  	    System.out.println("Enter 2 to UPDATE Book.");
				  	    System.out.println("Enter 3 to DELETE Book.");
				  	    System.out.println("Enter 4 to SEARCH Book.");
				  	    System.out.println("Enter 5 to VIEW Books.");
				  	    System.out.println("Enter 6 to VIEW Orders.");
				  	    System.out.println("Enter 7 to Exit"); 
			          c = sc.nextInt();
			          	switch(c)
			          	
			          	{
			          		case 1://Addition of Book
			          			Book book = new Book();
			          			String bookName= null;
			          			String bookAuthor = null;
			          			int id =0;
			          			int quantity=0;
			          			System.out.println("Enter book name");
			          			bookName= sc.next();
			          			System.out.println("Enter book author");
			          			bookAuthor= sc.next();
			          			System.out.println("Enter book id");
			          			id= sc.nextInt();
			          			System.out.println("Enter book quantity");
			          			quantity= sc.nextInt();
			          			
			          			book.setAuthor(bookAuthor);
			          			book.setId(id);
			          			book.setName(bookName);
			          			book.setQuantity(quantity);
			          			
			          			
			          			Book addedBook = bookService.addBook(book);
			          			
			          			if(addedBook != null) {
			          				System.out.println("Book added successfully!");
			          			}
			          			else {
			          				System.out.println("Error occured while adding book!");
			          			}
			          			break;
			          		case 2://Update Book
			          			int updateId;
			          			System.out.println("Enter the id of book which you want to update");
			          			updateId= sc.nextInt();
			          			Book searchedBook=bookService.findBookById(updateId);
			          			if(searchedBook!= null) {
			          				int option;
			          				System.out.println("Press 1 to edit Name \n Press 2 to edit Author \n Press 3 to edit quantity \n Press 4 to cancel editing");
			          				option = sc.nextInt();
			          				switch(option) {
			          					case 1:	
			          						String name;
			          						System.out.println("Enter name");
			          						name= sc.next();
			          						searchedBook.setName(name);
			          						break;
			          					case 2:
			          						String author;
			          						System.out.println("Enter author");
			          						author= sc.next();
			          						searchedBook.setAuthor(author);
			          						break;
			          					case 3:
			          						int qty;
			          						System.out.println("Enter author");
			          						qty= sc.nextInt();
			          						searchedBook.setQuantity(qty);
			          						break;
			          					case 4:
			          						System.out.println("You selected not to edit.");
			          						break;
			          				}
			          				Book updateBook=bookService.updateBook(searchedBook);
			          				if (updateBook!=null) {
			          					System.out.println("Book Updated successfully!");
			          					System.out.println("-------------------------------------------------");
			          				}
			          			}else {
			          				System.out.println("Book not present! please enter a correct book id \n -----------------------------------");
			          			}
			          			//ob.UpdateBook();
			          			break;
			                case 3://Delete Book
			                	int idTobeDeleted;
			                	System.out.println("Enter id of book to be deleted");
			                	idTobeDeleted = sc.nextInt();
			                	bookService.deleteBook(idTobeDeleted);
			                	System.out.println("Book with id " + idTobeDeleted + "is deleted successfully!");
			                     break;                 
			                case 4://Search Book
			                	System.out.println("Enter 1 to Search with Serial No.");
			                	System.out.println("Enter 2 to Search with Book Name(Full Name).");
			                	searchChoice = sc.nextInt();

			                	switch(searchChoice)
			                	{
			                		case 1:
			                			bookService.searchBookById(sc);
			                			break;
			                		case 2:
			                			System.out.println("work under progress!");
			                			//ob.searchBybookName();
			                			break;
			                	}
			                	break;
			                case 5://view books
			                	bookService.viewAllBooks();
			                	break;
			                case 6://view books
			                	bookOrderService.viewAllOrders();
			                	break;
			                case 7:
			                	System.out.println("Thank You Admin!");
			                	break;
			          	}
			        }while(c!=7);
					break;
			 	case 2: 
			 			System.out.println("You are in Student Mode");
			 			String email = null;
			 			String password= null;
			 			//user login starts
			 			System.out.println("Please enter your registered email");
			 			email= sc.next();
			 			System.out.println("Please enter your password");
			 			password=sc.next();
			 			
			 			User user = userService.userLogin(email, password);
			 			
			 			if(user != null) {
			 				int c1;
				 			System.out.println("              *** \nWELCOME USER ***               ");
				 			System.out.println("              *** \nYou Can Access Library System ***\n               ");
				 			do
				 			{
				 				System.out.println("Enter 1 to VIEW BOOKS");
					 		    System.out.println("Enter 2 to SEARCH BOOK");
					 		    System.out.println("Enter 3 to ORDER BOOK");
					 		    System.out.println("Enter 4 to RETURN BOOK");
					 		    System.out.println("Enter 5 to Register Student.");
					 		    System.out.println("Enter 6 to Show All Registered Students/Users.");
					 		    System.out.println("Enter 7 to Exit");
				 				c1 = sc.nextInt();
				 				switch(c1)
				 				{
				 					case 1:  //view book
				 							bookService.viewAllBooks();
				 							break;
				 					case 2://Search Book
				 							System.out.println("Enter 1 to Search with Serial No.");
				 							System.out.println("Enter 2 to Search with Book Name(Full Name).");
				 							searchChoice = sc.nextInt();
				 							switch(searchChoice)
				 							{
				 								case 1:
				 									bookService.searchBookById(sc);
				 									break;
				 								case 2:
				 									System.out.println("work under progress!");
				 									break;
				 							}	
				 							break;
				 					case 3://Order Book
				 							BookOrder bookOrder = new BookOrder();
				 							int bookIssueId = 0;
				 							System.out.println("Enter the book id you want to issue");
				 							bookIssueId=sc.nextInt();
				 							Book searchBook=bookService.findBookById(bookIssueId);
						          			if(searchBook != null) {
						          				//bookOrder.setOrderid(1);
						          				bookOrder.setId(searchBook);
						          				bookOrder.setEmailid(user);
						          				bookOrder.setOrderDate(new Date());
						          				if(bookOrderService.placeOrder(bookOrder)!= null) {
						          					searchBook.setQuantity(searchBook.getQuantity()-1);
						          					bookService.updateBook(searchBook);
						          					System.out.println("Order placed successfully!");
						          				}
						          			}
				 							break;
				 					case 4:
				 							//return book
				 							int orderId = 0;
				 							String choice =null;
				 							System.out.println("Enter the order id you want to return");
				 							orderId=sc.nextInt();
				 							BookOrder returnBookOrder = bookOrderService.searchOrder(orderId);
				 							if(returnBookOrder!=null && !returnBookOrder.isBookReturned()) {
				 							System.out.println("do you want to check details of the orders too?press Y/y see orders else presss any other key to continuing return of order");
				 							choice= sc.next();
				 							if(choice.equals("Y") || choice.equals("y")) {
				 								System.out.println("your issue date " + returnBookOrder.getOrderDate() );
				 								System.out.println("your return date " + returnBookOrder.getReturnDate() );
				 								System.out.println("your fine" + returnBookOrder.getLateReturnFee() );
				 								int bookId=bookOrderService.findBookIdByOrder(returnBookOrder);
				 								Book returnBook = bookService.findBookById(bookId);
				 								if(bookOrderService.returnBook(returnBookOrder)!= null) {
				 									int qty=returnBook.getQuantity()+1;
				 									returnBook.setQuantity(qty);
				 									bookService.updateBook(returnBook);
						          					System.out.println("Book returned successfully!");
				 							}
				 							else {
					 								int bookId1=bookOrderService.findBookIdByOrder(returnBookOrder);
					 								Book returnBook1 = bookService.findBookById(bookId1);
					 								if(bookOrderService.returnBook(returnBookOrder)!= null) {
					 									int qty=returnBook1.getQuantity()+1;
					 									returnBook1.setQuantity(qty);
					 									bookService.updateBook(returnBook1);
							          					System.out.println("Book returned successfully!");
							          				}
				 								}
				 							}
				 							
				 							}
				 		
				 							break;
				 					case 5:   
				 							//register student
				 							String emailid;
				 							String pwd;
				 							String fName;
				 							String lName;
				 							String rollNo;
				 							System.out.println("Enter first name");
				 							fName=sc.next();
				 							System.out.println("Enter last name");
				 							lName=sc.next();
				 							System.out.println("Enter roll no.");
				 							rollNo=sc.next();
				 							System.out.println("Enter emailId to be registered");
				 							emailid=sc.next();
				 							System.out.println("Enter password");
				 							pwd = sc.next();
				 							User newStudent = new User();
				 							
				 							//Role selectedRole = roleService.getRoleByUserType("student");
				 							Role selectedRole = new Role();
				 							selectedRole.setRoleid(1);//setting to 1 as this is student registrastion . set 2 for admin registration
				 							newStudent.setFirstname(fName);
				 							newStudent.setLastname(lName);
				 							newStudent.setEmailid(emailid);
				 							newStudent.setPassword(pwd);
				 							newStudent.setUserid(rollNo);
				 							newStudent.setRoleid(selectedRole);
				 							if(userService.registerStudent(newStudent)!= null) {
				 								System.out.println("Student Registered successfully!");
				 							}
				 							else {
				 								System.out.println("error while registering student!");
				 							}
				 							break;
				 					case 6: 
				 							//view all students
				 							System.out.println("List of All Students");
				 							List<User> studentsList = userService.getAllStudents();
				 							if(studentsList != null) {
				 								for(User student:studentsList) {
				 									int i = 1;
				 									System.out.println(i + ". "+ student.getFirstname() + " " + student.getLastname());
				 								}
				 								
				 							}else {
				 								System.out.println("No Students were found!");
				 							}
				 							break;
				 					case 7: 
			 							//exit
				 						System.out.println("Thank You Student!");;
			 							break;
								}
							}while(c1!=7);
			 			}
			 			else {
			 				System.out.println("PLease check your credentials!");
			 			}
			 			
						break;
			 	case 3 : 
			 			System.out.println("Thank You!Do visit again.");
			 			break;
			 }

	 }while(usertype!= 3);
       
	}



	

}
