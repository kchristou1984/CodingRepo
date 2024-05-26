package Food;

public class Main {
    public static void main(String[] args) {
        Vegetable vegetable = new Vegetable("Μπρόκολο", 8.0);
        vegetable.kindFood();
        Fruit fruit = new Fruit("κίτρινο", "μπανάνα");
        fruit.kindFood();

    }
}
