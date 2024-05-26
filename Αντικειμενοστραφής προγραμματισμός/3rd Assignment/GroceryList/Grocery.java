package GroceryList;
import java.io.*;
import java.io.IOException;
import java.util.*;


public class Grocery {
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try{
            FileWriter f1 = new FileWriter("grocerylist.txt");
            int count = 1;
            double totalSum = 0.0;
            int quantity = 0;
            double price = 0.0;
            f1.write("~~~GROCERY LIST~~~");
            f1.write("\n"+"\n");
        // Ερώτηση για το τι αγόρασε ο χρήστης.

            while (true){
            f1.write("ITEM " + count);
            f1.write("\n");
            System.out.println("What did you purchase?");   
            String item = input.nextLine();
            f1.write("Item: " + item);
            f1.write("\n");
            
        //Ερώτηση για τα ψώνια

            while(true){
            try{
            System.out.println("How many items did you purchase?");
            quantity = input.nextInt();
            input.nextLine();
            f1.write("Quantity: " + Integer.toString(quantity));
            f1.write("\n");
            break;
        }catch (InputMismatchException e){
            System.out.println("Enter valid input");
            input.nextLine();
            
        }
    }
    //Ερώτηση για το κόστος κάθε αντικειμένου
            while(true){
            try{
            System.out.println("What much did it cost per unit?");
            price = input.nextDouble();
            input.nextLine();
            f1.write("Unit Cost " + Double.toString(price));
            f1.write("\n");
            totalSum = totalSum + quantity*price;
            break;
        }catch (InputMismatchException e){
            System.out.println("Enter a valid input");
            input.nextLine();
            
            }
        }
            f1.write("Total Cost: " + quantity*price);
            f1.write("\n");
            f1.write("\n");


            System.out.println("You got " + quantity + " " + item + " and you paid " + price*quantity + " $");
            System.out.println("Do you want to continue? Yes to continue / No to exit and print grocery list...");
            String check = input.nextLine().toLowerCase();
            if (check.equals("no")){
                f1.write("Total amount paid: " + totalSum);
                f1.close();
                break;
            }
            count++;
        }
    }
    catch (IOException e){
        System.out.println("Error--"+ e.toString());
    }
        input.close();
        
        try{
            FileReader file = new FileReader("grocerylist.txt");
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            System.out.println("");
            while (!eof){
                String line = buff.readLine();
                if (line==null){
                    eof = true;
                }
                else{
                    System.out.println(line);
                }
            }   
            buff.close();
            file.close();    
        }catch(IOException e){
            System.out.println("Error--" + e.toString());
        }
    }
}
