package Food;

public class Vegetable implements Food {
    private Double calories;
    private String name;

    public Vegetable(String name, Double calories){
        this.name = name;
        this.calories = calories;
    }

    public void kindFood(){
        System.out.println("Το όνομα είναι " + name + " και οι θερμίδες που έχει είναι " + calories);
    }
}
