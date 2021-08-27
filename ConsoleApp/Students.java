package library;

import java.util.Scanner;

public class Students {

Scanner input = new Scanner(System.in);

Student theStudents[] = new Student[50];

//books book;


public static int count = 0;

public void login(Student s){

    for (int i=0; i<count; i++){

        if(s.ID.equalsIgnoreCase(theStudents[i].ID)){

            System.out.println("Student of Roll_no " + s.ID + " is Already Registered.");
            return;
        }
    }

    if (count<=50){

        theStudents[count] = s;
        count++;

    }

}
public void showAllStudents(){

    System.out.println("Student Name\t\tID Number");
    for (int i=0; i<count; i++){

        System.out.println(theStudents[i].studentName + "\t\t" + theStudents[i].ID);

    }


}

public int isStudent(){
    //return index number of student if available

     //System.out.println("Enter Student Name:");
    //String studentName = input.nextLine();

    System.out.println("Enter ID Number:");
    String ID = input.nextLine();

    for (int i=0; i<count; i++){

        if (theStudents[i].ID.equalsIgnoreCase(ID)){

            return i;

        }

    }
    System.out.println("Student is not Registered.");
    System.out.println("Get Registered First.");


    return -1;

}
public void OrderBook(Books book){
    int studentIndex =this.isStudent();

    if (studentIndex!=-1){
        System.out.println("Authenticated Student/USER! ");

        book.ViewBooks();
        Book b = book.issueBook();
        System.out.println("Issue Book:");
        if (b!= null){

            if (theStudents[studentIndex].booksCount<=3){
                System.out.println("adding book");
                theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                theStudents[studentIndex].booksCount++;
                return;

            }
            else {

                System.out.println("Student Can not Borrow more than 3 Books.");
                return;

            }
        }
        System.out.println("Book is not Available.");

    }

}

public void ReturnBook(Books book){

    int studentIndex = this.isStudent();
    if (studentIndex != -1){
        System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
        Student s = theStudents[studentIndex];
        for (int i=0; i<s.booksCount; i++){

            System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t"+
                    s.borrowedBooks[i].authorName);

        }
        System.out.println("Enter Serial Number of Book to be Return:");
        int sNo = input.nextInt();
        for (int i=0; i<s.booksCount; i++){

            if (sNo == s.borrowedBooks[i].sNo){

                book.submitBook(s.borrowedBooks[i]);
                s.borrowedBooks[i]=null;
                return;

            }


        }
        System.out.println("Book of Serial No "+sNo+"not Found");

    }



}
}