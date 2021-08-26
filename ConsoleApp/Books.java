package library;

import java.util.Scanner;

public class Books {

Book theBooks[] = new Book[50];     // Array that stores 'book' Objects.
public static int count;    // Counter for No of book objects Added in Array.

Scanner input = new Scanner(System.in);


public void dispMenu(){

    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 1 to VIEW BOOKS");
    System.out.println("Enter 2 to SEARCH BOOK");
    System.out.println("Enter 3 to ORDER BOOK");
    System.out.println("Enter 4 to RETURN BOOK");
    System.out.println("Enter 5 to Register Student.");
   // System.out.println("Enter 6 to Show All Registered Students/Users.");
    System.out.println("Enter 6 to Exit");
    System.out.println("------------------------------------------------------------ ---------------------------------------------");

}
 public void dispMenu_Admin()
 {

    System.out.println("----------------------------------------*****ADMIN RIGHTS------------------------------------------------------------------");
    System.out.println("Enter 1 to ADD Book");
    System.out.println("Enter 2 to UPDATE Book.");
    System.out.println("Enter 3 to DELETE Book.");
    System.out.println("Enter 4 to SEARCH Book.");
    System.out.println("Enter 5 to VIEW Books.");
    System.out.println("Enter 6 to Exit");   
    /* System.out.println("Enter 6 to RETURN Book. ");
    System.out.println("Enter 7 to ORDER Book");
    System.out.println("Enter 5 to Register Student.");
    System.out.println("Enter 6 to Show All Registered Students.");
   
    System.out.println("------------------------------------------------------------- ---------------------------------------------");

*/
   }
public int compareBookObjects(Book b1, Book b2){

    if (b1.bookName.equalsIgnoreCase(b2.bookName))
    {
    	    		if(b1.authorName.equalsIgnoreCase(b2.authorName))
    				{
    				System.out.println("Book of this Name and author Already Exists.");
    				return 0;
    				}
    }
    
    if (b1.sNo==b2.sNo){

        System.out.println("Book of this Serial No Already Exists.");
        return 0;
    }
    return 1;
}

public void addBook(Book b){

    for (int i=0; i<count; i++){

        if (this.compareBookObjects(b, this.theBooks[i]) == 0)
            return;

    }

    if (count<50){

        theBooks[count] = b;
        count++;

    }
    else{

        System.out.println("No Space to Add More Books.");

    }

}

public void deleteBook()
{

    System.out.println("\nDELETE BY SERIAL NUMBER");

    int sNo,k;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();

    int flag = 0;
    int k1=0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<theBooks.length; i++)
    {
    	if (sNo != theBooks[i].sNo)
    	{
              	System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                    theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
              	for(int j=i; j<(count-1); j++)
              	{
        		theBooks[j].sNo= theBooks[i+1].sNo;
            	theBooks[j].bookName = theBooks[i+1].bookName;
            	theBooks[j].authorName=theBooks[i+1].authorName;
            	theBooks[j].bookQtyCopy = theBooks[i+1].bookQtyCopy;
            	theBooks[j].bookQty= theBooks[i+1].bookQty;
            	}           
        	flag++;
            return;
         }
    }
   if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");
   else
   {	count--;
	   System.out.println("Book for Serial No " + sNo + " Deleted.");
	   ViewBooks();
   }
   
}

public void searchBybookName(){

    System.out.println("\t\t\t\tSEARCH BY BOOK NAME");
    //input.nextLine();
    System.out.println("Enter Book Name:");
    String bookName = input.nextLine();
    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (bookName.equalsIgnoreCase(theBooks[i].bookName)){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
        }

    }
    if (flag == 0)
        System.out.println("No Books of " + bookName + " Found.");

}

public void searchBySno(){

    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
            return;

        }

    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");

}


public void ViewBooks(){

    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);


    }

}

public void UpdateBook(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
    System.out.println("Enter Serial No of Book");
    int sNo = input.nextInt();
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println("Enter No of Books to be Added:");
            int addingQty = input.nextInt();
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;

        }

    }

}

public int isAvailable(int sNo){

    //returns the index number if available



    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){
            if(theBooks[i].bookQtyCopy > 0){

                System.out.println("Book is Available.");
                return i;

            }
            System.out.println("Book is Unavailable");
            return -1;

        }

    }

    System.out.println("No Book of Serial Number " + " Available in Library.");
    return -1;


}

public Book ReturnBook(){

    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = input.nextInt();

    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){

        //int bookIndex = isAvailable(sNo);
        theBooks[bookIndex].bookQtyCopy--;

        return theBooks[bookIndex];
    }

    return null;

}

public void OrderBook(Book b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

            theBooks[i].bookQtyCopy++;
            return;

        }

    }

}
 }