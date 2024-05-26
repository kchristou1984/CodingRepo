public class FindMax {
    public static int findMax(int[] a){
        int max = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i]>max){
                max = i;
            };
        }
        return max;
    }
    public static void main(String[] args) {
        int [] a = {5,8,12,4,6,8,45,2};
    
        int result = findMax(a);
        System.out.println("The greatest number is: " + a[result] + " and it's index is: " + result);
        }
}
