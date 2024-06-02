// import java.util.*;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private String position;
    private int lendCount;

    //Να προσθέσω και ιδιότητα για το count των δανεισμών σε κάθε βιβλίο τύπου int lendCount = 0 και να γίνεται +1 κάθε φορά που καλείται η lendBook()
    public Book(String ISBN, String title, String author, String genre,String position){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.position = position;
        this.lendCount = 0;
    }
    
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public String getISBN(){
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public int getLendCount(){
        return lendCount;
    }

    public void lendBook(){
        lendCount++;
    }

    @Override
    public String toString(){
        return "ISBN: " + ISBN +"\n" + "Title: " +  title +"\n"+ "Author: " + author + "\n"+ "Genre: " + genre + "\n"+ "Library Position:" + position+ "\n" + "Lended " + lendCount + " times" + "\n";
    }


}
