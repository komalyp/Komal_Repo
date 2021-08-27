package library;

import java.util.Scanner;

public class LibApp 
{

	public static void main(String[] args) 
	{
//		 @SuppressWarnings("resource")
			Scanner ip = new Scanner(System.in);
			int usertype ;
		 	int searchChoice;
			//LibApp lp=new LibApp();
		    Books ob = new Books();
		    Students ss1 = new Students();
		
		 System.out.println("********************Welcome to the Library Management System!********************");
		 do 
		 {
			 System.out.println("              \nPlease Select USER TYPE to Access Library Syetem:               ");
			 System.out.println("              \n Enter 1 for ADMIN \n Enter 2 for USER  \n Enter 3 for Exit            ");
			 usertype = ip.nextInt();
			 switch(usertype)
			 {
			 	case 1:
				 	System.out.println("You are in Admin Mode");
         			//admin_Act();
					
				    int c;
				    System.out.println("              *** WELCOME ADMIN ***               ");
			  	  	System.out.println("              *** You Can Access Library System ***               ");
			  	  	do
			  	  	{ 
			          ob.dispMenu_Admin();
			          c = ip.nextInt();
			          	switch(c)
			          	
			          	{
			          		case 1://Addition of Book
			          			Book b = new Book();
			          			ob.addBook(b);
			          			break;
			          		case 2://Update Book
			          			ob.UpdateBook();
			          			break;
			                case 3://Delete Book
			                	ob.deleteBook();
			                     break;                 
			                case 4://Search Book
			                	System.out.println("Enter 1 to Search with Serial No.");
			                	System.out.println("Enter 2 to Search with Book Name(Full Name).");
			                	searchChoice = ip.nextInt();

			                	switch(searchChoice)
			                	{
			                		case 1:
			                			ob.searchBySno();
			                			break;
			                		case 2:
			                			ob.searchBybookName();
			                			break;
			                	}
			                	break;
			                case 5://view books
			                	ob.ViewBooks();
			                	break;
			                case 6:
			                	System.out.println("Thank You Admin!");
			                	break;
			          	}
			        }while(c!=6);
					break;
			 	case 2: 
			 			System.out.println("You are in User Mode");
			 			Student s = new Student();
			 			ss1.login(s);
			 			//user_Act();
			 			int c1;
			 			System.out.println("              *** \nWELCOME USER ***               ");
			 			System.out.println("              *** \nYou Can Access Library System ***\n               ");
			 			int User_Ch;
			 			do
			 			{
			 				ob.dispMenu();
			 				c1 = ip.nextInt();
			 				switch(c1)
			 				{
			 					case 1:  //view book
			 							ob.ViewBooks();
			 							break;
			 					case 2://Search Book
			 							System.out.println("Enter 1 to Search with Serial No.");
			 							System.out.println("Enter 2 to Search with Book Name(Full Name).");
			 							searchChoice = ip.nextInt();
			 							switch(searchChoice)
			 							{
			 								case 1:
			 									ob.searchBySno();
			 									break;
			 								case 2:
			 									ob.searchBybookName();
			 									break;
			 							}	
			 							break;
			 					case 3://Order Book
			 							ss1.OrderBook(ob);
			 							break;
			 					case 4:
			 							ss1.ReturnBook(ob);
			 							break;
			 					case 5:   	
			 						Student s01 = new Student();
			 						ss1.login(s01);
			 							System.out.println("User Reg is under work");
			 							
			 							break;
			 					case 6: 
			 							System.out.println("Thank You User!");
			 							break;
							}
						}while(c1!=6);
						break;
			 	case 3 : 
			 			System.out.println("Thank You!Do visit again.");
			 			break;
			 }
		/*	 System.out.println("Do you want to continue(Y/N)");
			 choice = ip.next();
    	*/
	 }while(usertype!= 3);
		   
	}	    
   
}