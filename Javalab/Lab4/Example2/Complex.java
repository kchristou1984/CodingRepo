package Example2;

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

    public static void main(String[] args) {
        Complex z1 = new Complex(3,2);
        System.out.println(z1);

        Complex z2 = new Complex(5,2);
        System.out.println(z2);
    }
}
