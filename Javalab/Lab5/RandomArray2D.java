import java.util.Random;

public class RandomArray2D {
    public static void main(String[] args) {
        int [] [] a = new int[10][2];
        Random random = new Random();
        for (int i = 0; i<a.length; i++){
            a[i][0] = random.nextInt(100);
            a[i][1] = random.nextInt(100);
            }

            for (int i = 0; i < a.length; i++){
                for (int j = 0; j<a[i].length; j++){

                System.out.print(a[i][j]+" ");
                }
                System.out.println();
                
            }

    }
}
