package Student;
import Book.Book;

public class Student {
    String name;
    String password;
    int AUD;
    int totalBorrowedBooks;
    Book[] borrowedBooks = new Book[5];
    
    public Student(String n,String pass,int rollNo){
       name = n;
       AUD = rollNo;
       password = pass;
       totalBorrowedBooks = 0;
       for(int i=0;i<5;i++){
           borrowedBooks[i] = new Book();
       }
    }
    
    public boolean checkDetails(String username,String pass){
        if(name.equals(username) && password.equals(pass)){
            return true;
        }else{
            return false;
        }
    }
    
    public String getName(){
        return name;
    }
    
    public void displayBorrowedBooks(){
        for(int i=0;i< totalBorrowedBooks;i++){
        System.out.println("Book Name : "+borrowedBooks[i].getName());
        System.out.println("");
        }
    }
    
    public void borrowBook(Book b){
        borrowedBooks[totalBorrowedBooks] = b;
        totalBorrowedBooks++;
    }
    
    public String returnBook(int choice){
        String bn = borrowedBooks[choice].getName();
        for(int i=choice;i<totalBorrowedBooks-1;i++){
            borrowedBooks[i] = borrowedBooks[i+1];
        }
        totalBorrowedBooks--;
        return bn;
    }
    
    public int getTotalBorrowedBooks(){
        return totalBorrowedBooks;
    }
    
    
    
}
