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
        library.addReader("133751036", "Kostas Christou", 39 , "Student  ");

        for (Book book : library.bookList) {
            System.out.println(book);
        }

        for (Reader reader : library.readerList) {
            System.out.println(reader);
        }

        library.lendBook("0156907399");
        library.lendBook("015690");
        library.printLendedBooks();
        library.lendBookJournal();
        library.lendBook("0156907399");
        library.lendBookJournal();
    }
    
}
