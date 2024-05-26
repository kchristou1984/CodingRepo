import java.util.*;


class ArrayListExamle{
    public static void main(String[] args) {
        int n = 5;
        
        ArrayList<Integer> arr1 = new ArrayList<Integer>(n);

        ArrayList<String> arr2 = new ArrayList<String>();

        System.out.println("Array 1:"+arr1);
        System.out.println("Array 2:"+arr2);

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);

        arr2.add("Good");
        arr2.add("Morning");

        System.out.println("Array1"+arr1);
        System.out.println("Array 2"+arr2);

    }
}