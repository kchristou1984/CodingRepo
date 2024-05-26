public class AddArray {
    public static int sumArray(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum = sum + a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] a = {5,8,12,4,6,8};
    
        int result = sumArray(a);
        System.out.println("The result is " + result);
        }
        
    
}
