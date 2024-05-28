import java.util.ArrayList;

public class LendingRecord {
    private Book book;
    private Reader reader;
    private Date lendingDate;
    private Date returnDate;

    public LendingRecord(Book book, Reader reader, Date lendingDate){
        this.book = book;
        this.reader = reader;
        this.lendingDate = lendingDate;
        this.returnDate = null;
    }

    ArrayList<LendingRecord> lendingRecordList = new ArrayList<LendingRecord>();



    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public Date getLendingDate() {
        return lendingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    
}
