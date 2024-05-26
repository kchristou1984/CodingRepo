package Food;

public class Fruit implements Food{
    private String color;
    private String name;

    public Fruit(String color, String name){
        this.color = color;
        this.name = name;
    }

    public void kindFood(){
        System.out.println("Το χρώμα είναι " + color + "το όνομα είναι " + name);
    }
}
