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