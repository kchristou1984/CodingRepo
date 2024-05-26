public class Product {
    String name;

    Product(String n){
        name = n;
    }

    public String toString(){
        return "The product is " + name;
    }

    public static void main(String[] args) {
        Product pd = new Product("Spaghetti");
        System.out.println(pd);
    }
}

class ExpiryDate extends Product{
    Date expiryDate;
    

    ExpiryDate(String n, Date expDate){
    super(n);
    expiryDate = expDate;
    }

    public String toString(){
        return super.toString() + "and it's expiry date is " + expiryDate;
    }

    public static void main(String[] args) {
        Date expiryDate = new Date(12, 10, 2025);
        ExpiryDate prod = new ExpiryDate("spaghetti", expiryDate);
        System.out.println(prod);
    }
}


