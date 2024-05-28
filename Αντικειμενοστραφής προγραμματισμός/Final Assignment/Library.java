import java.util.*;

public class Library {


    static ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Reader> readerList = new ArrayList<Reader>();
    ArrayList<Book> lendedBookList = new ArrayList<Book>();


    public void addBook(String ISBN, String title, String author, String genre, String position){
        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                System.out.println("Book is already registered..");
                return;
            }
        } 
        bookList.add(new Book(ISBN,title,author,genre,position));
        System.out.println("Book " + title + " registered succesfully");
    }

    public void addReader(String afm,String name,int age,String category){
        for(Reader reader: readerList){
            if (reader.getAfm().equals(afm)){
                System.out.println("Reader is already registered...");
                return;
            }
        }
        readerList.add(new Reader(afm, name, age, category));
        System.out.println("Reader " + name + " registered succesfully...");

    }

    // public void lendBook(String ISBN){

    //     for (Book book : bookList){
    //         if (book.getISBN().equals(ISBN)){
    //             if (lendedBookList.contains(book)==false){
    //                 lendedBookList.add(book);
    //                 book.lendBook();
    //                 System.out.println(book.getTitle() + " has been lent succesfully");
    //                 return;
    //             } else{
    //                 System.out.println(book.getTitle() + " is lent");
    //                 return;
    //             }
    //         } 
    //         } System.out.println("Book not found...");
    //     }
       

        public void lendBook(Book book, Reader reader, Date lendingDate){
        if (bookList.contains(book)){
            if (lendedBookList.contains(book)==false){
                lendedBookList.add(book);
                book.lendBook();
                LendingRecord lendingRecord = new LendingRecord(book, reader, lendingDate);
                lendingRecord.lendingRecordList.add(lendingRecord);
                System.out.println(book.getTitle() + " has been lent succesfully");
                return;
            } else{
                System.out.println(book.getTitle() + " is lent");
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
            System.out.println("Book " + book.getTitle() + " registered "+ book.getLendCount() + " times.");
        }
    }

    public void printLendReaderJournal(){

    }

    public void findBestReaders(){

    }

    public void  findBestBooks(){

    }
}
