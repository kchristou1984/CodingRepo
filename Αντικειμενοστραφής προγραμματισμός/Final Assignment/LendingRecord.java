// import java.util.ArrayList;

public class LendingRecord {
    private Book book;
    private Reader reader;
    private String lendingDate;
    private String returnDate;

    public LendingRecord(Book book, Reader reader, String lendingDate){
        this.book = book;
        this.reader = reader;
        this.lendingDate = lendingDate;
        this.returnDate = null;
    }

    

    @Override
    public String toString(){
        return "Book title: " + book.getTitle() + "\n" + "Reader: " + reader.getName() + "\n"+ "Date Lended: " + getLendingDate() + "\n" + "Date Returned: " + getReturnDate() + "\n";
    }


    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public String getLendingDate() {
        return lendingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }

    
}
