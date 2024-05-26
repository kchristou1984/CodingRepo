public class Add2DArray {
    public static int add2DArray(int[][] a, int [][] b){
        
        int [][] c = new int[a.length][2];

        for (int i = 0; i<a.length; i++){
            int c[0] = a[i][0] + b[i][0];
            int c[1] = a[i][1] + b[i][1];
        }
        
        return c;
    }

    public static void main(String[] args) {
        int [][] a = {{5,8}, {3,6},{2,3}};
        int [][] b = {{2,4}, {7,1},{6,4}};
    
        int result = add2DArray(a,b);
        System.out.println("The result is " + result);
        }
}
