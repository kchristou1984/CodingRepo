import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;






public class Main {

    public static void textField(JTextField textField, String textDisplay){
        textField.setText(textDisplay);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e){
                if (textField.getText().equals(textDisplay)){
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
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
        f.setSize(2000,500);
        
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Buttons and output
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        
        // Reader Journal Button
        // JPanel readerJournaJPanel = new JPanel(new GridLayout());
        JPanel readerJournaJPanel = new JPanel(new GridBagLayout());
        JButton b1 = new JButton("Show reader journal");
        JTextField i1 = new JTextField();
        i1.setBounds(100,20,165,25);
        textField(i1,"Enter reader ΑΦΜ");
        readerJournaJPanel.add(i1);
        readerJournaJPanel.add(b1);
        buttonPanel.add(readerJournaJPanel);

        
        
        // Book Journal Button
        // JPanel bookJournaJPanel = new JPanel(new GridLayout());
        JPanel bookJournaJPanel = new JPanel(new GridBagLayout());
        JButton b2 = new JButton("Book Journal");
        JTextField i2 = new JTextField();
        textField(i2,"Enter book ISBN");
        bookJournaJPanel.add(i2);
        bookJournaJPanel.add(b2);
        buttonPanel.add(bookJournaJPanel);
        
        // Register new book panel
        // JPanel registerBookJPanel = new JPanel(new GridLayout());
        JPanel registerBookJPanel = new JPanel(new GridBagLayout());
        JTextField isbnField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        // JTextField genreField = new JTextField();
        JTextField positionField = new JTextField();
        textField(isbnField,"Enter book ISBN");
        textField(titleField,"Enter book title");
        textField(authorField,"Enter book author");
        // textField(genreField,"Enter book genre");
        textField(positionField,"Enter book position in library");
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
        // JPanel registerReaderJPanel = new JPanel(new GridLayout());
        JPanel registerReaderJPanel = new JPanel(new GridBagLayout());
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
        // JPanel lendBookJPanel = new JPanel(new GridLayout());
        JPanel lendBookJPanel = new JPanel(new GridBagLayout());
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
        // JPanel returnBookJPanel = new JPanel(new GridLayout());
        JPanel returnBookJPanel = new JPanel(new GridBagLayout());
        JTextField returnISBNField = new JTextField();
        JTextField returnDateField = new JTextField();
        textField(returnISBNField,"Enter book ISBN");
        textField(returnDateField,"Enter return date");
        returnBookJPanel.add(returnISBNField);
        returnBookJPanel.add(returnDateField);
        returnBookJPanel.add(b6);
        buttonPanel.add(returnBookJPanel);
        

        
        
        // Υπόλοιπα κουμπιά
        JPanel buttonPanelRest = new JPanel(); 
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
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        // mainPanel.add(buttonPanelRest,BorderLayout.SOUTH);
        f.add(mainPanel);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // User Input
        
        // Action to print reader journal
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String userInput = i1.getText();
                output.setText(library.printLendReaderJournal(userInput));
            }
        });

        // Action to print book journal
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String bookISBN = i2.getText();
                output.setText(library.lendBookJournal(bookISBN));
            }
        });

        // Action to register new book
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                // String genre = genreField.getText();
                String genre = (String) genreBox.getSelectedItem();
                String position = positionField.getText();

                if (isbn.isEmpty()||title.isEmpty()||author.isEmpty()||position.isEmpty()){
                    output.setText("All fields must be filled");
                } else{
                    if (genre.equals("Select genre")==false){
                output.setText(library.addBook(isbn,title,author,genre,position)); 
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
                String result = library.addReader(afm,name,age,category);
                output.setText(result); 
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
                String lendingDate = readerLendingDateField.getText();
                if (ISBN.isEmpty()||afm.isEmpty()||lendingDate.isEmpty()){
                    output.setText("All fields must be filled");
                } 
                String result = library.lendBook(ISBN, afm, lendingDate);
                output.setText(result);

            }
        });

        // Action to return a book

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String ISBN = returnISBNField.getText();
                String returnDate = returnDateField.getText();
                if (ISBN.isEmpty()||returnDate.isEmpty()){
                    output.setText("All fields must be filled");
                } 
                String result = library.returnBook(ISBN, returnDate);
                output.setText(result);
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