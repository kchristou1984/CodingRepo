import java.util.*;



public class Library {


    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Reader> readerList = new ArrayList<Reader>();
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
      

    public void lendBook(String ISBN, String name, String lendingDate){
        Book bookToLend = null;

        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                if (lendedBookList.contains(book)==false){
                    // System.out.println(book.getTitle() + " has been lent succesfully");
                    bookToLend = book;
                    
                } 
                else{
                    System.out.println(book.getTitle() + " is lent");
                    return;
                } break;
            } 
        } if (bookToLend == null){
            System.out.println("Book not found...");
            return;
        }
            
        Reader readerLending = null;
        for (Reader reader:readerList){
            if (reader.getName().equals(name)){
                readerLending = reader;
                break;
            } 
        }
        if(readerLending==null){
            System.out.println("Reader not found...");
            return;
        }

        lendedBookList.add(bookToLend);
        bookToLend.lendBook();
        readerLending.readerLendBook();
        LendingRecord lendingRecord = new LendingRecord(bookToLend, readerLending, lendingDate);
        lendingRecordList.add(lendingRecord);
        System.out.println(bookToLend.getTitle() + " succesfully registered to " + readerLending.getName());

    }

    
    public void returnBook(String ISBN, String returnDate){
        Book bookToReturn = null;
        for (Book book : lendedBookList){
            if (ISBN.equals(book.getISBN())){
                bookToReturn = book;
                break;
                
            }
        } 
        if (bookToReturn==null){
            System.out.println("Book not found in lended books");
            return;
        }
        for (LendingRecord lendingRecord : lendingRecordList){
            if (lendingRecord.getBook().getISBN().equals(ISBN) && lendingRecord.getReturnDate()==null){
                lendingRecord.setReturnDate(returnDate);
                lendedBookList.remove(bookToReturn);
                System.out.println(bookToReturn.getTitle() + " returned succesfully..." );
                return;
            }
        } System.out.println("Book not found in lended books");
        
        
        
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

    public void printLendReaderJournal(String afm){
        boolean found = false;
        for (Reader reader : readerList){
            if (afm.equals(reader.getAfm())){
                found = true;
                boolean recordFound = false;
                for (LendingRecord lendingRecord : lendingRecordList){
                    if (lendingRecord.getReader().getAfm().equals(afm)){
                    recordFound = true;
                    System.out.println("---------------------------");
                    System.out.println(lendingRecord.getReader().getName() + " Lending Journal");
                    System.out.println(lendingRecord.getBook().getTitle() + "\n"+"Lending Date: " + "\n" + lendingRecord.getLendingDate()  + "\n" + "Return Date: " + "\n" + lendingRecord.getReturnDate() );
                    System.out.println("---------------------------");
                    } 
                }  if(!recordFound){
                    System.out.println("Reader hasn't lended a book yet");  
                    } break;
            }      //Να βάλω πότε δανείστηκε και από ποιον μάλλον από το lendingRecord
        } if (!found){
            System.out.println("Reader not found...");
        }
    } 


    public void findBestReaders(ArrayList<Reader> list){
        Collections.sort(list, Comparator.comparing(Reader::getReaderLendCount));
        Reader r1 = list.get(list.size()-1);
        System.out.println("The reader that has read the most books is: " + r1.getName() + " who has read " + r1.getReaderLendCount() + " books");
    }

    public void findBestBooks(ArrayList<Book> list){

        Collections.sort(list, Comparator.comparing(Book::getLendCount));
        Book b1 = list.get(list.size()-1);
        System.out.println("The book that has been rented more times is: " + b1.getTitle() + " that has been rented " + b1.getLendCount() + " times.");
    
    }
}
