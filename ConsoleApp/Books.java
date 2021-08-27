package library;

import java.util.Scanner;


public class Books {

Book theBooks[] = new Book[50];     // Array that stores 'book' Objects.
public static int count;    // Counter for No of book objects Added in Array.

Scanner input = new Scanner(System.in);

//for user
public void dispMenu(){

    System.out.println("----------------------------------------*****USER RIGHTS*****------------------------------------------------------------------");
    System.out.println("Enter 1 to VIEW BOOKS");
    System.out.println("Enter 2 to SEARCH BOOK");
    System.out.println("Enter 3 to ORDER BOOK");
    System.out.println("Enter 4 to RETURN BOOK");
    System.out.println("Enter 5 to Register Student.");
   // System.out.println("Enter 6 to Show All Registered Students/Users.");
    System.out.println("Enter 6 to Exit");
    System.out.println("------------------------------------------------------------ ---------------------------------------------");

}
//for admin
 public void dispMenu_Admin()
 {

    System.out.println("----------------------------------------*****ADMIN RIGHTS*****------------------------------------------------------------------");
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

    System.out.println("\nDELETE BOOK BY SERIAL NUMBER");

    int sNo,k;
    System.out.println("Enter Serial No. of Book:");
    sNo = input.nextInt();

    int flag = 0;
    int k1=0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tPrice\t\t\tTotal Qty");
    for (int i=0; i<theBooks.length; i++)
    {
    	if (sNo == theBooks[i].sNo)
    	{
              	System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                    theBooks[i].bookQtyCopy + "\t\t\t\t\t" + theBooks[i].price + "\t\t\t\t"+ theBooks[i].bookQty);
              	for(int j=i; j<(count-1); j++)
              	{
        		theBooks[j].sNo= theBooks[j+1].sNo;
            	theBooks[j].bookName = theBooks[j+1].bookName;
            	theBooks[j].authorName=theBooks[j+1].authorName;
            	theBooks[j].bookQtyCopy = theBooks[j+1].bookQtyCopy;
            	theBooks[j].bookQty= theBooks[j+1].bookQty;
            	theBooks[j].price= theBooks[j+1].price;
            	}           
        	flag++;
        	break;
        	
           // return;
         }
    	
    }
   if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");
   else
   {	count--;
	   System.out.println("Book for Serial No " + sNo + " Deleted.");
	   System.out.println("New List of available Books : " );
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
                theBooks[i].bookQtyCopy + "\t\t" + "\t\t\t"+theBooks[i].price +"\t\t\t"+ theBooks[i].bookQty);
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
                    theBooks[i].bookQtyCopy + "\t\t" + "\t\t\t"+theBooks[i].price +"\t\t\t"+ theBooks[i].bookQty);
                flag++;
            return;

        }

    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");

}


public void ViewBooks(){

    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\t\tPrice\t\t\tTotal Qty");
    for (int i=0; i<count; i++){

    	System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + "\t\t\t"+theBooks[i].price +"\t\t\t"+ theBooks[i].bookQty);
            

    }

}

public void UpdateBook()//Updating Qty ,Price
{

	 System.out.println("Enter Serial No of Book");
	 int sNo = input.nextInt();
	   
	 System.out.println("\t\t\tUpdate Book for SR.NO" + sNo +"\n\n :1.Update Qty \t\t 2.Update Price \t\t\t\3.Update Qty and Price");
	 int ch= input.nextInt();
	 if(ch==1)
	 {
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		for (int i=0; i<count; i++)
		{
			if (sNo == theBooks[i].sNo)
			{
            System.out.println("Enter No of Books to be Added:");
            int addingQty = input.nextInt();
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;
			}
		}

	}
	 if(ch==2)
	 {
		 System.out.println("\t\t\t\tUPGRADE PRICE OF A BOOK\n");
			for (int i=0; i<count; i++)
			{
				if (sNo == theBooks[i].sNo)
				{
	            System.out.println("Enter Price to be Added:");
	            float cost = input.nextFloat();
	            theBooks[i].price = cost;
	           // theBooks[i].bookQtyCopy += addingQty;
	            return;
				}
			}


		 
	 }
	 if(ch==3)
	 {
		 System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
			for (int i=0; i<count; i++)
			{
	 			if (sNo == theBooks[i].sNo)
				{
	            System.out.println("Enter No of Books to be Added:");
	            int addingQty = input.nextInt();
	            theBooks[i].bookQty += addingQty;
	            theBooks[i].bookQtyCopy += addingQty;
	            System.out.println("Enter Updated Price of Book:");
	            float cost = input.nextFloat();
	            theBooks[i].bookQty += addingQty;
	            theBooks[i].bookQtyCopy += addingQty;
	            theBooks[i].price =cost;
	            return;
				}
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

public Book issueBook(){

    System.out.println("Enter Serial No of Book to be Issued");
    int sNo = input.nextInt();

    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){

        //int bookIndex = isAvailable(sNo);
        theBooks[bookIndex].bookQtyCopy--;

        return theBooks[bookIndex];
    }

    return null;

}

public void submitBook(Book b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

            theBooks[i].bookQtyCopy++;
            return;

        }

    }

}
 }