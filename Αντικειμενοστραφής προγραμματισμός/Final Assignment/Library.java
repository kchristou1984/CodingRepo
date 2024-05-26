import java.util.*;

public class Library {


    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Reader> readerList = new ArrayList<>();
    ArrayList<Book> lendedBookList = new ArrayList<>();


    public void addBook(String ISBN, String title, String author, String genre, String position){
        bookList.add(new Book(ISBN,title,author,genre,position));
    }

    public void addReader(String afm,String name,int age,String category){
        readerList.add(new Reader(afm, name, age, category));
    }
    public void lendBook(Book book){
        lendedBookList.add(Book book);
    }

    public void returnBook(){

    }
    public void printLendedBooks(){
        //
    }

    public void lendBookJournal(){

    }

    public void printLendReaderJournal(){

    }

    public void findBestReaders(){

    }

    public void  findBestBooks(){

    }
}
