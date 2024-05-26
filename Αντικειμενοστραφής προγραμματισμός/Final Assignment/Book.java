// import java.util.*;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private String position;

    public Book(String ISBN, String title, String author, String genre,String position){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.position = position;
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

    @Override
    public String toString(){
        return "ISBN: " + ISBN +"\n" + "Title: " +  title +"\n"+ "Author: " + author + "\n"+ "Genre: " + genre + "\n"+ "Library Position:" + position+ "\n";
    }


}
