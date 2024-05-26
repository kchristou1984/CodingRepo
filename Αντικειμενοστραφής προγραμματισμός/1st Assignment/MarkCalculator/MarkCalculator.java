import java.util.Scanner;

    class Student {

        private String name;
        private int Id;
        private double examGrade;
        private double projectGrade;
        private double finalGrade;

        public Student(String initName, int initId, double initExamGrade, double initProjectGrade)
        {
            name = initName;
            Id = initId;
            examGrade = initExamGrade;
            projectGrade = initProjectGrade;
            
        }

        public void setName (String newName){
            name = newName;
        }

        public String getName () {
            return name;
        }

        public void setId (int newId){
            Id = newId;
        }

        public int getId() {
            return Id;
        }

        public boolean setExamGrade (double newExamGrade){
            if (newExamGrade < 0 || newExamGrade>10){
                return false;
            } 
            else {
            examGrade = newExamGrade;
            return true;
            }
        }

        public double getExamGrade () {
            return examGrade;
        }

        public boolean setProjectGrade (double newProjectGrade){
            if (newProjectGrade < 0 || newProjectGrade > 10){
                return false;
            } 
            else {
            projectGrade = newProjectGrade;
            return true;
            }
        }

        public double getProjectGrade () {
            return projectGrade;
        }

        public void calculateFinalGrade () {
            finalGrade = (0.6*examGrade + 0.4*projectGrade);

         }

        public double getFinalGrade () {
            return finalGrade;
        }

        public void Promotion() {
        
            if (getFinalGrade() >= 5) {
                System.out.println("Student " + getName() + " with ID: " + getId() + ", is promoted. Final Grade: " + getFinalGrade());
            }
            else {
                System.out.println("Student " + getName() + " with ID: " + getId() + ", is not promoted. Final Grade: " + getFinalGrade());
            }
        }

    }

public class MarkCalculator {

    public static void main(String[] args) 
{
        
    Scanner sc = new Scanner(System.in);
    


    //Name.
    System.out.println("Please give student's name: ");
    String name = sc.nextLine();

    //Student ID.
    System.out.println("Please give student's ID: ");
    int Id = sc.nextInt();

    //Exam Grade.
    double examGrade;
    do {System.out.println("Please give student's grade of exam: ");
    examGrade = sc.nextDouble();
    }
       while (examGrade<0 || examGrade>10);

    //Project Grade.
    double projectGrade;
    do {System.out.println("Please give student's project grade: ");
    projectGrade = sc.nextDouble();
    }
        while (projectGrade<0||projectGrade>10);


    Student student = new Student(name, Id, examGrade, projectGrade);
    
    student.calculateFinalGrade();  
    student.Promotion();
    
    

    sc.close();
    
    }

}