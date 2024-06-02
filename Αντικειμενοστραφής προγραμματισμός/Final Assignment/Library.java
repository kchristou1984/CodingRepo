import java.util.*;

public class Library {


    static ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Reader> readerList = new ArrayList<Reader>();
    ArrayList<Book> lendedBookList = new ArrayList<Book>();
    ArrayList<LendingRecord> lendingRecordList = new ArrayList<LendingRecord>();


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
       

        public void lendBook(String ISBN, String name, Date lendingDate){
        Book bookToLend = null;

        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                if (lendedBookList.contains(book)==false){
                    // System.out.println(book.getTitle() + " has been lent succesfully");
                    bookToLend = book;
                    break;
                } 
                else{
                    System.out.println(book.getTitle() + " is lent");
                    break;
                }
            } 
        } if (bookToLend == null){
            System.out.println("Book not found...");
        }
            
    Reader readerLending = null;
            for (Reader reader:readerList){
                if (reader.getName().equals(name)){
                    readerLending = reader;
                    lendedBookList.add(bookToLend);
                    bookToLend.lendBook();
                    LendingRecord lendingRecord = new LendingRecord(bookToLend, readerLending, lendingDate);
                    lendingRecordList.add(lendingRecord);
                    System.out.println(bookToLend.getTitle() + " succesfully registered to " + readerLending.getName());
                } else{
                    System.out.println("Reader not found...");
                }
            }


        }

    
    public void returnBook(String ISBN){
        Book bookToReturn = null;
        for (Book book : lendedBookList){
            if (ISBN.equals(book.getISBN())){
                bookToReturn = book;
                lendedBookList.remove(bookToReturn);
                System.out.println(book.getTitle() + " returned succesfully..." );
                break;
            }
        }
    }

    public void printLendedBooks(){
        for(Book book:lendedBookList){
            System.out.println(book);
        }
    }

    public void lendBookJournal(String ISBN){
        boolean found = false;
        for (Book book : bookList){
            if (ISBN.equals(book.getISBN())){
                found = true;
                boolean recordFound = false;
                for (LendingRecord lendingRecord : lendingRecordList){
                    if (lendingRecord.getBook().getISBN().equals(ISBN)){
                    recordFound = true;
                    System.out.println("---------------------------");
                    System.out.println(lendingRecord.getBook().getTitle());
                    System.out.println("Lended by " + lendingRecord.getReader().getName() + " on " + lendingRecord.getLendingDate());
                    System.out.println("---------------------------");
                    } 
                }  if(!recordFound){
                    System.out.println("Book hasn't been lended yet");  
                    } break;
            }      //Να βάλω πότε δανείστηκε και από ποιον μάλλον από το lendingRecord
        } if (!found){
            System.out.println("Book not found...");
        }
    } 

    public void printLendReaderJournal(){

    }

    public void findBestReaders(){

    }

    public void  findBestBooks(){

    }
}
