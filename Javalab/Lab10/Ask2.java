import java.util.*;

public class Ask2 {

    public static int listAdd(ArrayList<Integer> list){
        int sum = 0;
        for (int i = 0; i<list.size();i++){
            sum = sum + list.get(i);
        }
        return sum;
    }

    public static int listEven(ArrayList<Integer> list){
        int sum = 0;
        for (int i = 0; i<list.size();i++){
            if(list.get(i)%2==0){
                sum += list.get(i);
            }
        }
        return sum;
    }

    public static void removeEven(ArrayList<Integer> list){
        for (int i = 0; i<list.size();i++){
            if(list.get(i)%2==0){
                System.out.println("Removing " + list.get(i)+ " from list");;
            }
        }
    }


    public static void main(String[] args) {
        int n = 10;

        ArrayList<Integer> list = new ArrayList<Integer>(n);
    
        Random rand = new Random();
        for (int i = 0; i<10; i++){
            list.add(rand.nextInt(100));

        }
        System.out.println(list);
        System.out.println("Sum of List: "+listAdd(list));
        System.out.println("Sum of even numbers is: "+ listEven(list));
        removeEven(list);
    }


    
}

