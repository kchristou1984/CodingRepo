public abstract class Mammal implements Animal{
    private String kind;

    public Mammal(String kind) {
        this.kind = kind;
    }

    public void printinfo(){
        System.out.println("Είμαι: " + kind);
    }
}
