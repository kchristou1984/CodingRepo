package Example2;

import java.util.Scanner;

class test {
    public static void main(String[] args) {
        Complex z;
        Scanner scan = new Scanner (System.in);
        System.out.println("Give a=");
        double a = scan.nextDouble();
        System.out.println("Give b=");
        double b = scan.nextDouble();

        z = new Complex (a,b);
        System.out.println("You gave:" + z);
        scan.close();
    }    
 
}
