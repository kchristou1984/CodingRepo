import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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


        JFrame f = new JFrame("Library Management");
        JPanel p = new JPanel();
        JLabel l= new JLabel();

        JButton b1 = new JButton("Reader Journal");
        JButton b2 = new JButton("Book Journal");
        JButton b3 = new JButton("Register new book");
        JButton b4 = new JButton("Register new reader");
        JButton b5 = new JButton("Show lended books");
        JButton b6 = new JButton("Show best readers");
        JButton b7 = new JButton("Show best books");
        JButton b8 = new JButton("Lend a book");
        JButton b9 = new JButton("Return a book");

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));        

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(l);
        f.add(p);
        
        f.setSize(800,300);
        // f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Action to print lended books
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                library.printLendedBooks();
            }
        });
        // Action for Best Readers
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                library.findBestReaders(Library.readerList);
            }
        });
        // Action to print best books
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                library.findBestBooks(Library.bookList);
            }
        });

    }
    
}
