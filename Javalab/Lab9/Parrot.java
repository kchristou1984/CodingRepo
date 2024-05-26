public class Parrot extends Bird {
    private String name;

    public Parrot(String akind, String name){
        super(akind);
        this.name = name;
    }

    public void printinfo(){
        super.printinfo();
        System.out.println("και ονομάζομαι " + name);
    }
}
