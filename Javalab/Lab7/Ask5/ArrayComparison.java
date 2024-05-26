package Ask5;

public class ArrayComparison {
    int x[][] = {{1,2},{4,5},{7,8}};
    int y[][] = {{1,2},{4,6},{8,9}};


    public boolean equals(int x[][], int y[][]){
        boolean b = true;
        if (x.length != y.length){
            b = false;
        }



        for (int i = 0; i<x.length;i++){
            for (int j=0; j<x[i].length;j++){
                if (x[i][j]!=y[i][j]){
                    b = false;
                }
            }
        }return b;
    }
    
    public static void main(String[] args) {
        ArrayComparison arrayComp = new ArrayComparison();
        System.out.println(arrayComp.equals(arrayComp.x,arrayComp.y));;  
    }
    
}
