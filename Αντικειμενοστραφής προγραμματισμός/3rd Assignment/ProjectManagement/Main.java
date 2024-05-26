package ProjectManagement;

import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supervisor supervisor = new Supervisor("Kostas", "Christou", "211");
        Project project = new Project("Building construction", "22/10/2023", "1/4/2024", supervisor);
        while(true){
        System.out.println("~~~~ Project Management~~~~" + "\n");
        System.out.println("Choose from the action below: " + '\n');
        System.out.println("1. Show project info");
        System.out.println("2. Show supervisor info");
        System.out.println("3. Assign supervisor to project");
        System.out.println("4. Exit" + '\n');
        
        try{
        int choice = sc.nextInt();
        if (choice == 1){
            project.showInfo();
        }
        
        else if (choice == 2) {
            System.out.println("Name of supervisor: " + supervisor.getName());
            System.out.println("ID of supervisor: " + supervisor.getId() + "\n");
        }

        else if (choice ==3){
            sc.nextLine();
            System.out.println("What is the name of the supervisor?");
            String newName = sc.nextLine();
            supervisor.setName(newName);
            System.out.println("What is the surname of the supervisor?");
            String newSurname = sc.nextLine();
            supervisor.setSurname(newSurname);
            System.out.println("What is the ID of the supervisor?");
            String newId = sc.nextLine();
            supervisor.setId(newId);
            
        }

        else if(choice == 4){
            System.out.println("Program exiting...");
                break;
            }
        
        }catch (InputMismatchException e1){
            System.out.println("Please give valid input \n");
            sc.nextLine();
        }
    }
    sc.close();
        
}
}

