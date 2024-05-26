import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        System.out.println("Give numbers to sum. Give 0 to sum them: ");
        while (true) 
        
        {
        int  number = Scanner.next();
        if (number==0){
            break;
        }
        sum += number;
        count++;
    }
        System.out.println("To άθροισμα είναι " + sum);
        System.out.println("You gave " + count + "numbers");
    }
}
