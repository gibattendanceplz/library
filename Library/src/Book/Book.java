package Book;

public class Book {
    String name;
    int quantity;
    
    public Book(){
        
    }
    public Book(String n,int amnt){
        name = n;
        quantity = amnt;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void increaseQuantity(){
        quantity++;
    }
    
    public void decreaseQuantity(){
        quantity--;
    }
}
