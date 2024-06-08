import java.util.*;



public class Library {


    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Reader> readerList = new ArrayList<Reader>();
    ArrayList<Book> lendedBookList = new ArrayList<Book>();
    ArrayList<LendingRecord> lendingRecordList = new ArrayList<LendingRecord>();


    public String addBook(String ISBN, String title, String author, String genre, String position){
        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                return "Book is already registered..";
                
            }

            if (book.getPosition().equals(position)){
                return "There is already a book in this position.";
            }
        } 
        bookList.add(new Book(ISBN,title,author,genre,position));
        return "Book " + title + " registered succesfully";
    }

    public String addReader(String afm,String name,int age,String category){
        for(Reader reader: readerList){
            if (reader.getAfm().equals(afm)){
                return "Reader is already registered...";
                
            }
        }
        readerList.add(new Reader(afm, name, age, category));
        return "Reader " + name + " registered succesfully...";

    }
      

    public String lendBook(String ISBN, String afm, String lendingDate){
        Book bookToLend = null;

        for (Book book : bookList){
            if (book.getISBN().equals(ISBN)){
                if (lendedBookList.contains(book)==false){
                    // System.out.println(book.getTitle() + " has been lent succesfully");
                    bookToLend = book;
                    
                } 
                else{
                    return book.getTitle() + " is lent";
                    
                } break;
            } 
        } if (bookToLend == null){
            return "Book not found...";
            
        }
            
        Reader readerLending = null;
        for (Reader reader:readerList){
            if (reader.getAfm().equals(afm)){
                readerLending = reader;
                break;
            } 
        }
        if(readerLending==null){
            return "Reader not found...";
            
        }

        lendedBookList.add(bookToLend);
        bookToLend.lendBook();
        readerLending.readerLendBook();
        LendingRecord lendingRecord = new LendingRecord(bookToLend, readerLending, lendingDate);
        lendingRecordList.add(lendingRecord);
        return bookToLend.getTitle() + " succesfully registered to " + readerLending.getName();

    }

    
    public String returnBook(String ISBN, String returnDate){
        Book bookToReturn = null;
        for (Book book : lendedBookList){
            if (ISBN.equals(book.getISBN())){
                bookToReturn = book;
                break;
                
            }
        } 
        if (bookToReturn==null){
            return "Book not found in lended books";
            
        }
        for (LendingRecord lendingRecord : lendingRecordList){
            if (lendingRecord.getBook().getISBN().equals(ISBN) && lendingRecord.getReturnDate()==null){
                lendingRecord.setReturnDate(returnDate);
                lendedBookList.remove(bookToReturn);
                return bookToReturn.getTitle() + " returned succesfully..." ;
                
            }
        } return "Book not found in lended books";
        
        
        
    }

    public String printLendedBooks(){
        String output = "";
        if (lendedBookList.isEmpty()) {
            output =  "No books are currently lended.";
        }
        
        if (lendedBookList.isEmpty()==false){
        output = "LENDED BOOKS" + "\n\n";
        for(Book book:lendedBookList){
            output += book.toString()+ "\n";
        } 
    }
        return output;
    }

    public String lendBookJournal(String ISBN){
        boolean found = false;
        String output = "";
        for (Book book : bookList){
            if (ISBN.equals(book.getISBN())){
                found = true;
                boolean recordFound = false;
                output = book.getTitle() + "Journal";
                for (LendingRecord lendingRecord : lendingRecordList){
                    if (lendingRecord.getBook().getISBN().equals(ISBN)){
                    recordFound = true;
                    if (lendingRecord.getReturnDate()==null){
                    output += lendingRecord.getBook().getTitle() +"\n" + "Reader: " + lendingRecord.getReader().getName() + "\n" + "Lending Date: " + lendingRecord.getLendingDate() +"\n" +  "Book has not been returned yet";
                } else{output += lendingRecord.getBook().getTitle()+"\n" + "Reader: " + lendingRecord.getReader().getName() + "\n" + "Lending Date: " + lendingRecord.getLendingDate() +"\n" +  "Return Date: " + lendingRecord.getReturnDate();}
                    } 
                }  if(!recordFound){
                    output = "Book hasn't been lended yet";  
                    } break;
            }      
        } if (!found){
            output = "Book not found...";
        } return output;
    } 

    public String printLendReaderJournal(String afm){
        boolean found = false;
        String output = "";
        for (Reader reader : readerList){
            if (afm.equals(reader.getAfm())){
                found = true;
                boolean recordFound = false;
                output = reader.getName() + " book journal" + "\n\n";
                for (LendingRecord lendingRecord : lendingRecordList){
                    if (lendingRecord.getReader().getAfm().equals(afm)){
                    recordFound = true;
                    if (lendingRecord.getReturnDate()==null){
                    output += "Book Title: " + lendingRecord.getBook().getTitle() + "\n"+"Lending Date: " + lendingRecord.getLendingDate()  + "\n" + "Return Date: Book has not been returned yet." ;
                    } else{output += lendingRecord.getReader().getName() + " Lending Journal" + "\n" + lendingRecord.getBook().getTitle() + "\n"+"Lending Date: " + "\n" + lendingRecord.getLendingDate()  + "\n" + "Return Date: " + "\n" + lendingRecord.getReturnDate();}
                    } 
                }  if(!recordFound){
                    output =  "Reader hasn't lended a book yet";  
                    } break;
            }      //Να βάλω πότε δανείστηκε και από ποιον μάλλον από το lendingRecord
        } if (!found){
            output =  "Reader not found...";
        } return output;
    } 


    public String findBestReaders(ArrayList<Reader> list){
        String output = "";
        if (list.isEmpty()){
            output =  "Reader list is empty";
        }
        else{output = "Best Reader(s): " + "\n\n";
        Collections.sort(list, Comparator.comparing(Reader::getReaderLendCount));
        
        Reader r1 = list.get(list.size()-1);
        int maxReaderLendCount=r1.getReaderLendCount();
        for (Reader reader:list){
            if (reader.getReaderLendCount()==maxReaderLendCount){
                output += reader.getName() + "\n" + "Books read: " + r1.getReaderLendCount()+ "\n\n";
            }
        } return output;
    }return output;
    }

    public String findBestBooks(ArrayList<Book> list){
        String output = "";
        if (list.isEmpty()){
            output = "There are no books registered";
        }
        else{
        output = "Best book(s): " + "\n\n"; 
        Collections.sort(list, Comparator.comparing(Book::getLendCount));
        Book b1 = list.get(list.size()-1);
        int maxLendCount = b1.getLendCount();
        
        for (Book book : list){
            if (book.getLendCount()==maxLendCount){
                output += book.getTitle() + "\n" + "Lended: " + book.getLendCount() + " times." + "\n\n";
            } 
            
        } return output;
    } return output;
    }

    public String printAllReaders(ArrayList<Reader> list){
        String output = "";
        int readerCount = 0;
        if (list.isEmpty()){
            output = "There are no readers registered";
        }
        else{
            for (Reader reader:list){
                readerCount ++;
                output +="Reader " +readerCount + "\n" + reader.toString() + "\n";
                
            }
             
        }return output;

    }

        public String printAllBooks(ArrayList<Book> list){
            String output = "";
            int bookCount = 0;
            if (list.isEmpty()){
                output = "There are no books registered";
            }
            else{
                for (Book book:list){
                    bookCount ++;
                    output +="Book " +bookCount + "\n" + book.toString() + "\n";
                    
                }
                 
            }return output;
    } 

    // Να φτιάξω print All gia vivlia
}
