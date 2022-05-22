package library;
import Book.Book;
import Student.Student;
import java.util.Scanner;
public class Library {

    public static void displayAllBooks(Book[] allBooks){
        for(Book b : allBooks){
           System.out.println("Book Name : "+b.getName());
           System.out.println("Quantity : "+b.getQuantity());
           System.out.println("");

       }
    }
    
    public static void main(String[] args) {
       Book[] allBooks = new Book[5];
       Student[] allStudents = new Student[3];
       boolean LoggedIn = false;
       int studentIndex = -1;
       String user;
       String pass;
       int choice;
       int bookChoice;
       Scanner scan = new Scanner(System.in);
       
       // Creating Books 
       allBooks[0] = new Book("Book 1",5);
       allBooks[1] = new Book("Book 2",5);
       allBooks[2] = new Book("Book 3",5);
       allBooks[3] = new Book("Book 4",5);
       allBooks[4] = new Book("Book 5",5);
       
       // Creating Students
       allStudents[0] = new Student("Ammar","123",11111);
       allStudents[1] = new Student("Hammad","123",22222);
       allStudents[2] = new Student("Ebrahim","123",33333);
       
       
       // Login User
       while(!LoggedIn){
           System.out.println("Enter Username : ");
           user = scan.nextLine();
           System.out.println("Enter Password : ");
           pass = scan.nextLine();
           
           for(int i=0;i<3;i++){
               
               if(allStudents[i].checkDetails(user,pass)){
               LoggedIn = true;
               studentIndex = i;  
               }
           }
           
           if(LoggedIn){
              System.out.println("Login Successfull"); 
           }else{
               System.out.println("Invalid Username Or Password !!");
           }
           
       }
       System.out.println("Welcome " + allStudents[studentIndex].getName());
       
       do{
           System.out.println("Pick An Option : ");
           System.out.println("1.Display All Books");
           System.out.println("2.Display Your Borrowed Books");
           System.out.println("3.Borrow A Book");
           System.out.println("4.Return A Book");
           System.out.println("5.Exit");
           choice = scan.nextInt();
           
           switch(choice){
               case 1:
                  displayAllBooks(allBooks);
               break;
               case 2:
                   allStudents[studentIndex].displayBorrowedBooks();
               break;
               case 3:
                   if(allStudents[studentIndex].getTotalBorrowedBooks() < 5){
                   displayAllBooks(allBooks);
                   System.out.println("Pick A Book : ");
                   bookChoice = scan.nextInt();
                   bookChoice--;
                   if(bookChoice < 5 && bookChoice >= 0){
                       if(allBooks[bookChoice].getQuantity() != 0){
                       allStudents[studentIndex].borrowBook(allBooks[bookChoice]);
                       allBooks[bookChoice].decreaseQuantity();
                       }else{
                           System.out.println("Book Unavailable !");
                       }
                       
                   }else{
                    System.out.println("Invalid Option");
                   }
                   }else{
                      System.out.println("You Already Have 5 Books , You Cannot Borrow Any More!");
                   }
               break;
               case 4:
                   if(allStudents[studentIndex].getTotalBorrowedBooks() > 0){
                   allStudents[studentIndex].displayBorrowedBooks();
                   System.out.println("Pick A Book To Return : ");
                   bookChoice = scan.nextInt();
                   bookChoice--;
                   if(bookChoice < allStudents[studentIndex].getTotalBorrowedBooks() && bookChoice >= 0){
                       
                       String bn = allStudents[studentIndex].returnBook(bookChoice);
                       
                       for(Book b:allBooks){
                           if(b.getName().equals(bn)){
                               b.increaseQuantity();
                           }
                       }
                   }else{
                    System.out.println("Invalid Option");
                   }
                   }else{
                      System.out.println("You No Borrowed Books!");
                   }
                  break;

           }
           
       }while(choice != 5);
       
       

       
       
       
    }
    
}
