public class Game {
    public static void main(String args[])
    {
        Human human1;

        human1=new Human();
        human1.numberOfEyes = 1;
        human1.name= "Cyclop 1";

        Human human2;

        human2= new Human();
        human2.numberOfEyes = 2;
        human2.name= "Cyclop 2";

        human1.say();
        human2.say();

    }
    
}