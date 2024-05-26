package Example1;
class Complex {
    double a = 0.0, b = 0.0;

    public static void main(String[] args) {
        Complex z1 = new Complex();
        z1.a = 3;
        z1.b = 2;

        System.out.println("z1=" + z1.a + "+" + z1.b + "i ");
    }
}