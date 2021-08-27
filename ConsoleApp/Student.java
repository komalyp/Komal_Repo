package library;

import java.util.Scanner;    
public class Student {

String studentName;
String ID;

Book borrowedBooks[] = new Book[3];
public int booksCount = 0;

Scanner input = new Scanner(System.in);

public Student(){

    System.out.println("Enter Student Name:");
    this.studentName = input.nextLine();

    System.out.println("Enter ID Number:");
    this.ID = input.nextLine();

}
}
/*
/*for add and return book

public Book OrderBook(){

    System.out.println("Enter Serial No of Book to be Ordered");
    int sNo = input.nextInt();

    int i =isAvailable(sNo);
    int j=0;
    if (i!=-1){

        //int bookIndex = isAvailable(sNo);
      
        System.out.println("\nBook details Before Order");
        System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + "\t\t\t" +theBooks[i].price +"\t\t\t"+ theBooks[i].bookQty);
        
          theBooks[i].bookQtyCopy--;
          //theBooks[i].bookQty--;
        
          System.out.println("\nIssued Book Details");
          System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                  theBooks[i].bookQtyCopy + "\t\t" + "\t\t\t" +theBooks[i].price +"\t\t\t"+ theBooks[i].bookQty);
          
          theIssue[j].sNo =theBooks[i].sNo;
          theIssue[j].bookName =theBooks[i].bookName;
          theIssue[j].bookISBN =theBooks[i].bookISBN;
          theIssue[j].authorName =theBooks[i].authorName;
          theIssue[j].issuedQty = theBooks[i].bookQty - theBooks[i].bookQtyCopy;
          theIssue[j].price=theBooks[i].price;
          theIssue[j].bookQty =theBooks[i].bookQty;
         
          
        return theBooks[i];
    }

    return null;

}

public void ReturnBook(Book b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

        	
            theBooks[i].bookQtyCopy++;
            return;

        }

    }

}
*/