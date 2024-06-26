import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;






public class Main {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Μέθοδος για να είναι τα γράμματα μέσα στα πεδία γκρι και να εξαφανίζονται όταν γίνεται κλικ επάνω τους
    public static void textField(JTextField textField, String textDisplay){
        textField.setText(textDisplay); 
        textField.setForeground(Color.GRAY); //To χρώμα είναι αρχικα γκρι
        textField.addFocusListener(new FocusListener() { //οταν γίνεται κλικ το κείμενο εξαφανίζεται (γίνεται "") και τα γράμματα είναι μαύρα
            @Override
            public void focusGained(FocusEvent e){
                if (textField.getText().equals(textDisplay)){
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e){ //όταν κλικάρει ο χρήστης αλλού, επανεμφανίζεται το αρχικό κείμενο με γκρι γράμματα)
                if (textField.getText().equals("")){
                    textField.setText(textDisplay);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
        

        
    }
    public static void main(String[] args) {
        Library library = new Library();
            
    // Graphic interface

        JFrame f = new JFrame("Library Management");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(2000,300);
        
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Buttons and output
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        
        // Reader Journal Button
        JPanel readerJournaJPanel = new JPanel(new GridLayout());
        
        JButton b1 = new JButton("Show reader journal");
        JTextField i1 = new JTextField();
        
        textField(i1,"Enter reader ΑΦΜ");
        readerJournaJPanel.add(i1);
        readerJournaJPanel.add(b1);
        buttonPanel.add(readerJournaJPanel);

        
        
        // Book Journal Button
        JPanel bookJournaJPanel = new JPanel(new GridLayout());
        
        JButton b2 = new JButton("Book Journal");
        JTextField i2 = new JTextField();
        textField(i2,"Enter book ISBN");
        bookJournaJPanel.add(i2);
        bookJournaJPanel.add(b2);
        buttonPanel.add(bookJournaJPanel);
        
        // Register new book panel
        JPanel registerBookJPanel = new JPanel(new GridLayout());
        
        JTextField isbnField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        
        JTextField positionField = new JTextField();
        textField(isbnField,"Enter book ISBN");
        textField(titleField,"Enter book title");
        textField(authorField,"Enter book author");
        
        textField(positionField,"Enter book position");
        JButton b3 = new JButton("Register new book");

        String [] genres = {"Select genre","Literature", "History", "Education", "Computers"};
        JComboBox<String> genreBox = new JComboBox<>(genres);

        registerBookJPanel.add(isbnField);
        registerBookJPanel.add(titleField);
        registerBookJPanel.add(authorField);
        registerBookJPanel.add(positionField);
        registerBookJPanel.add(genreBox);
        registerBookJPanel.add(b3);
        buttonPanel.add(registerBookJPanel);
        
        // Register new reader
        JButton b4 = new JButton("Register new reader");
        JPanel registerReaderJPanel = new JPanel(new GridLayout());
        
        JTextField afmField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();

        String [] categories = {"Select student category","Student", "Other"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);      
        textField(afmField,"Enter reader ΑΦΜ");
        textField(nameField,"Enter reader name");
        textField(ageField,"Enter reader's age");
        registerReaderJPanel.add(afmField);
        registerReaderJPanel.add(nameField);
        registerReaderJPanel.add(ageField);
        registerReaderJPanel.add(categoryBox);
        registerReaderJPanel.add(b4);
        buttonPanel.add(registerReaderJPanel);
        
        
        // Lend a book
        JButton b5 = new JButton("Lend a book");
        JPanel lendBookJPanel = new JPanel(new GridLayout());
        
        JTextField bookISBNField = new JTextField();
        JTextField readerAfmField = new JTextField();
        JTextField readerLendingDateField = new JTextField(); 
        textField(bookISBNField,"Enter book ISBN");
        textField(readerAfmField,"Enter reader ΑΦΜ");
        textField(readerLendingDateField,"Enter lending date");
        lendBookJPanel.add(bookISBNField);
        lendBookJPanel.add(readerAfmField);
        lendBookJPanel.add(readerLendingDateField);
        lendBookJPanel.add(b5);
        buttonPanel.add(lendBookJPanel);

        // Return a book
        JButton b6 = new JButton("Return a book");
        JPanel returnBookJPanel = new JPanel(new GridLayout());
        
        JTextField returnISBNField = new JTextField();
        JTextField returnDateField = new JTextField();
        textField(returnISBNField,"Enter book ISBN");
        textField(returnDateField,"Enter return date");
        returnBookJPanel.add(returnISBNField);
        returnBookJPanel.add(returnDateField);
        returnBookJPanel.add(b6);
        buttonPanel.add(returnBookJPanel);
        

        
        
        // Υπόλοιπα κουμπιά
        JPanel buttonPanelRest = new JPanel(new GridLayout()); 
        JButton b7 = new JButton("Show lended books");
        JButton b8 = new JButton("Show best readers");
        JButton b9 = new JButton("Show best books");
        JButton b10 = new JButton("Print all readers");
        JButton b11 = new JButton("Print all books");
        buttonPanelRest.add(b7);
        buttonPanelRest.add(b8);
        buttonPanelRest.add(b9);
        buttonPanelRest.add(b10);
        buttonPanelRest.add(b11);
        buttonPanel.add(buttonPanelRest);
        
        
        

        JTextArea output = new JTextArea();
        output.setFont(new Font("Verdana",Font.BOLD, 12));
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        f.add(mainPanel);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User Input
        
        // Action to print reader journal
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String userInput = i1.getText();
                if (userInput.equals("Enter reader ΑΦΜ")){
                    output.setText("Please enter a reader ΑΦΜ");
                }else{
                output.setText(library.printLendReaderJournal(userInput));
                }
            }
        });

        // Action to print book journal
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String bookISBN = i2.getText();
                if (bookISBN.equals("Enter book ISBN")){
                    output.setText("Please enter a book ISBN");
                }else{
                output.setText(library.lendBookJournal(bookISBN));}
            }
        });

        // Action to register new book
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                
                String genre = (String) genreBox.getSelectedItem();
                String position = positionField.getText();

                if (isbn.isEmpty()||title.isEmpty()||author.isEmpty()||position.isEmpty()){
                    output.setText("All fields must be filled");
                } else{
                    if (genre.equals("Select genre")==false){
                        if (isbn.equals("Enter book ISBN")||title.equals("Enter book title")||author.equals("Enter book author")||position.equals("Enter book position")){
                output.setText("Please enter all values."); 
            }else{output.setText(library.addBook(isbn,title,author,genre,position));}
                    } else {output.setText("Please select a genre");}
                }
            }
        });

        // Action to register new reader
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String afm = afmField.getText();
                String name = nameField.getText();
                String ageText = ageField.getText();
                String category = (String) categoryBox.getSelectedItem();
               

                if (afm.isEmpty()||name.isEmpty()||ageText.isEmpty()){
                    output.setText("All fields must be filled");
                } else{
                try{
                if (category.equals("Select student category")==false){
                int age = Integer.parseInt(ageText);
                if (afm.equals("Enter reader ΑΦΜ")||name.equals("Enter reader name")){
                    output.setText("Please enter all values");
                } else{
                String result = library.addReader(afm,name,age,category);
                output.setText(result); }
                } else {output.setText("Please select a student category");}
                } catch (NumberFormatException ex){
                    output.setText("Please enter a valid age");
                }

                }
            }
        });

        // Action to lend a book

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String ISBN = bookISBNField.getText();
                String afm = readerAfmField.getText();
                String lendingDateText = readerLendingDateField.getText();
        
                if (ISBN.isEmpty()||afm.isEmpty()||lendingDateText.isEmpty()){
                    output.setText("All fields must be filled");
                    return;
                } 

                if (ISBN.equals("Enter book ISBN")||afm.equals("Enter reader ΑΦΜ")||lendingDateText.equals("Enter lending date")){
                    output.setText("Please enter all values");
                }
                try{
                    Date lendingDate = dateFormat.parse(lendingDateText);
                    String result = library.lendBook(ISBN, afm, lendingDate);
                    output.setText(result);
                } catch (Exception ex){
                    output.setText("Please enter a valid date in the format dd-MM-yyyy");
                }
                ;

                
                
            }
        });

        // Action to return a book

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String ISBN = returnISBNField.getText();
                String returnDateText = returnDateField.getText();

                if (ISBN.isEmpty()||returnDateText.isEmpty()){
                    output.setText("All fields must be filled");
                } 
                if (ISBN.equals("Enter book ISBN")||returnDateText.equals("Enter return date")){
                    output.setText("Please enter all values.");
                }
                try{
                    Date returnDate = dateFormat.parse(returnDateText);
                    String result = library.returnBook(ISBN, returnDate);
                    output.setText(result);
                } catch (ParseException ex){
                    output.setText("Please enter a valid date in the format dd-mm-yyyy");
                }
                
                
            }
        });

        // Action to print lended books

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                output.setText(library.printLendedBooks());
            }
        });

        // Action for Best Readers

        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                output.setText(library.findBestReaders(Library.readerList));
            }
        });

        // Action to print best books
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                output.setText(library.findBestBooks(Library.bookList));
            }
        });
        // Action to print all readers
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                output.setText(library.printAllReaders(Library.readerList));
            }
        });
        // Action to print all books
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                output.setText(library.printAllBooks(Library.bookList));
            }
        });

    
    }
    
}


// Να φτιάξω lending journal με iterate sto lendingrecordlist, ημερομηνία και να έιναι μοναδική η θέση που μπαίνει κάθε βιβλίο