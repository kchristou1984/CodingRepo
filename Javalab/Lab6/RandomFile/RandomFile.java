// Να κατασκευαστεί εφαρμογή που γράφει ένα αρχείο τυχαίων αριθμών τύπου double στο δίσκο. 
// Το πλήθος των αριθμών που αποθηκεύεται θα πρέπει να είναι  και αυτό τυχαίο. 
// Στην αρχή του αρχείου θα πρέπει να αποθηκεύεται το πλήθος των αριθμών. 
// Αμέσως μετά, θα πρέπει να αποθηκεύονται οι αριθμοί.

package RandomFile;

import java.util.*;
import java.io.*;

public class RandomFile {
    public static void main(String[] args) {
        try{
            File numberfile = new File("random_doubles.txt");
            FileWriter fr = new FileWriter(numberfile);
            Random rn = new Random();
            int arrayLength = rn.nextInt(100);
            
            System.out.println(arrayLength);
            fr.write("Number count is: ");
            fr.write(Integer.toString(arrayLength));
            fr.write("\n");
            for (int i =0; i<arrayLength; i++)
            {
            double randomDouble = rn.nextDouble();
            System.out.println(randomDouble);
            fr.write(Double.toString(randomDouble));
            fr.write("\n");
            }
            fr.close();

    }
catch(IOException e){
    System.out.println("Error -- " + e.toString());
    }
}
}
