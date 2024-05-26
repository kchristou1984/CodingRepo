package File;
// Να κατασκευαστεί εφαρμογή που διαβάζει ένα αρχείο κειμένου 
// από το δίσκο και το εμφανίζει στην οθόνη. Το όνομα του 
// αρχείου να δίνεται ως όρισμα από  τη γραμμή εντολών.

import java.io.*;
import java.util.Scanner;

class File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the file's path name: ");
        String filePath = sc.nextLine();
        try{
            FileReader file = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            
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
            sc.close();
        }
            catch (IOException e){
                System.out.println("Error--"+ e.toString());
            }

    }
}
