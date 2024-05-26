public class Dog extends Mammal {
    private String name;

    public Dog(String akind, String name){
        super(akind);
        this.name = name;
    }
    
    public void printinfo(){
        super.printinfo();
        System.out.println("και ονομάζομαι " + name);
    }
}
