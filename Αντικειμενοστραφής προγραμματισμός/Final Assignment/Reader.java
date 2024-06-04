// import java.util.*;

public class Reader{
    private String afm;
    private String name;
    private int age;
    private String category;
    private int readerLendCount;

    public Reader(String afm, String name, int age, String category){
        this.afm = afm;
        this.name = name;
        this.age = age;
        this.category = category;
        this.readerLendCount = 0;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReaderLendCount(){
        return readerLendCount;
    }

    public void readerLendBook(){
        readerLendCount++;
    }

    @Override
    public String toString(){
        return "AFM: " + afm + "\n" + "Name: " + name + "\n" + "Age " + age + "\n" + "Category: " + category + "\n";
    }
}