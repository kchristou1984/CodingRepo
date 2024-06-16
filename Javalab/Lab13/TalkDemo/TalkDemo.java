package TalkDemo;

public class TalkDemo {
    public static void main(String[] args) {
        Context context = new Context (new CharacterTalk());
    System.out.println("Donald says: " + context.executeTalk("Quack quack"));
    System.out.println("Goofy says: " + context.executeTalk("Hugh"));
    
    }
}
