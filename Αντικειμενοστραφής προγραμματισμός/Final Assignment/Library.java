import java.util.*;

public class Library {


    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Reader> readerList = new ArrayList<Reader>();
    ArrayList<Book> lendedBookList = new ArrayList<Book>();


    public void addBook(String ISBN, String title, String author, String genre, String position){
        bookList.add(new Book(ISBN,title,author,genre,position));
    }

    public void addReader(String afm,String name,int age,String category){
        readerList.add(new Reader(afm, name, age, category));
    }
    public void lendBook(String ISBN){

        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                lendedBookList.add(book);
                // book.lendCount++;
                book.lendBook();
                return;
            } 
        } System.out.println("Book not found...");
        
        
    }

    public void returnBook(){

    }
    public void printLendedBooks(){
        for(Book book:lendedBookList){
            System.out.println(book);
        }
    }

    public void lendBookJournal(){
        for (Book book : bookList){
            System.out.println(book.getLendCount());
        }
    }

    public void printLendReaderJournal(){

    }

    public void findBestReaders(){

    }

    public void  findBestBooks(){

    }
}
