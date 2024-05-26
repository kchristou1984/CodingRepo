public abstract class Bird implements Animal{
    private String kind;

    public Bird(String kind) {
        this.kind = kind;
    }

    public void printinfo(){
        System.out.println("Είμαι " + kind);
    }
}
