import java.util.ArrayList;
import java.util.Random;

public class Random2Array {
    public static void main(String[] args) {
        
        ArrayList<Integer>[] intlist = new ArrayList[10];

        
        for (int i = 0; i < intlist.length; i++) {
            intlist[i] = new ArrayList<>();
        }

       
        Random random = new Random();
        for (int i = 0; i < intlist.length; i++) {
            for (int j = 0; j<2;j++){
                intlist[i].add(random.nextInt());
            }
            
        }

        
        System.out.println("Random integers of two-dimension ArrayList:");
        for (int i = 0; i < intlist.length; i++) {
            System.out.print("ArrayList " + i + ": ");
            for (int value : intlist[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
