import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        int [] a = new int[10];
        Random random = new Random();
        for (int i = 0; i<a.length; i++)
            a[i] = random.nextInt();

            for (int j = 0; j < a.length; j++){
                System.out.println(a[j]);
            }

    }
}