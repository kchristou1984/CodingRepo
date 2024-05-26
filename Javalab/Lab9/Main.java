public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Θηλαστικό", "Rex");
        dog.printinfo();

        Animal animal = new Dog("Θηλαστικό", "Jack");
        animal.printinfo();

        Parrot parrot = new Parrot("Πτηνό", "Kostas");
        parrot.printinfo();
    }
}
