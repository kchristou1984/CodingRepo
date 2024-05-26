import java.util.Scanner;

public class Complex {
    double a = 0.0, b = 0.0;

    Complex(double alfa, double beta){
        a = alfa;
        b = beta;
    }

    Complex() {

    }

    public String toString(){
        String s;
        s = a + "+" + b + "i";
        return s;
    }

    public void print(){
        System.out.println(this);
    }

    public double mathSqrt(){
        double m;
        m = Math.sqrt(a*a+b*b);
        return m;
    }

    public Complex add(Complex other){
        double newA = this.a + other.a;
        double newB = this.b + other.b;
        return new Complex(newA, newB);
    }

    public static Complex input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a=");
        double a = sc.nextDouble();
        System.out.println("Give b=");
        double b = sc.nextDouble();
        Complex z3 = new Complex(a,b);
        sc.close();
        return z3;
        

        
    }

    public static void main(String[] args) {
        Complex z1 = new Complex(3,2);
        System.out.println(z1);

        Complex z2 = new Complex(5,2);
        System.out.println(z2);

        z1.print();
        z2.print();
        System.out.println("Square root of z1: " + z1.mathSqrt());
        System.out.println("Square root of z2: " + z2.mathSqrt());
        System.out.println(("The result is: " + z1.add(z2)));
        System.out.println(input());
    }
}
