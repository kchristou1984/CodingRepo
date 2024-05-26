import java.util.Random;

public class MyTable{

    public static void fillTableRandomly(double[] array){
        
        Random rn = new Random();
        for(int i = 0; i<array.length; i++){
            double number = rn.nextDouble();
            array[i] = number;
        }
    }

    public static void printTableH(double[] array){
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+ " ");
        }
    }

    public static void printTableV(double[] array){
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void swapValues(double[] array, int a, int b){
        double temp = array[a];
        array[a] = array [b];
        array[b] = temp;
        System.out.println(array[a] + " swapped with " + array[b]);

    }

    public static void minLocationFrom(double[] array, int a){
        double min = array[a];
        for(int i=a; i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        System.out.println("Lowest number in array is " + min );
    }

    public static void maxLocationFrom(double[] array, int a){
        double max = array[a];
        for(int i=a; i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println("Highest number in array is " + max );
    }
    
    public static void cloneTable(double[] array){
        double clonedArray[] = new double[array.length];
        for(int i = 0; i<array.length;i++){
            clonedArray[i] = array[i]; 
            
        }
        printTableV(clonedArray);
    }
    public static void mergeTables( double[] arrayA, double[] arrayB){
        int a1 = arrayA.length;
        int b1 = arrayB.length;
        int c1 = a1 + b1; 
        double newArray[] = new double[c1];
        for(int i=0;i<arrayA.length;i++){
            newArray[i] = arrayA[i];
        }
        for(int j=0;j<arrayB.length;j++){
            newArray[j+a1] = arrayB[j];
        }
        printTableV(newArray);
    }

public static void main(String[] args) {
    double array[] = new double[50];

    MyTable.fillTableRandomly(array);
    MyTable.printTableH(array);
    System.out.println("");
    MyTable.printTableV(array);
    MyTable.swapValues(array, 1 ,2);
    MyTable.minLocationFrom(array, 0);
    MyTable.maxLocationFrom(array, 0);
    MyTable.cloneTable(array);

    System.out.println("");
    System.out.println("New array from here");
    System.out.println("");

    double array1[] = new double[50]; //Νέος πίνακας για χρήση με mergeTables
    MyTable.fillTableRandomly(array1);
    MyTable.printTableV(array1);

    System.out.println("");
    System.out.println("Merged array from here"); //Κενά για να ξεχωρίζω τους πίνακες
    System.out.println("");

    mergeTables(array, array1);


}
}