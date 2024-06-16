import java.util.ArrayList;
import java.util.Random;

public class RandomArray {
    ArrayList<Integer> randomArrayList = new ArrayList<>();


    public RandomArray(){
        Random random = new Random();
        for (int i = 0;i<10;i++){
            randomArrayList.add(random.nextInt());
        }
    }

    public void printArray(){
        for (int i : randomArrayList){
            System.out.println(i);
        }
    }

    public String addArray(){
        int sum = 0;
        for (int i: randomArrayList){
            sum += i;
            
        } return ("The sum of all array elements is: " + sum);
    }

    public String findMax(){
        int max = 0;
        int position = 0;
        for (int i:randomArrayList){
            if (i>max){
                max = i;
                position++;
            } 
        } return "The max integer is " + max + "and the position is " + position;
    }

    public static void main(String[] args) {
        RandomArray ra = new RandomArray();
        ra.printArray();
        System.out.println(ra.addArray());
        System.out.println(ra.findMax());
    }
}
