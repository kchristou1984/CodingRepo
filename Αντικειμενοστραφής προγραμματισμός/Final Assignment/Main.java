// import java.util.*;

public class Main {

    
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("0061120081", "To Kill a Mockingbird", "Harper Lee", "Literature", "B207");
        library.addBook("0451524934", "1984", "George Orwell", "Literature", "A101");
        library.addBook("0061120081", "To Kill a Mockingbird", "Harper Lee", "Literature", "B207");
        library.addBook("0743273567", "The Great Gatsby", "F. Scott Fitzgerald", "Literature", "C305");
        library.addBook("0141439511", "Pride and Prejudice", "Jane Austen", "Literature", "D412");
        library.addBook("0316769487", "The Catcher in the Rye", "J.D. Salinger", "Literature", "E523");
        library.addBook("059035342X", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "F634");
        library.addBook("0156907399", "To the Lighthouse", "Virginia Woolf", "Literature", "G712");
        library.addBook("0142437247", "Moby-Dick", "Herman Melville", "Literature", "H823");
        library.addBook("0544003411", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "I935");
        library.addBook("0143107631", "Crime and Punishment", "Fyodor Dostoevsky", "Literature", "J1046");
        library.addReader("133751036", "Kostas Christou", 39 , "Student");
        library.addReader("1321582", "Ioulia Papoutsi", 39 , "Student");

        // for (Reader reader : library.readerList) {
        //     System.out.println(reader);
        // }

        // library.lendBook("0156907399");
        // library.lendBook("015690");
        // library.printLendedBooks();
        // library.lendBookJournal();
        // library.lendBook("0156907399");
        // library.lendBook("01faw5699");
        // library.lendBookJournal();
        // Date lenginDate = new Date(19,4,2024);
        library.lendBook("059035342X","Kostas Christou","22/5/2024");
        library.lendBook("0743273567", "Ioulia Papoutsi", "22/5/2024");
        // library.printLendedBooks();
        library.returnBook("059035342X","25/6/2024");
        library.lendBook("059035342X","Ioulia Papoutsi","3/6/2024");
        library.lendBook("059035342X","Kostas Christou","3/6/2024");
        library.lendBook("0451524934","Kostas Christou","3/6/2024");
        library.returnBook("059035342X","27/6/2024");
        // library.printLendedBooks();
        
        library.printLendReaderJournal("133751036");
        // library.lendBookJournal("059035342X");
        
        library.findBestBooks(Library.bookList);
        library.findBestReaders(Library.readerList);


        // // library.lendBookJournal("059035342X");
        // library.lendBookJournal("0156907399");
        // library.lendBookJournal("0743273567");
        // library.printLendedBooks();

        // for (LendingRecord lendingRecord:library.lendingRecordList){
        //     System.out.println(lendingRecord);
        // }
    }
    
}
