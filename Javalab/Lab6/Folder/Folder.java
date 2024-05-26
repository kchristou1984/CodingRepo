package Folder;
// Να κατασκευαστεί ένα πρόγραμμα που θα ζητά από το χρήστη μια διαδρομή φακέλου στο δίσκο. 
// Αφού ο χρήστης γράψει τη διαδρομή στο πληκτρολόγιο και πιέσει το πλήκτρο Enter, 
// θα τυπώνει τα περιεχόμενα του φακέλου στην οθόνη.

import java.io.*;
import java.util.Scanner;




class Folder{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the folder's path name");
        String filePath = sc.nextLine();
        File dir = new File(filePath);
        if (dir.isDirectory()){
            String[] listing = dir.list();
            for (int i = 0;i<listing.length;i++){
                System.out.println("\t" + listing[i]);
            } 
       
        }
        else{
            System.out.println("The given folder path does not exist");
        }
        sc.close();
    }

}